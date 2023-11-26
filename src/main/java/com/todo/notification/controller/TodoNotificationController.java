package com.todo.notification.controller;

import java.sql.Timestamp;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.notification.model.Todo;
import com.todo.notification.model.User;
import com.todo.notification.repository.ToDoNotificationObserver;
import com.todo.notification.repository.TodoDataRepo;
import com.todo.notification.repository.UserDataRepo;
import com.todo.notification.service.ToDoEmailNotificationService;
import com.todo.notification.service.ToDoNotificationSubject;

@RestController
@RequestMapping("/todo")
public class TodoNotificationController {

	@Autowired
	private ToDoNotificationSubject toDoSubject;

	@PostMapping("/completenotification")
	public ResponseEntity<String> completeNotificationMail() {
		toDoSubject.sendCompleteNotificationEmail();
		return ResponseEntity.ok("To-Do Tasks Notification mails sent to users");
	}

	@PostMapping("/remindernotification")
	public ResponseEntity<String> reminderNotificationMail() {
		toDoSubject.sendReminderNotificationEmail();
		return ResponseEntity.ok("To-Do Tasks Reminder mails sent to users");
	}

//	@PostMapping("/addobserver/{userId}")
//	public ResponseEntity<String> addObservers(@PathVariable String userId) {
//		Long userIdLong = Long.parseLong(userId);
//		Optional<User> user = userRepo.findById(userIdLong);
//		if (user.isPresent()) {
//			User userMail = user.get();
//			// System.out.println("User Present" + user.toString());
//			toDoSubject.addObserver(userMail);
//		} else {
//			return ResponseEntity.ok("User with id: " + userId + " not present");
//		}
//
//		return ResponseEntity.ok("New user added to observer list");
//	}

}
