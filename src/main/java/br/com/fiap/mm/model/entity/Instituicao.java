package br.com.fiap.mm.model.entity;

import jakarta.validation.constraints.NotBlank;

public class Instituicao {
	
	private int id;
	
	@NotBlank
	private String cnpj;
	
	@NotBlank
	private String nome;
	
	@NotBlank
	private String endereco; 
	
	@NotBlank
	private String tipo;
	
	
	// construtor vazio
	public Instituicao() {

	}
	
	
	// getters e setters
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getCnpj() {
		return cnpj;
	}
	
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}