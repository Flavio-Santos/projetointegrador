package br.com.iftm.projetointegrador.entity;

public class Voluntario {
	private String login;
	private String nome;
	private String senha;
	private Integer codvoluntario;
	private String email;
	private String sexo;
	private Boolean admin = false;
	private Boolean ativo = true;
	private Integer experiencia = 0;
	private Patente patente = new Patente("Recruta", 0, 1);
	
	public Voluntario(String login, String nome, String senha, Integer codvoluntario, Boolean admin, Boolean ativo, String email,
			Integer experiencia, String sexo, Patente patente) {
		super();
		this.login = login;
		this.nome = nome;
		this.senha = senha;
		this.codvoluntario = codvoluntario;
		this.admin = admin;
		this.ativo = ativo;
		this.email = email;
		this.experiencia = experiencia;
		this.sexo = sexo;
		this.patente = patente;
	}
	
	//Construtor usado na cadastrado de novo usuario
	public Voluntario(String login, String nome, String senha, String email, String sexo) {
		super();
		this.login = login;
		this.nome = nome;
		this.senha = senha;
		this.email = email;
		this.sexo = sexo;
	}

	public Voluntario() {
	}

	public String getLogin() {
		return login;
	}
	
	public int getCodpatente() {
		return patente.getCodpatente();
	}
	
	public String getNomepatente() {
		return patente.getNomepatente();
	}
	public void setLogin(String login) {
		this.login = login;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Boolean getAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(Integer experiencia) {
		this.experiencia = experiencia;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Integer getCodvoluntario() {
		return codvoluntario;
	}	
	
}
