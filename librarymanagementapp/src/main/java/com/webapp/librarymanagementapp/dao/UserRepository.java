package com.webapp.librarymanagementapp.dao;

import org.springframework.data.repository.CrudRepository;

import com.webapp.librarymanagementapp.entities.User;

public interface UserRepository extends CrudRepository<User, Integer>{

	public User findByUsernameAndPassword(String username, String password);
	public User save(User user);
}