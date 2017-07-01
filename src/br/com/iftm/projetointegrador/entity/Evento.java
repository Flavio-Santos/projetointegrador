
package br.com.iftm.projetointegrador.entity;

import java.util.Date;
import java.util.LinkedList;

public class Evento {
	private String descricao;
	private String nomeevento;
	private Integer codevento = null;
	private Date datainicio;
	private Date datafim;
	private Categoria categoria;
	//O administrador é o voluntario na posicao 0
	private LinkedList<Voluntario> voluntarios = new LinkedList<Voluntario>();

	//Construtor quando se cria uma categoria para inseri-lá no banco de dados
	public Evento(String nomeevento, String descricao, Date datainicio, Date datafim, Categoria categoria, Voluntario administrador){
		this.descricao = descricao;
		this.nomeevento = nomeevento;
		this.datainicio = datainicio;
		this.datafim = datafim;
		this.categoria = categoria;
		this.voluntarios.add(0,administrador);
		administrador.associaEvento(this);
	}
		
	//Construtor quando se pega um Evento do banco de dados
	public Evento(String descricao, String nomeevento, Integer codevento, Date datainicio, Date datafim,
			Categoria categoria, Voluntario administrador) {
		this.descricao = descricao;
		this.nomeevento = nomeevento;
		this.codevento = codevento;
		this.datainicio = datainicio;
		this.datafim = datafim;
		this.categoria = categoria;
		this.voluntarios.add(0,administrador);
	}
	
	public Evento(){
		
	}
	
	public void associaVoluntario(Voluntario voluntatio){
		if (this.voluntarios.size() > 0 ) {
			this.voluntarios.add(voluntatio);
		}
	}

	public Integer getCodadmin(){
		return this.voluntarios.get(0).getCodvoluntario();
	}
	
	public String getNomeadmin(){
		return this.voluntarios.get(0).getNome();
	}
	
	public Integer getCodcategoria(){
		return categoria.getCodcategoria();
	}
	
	public String getNomecategoria(){
		return categoria.getNomecategoria();
	}
	
	public Integer getExperiencia(){
		return categoria.getExperiencia();
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
		return this.nomeevento;
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
	
	@Override
	public String toString() {
		String info = "";
		info += "EVENTO:";
		info += "\nNome = " + this.nomeevento;
		info += "\nDescricao = " + this.descricao;
		info += "\nData Inicio = " + this.datainicio;
		info += "\nData Fim = " + this.datafim;
		info += "\nCategoria = " + this.categoria.getNomecategoria();
		info += "\nAdministrador = " + this.getNomeadmin();
		
		return info;
	}	
}