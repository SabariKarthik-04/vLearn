package com.Vlearn.Auth_Service.Exception;


public class InvalidEmailPassException extends Exception{

	private static final long serialVersionUID = 1L;
	String detail;
	public InvalidEmailPassException(String message,String detail) {
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
