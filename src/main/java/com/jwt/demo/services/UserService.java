package com.jwt.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.jwt.demo.entities.Todo;
import com.jwt.demo.entities.User;
import com.jwt.demo.repository.TodoRepository;
import com.jwt.demo.repository.UserRepository;
import com.jwt.demo.todoapp.request.AddTodoRequest;

@Service
public class UserService {

	//private List<User> store= new ArrayList<>();
    @Autowired   
	private UserRepository userRepository;
    @Autowired 
    private TodoRepository todoRepository;

    
    @Autowired
    private PasswordEncoder passwordEncoder;
	
	public List<User> getUsers(){
		return userRepository.findAll();
	}
	
	public User createUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
		
	}
	
	public User addTodo(Long userId, AddTodoRequest todoRequest) {

		User user = userRepository.findById(userId).orElseThrow(() -> new NoSuchElementException());
		Todo todo = new Todo();
		todo.setContent(todoRequest.getContent());
		user.getTodoList().add(todo);

		return userRepository.save(user);
     }
	
	public Todo toggleTodoCompleted(Long todoId) {
		Todo todo = todoRepository.findById(todoId).orElseThrow(() -> new NoSuchElementException());
		todo.setCompleted(!todo.getCompleted());
		return todoRepository.save(todo);
	}
	
	public User getUserById(Long userId) {
		return userRepository.findById(userId).orElseThrow(() -> new NoSuchElementException());
	}
	
	
	public void deleteTodo(@PathVariable Long userId, @PathVariable Long todoId) {
		User user = userRepository.findById(userId).orElseThrow(() -> new NoSuchElementException());
		Todo todo = todoRepository.findById(todoId).orElseThrow(() -> new NoSuchElementException());
		user.getTodoList().remove(todo);
		todoRepository.delete(todo);
	}
	
	
}
