package com.cutomer.sanitize.exception;

public class UserNotFoundException extends  RuntimeException{
	public UserNotFoundException(String desc) {
		super(desc);
	}
}
