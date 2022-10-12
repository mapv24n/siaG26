package com.example.demo.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entidades.Curso;
import com.example.demo.servicios.CursoService;

@Controller
public class CursoControlador {
	
	@Autowired
	private CursoService cursoService;
	
	@GetMapping ("/siaG26")
	public String seleccionarCursos(Model model) {
		try {
			List<Curso> listaCursos = cursoService.findAll();
			System.out.println("listaCursos-->"+listaCursos.toString());
			model.addAttribute("cursos", listaCursos);
			
		}
		catch(Exception e) {
			System.out.println("Error: " + e);
		}	
		return "/index";
	}
	
	@GetMapping("/nuevoCurso")
	public String addCurso(Model model) {
		model.addAttribute("curso", new Curso());
		return "/addCurso";
	}
	
	@PostMapping("/saveCurso")
	public String addCurso(@Validated Curso curso) {
		System.out.println("Curso-->"+curso.toString());
		cursoService.save(curso);
		return "redirect:/siaG26";
	}
	
	@GetMapping("/editarCurso/{id}")
	public String Editar(@PathVariable int id, Model model) {
		Optional<Curso> curso = cursoService.findById(id);
		model.addAttribute("curso", curso.get());
		return "/edit";
	}
	
	@GetMapping("/eliminarCurso/{id}")
	public String eliminar(@PathVariable int id) {
		cursoService.deleteById(id);
		return "redirect:/siaG26";
	}
	
	@GetMapping("/mostrarCurso/{id}")
	public String mostrar(@PathVariable int id, Model model) {
		Optional<Curso> curso = cursoService.findById(id);
		model.addAttribute("curso", curso.get());
		return "/mostrar";
	}
	
}