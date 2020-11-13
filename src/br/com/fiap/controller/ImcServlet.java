package br.com.fiap.controller;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.DAOFactory.DAOFactory;
import br.com.fiap.dao.ImcDAO;
import br.com.fiap.exception.DBException;
import br.com.fiap.model.Imc;

@WebServlet("/imc")
public class ImcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ImcDAO dao;

	@Override
	public void init() throws ServletException {
		super.init();
		dao = DAOFactory.getImcDAO();
	}

	public ImcServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String acao = request.getParameter("acao");

		switch (acao) {
		case "listar":
			listar(request, response);
			break;
		case "abrir-form-edicao":
			abrirFormEdicao(request, response);
			break;
		}
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Imc> lista = dao.listarTodos();
		request.setAttribute("imcs", lista);
		request.getRequestDispatcher("peso.jsp").forward(request, response);
	}

	private void abrirFormEdicao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("codigo"));
		Imc imc = dao.buscarPorId(id);
		request.setAttribute("imc", imc);
		request.getRequestDispatcher("edicao-imc.jsp").forward(request, response);
		;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String acao = request.getParameter("acao");

		switch (acao) {
		case "cadastrar":
			cadastrar(request, response);
			break;
		case "excluir":
			excluir(request, response);
			break;
		case "editar":
			editar(request, response);
			break;
		}
	}

	private void cadastrar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try

		{
			Calendar dtCadastro = Calendar.getInstance();
			Double altura = Double.parseDouble(request.getParameter("altura"));
			Double peso = Double.parseDouble(request.getParameter("peso"));
//			Double valor = peso / (altura * altura);
			Double valor = Double.valueOf(new DecimalFormat("####,00").format((peso / (altura * altura))));
			Integer idUsuario = Integer.parseInt(request.getParameter("idUsuario"));

			Imc imc = new Imc(0, valor, dtCadastro, peso, altura, idUsuario);
			dao.cadastrar(imc);

			request.setAttribute("mensagemImc", "Imc cadastrado!");
		} catch (DBException db) {
			db.printStackTrace();
			request.setAttribute("erroImc", "Erro ao cadastrar imc.");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erroImc", "Por favor, valide as informações.");
		}
		request.getRequestDispatcher("peso.jsp").forward(request, response);
	}

	private void excluir(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		try {
			dao.remover(codigo);
			request.setAttribute("msg", "Removido com sucesso!");
		} catch (DBException e) {
			e.printStackTrace();
			request.setAttribute("erro", "Erro ao atualizar");
		}
		listar(request, response);
	}

	private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try

		{
			int codigo = Integer.parseInt(request.getParameter("codigo"));
			Calendar dtCadastro = Calendar.getInstance();
			Double altura = Double.parseDouble(request.getParameter("altura"));
			Double peso = Double.parseDouble(request.getParameter("peso"));
//			Double valor = peso / (altura * altura);
			Double valor = Double.valueOf(new DecimalFormat("####,00").format((peso / (altura * altura))));
			Integer idUsuario = Integer.parseInt(request.getParameter("idUsuario"));

			Imc imc = new Imc(codigo, valor, dtCadastro, peso, altura, idUsuario);
			dao.atualizar(imc);

		} catch (DBException db) {
			db.printStackTrace();
			request.setAttribute("erro", "Erro ao atualizar!");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", "Por favor, valide os dados!");
		}
	}
}
