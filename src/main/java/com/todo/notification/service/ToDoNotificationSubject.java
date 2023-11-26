package com.todo.notification.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.notification.model.User;
import com.todo.notification.repository.ToDoNotificationObserver;
import com.todo.notification.repository.UserDataRepo;

@Service
public class ToDoNotificationSubject {

	@Autowired
	private ToDoNotificationObserver notifyObserver;

	@Autowired
	private UserDataRepo userRepo;

	private List<User> userObservers = new ArrayList<>();

	public void addObserver(User userObserver) {
		this.userObservers.add(userObserver);
	}

	public void removeObserver(User user) {
		this.userObservers.remove(user);
	}

	public void sendCompleteNotificationEmail() {
		List<User> userObservers = userRepo.findCompletedTask();
		for (User user : userObservers) {
			notifyObserver.updateCompleteNotificationMail(user);
		}
	}

	public void sendReminderNotificationEmail() {
		List<User> userDueDate = userRepo.getTaskDueDateDetails();
		for (User userTodoDetails : userDueDate) {
			notifyObserver.updateReminderNotificationMail(userTodoDetails);
		}
	}

}
