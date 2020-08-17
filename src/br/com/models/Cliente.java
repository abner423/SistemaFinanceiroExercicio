package br.com.models;

public class Cliente {
	private Integer id;
	private String sobreNome;
	private Long rg;
	private String cpf;
	
	public Cliente(Integer id, String sobreNome, Long rg, String cpf) {
		this.id = id;
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
	public Long getRg() {
		return rg;
	}
	public void setRg(Long rg) {
		this.rg = rg;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	

}
