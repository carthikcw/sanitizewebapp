package com.cutomer.sanitize.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cutomer.sanitize.entity.User;
import com.cutomer.sanitize.exception.UserNotFoundException;
import com.cutomer.sanitize.service.UserService;
import com.cutomer.sanitize.util.AES;

@RestController
@RequestMapping("/v1")
public class LoginController {

	@Autowired
	private UserService userservice;
	@Autowired
	private PasswordEncoder encoder;

	@PostMapping("/login2")
	public ResponseEntity<?> getUserDetails(@RequestBody User uservo) {
		//uservo.setPassword(encoder.encode(uservo.getPassword()));
		// uservo.setPassword(AES.decrypt(uservo.getPassword(),"sanitize"));
		User userdata = userservice.finduserByUsername(uservo.getUsername());
		if(userdata!=null) {
			if(userdata.getPassword() == AES.decrypt(uservo.getPassword(),"sanitize"))
			{
				throw new UserNotFoundException("Invalid username and password");
			}
		}
		else
			throw new UserNotFoundException("Invalid username");	
	
		/*
		 * User usedata = userservice.finduser(uservo.getUsername(),
		 * uservo.getPassword()); if (usedata == null) { throw new
		 * UserNotFoundException("Invalid username and password");
		 * 
		 * }
		 */
		return new ResponseEntity<>(userdata, HttpStatus.OK);

	}

}
