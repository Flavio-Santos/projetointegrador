package br.com.iftm.projetointegrador.entity;

public abstract class Usuario {
	private String nome;
	private String login;
	private String senha;
	private String sexo;
	private Integer experiencia = 0;
	private String hierarquia;
	private Integer id;
	
	public Usuario(String nome, String login, String sexo, String hierarquia, Integer id) {
		this.nome = nome;
		this.login = login;
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
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
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

	public Integer getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(Integer experiencia) {
		this.experiencia = experiencia;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}

