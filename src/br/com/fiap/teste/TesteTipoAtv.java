package br.com.fiap.teste;

import java.util.List;

import br.com.fiap.DAOFactory.DAOFactory;
import br.com.fiap.dao.PeriodoAlimentoDAO;
import br.com.fiap.dao.TipoAtvDAO;
import br.com.fiap.exception.DBException;
import br.com.fiap.model.PeriodoAlimento;
import br.com.fiap.model.TipoAtv;

public class TesteTipoAtv {


	public static void main(String[] args) throws DBException {

		TipoAtvDAO dao = DAOFactory.getTipoAtvDAO();
		List<TipoAtv> lista = dao.listarTodos();
		for( TipoAtv item : lista) {
			System.out.println(item.getDsTipoAtv());
		}
	
	}
	
}
