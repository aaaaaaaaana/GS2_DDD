package br.com.fiap.mm.model.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ResultadoExame {
	
	private int id;
	
	@NotNull
	private Paciente paciente; // id do paciente
	
	@NotBlank
	private String laboratorio;
	
	@NotBlank
	private String exameUrina;
	
	@NotBlank
	private String exameColesterol;
	
	@NotBlank
	private String exameEletrocardiograma;
	
	@NotBlank
	private String exameSangue;
	
	
	// construtor vazio
	public ResultadoExame() {

	}
	
	// getters e setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public String getLaboratorio() {
		return laboratorio;
	}

	public void setLaboratorio(String laboratorio) {
		this.laboratorio = laboratorio;
	}

	public String getExameUrina() {
		return exameUrina;
	}

	public void setExameUrina(String exameUrina) {
		this.exameUrina = exameUrina;
	}

	public String getExameColesterol() {
		return exameColesterol;
	}

	public void setExameColesterol(String exameColesterol) {
		this.exameColesterol = exameColesterol;
	}

	public String getExameEletrocardiograma() {
		return exameEletrocardiograma;
	}

	public void setExameEletrocardiograma(String exameEletrocardiograma) {
		this.exameEletrocardiograma = exameEletrocardiograma;
	}

	public String getExameSangue() {
		return exameSangue;
	}

	public void setExameSangue(String exameSangue) {
		this.exameSangue = exameSangue;
	}
	
	

}