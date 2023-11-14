package com.todolistapp.request;

import com.todolistapp.entity.Role;

public class AddUserRequest {

	private String username;
	private String password;
	private String emailId;
	private Role role;

	public AddUserRequest() {
	}

	public AddUserRequest(String username, String password, String emailid, Role role) {
		this.username = username;
		this.password = password;
		this.emailId = emailid;
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailid) {
		this.emailId = emailid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
