package com.taskbuzz.mediator;

import com.taskbuzz.entities.User;
import com.taskbuzz.services.UserService;

public class ServiceMediatorImpl implements ServiceMediator {
	private UserService userservice;

	@Override
	public User getUser(Long userId) {
		return userservice.getUserById(userId);
	}

	public ServiceMediatorImpl(UserService userservice) {
		super();
		this.userservice = userservice;
	}
}
