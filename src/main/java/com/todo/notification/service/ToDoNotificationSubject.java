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
	
	@Autowired
	private SmsService smsService;

	private List<User> userObservers = new ArrayList<>();

	public void addObserver(User userObserver) {
		this.userObservers.add(userObserver);
	}

	public void removeObserver(User user) {
		this.userObservers.remove(user);
	}

	public void sendCompleteNotifEmailSms() {
		List<User> userObservers = userRepo.findCompletedTask();
		for (User user : userObservers) {
			// mail send
			notifyObserver.updateCompleteNotificationMail(user);
			//sms send
			smsService.sendSms(user.getPhoneNumber(), user.getTodoList(),true); }
	}

	public void sendReminderNotifEmailSms() {
		List<User> userDueDate = userRepo.getTaskDueDateDetails();
		for (User userTodoDetails : userDueDate) {
			// mail send
			notifyObserver.updateReminderNotificationMail(userTodoDetails);
			//sms send
			smsService.sendSms(userTodoDetails.getPhoneNumber(), userTodoDetails.getTodoList(),false);
		}
	}

}
