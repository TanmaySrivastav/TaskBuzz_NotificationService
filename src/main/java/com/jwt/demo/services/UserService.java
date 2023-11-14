package com.todolistapp.service;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.todolistapp.entity.User;
import com.todolistapp.repository.UserRepository;
import com.todolistapp.request.AddUserRequest;

@Service
public class UserService {

	private UserRepository userrepository;

	public UserService(UserRepository userrepository) {
		super();
		this.userrepository = userrepository;
	}

	public User getUserById(Long userId) {
		return userrepository.findById(userId).orElseThrow(() -> new NoSuchElementException());
	}

	public User addUser(AddUserRequest userRequest) {
		System.out.println("User POST called" + userRequest);
		User user = new User();
		user.setUsername(userRequest.getUsername());
		System.out.println(userRequest.getUsername());
		user.setEmailId(userRequest.getEmailId());
		user.setPassword(userRequest.getPassword());
		user.setRole(userRequest.getRole());
		return userrepository.save(user);
	}
}
