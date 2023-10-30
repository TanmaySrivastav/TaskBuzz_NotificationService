package com.jwt.demo.controllers;

import java.security.Principal;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.demo.entities.Todo;
import com.jwt.demo.entities.User;
import com.jwt.demo.repository.TodoRepository;
import com.jwt.demo.repository.UserRepository;
import com.jwt.demo.services.UserService;
import com.jwt.demo.todoapp.request.AddTodoRequest;

@RestController
@RequestMapping("/users")

public class UserController {

	@Autowired
	private UserService userService;

	private UserRepository userRepository;
	private TodoRepository todoRepository;

	public UserController(UserRepository userRepository, TodoRepository todoRepository) {
		this.userRepository = userRepository;
		this.todoRepository = todoRepository;
	}

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

}
