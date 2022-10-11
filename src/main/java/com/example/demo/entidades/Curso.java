package com.example.demo.entidades;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Curso {
	
	@Id
	private int codCurso;
	private String Grado;
	private String Grupo;
	
	public int getCodCurso() {
		return codCurso;
	}
	public void setCodCurso(int codCurso) {
		this.codCurso = codCurso;
	}
	public String getGrado() {
		return Grado;
	}
	public void setGrado(String grado) {
		Grado = grado;
	}
	public String getGrupo() {
		return Grupo;
	}
	public void setGrupo(String grupo) {
		Grupo = grupo;
	}
	
	

}
