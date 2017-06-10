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
		this.nomeevento = nomeevento;
		this.descricao = descricao;
		this.idadmin = admin.getId();;
		this.datainicio = datainicio;
		this.datafim = datafim;
		this.categoria = categoria;
		categoria.assosiaEvento(this);
		this.admin = admin;
		
	}
	
	
	
	
}
