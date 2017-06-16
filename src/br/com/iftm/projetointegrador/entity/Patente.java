package br.com.iftm.projetointegrador.entity;

public class Patente {
	private String nomepatente;
	private Integer expnecessaria;
	private Integer codpatente;
	
	public Patente(String nomepatente, Integer expnecessaria, Integer codpatente) {
		super();
		this.nomepatente = nomepatente;
		this.expnecessaria = expnecessaria;
		this.codpatente = codpatente;
	}
	
	public Patente(){
	}

	public void setNomepatente(String nomepatente) {
		this.nomepatente = nomepatente;
	}

	public void setExpnecessaria(Integer expnecessaria) {
		this.expnecessaria = expnecessaria;
	}

	public void setCodpatente(Integer codpatente) {
		this.codpatente = codpatente;
	}

	public String getNomepatente() {
		return nomepatente;
	}

	public Integer getExpnecessaria() {
		return expnecessaria;
	}

	public Integer getCodpatente() {
		return codpatente;
	}
	
}
