package br.com.models;

import java.util.Random;

public class Cliente {
	private Integer id;
	private String sobreNome;
	private String rg;
	private String cpf;
	
	public Cliente(String sobreNome, String rg, String cpf) {
		Random gerador = new Random();
		this.id = gerador.nextInt();
		this.sobreNome = sobreNome;
		this.rg = rg;
		this.cpf = cpf;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSobreNome() {
		return sobreNome;
	}
	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	

}
