package br.com.iftm.projetointegrador.entity;

import java.util.LinkedList;

public class Voluntario extends Usuario{
	private String tiposangue;
	private Integer experencia;
	private Patente patente;
	private LinkedList<Evento> eventos = new LinkedList<Evento>();
	
	public Voluntario(String nome, String email, String sexo, Integer experencia, String hierarquia, Integer id) {
		super(nome, email, sexo, hierarquia, id);
	}
	
	public void participaEvento(Evento evento){
		
		this.eventos.add(evento);
		
	}
	
	private void aumentaExperiencia(Integer exp){
		this.experencia += exp;
	}
	
	
}
