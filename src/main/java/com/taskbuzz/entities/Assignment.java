package com.taskbuzz.entities;

public class Assignment implements Category {

	@Override
	public String getCategory(String categoryType) {
		return "Assignment";
	}

}
