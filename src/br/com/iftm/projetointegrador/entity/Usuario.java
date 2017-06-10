package br.com.iftm.projetointegrador.entity;

public abstract class Usuario {
	private String nome;
	private String email;
	private String senha;
	private String sexo;
	private String hierarquia;
	private Integer id;
	
	public Usuario(String nome, String email, String sexo, String hierarquia, Integer id) {
		this.nome = nome;
		this.email = email;
		this.sexo = sexo;
		this.hierarquia = hierarquia;
		this.id = id;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getHierarquia() {
		return hierarquia;
	}
	public void setHierarquia(String hierarquia) {
		this.hierarquia = hierarquia;
	}	

	public Integer getId(){
		return this.id;
	}
}

