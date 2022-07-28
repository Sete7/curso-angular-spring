package com.app.curso.dto;

import com.app.curso.entities.Curso;

public class CursoDTO {

	private String description;
	private Boolean done;

	public CursoDTO() {

	}

	public Curso convertDTO() {
		return new Curso(description, done);

	}

	public CursoDTO(String description, Boolean done) {
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
