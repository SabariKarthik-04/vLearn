package com.Vlearn.Auth_Service.Exception;

public class RegisterException extends Exception{

	private static final long serialVersionUID = 1L;
	private String detail;
	public RegisterException(String message,String detail) {
		super(message);
		this.detail = detail;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
}
