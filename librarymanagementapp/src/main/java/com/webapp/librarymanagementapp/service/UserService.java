package com.webapp.librarymanagementapp.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp.librarymanagementapp.dao.UserRepository;
import com.webapp.librarymanagementapp.entities.User;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User findByUsernameAndPassword(String username, String password) {
		return this.userRepository.findByUsernameAndPassword(username,password);
	}
	
	public void saveUser(User user) {
        userRepository.save(user);
    }
}
