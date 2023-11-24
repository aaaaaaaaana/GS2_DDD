package br.com.fiap.mm.model.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Robo {
	
	
	private int id;
	
	@NotNull
	private int numSerie;
	
	@NotBlank
	private String funcao;
	
	
	private Instituicao instituicao; // id da instituicao
	
	// construtor vazio
	public Robo() {

	}
	
	// getters e setters
	public Instituicao getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(Instituicao instituicao) {
		this.instituicao = instituicao;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getNumSerie() {
		return numSerie;
	}
	
	public void setNumSerie(int numSerie) {
		this.numSerie = numSerie;
	}
	
	public String getFuncao() {
		return funcao;
	}
	
	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
}