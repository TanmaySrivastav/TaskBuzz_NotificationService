package com.todolistapp.mediator;

import com.todolistapp.entity.User;
import com.todolistapp.service.UserService;

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
