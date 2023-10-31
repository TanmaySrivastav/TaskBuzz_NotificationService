package com.todolistapp.controller;

import java.util.NoSuchElementException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todolistapp.entity.Todo;
import com.todolistapp.entity.User;
import com.todolistapp.repository.ToDoRepository;
import com.todolistapp.repository.UserRepository;
import com.todolistapp.request.AddToDoRequest;

@RestController
@RequestMapping("/todos")
public class ToDoController {

	private UserRepository userrepository;
	private ToDoRepository todorepository;

	public ToDoController(UserRepository userrepository, ToDoRepository todorepository) {
		super();
		this.userrepository = userrepository;
		this.todorepository = todorepository;
	}

	@GetMapping("/{ToDoId}")
	public Todo getToDoById(@PathVariable Long ToDoId) {
		return todorepository.findById(ToDoId).orElseThrow(() -> new NoSuchElementException());
	}

	@PostMapping("/{UserId}/todos")
	public void addTodo(@PathVariable Long UserId, @RequestBody AddToDoRequest todoRequest) {
		System.out.println("Todo User POST called " + UserId + "=" + todoRequest);
		User user = userrepository.findById(UserId).orElseThrow(() -> new NoSuchElementException());
		Todo todo = new Todo();
		todo.setTask(todoRequest.getTask());
		user.getTodoList().add(todo);
		System.out.println("POST call " + todoRequest.getTask());
		userrepository.save(user);

	}

	@PostMapping("/todos/{ToDoId}")
	public void toggleTodoCompleted(@PathVariable Long ToDoId) {
		Todo todo = todorepository.findById(ToDoId).orElseThrow(() -> new NoSuchElementException());
		todo.setCompleted(!todo.getCompleted());
		todorepository.save(todo);
	}
}
