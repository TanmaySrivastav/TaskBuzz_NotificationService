package com.todolistapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Todo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long ToDoId;
	private String Task;
	private Boolean Completed = Boolean.FALSE;

	public Todo(Long toDoId, String task, Boolean completed) {
		super();
		ToDoId = toDoId;
		Task = task;
		Completed = completed;
	}

	public Todo() {
	}

	public Long getToDoId() {
		return ToDoId;
	}

	public void setToDoId(Long toDoId) {
		ToDoId = toDoId;
	}

	public String getTask() {
		return Task;
	}

	public void setTask(String task) {
		Task = task;
	}

	public Boolean getCompleted() {
		return Completed;
	}

	public void setCompleted(Boolean completed) {
		Completed = completed;
	}

}
