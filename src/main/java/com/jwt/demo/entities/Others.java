package com.todolistapp.entity;

public class Others implements Category {

	@Override
	public String getCategory(String categoryType) {
		return "Others";
	}

}
