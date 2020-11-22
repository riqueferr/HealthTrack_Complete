package br.com.fiap.teste;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import br.com.fiap.dao.impl.AtividadeDAPOImpl;
import br.com.fiap.exception.DBException;
import br.com.fiap.model.Atividade;

public class TesteAtividade {

	public static void main(String[] args) throws DBException {
		AtividadeDAPOImpl dao = new AtividadeDAPOImpl();
		SimpleDateFormat formatacaoData = new SimpleDateFormat("dd/MM/yyyy");
		
		Atividade a = new Atividade();
		a = dao.buscarPorId(51);
		a.setVlDistancia(10.0);
		try {
			dao.atualizar(a);
			System.out.println("Produto alterado");
		} catch (DBException e) {
			e.printStackTrace();
		}

	}

}
