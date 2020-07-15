package com.cutomer.sanitize.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cutomer.sanitize.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	public User findByUsernameAndPassword(String username,String password);
	public User findByUsername(String username);
	
	

}
