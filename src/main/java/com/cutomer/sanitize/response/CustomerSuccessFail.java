package com.cutomer.sanitize.response;

public class CustomerSuccessFail {
	
	private String status;
	private String message;
	
	public CustomerSuccessFail() {
		super();
	}
	public CustomerSuccessFail(String status, String message) {
		super();
		this.status = status;
		this.message = message;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "CustomerSuccessFail [status=" + status + ", message=" + message + "]";
	}
	
	
	

}
