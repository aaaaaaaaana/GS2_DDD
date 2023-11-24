package br.com.fiap.mm.model.entity;


import jakarta.validation.constraints.NotBlank;


public class Paciente {
	
	private int id;
	
	@NotBlank
	private String nome;

	
	@NotBlank
	private String cpf;
	
	private Robo robo; // id do robo
	
	
	// construtor vazio
	public Paciente() {

	}
	
	// getters e setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Robo getRobo() {
		return robo;
	}

	public void setRobo(Robo robo) {
		this.robo = robo;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	

}