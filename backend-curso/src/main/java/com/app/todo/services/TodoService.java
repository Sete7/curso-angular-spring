package com.app.todo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.todo.dto.TodoDTO;
import com.app.todo.entities.Todo;
import com.app.todo.repository.TodoRepository;

@Service
public class TodoService {

	@Autowired
	private TodoRepository repository;

	public List<Todo> listarTodos() {
		List<Todo> obj = repository.findAll();
		return obj;
	}

	@Transactional
	public Todo salvar(Todo obj) {
		Todo todo = repository.save(obj);
		return todo;
	}

}
