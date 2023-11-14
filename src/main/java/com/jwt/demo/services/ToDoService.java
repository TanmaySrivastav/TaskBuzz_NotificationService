package com.todolistapp.service;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.todolistapp.entity.CategoryFactory;
import com.todolistapp.entity.Todo;
import com.todolistapp.entity.User;
import com.todolistapp.mediator.ServiceMediator;
import com.todolistapp.mediator.ServiceMediatorImpl;
import com.todolistapp.repository.ToDoRepository;
import com.todolistapp.repository.UserRepository;
import com.todolistapp.request.AddToDoRequest;
import com.todolistapp.request.UpdateToDoRequest;

@Service
public class ToDoService {

	private UserRepository userrepository;
	private ToDoRepository todorepository;
	private UserService userService;

	public ToDoService(ToDoRepository todorepository, UserService userService, UserRepository userrepository) {
		super();
		this.todorepository = todorepository;
		this.userrepository = userrepository;
		this.userService = userService;
	}

	public Todo getToDoById(Long todoId) {
		return todorepository.findById(todoId).orElseThrow(() -> new NoSuchElementException());
	}

	public void addToDoList(Long userId, AddToDoRequest todoRequest) {
		System.out.println("Todo User POST called " + userId + "=" + todoRequest);
		ServiceMediator serviceMediator = new ServiceMediatorImpl(userService);
		User user = serviceMediator.getUser(userId);
		Todo todo = new Todo();
		todo.setTask(todoRequest.getTask());
		todo.setDueDate(todoRequest.getDueDate());
		todo.setPriority(todoRequest.getPriority());
		String category = new CategoryFactory().getCategoryType(todoRequest.getCategory());
		todo.setCategory(category);
		user.getTodoList().add(todo);
		System.out.println("POST call " + todoRequest.getTask());
		userrepository.save(user);
	}

	public void toggleToDoCompleted(Long todoId) {
		Todo todo = getToDoById(todoId);
		todo.setCompleted(!todo.getCompleted());
		todorepository.save(todo);
	}

	public void deleteToDo(Long userId, Long todoId) {
		ServiceMediator serviceMediator = new ServiceMediatorImpl(userService);
		User user = serviceMediator.getUser(userId);
		Todo todo = getToDoById(todoId);
		user.getTodoList().remove(todo);
		todorepository.delete(todo);
	}

	public void updateToDoById(Long todoId, UpdateToDoRequest updatetodorequest) {
		Todo todo = getToDoById(todoId);
		if (todo != null) {
			if (updatetodorequest.getDueDate() != null && updatetodorequest.getTask() != null
					&& updatetodorequest.getPriority() != null) {
				todo.setDueDate(updatetodorequest.getDueDate());
				todo.setTask(updatetodorequest.getTask());
				todo.setPriority(updatetodorequest.getPriority());
			} else if (updatetodorequest.getDueDate() != null) {
				todo.setDueDate(updatetodorequest.getDueDate());
			} else if (updatetodorequest.getTask() != null) {
				todo.setTask(updatetodorequest.getTask());
			} else if (updatetodorequest.getPriority() != null) {
				todo.setPriority(updatetodorequest.getPriority());
			}
			todorepository.save(todo);
		}
	}
}
