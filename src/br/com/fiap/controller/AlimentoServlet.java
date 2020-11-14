package br.com.fiap.controller;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.DataBindingException;

import br.com.fiap.DAOFactory.DAOFactory;
import br.com.fiap.dao.AlimentoDAO;
import br.com.fiap.dao.PeriodoAlimentoDAO;
import br.com.fiap.exception.DBException;
import br.com.fiap.model.Alimento;
import br.com.fiap.model.PeriodoAlimento;
import br.com.fiap.model.PressaoArterial;

@WebServlet("/alimento")
public class AlimentoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AlimentoDAO dao;
	private PeriodoAlimentoDAO periodoDao;

	public AlimentoServlet() {
		super();
	}

	@Override
	public void init() throws ServletException {
		super.init();
		dao = DAOFactory.getAlimentoDAO();
		periodoDao = DAOFactory.getPeriodoAlimento();
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
		List<Alimento> listaAlimento = dao.listarTodos();
		request.setAttribute("alimentos", listaAlimento);
		request.getRequestDispatcher("alimento.jsp").forward(request, response);
	}

	private void abrirFormCadastro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<PeriodoAlimento> listaPeriodo = periodoDao.listarTodos();
		carregarOpcoesPeriodo(request);
		request.getRequestDispatcher("alimento.jsp").forward(request, response);
	}

	private void abrirFormEdicao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("codigo"));
		Alimento alimento = dao.buscarPorId(id);
		request.setAttribute("alimento", alimento);
		request.getRequestDispatcher("edicao-alimento.jsp").forward(request, response);
		;
	}

	private void carregarOpcoesPeriodo(HttpServletRequest request) {
		List<PeriodoAlimento> lista = periodoDao.listarTodos();
		request.setAttribute("periodos", lista);
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

	}

	private void cadastrar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
//			stmt.setString(1, alimento.getNmAlimento());
//			stmt.setInt(2, alimento.getQtdeAlimento());
//			stmt.setInt(3, alimento.getQtdeCaloria());
//			stmt.setInt(4, alimento.getIdUsuario());
//			stmt.setInt(5, alimento.getPeriodoAlimento().getIdPeriodo());
//			java.sql.Date dataAtual = new java.sql.Date(alimento.getDtCadastro().getTimeInMillis());
//			stmt.setDate(6, dataAtual);
			
			String nmAlimento = request.getParameter("nmAlimento");
			Integer qtdeAlimento = Integer.parseInt(request.getParameter("qtdeAlimento"));
			Integer qtdeCaloria = Integer.parseInt(request.getParameter("qtdeCaloria"));
			Integer idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
			Integer idPeriodo = Integer.parseInt(request.getParameter("periodo"));
			Calendar dtCadastro = Calendar.getInstance();
			
			PeriodoAlimento periodo = new PeriodoAlimento();
			periodo.setIdPeriodo(idPeriodo);
			
			Alimento alimento = new Alimento(0, nmAlimento, qtdeAlimento, qtdeCaloria, idUsuario, dtCadastro);
			alimento.setPeriodoAlimento(periodo);
			
			dao.cadastrar(alimento);

			request.setAttribute("msg", "Alimento cadastrado!");
		} catch (DBException db) {
			db.printStackTrace();
			request.setAttribute("erro", "Erro ao cadastrar!");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", "Por favor, valide os dados!");
		}
		abrirFormCadastro(request, response);
	}
}
