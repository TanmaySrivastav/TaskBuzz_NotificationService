package com.todo.notification.repository;

import org.springframework.stereotype.Repository;

@Repository
public interface ToDoNotificationSubjects {

	void registerObserver(ToDoNotificationObserver observer);

	void removeObserver(ToDoNotificationObserver observer);

	void notifyObservers(String message);
}
