package com.Vlearn.Api_Gateway.config;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class JwtAuthFilter extends AbstractGatewayFilterFactory<JwtAuthFilter.Config> {

    private final WebClient.Builder webClientBuilder;

    public JwtAuthFilter(WebClient.Builder webClientBuilder) {
        super(Config.class);
        this.webClientBuilder = webClientBuilder;
    }

    public static class Config {}

    // ✅ All endpoints that should bypass JWT validation
    private static final List<String> OPEN_API_PATHS = List.of(
            "/swagger-ui.html",
            "/swagger-ui/",
            "/swagger-ui/index.html",
            "/swagger-resources",
            "/webjars/",
            "/v3/api-docs",
            "/auth/v3/api-docs",
            "/user/v3/api-docs",
            "/rating/v3/api-docs",
            "/meeting/v3/api-docs"
    );

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            String path = exchange.getRequest().getURI().getPath();

            // ✅ Skip JWT validation for Swagger & OpenAPI docs
            if (isOpenApiPath(path)) {
                return chain.filter(exchange);
            }

            String authHeader = exchange.getRequest().getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
            if (authHeader == null || !authHeader.startsWith("Bearer ")) {
                exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                return exchange.getResponse().setComplete();
            }

            String token = authHeader.substring(7);

            return webClientBuilder.build()
                    // ⚠️ Use http:// not https:// when calling Eureka service
                    .get()
                    .uri("lb://AUTH-SERVICE/auth/validate?token=" + token)
                    .retrieve()
                    .onStatus(
                            status -> status.is4xxClientError() || status.is5xxServerError(),
                            resp -> Mono.error(new RuntimeException("UNAUTHORIZED"))
                    )
                    .bodyToMono(Boolean.class)
                    .flatMap(valid -> {
                        if (Boolean.TRUE.equals(valid)) {
                            return chain.filter(exchange);
                        } else {
                            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                            return exchange.getResponse().setComplete();
                        }
                    });
        };
    }

    private boolean isOpenApiPath(String path) {
        // ✅ Match Swagger or OpenAPI endpoints for all services
        return OPEN_API_PATHS.stream().anyMatch(path::startsWith);
    }
}
