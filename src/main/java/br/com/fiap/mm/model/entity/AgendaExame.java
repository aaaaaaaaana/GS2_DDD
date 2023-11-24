package br.com.fiap.mm.model.entity;

import java.sql.Timestamp;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public class AgendaExame {
	
	private int id;
	
	@NotNull
	private Paciente paciente; // id do paciente
	
	@NotBlank
	private String tipo;
	
	@NotBlank
	private String laboratorio;
	
	@PositiveOrZero
	@FutureOrPresent
	private Timestamp dataHora;
	
	// construtor vazio
	public AgendaExame() {

	}

	// getters e setters
	public Paciente getPaciente() {
		return paciente;
	}
	
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getLaboratorio() {
		return laboratorio;
	}
	
	public void setLaboratorio(String laboratorio) {
		this.laboratorio = laboratorio;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Timestamp getDataHora() {
		return dataHora;
	}
	
	public void setDataHora(Timestamp dataHora) {
		this.dataHora = dataHora;
	}
	


}