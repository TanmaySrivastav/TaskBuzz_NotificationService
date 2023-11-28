package com.todo.notification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.notification.service.ToDoNotificationSubject;

@RestController
@RequestMapping("/todo")
public class TodoNotificationController {

	@Autowired
	private ToDoNotificationSubject toDoSubject;

	@PostMapping("/completenotification")
	public ResponseEntity<String> completeNotificationMail() {
		toDoSubject.sendCompleteNotifEmailSms();
		return ResponseEntity.ok("To-Do Tasks Notification mails & sms sent to users");
	}

	@PostMapping("/remindernotification")
	public ResponseEntity<String> reminderNotificationMail() {
		toDoSubject.sendReminderNotifEmailSms();
		return ResponseEntity.ok("To-Do Tasks Reminder mails & sms sent to users");
	}


}
