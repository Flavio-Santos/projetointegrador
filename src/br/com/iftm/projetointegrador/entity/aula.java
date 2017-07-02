package br.com.iftm.projetointegrador.entity;

import java.sql.SQLException;
import java.util.Date;

import br.com.iftm.projetointegrador.dao.VoluntarioDAO;

public class aula {
	public static void main(String[] args) {
		Date hoje = new Date();
		
		Voluntario v = new Voluntario("login", "Ariel", "senha", "ronney@email.com", "m");
		Categoria c = new Categoria("Categoria 1", "Categoria de teste");
		Evento e1 = new Evento("Super Doacao","Evento de teste", hoje, hoje, c,v);
		Evento e2 = new Evento("Mega Doacao","Evento de teste", hoje, hoje, c,v);
		
		
		VoluntarioDAO vd = new VoluntarioDAO();
		try {
			vd.getVoluntario(1);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
