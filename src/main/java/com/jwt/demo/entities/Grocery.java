package com.todolistapp.entity;

public class Grocery implements Category {

	@Override
	public String getCategory(String categoryType) {
		return "Grocery";
	}

}
