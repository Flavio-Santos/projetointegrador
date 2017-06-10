package br.com.iftm.projetointegrador.entity;

import java.util.LinkedList;

public class CategoriaEvento {
	private String nomecategoria;
	private String descricao;
	private Integer experiencia;
	private Integer id;
	private LinkedList<Evento> eventos = new LinkedList<Evento>();
	
	public CategoriaEvento(String nomecategoria, String descricao, Integer experiencia, Integer id) {
		this.nomecategoria = nomecategoria;
		this.descricao = descricao;
		this.experiencia = experiencia;
		this.id = id;
	}

	public void assosiaEvento(Evento evento) {
		this.eventos.add(evento);
	}
	
	
}
