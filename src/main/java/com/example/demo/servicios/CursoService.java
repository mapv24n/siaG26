package com.example.demo.servicios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entidades.Curso;

@Repository
public interface CursoService extends JpaRepository<Curso, Integer> {
	
}
