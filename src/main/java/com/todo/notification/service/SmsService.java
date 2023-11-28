package com.todo.notification.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.todo.notification.model.Todo;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

@Service
public class SmsService {

	@Value("${twilio.account.sid}")
	private String sid;

	@Value("${twilio.account.authtoken}")
	private String authToken;

	@Value("${twilio.account.fromphonenumber}")
	private String fromPhoneNumber;

	public void sendSms(String toNumber, List<Todo> todoTaskList, boolean isCompleteNotification) {
		for (Todo todoTask : todoTaskList) {
			String msgBody = null;
			if (isCompleteNotification) {
				msgBody = createCompleteNotifMsg(todoTask);

			} else {
				msgBody = createReminderNotifMsg(todoTask);
			}
			Twilio.init(sid, authToken);
			Message message = Message.creator(new com.twilio.type.PhoneNumber(toNumber),
					new com.twilio.type.PhoneNumber(fromPhoneNumber), msgBody).create();
			System.out.println(message.getSid());
		}
	}

	private String createCompleteNotifMsg(Todo todoTask) {
		if (null != todoTask.getTask())
			return "Your Task " + todoTask.getTask() + " has been completed.";
		return null;
	}

	private String createReminderNotifMsg(Todo todoTask) {
		if (null != todoTask.getTask() & null != todoTask.getDueDate())
			return "Your Task " + todoTask.getTask() + " is due by " + todoTask.getDueDate();
		return null;
	}

}
