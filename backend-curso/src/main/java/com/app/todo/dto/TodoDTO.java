package com.app.todo.dto;

import com.app.todo.entities.Todo;

public class TodoDTO {

	private String description;
	private Boolean done;

	public TodoDTO() {

	}

	public Todo convertDTO() {
		return new Todo(description, done);

	}

	public TodoDTO(String description, Boolean done) {
		this.description = description;
		this.done = done;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getDone() {
		return done;
	}

	public void setDone(Boolean done) {
		this.done = done;
	}

}
