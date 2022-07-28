package com.app.curso.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.app.curso.dto.CursoDTO;
import com.app.curso.entities.Curso;
import com.app.curso.repository.CursoRepository;
import com.app.curso.services.CursoService;

@RestController
@RequestMapping( value = "/api/curso")
@CrossOrigin( value = "http://localhost:4200")
public class CursoController {

	@Autowired
	private CursoRepository repository;

	@Autowired
	private CursoService cursoService;

	@PostMapping
	public ResponseEntity<?> salvar(@RequestBody CursoDTO dto) {
		try {
			Curso obj = cursoService.salvar(dto.convertDTO());
			return new ResponseEntity<>(obj, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
		}
	}

	@GetMapping("{id}")
	public Curso getById(@PathVariable Long id) {
		return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	@GetMapping(value = "listar")
	public ResponseEntity<?> listar() {
		try {
			List<Curso> obj = cursoService.listarTodos();
			return new ResponseEntity<>(obj, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
