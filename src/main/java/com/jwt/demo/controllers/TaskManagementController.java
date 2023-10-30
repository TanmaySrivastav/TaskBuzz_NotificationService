package com.jwt.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.demo.entities.Todo;
import com.jwt.demo.entities.User;
import com.jwt.demo.repository.TodoRepository;
import com.jwt.demo.repository.UserRepository;
import com.jwt.demo.services.TaskManagementService;
import com.jwt.demo.services.UserService;
import com.jwt.demo.todoapp.request.AddTodoRequest;

@RestController
@RequestMapping("/Todo")

public class TaskManagementController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private TaskManagementService managementService;

	private UserRepository userRepository;
	private TodoRepository todoRepository;

	public TaskManagementController(TodoRepository todoRepository) {
	
	{
	  this.todoRepository = todoRepository;
	}
   }
	
	@PostMapping("/{userId}/todos")
	public User addTodo(@PathVariable Long userId, @RequestBody AddTodoRequest todoRequest) {

		return managementService.addTodo(userId, todoRequest);

	}
	
	@PostMapping("/todos/{todoId}")
	public Todo toggleTodoCompleted(@PathVariable Long todoId) {
		
		return managementService.toggleTodoCompleted(todoId);
	}
	
	@DeleteMapping("{userId}/todos/{todoId}")
	public void deleteTodo(@PathVariable Long userId, @PathVariable Long todoId) {
		
		managementService.deleteTodo(userId, todoId);
	}
	
}
