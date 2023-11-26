package com.todo.notification.repository;

import org.springframework.stereotype.Repository;

import com.todo.notification.model.User;

@Repository
public interface ToDoNotificationObserver {

	void updateCompleteNotificationMail(User user);
	
	void updateReminderNotificationMail(User user);
}
