package br.com.fiap.controller;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.DAOFactory.DAOFactory;
import br.com.fiap.dao.AtividadeDAO;
import br.com.fiap.dao.TipoAtvDAO;
import br.com.fiap.exception.DBException;
import br.com.fiap.model.Alimento;
import br.com.fiap.model.Atividade;
import br.com.fiap.model.PeriodoAlimento;
import br.com.fiap.model.TipoAtv;

/**
 * Servlet implementation class AtividadeServlet
 */
@WebServlet("/atividade")
public class AtividadeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AtividadeDAO dao;
	private TipoAtvDAO tipoAtvDao;
	
	
	
	
    @Override
	public void init() throws ServletException {
		dao = DAOFactory.getAtividadeDAO();
		tipoAtvDao = DAOFactory.getTipoAtvDAO();
	}

	public AtividadeServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String acao = request.getParameter("acao");

		switch (acao) {
		case "listar":
			listar(request, response);
			break;
		case "abrir-form-cadastro":
			abrirFormCadastro(request, response);
			break;
		case "abrir-form-edicao":
			abrirFormEdicao(request, response);
			break;
		}
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Atividade> lista = dao.listarTodos();
		request.setAttribute("atividades", lista);
		request.getRequestDispatcher("atividade.jsp").forward(request, response);
	}

	private void abrirFormCadastro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		carregarOpcoesTipoAtividade(request);
		request.getRequestDispatcher("cadastrarAtividade.jsp").forward(request, response);
	}

	private void abrirFormEdicao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("codigo"));
		Atividade atividade = dao.buscarPorId(id);
		request.setAttribute("atividade", atividade);
		carregarOpcoesTipoAtividade(request);
		request.getRequestDispatcher("editarAtividade.jsp").forward(request, response);
		;
	}

	private void carregarOpcoesTipoAtividade(HttpServletRequest request) {
		List<TipoAtv> lista = tipoAtvDao.listarTodos();
		request.setAttribute("tipoAtividade", lista);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String acao = request.getParameter("acao");

		switch (acao) {
		case "cadastrar":
			cadastrar(request, response);
			break;
		case "editar":
			editar(request, response);
			break;
		case "excluir":
			excluir(request, response);
			break;
		}
	}

	private void excluir(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int codigo = Integer.parseInt("codigo");
		try {
			dao.remover(codigo);
			request.setAttribute("msg", "Produto removido");
		} catch (DBException e) {
			e.printStackTrace();
			request.setAttribute("erro", "Erro ao excluir");
		}
		listar(request, response);
	}

	private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int codigo = Integer.parseInt(request.getParameter("codigo"));
			Integer vlTempo = Integer.parseInt(request.getParameter("vlTempo"));
			Double vlDistancia = Double.parseDouble(request.getParameter("vlDistancia"));
			Integer idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
			Integer idTipoAtividade = Integer.parseInt(request.getParameter("tipoAtividade"));
			Calendar dtCadastro = Calendar.getInstance();

			TipoAtv tipoAtividade = new TipoAtv();
			tipoAtividade.setIdTipoAtv(idTipoAtividade);

			Atividade atividade = new Atividade(codigo, dtCadastro, vlTempo, vlDistancia, idUsuario);

			dao.atualizar(atividade);

			request.setAttribute("msg", "Alimento atulizado.");
		} catch (DBException db) {
			db.printStackTrace();
			request.setAttribute("erro", "Erro ao atualizar.");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", "Por favor, valide os dados.");
		}
		listar(request, response);
	}

	private void cadastrar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Integer vlTempo = Integer.parseInt(request.getParameter("vlTempo"));
			Double vlDistancia = Double.parseDouble(request.getParameter("vlDistancia"));
			Integer idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
			Integer idTipoAtividade = Integer.parseInt(request.getParameter("tipoAtividade"));
			Calendar dtCadastro = Calendar.getInstance();

			TipoAtv tipoAtividade = new TipoAtv();
			tipoAtividade.setIdTipoAtv(idTipoAtividade);

			Atividade atividade = new Atividade(0, dtCadastro, vlTempo, vlDistancia, idUsuario);

			dao.cadastrar(atividade);

			request.setAttribute("msg", "Atividade cadastrado!");
		} catch (DBException db) {
			db.printStackTrace();
			request.setAttribute("erro", "Erro ao cadastrar.");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", "Por favor, valide os dados.");
		}
		abrirFormCadastro(request, response);
	}
    
}
