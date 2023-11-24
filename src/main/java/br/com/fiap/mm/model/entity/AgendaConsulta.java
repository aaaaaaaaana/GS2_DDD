package br.com.fiap.mm.model.entity;

import java.sql.Timestamp;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public class AgendaConsulta {
	
	private int id;
	@NotNull
	private Paciente paciente; // id do paciente
	
	@NotBlank
	private String especialidade;
	
	@NotBlank
	private String local;
	
	@PositiveOrZero
	@FutureOrPresent
	private Timestamp dataHora;
	
	
	// construtor vazio
	public AgendaConsulta() {

	}
	
	// getters e setters
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
	public String getEspecialidade() {
		return especialidade;
	}
	
	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
	
	public String getLocal() {
		return local;
	}
	
	public void setLocal(String local) {
		this.local = local;
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
	
	public void setDataHora(Timestamp timestamp) {
		this.dataHora = timestamp;
	}

}