package com.todo.notification.service;

import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.todo.notification.model.Todo;
import com.todo.notification.model.User;
import com.todo.notification.repository.ToDoNotificationObserver;

@Service
public class ToDoEmailNotificationService implements ToDoNotificationObserver {

	private JavaMailSender javaMailSender;

	public ToDoEmailNotificationService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	@Override
	public void updateCompleteNotificationMail(User user) {
		try {
			sendCompleteNotificationMail(user);
		} catch (MailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void sendCompleteNotificationMail(User user) {
		for (Todo todo : user.getTodoList()) {
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setTo(user.getEmailId());
			mailMessage.setSubject("Task: " + todo.getTask() + " Completed");
			mailMessage.setText("Your Task " + todo.getTask() + " has been completed.");
			javaMailSender.send(mailMessage);
		}
	}

	private void sendReminderNotificationMail(User user) {
		for (Todo todo : user.getTodoList()) {
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setTo(user.getEmailId());
			mailMessage.setSubject("Task: " + todo.getTask() + " Due date is near");
			mailMessage.setText("Your Task " + todo.getTask() + " is due by " + todo.getDueDate());
			javaMailSender.send(mailMessage);
		}
	}

	@Override
	public void updateReminderNotificationMail(User user) {
		try {
			sendReminderNotificationMail(user);
		} catch (MailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
