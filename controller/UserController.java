
package com.todolistapp.controller;

import java.util.NoSuchElementException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todolistapp.entity.User;
import com.todolistapp.repository.UserRepository;
import com.todolistapp.request.AddUserRequest;

@RestController
@RequestMapping("/users")
public class UserController {

	private UserRepository userrepository;

	public UserController(UserRepository userrepository) {
		super();
		this.userrepository = userrepository;

	}

	@GetMapping("/{UserId}")
	public User getUserById(@PathVariable Long UserId) {
		return userrepository.findById(UserId).orElseThrow(() -> new NoSuchElementException());
	}

	@PostMapping
	public User addUser(@RequestBody AddUserRequest userRequest) {
		System.out.println("User POST called" + userRequest);
		User user = new User();
		user.setUsername(userRequest.getUsername());
		System.out.println(userRequest.getUsername());
		user.setEmailId(userRequest.getEmailId());
		user.setPassword(userRequest.getPassword());
		return userrepository.save(user);

	}

}