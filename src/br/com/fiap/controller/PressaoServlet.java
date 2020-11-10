package br.com.fiap.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.DAOFactory.DAOFactory;
import br.com.fiap.dao.PressaoArterialDAO;
import br.com.fiap.model.PressaoArterial;

/**
 * Servlet implementation class PressaoServlet
 */
@WebServlet("/pressoes")
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
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<PressaoArterial> listaPressao = dao.listarTodos();
		request.setAttribute("pressoes", listaPressao);
		request.getRequestDispatcher("pressao.jsp").forward(request, response);
		}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
