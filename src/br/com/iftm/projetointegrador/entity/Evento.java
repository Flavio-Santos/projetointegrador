package br.com.iftm.projetointegrador.entity;

import java.util.Date;
import java.util.LinkedList;

public class Evento {
	private String descricao;
	private String nomeevento;
	private Integer codevento;
	private Date datainicio;
	private Date datafim;
	private Categoria categoria;
	private Voluntario administrador ;
	private LinkedList<Voluntario> voluntarios = new LinkedList<Voluntario>();

	public Evento(String descricao, String nomeevento, Integer codevento, Date datainicio, Date datafim,
			Categoria categoria, Voluntario administrador) {
		this.descricao = descricao;
		this.nomeevento = nomeevento;
		this.codevento = codevento;
		this.datainicio = datainicio;
		this.datafim = datafim;
		this.categoria = categoria;
		this.administrador = administrador;
	}

	public Evento(String nomeevento, String descricao, Date datainicio, Date datafim){
		this.descricao = descricao;
		this.nomeevento = nomeevento;
		this.datainicio = datainicio;
		this.datafim = datafim;
	}

	public Evento(String nome, String descricao) {
		this.nomeevento = nome;
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNomeevento() {
		return nomeevento;
	}

	public void setNomeevento(String nomeevento) {
		this.nomeevento = nomeevento;
	}

	public Date getDatainicio() {
		return datainicio;
	}

	public void setDatainicio(Date datainicio) {
		this.datainicio = datainicio;
	}

	public Date getDatafim() {
		return datafim;
	}

	public void setDatafim(Date datafim) {
		this.datafim = datafim;
	}

	public Integer getCodevento() {
		return codevento;
	}

	public void setCodevento(Integer codevento) {
		this.codevento = codevento;
	}

	
	
	
	
	
}
