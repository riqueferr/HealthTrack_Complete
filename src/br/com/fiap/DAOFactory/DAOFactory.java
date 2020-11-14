package br.com.fiap.DAOFactory;

import br.com.fiap.dao.AlimentoDAO;
import br.com.fiap.dao.AtividadeDAO;
import br.com.fiap.dao.EnderecoDAO;
import br.com.fiap.dao.ImcDAO;
import br.com.fiap.dao.PeriodoAlimentoDAO;
import br.com.fiap.dao.PressaoArterialDAO;
import br.com.fiap.dao.TipoPagamentoDAO;
import br.com.fiap.dao.UsuarioDAO;
import br.com.fiap.dao.impl.AlimentoDAOImpl;
import br.com.fiap.dao.impl.AtividadeDAPOImpl;
import br.com.fiap.dao.impl.EnderecoDAOImpl;
import br.com.fiap.dao.impl.ImcDAOImpl;
import br.com.fiap.dao.impl.PeriodoAlimentoDAOImpl;
import br.com.fiap.dao.impl.PressaoArterialDAOImpl;
import br.com.fiap.dao.impl.TipoPagamentoDAOImpl;
import br.com.fiap.dao.impl.UsuarioDAOImpl;
import br.com.fiap.model.PeriodoAlimento;

public class DAOFactory {

	public static UsuarioDAO getUsuarioDAO() {
		return new UsuarioDAOImpl();
	}

	public static AlimentoDAO getAlimentoDAO() {
		return new AlimentoDAOImpl();
	}

	public static AtividadeDAO getAtividadeDAO() {
		return new AtividadeDAPOImpl();
	}

	public static EnderecoDAO getEnderecoDAO() {
		return new EnderecoDAOImpl();
	}

	public static ImcDAO getImcDAO() {
		return new ImcDAOImpl();
	}

	public static PressaoArterialDAO getArterialDAO() {
		return new PressaoArterialDAOImpl();
	}
	
	public static TipoPagamentoDAO getTipoPagamentoDAO() {
		return new TipoPagamentoDAOImpl();
	}

	public static PeriodoAlimentoDAO getPeriodoAlimento() {
		return new PeriodoAlimentoDAOImpl();
	}
}
