package br.com.fiap.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.DAOFactory.DAOFactory;
import br.com.fiap.dao.PressaoArterialDAO;
import br.com.fiap.exception.DBException;
import br.com.fiap.model.Alimento;
import br.com.fiap.model.PressaoArterial;
import br.com.fiap.model.Usuario;

/**
 * Servlet implementation class PressaoServlet
 */
@WebServlet("/pressao")
public class PressaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private PressaoArterialDAO dao;

	public PressaoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		super.init();
		dao = DAOFactory.getArterialDAO();
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
		List<PressaoArterial> listaPressao = dao.listarTodos();
		request.setAttribute("pressoes", listaPressao);
		request.getRequestDispatcher("pressao.jsp").forward(request, response);
	}

	private void abrirFormCadastro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("cadastrarPressao.jsp").forward(request, response);
	}

	private void abrirFormEdicao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("codigo"));
		PressaoArterial pressao = dao.buscarPorId(id);
		request.setAttribute("pressao", pressao);
		request.getRequestDispatcher("editarPressao.jsp").forward(request, response);
		;
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String acao = req.getParameter("acao");

		switch (acao) {
		case "cadastrar":
			cadastrar(req, resp);
			break;
		case "editar":
			editar(req, resp);
			break;
		case "excluir":
			excluir(req, resp);
			break;
		}
	}

	private void cadastrar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Integer nrSistolica = Integer.parseInt(req.getParameter("sistolica"));
			Integer nrDiastolica = Integer.parseInt(req.getParameter("diastolica"));
			Calendar dtCadastro = Calendar.getInstance();
			Integer idUsuario = Integer.parseInt(req.getParameter("idusuario"));

			PressaoArterial pressao = new PressaoArterial(0, nrSistolica, nrDiastolica, dtCadastro, idUsuario);
			dao.cadastrar(pressao);

			req.setAttribute("msg", "Pressão cadastrada!");
		} catch (DBException db) {
			db.printStackTrace();
			req.setAttribute("erro", "Erro ao cadastrar pressão.");
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("erro", "Por favor, valide as informações.");
		}
		abrirFormCadastro(req, resp);
	}

	private void editar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Integer nrSistolica = Integer.parseInt(req.getParameter("sistolica"));
			Integer nrDiastolica = Integer.parseInt(req.getParameter("diastolica"));
			Calendar dtCadastro = Calendar.getInstance();
			Integer idUsuario = Integer.parseInt(req.getParameter("idusuario"));

			PressaoArterial pressao = new PressaoArterial(0, nrSistolica, nrDiastolica, dtCadastro, idUsuario);
			dao.cadastrar(pressao);

			req.setAttribute("msg", "Pressão Atualizada!");
		} catch (DBException db) {
			db.printStackTrace();
			req.setAttribute("erro", "Erro ao atualuizar.");
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("erro", "Por favor, valide os dados!");
		}
	}

	private void excluir(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int codigo = Integer.parseInt(req.getParameter("codigo"));
		try {
			dao.remover(codigo);
			req.setAttribute("msg", "Pressão removida");
		} catch (DBException e) {
			e.printStackTrace();
			req.setAttribute("erro", "Erro ao excluir");
		}
		listar(req, resp);
	}
}
