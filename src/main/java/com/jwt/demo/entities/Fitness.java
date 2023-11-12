package com.todolistapp.entity;

public class Fitness implements Category {

	@Override
	public String getCategory(String categoryType) {
		return "Fitness";
	}

}
