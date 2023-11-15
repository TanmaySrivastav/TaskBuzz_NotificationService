package com.taskbuzz.controllers;

import java.util.List;
import java.security.Principal;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taskbuzz.entities.User;
import com.taskbuzz.services.UserService;
import com.taskbuzz.todoapp.request.AddUserRequest;



@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/allusers")
	public List<User> getUser() {

		return userService.getUsers();
	}

	@GetMapping("/current-user")
	public String getLoggedInUser(Principal principal) {
		return principal.getName();
	}

	@PostMapping("/create-user")
	public User createUser(@RequestBody User user) {

		return userService.createUser(user);
	}

	@GetMapping("/{userId}")
	public User getUserById(@PathVariable Long userId) {
		return userService.getUserById(userId);
	}

	@PostMapping
	public User addUser(@RequestBody AddUserRequest userRequest) {

		return userService.addUser(userRequest);
	}

}