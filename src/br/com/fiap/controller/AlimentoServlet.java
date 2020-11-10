package br.com.fiap.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.dao.AlimentoDAO;
import br.com.fiap.model.Alimento;
import br.com.fiap.model.PressaoArterial;

/**
 * Servlet implementation class AlimentoServlet
 */
@WebServlet("/AlimentoServlet")
public class AlimentoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AlimentoDAO dao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AlimentoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Alimento> listaAlimento = dao.listarTodos();
		request.setAttribute("pressoes", listaAlimento);
		request.getRequestDispatcher("alimento.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
