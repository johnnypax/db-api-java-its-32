package com.archety.lez02_mavendb;

public class Persona {
	
	private int id;
	private String nome;
	private String cogn;
	private String codf;
	private String emai;
	private String tele;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCogn() {
		return cogn;
	}
	public void setCogn(String cogn) {
		this.cogn = cogn;
	}
	public String getCodf() {
		return codf;
	}
	public void setCodf(String codf) {
		this.codf = codf;
	}
	public String getEmai() {
		return emai;
	}
	public void setEmai(String emai) {
		this.emai = emai;
	}
	public String getTele() {
		return tele;
	}
	public void setTele(String tele) {
		this.tele = tele;
	}
	@Override
	public String toString() {
		return "Persona [id=" + id + ", nome=" + nome + ", cogn=" + cogn + ", codf=" + codf + ", emai=" + emai
				+ ", tele=" + tele + "]";
	}
	
	
	
	

}
