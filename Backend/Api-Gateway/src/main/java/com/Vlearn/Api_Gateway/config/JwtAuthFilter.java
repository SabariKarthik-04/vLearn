package com.Vlearn.Api_Gateway.config;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Component
public class JwtAuthFilter extends AbstractGatewayFilterFactory<JwtAuthFilter.Config>{
	
	
	private final WebClient.Builder webClientBuilder;

	
    public JwtAuthFilter(WebClient.Builder weBuilder) {
        super(Config.class);
        this.webClientBuilder = weBuilder;
    }
    
    public static class Config {}



	@Override
	public GatewayFilter apply(Config config) {
		return (exchange,chain) -> {
			String authHeader = exchange.getRequest().getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
			if(authHeader == null || !authHeader.startsWith("Bearer ")) {
				exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                return exchange.getResponse().setComplete();
			}
			String token = authHeader.substring(7);
			return webClientBuilder.build()
					.get()
					.uri("https://AUTH-SERVICE/auth/validate?token="+token)
					.retrieve()
					.onStatus(status->status.is4xxClientError() || status.is5xxServerError(),
							resp->Mono.error(new RuntimeException("UNAUTHORIZED")))
					.bodyToMono(Boolean.class)
					.flatMap(valid -> {
						if(Boolean.TRUE.equals(valid)) {
							return chain.filter(exchange);
						}else {
							exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
	                        return exchange.getResponse().setComplete();
						}
				});
		};
	}
}
