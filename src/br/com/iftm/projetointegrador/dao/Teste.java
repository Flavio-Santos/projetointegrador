package br.com.iftm.projetointegrador.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.iftm.projetointegrador.entity.Evento;
import br.com.iftm.projetointegrador.entity.Voluntario;

public class Teste {

	public static void main(String[] args) throws SQLException {
		Voluntario vol1 = new Voluntario();
		vol1.setCodvoluntario(2);
		AdministradorDAO admdao = new AdministradorDAO();
		List<Evento> eventosPorAdministrador = admdao.eventosPorAdministrador(vol1);
		System.out.println(eventosPorAdministrador);
	}

}
