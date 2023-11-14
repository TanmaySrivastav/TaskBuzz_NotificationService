package com.todolistapp.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todolistapp.entity.Todo;
import com.todolistapp.request.AddToDoRequest;
import com.todolistapp.request.UpdateToDoRequest;
import com.todolistapp.service.ToDoService;
import com.todolistapp.service.UserService;

@RestController
@RequestMapping("/todos")
public class ToDoController {

	private ToDoService todoservice;

	public ToDoController(UserService userservice, ToDoService todoservice) {
		super();
		this.todoservice = todoservice;
	}

	@GetMapping("/{todoId}")
	public Todo getToDoById(@PathVariable Long todoId) {
		return todoservice.getToDoById(todoId);
	}

	@PostMapping("/{userId}/todos")
	public void addTodo(@PathVariable Long userId, @RequestBody AddToDoRequest todoRequest) {

		todoservice.addToDoList(userId, todoRequest);
	}

	@PostMapping("/todos/{todoId}")
	public void toggleTodoCompleted(@PathVariable Long todoId) {
		todoservice.toggleToDoCompleted(todoId);
	}

	@PutMapping("/todos/{todoId}")
	public void updateToDoById(@PathVariable Long todoId, @RequestBody UpdateToDoRequest updatetodorequest) {
		todoservice.updateToDoById(todoId,updatetodorequest);
	}

	@DeleteMapping("{userId}/todos/{todoId}")
	public void deleteTodo(@PathVariable Long userId, @PathVariable Long todoId) {
		todoservice.deleteToDo(userId, todoId);
	}
}
