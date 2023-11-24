package br.com.fiap.mm.model.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Historico {

	private int id;
	
	@NotNull
	private Paciente paciente;  // id do paciente
	
	@NotBlank
	private String febre;
	
	@NotBlank
	private String alcool;
	
	@NotBlank
	private String alergia;
	
	@NotBlank
	private String antibioticos;
	
	@NotBlank
	private String medicamentos;
	
	@NotBlank
	private String doencas;
	
	@NotBlank
	private String cardio;
	
	@NotBlank
	private String fumo;
	
	@NotBlank
	private String diabetes;
	
	@NotBlank
	private String gravidez;
	
	@NotBlank
	private String implantes;
	
	@NotBlank
	private String cicatrizacao;
	
	
	
	// construtor vazio
	public Historico() {

	}
	
	
	// getters e setters
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getCicatrizacao() {
		return cicatrizacao;
	}

	public void setCicatrizacao(String cicatrizacao) {
		this.cicatrizacao = cicatrizacao;
	}

	public Paciente getPaciente() {
		return paciente;
	}
	
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
	public String getFebre() {
		return febre;
	}
	
	public void setFebre(String febre) {
		this.febre = febre;
	}
	
	public String getAlcool() {
		return alcool;
	}
	
	public void setAlcool(String alcool) {
		this.alcool = alcool;
	}
	
	public String getAlergia() {
		return alergia;
	}
	
	public void setAlergia(String alergia) {
		this.alergia = alergia;
	}
	
	public String getAntibioticos() {
		return antibioticos;
	}
	
	public void setAntibioticos(String antibioticos) {
		this.antibioticos = antibioticos;
	}
	
	public String getMedicamentos() {
		return medicamentos;
	}
	
	public void setMedicamentos(String medicamentos) {
		this.medicamentos = medicamentos;
	}
	
	public String getDoencas() {
		return doencas;
	}
	
	public void setDoencas(String doencas) {
		this.doencas = doencas;
	}
	
	public String getCardio() {
		return cardio;
	}
	
	public void setCardio(String cardio) {
		this.cardio = cardio;
	}
	
	public String getFumo() {
		return fumo;
	}
	
	public void setFumo(String fumo) {
		this.fumo = fumo;
	}
	
	public String getDiabetes() {
		return diabetes;
	}
	
	public void setDiabetes(String diabetes) {
		this.diabetes = diabetes;
	}
	
	public String getGravidez() {
		return gravidez;
	}
	
	public void setGravidez(String gravidez) {
		this.gravidez = gravidez;
	}
	
	public String getImplantes() {
		return implantes;
	}
	
	public void setImplantes(String implantes) {
		this.implantes = implantes;
	}

	
	
}