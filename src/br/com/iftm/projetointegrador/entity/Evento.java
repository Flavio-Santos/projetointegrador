package br.com.iftm.projetointegrador.entity;

import java.util.Date;
import java.util.LinkedList;

public class Evento {
	private String nomeevento;
	private String descricao;
	private Integer idadmin;
	private Date datainicio;
	private Date datafim;
	private CategoriaEvento categoria;
	private Administrador admin;
	private LinkedList<Voluntario> voluntarios = new LinkedList<Voluntario>();
	
	public Evento(String nomeevento, String descricao, Date datainicio, Date datafim, CategoriaEvento categoria, Administrador admin) {
		super();
		this.setNomeEvento(nomeevento);
		this.setDescricao(descricao);
		this.idadmin = admin.getId();;
		this.setDataInicio(datainicio);
		this.setDataFim(datafim);
		this.categoria = categoria;
		categoria.assosiaEvento(this);
		this.admin = admin;
	}
	
	public Evento(String nomeevento, String descricao, Date datainicio, Date datafim){
		this.setNomeEvento(nomeevento);
		this.setDescricao(descricao);
		this.setDataInicio(datainicio);
		this.setDataFim(datafim);
	}

	public Evento(String nome, String descricao) {
		this.nomeevento = nome;
		this.descricao = descricao;
	}

	public String getNomeEvento() {
		return nomeevento;
	}

	public void setNomeEvento(String nomeevento) {
		this.nomeevento = nomeevento;
	}


	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataInicio() {
		return datainicio;
	}

	public void setDataInicio(Date datainicio) {
		this.datainicio = datainicio;
	}

	public Date getDataFim() {
		return datafim;
	}

	public void setDataFim(Date datafim) {
		this.datafim = datafim;
	}

	
	
	
	
}
