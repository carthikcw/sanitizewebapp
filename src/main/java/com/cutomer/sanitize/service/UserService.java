package com.cutomer.sanitize.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cutomer.sanitize.entity.User;
import com.cutomer.sanitize.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userrepository;

	public User finduser(String username, String password) {
		User UserDetails = userrepository.findByUsernameAndPassword(username, password);
		return UserDetails;
	}
	
	public User finduserByUsername(String username) {
		User userDetails = userrepository.findByUsername(username);
		return userDetails;
	}

	public User addUser(User user) {
		User createdUser = userrepository.save(user);
		return createdUser;
	}
}
