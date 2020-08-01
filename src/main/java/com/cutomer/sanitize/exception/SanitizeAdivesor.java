package com.cutomer.sanitize.exception;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class SanitizeAdivesor extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status, WebRequest request) {

        Map<String, Object> body = new LinkedHashMap<>();
        List<String> errorMsg = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(x -> x.getDefaultMessage())
                .collect(Collectors.toList());
        body.put("errors", errorMsg);
        return new ResponseEntity<>(body, headers, HttpStatus.BAD_REQUEST);

    }
    
	@ExceptionHandler(InvalidDatesException.class)
	public ResponseEntity<Object> handleInvalidDatesException(InvalidDatesException ex, WebRequest request) {
		Map<String, Object> errormap = new HashMap<>();
		errormap.put("message", ex.getMessage());
		return new ResponseEntity<>(errormap, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Object> handleuserandpassword(UserNotFoundException ex, WebRequest request) {
		Map<String, Object> errormap = new HashMap<>();
		errormap.put("message", ex.getMessage());
		return new ResponseEntity<>(errormap, HttpStatus.OK);
	}
	@ExceptionHandler(UserCreationException.class)
	public ResponseEntity<Object> handleUserCreationException(UserCreationException ex, WebRequest request) {
		Map<String, Object> errormap = new HashMap<>();
		errormap.put("message", ex.getMessage());
		return new ResponseEntity<>(errormap, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(TermsConditonsException.class)
	public ResponseEntity<Object> handleTermsConditonsException(TermsConditonsException ex, WebRequest request) {
		Map<String, Object> errormap = new HashMap<>();
		errormap.put("message", ex.getMessage());
		return new ResponseEntity<>(errormap, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	

}
