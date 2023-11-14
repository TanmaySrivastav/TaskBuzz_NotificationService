package com.todolistapp.entity;

public class Assignment implements Category {

	@Override
	public String getCategory(String categoryType) {
		return "Assignment";
	}

}
