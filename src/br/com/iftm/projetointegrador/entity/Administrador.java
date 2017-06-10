package br.com.iftm.projetointegrador.entity;

import java.util.Date;
import java.util.LinkedList;

public class Administrador extends Usuario{
	private Integer idadmin;
	private LinkedList<Evento> eventos = new LinkedList<Evento>();

	public Administrador(String nome, String email, String sexo, String hierarquia, Integer id, Integer idadmin) {
		super(nome, email, sexo, hierarquia, id);
		this.idadmin = idadmin;
	}
	
	public Integer getId(){
		return this.idadmin;
	}
	
	public Evento criaEvento(String nome, String descricao, Date datainicio, Date datafim, CategoriaEvento categoria, Administrador admin){
		Evento evento = new Evento(nome, descricao, datainicio, datafim, categoria, this);
		eventos.add(evento);
		return evento;
	}
	
}
