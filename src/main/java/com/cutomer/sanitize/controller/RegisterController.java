package com.cutomer.sanitize.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cutomer.sanitize.entity.User;
import com.cutomer.sanitize.exception.UserCreationException;
import com.cutomer.sanitize.service.UserService;
import com.cutomer.sanitize.util.AES;

@RestController
@RequestMapping("/v1")
public class RegisterController {
	/*
	 * @Autowired private PasswordEncoder passwordEncoder;
	 */

	@Autowired
	private UserService userService;
	@Autowired
	private PasswordEncoder encoder;

	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@Valid @RequestBody User uservo) {
		
		uservo.setEnabled(true);
		//uservo.setPassword(encoder.encode(uservo.getPassword()));
		uservo.setPassword(AES.encrypt(uservo.getPassword(),"sanitize"));
		User createduser = userService.addUser(uservo);
		if (createduser == null) {
			throw new UserCreationException("User creation is failed");
		}
		Map<String, Object> body = new LinkedHashMap<>();
		body.put("status", "success");
		body.put("message", "User Created Successfully");
		return new ResponseEntity<>(body, HttpStatus.OK);
	}

}
