package com.app.curso.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.curso.dto.CursoDTO;
import com.app.curso.entities.Curso;
import com.app.curso.repository.CursoRepository;

@Service
public class CursoService {

	@Autowired
	private CursoRepository repository;

	public List<Curso> listarTodos() {
		List<Curso> obj = repository.findAll();
		return obj;
	}

	@Transactional
	public Curso salvar(Curso obj) {
		Curso curso = repository.save(obj);
		return curso;
	}

}
