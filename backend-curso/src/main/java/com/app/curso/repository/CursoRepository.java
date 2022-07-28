package com.app.curso.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.curso.entities.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {

}
