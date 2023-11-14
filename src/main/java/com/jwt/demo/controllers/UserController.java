
package com.todolistapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todolistapp.entity.User;
import com.todolistapp.request.AddUserRequest;
import com.todolistapp.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	private UserService userservice;

	public UserController(UserService userservice) {
		super();
		this.userservice = userservice;

	}

	@GetMapping("/{userId}")
	public User getUserById(@PathVariable Long userId) {
		return userservice.getUserById(userId);
	}

	@PostMapping
	public User addUser(@RequestBody AddUserRequest userRequest) {

		return userservice.addUser(userRequest);
	}

}