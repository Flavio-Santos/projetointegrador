package br.com.iftm.projetointegrador.entity;

public class Categoria {

	private String nomecategoria;
	private String descricao;
	private Integer experiencia = 0;
	private Integer codcategoria;
	
	public Categoria(String nome, String descricao){
		this.nomecategoria = nome;
		this.descricao = descricao;
	}
	
	public Categoria(String nomecategoria, String descricao, Integer experiencia, Integer codcategoria) {
		super();
		this.nomecategoria = nomecategoria;
		this.descricao = descricao;
		this.experiencia = experiencia;
		this.codcategoria = codcategoria;
	}

	public Categoria() {
		super();
	}

	public String getNomecategoria() {
		return nomecategoria;
	}

	public void setNomecategoria(String nomecategoria) {
		this.nomecategoria = nomecategoria;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(Integer experiencia) {
		this.experiencia = experiencia;
	}

	public Integer getCodcategoria() {
		return codcategoria;
	}

	public void setCodcategoria(Integer codcategoria) {
		this.codcategoria = codcategoria;
	}
	
	
	
	
}
