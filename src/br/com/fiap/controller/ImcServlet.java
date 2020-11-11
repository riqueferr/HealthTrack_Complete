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

/**
 * Servlet implementation class ImcServlet
 */
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
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Imc> lista = dao.listarTodos();
		request.setAttribute("imcs", lista);
		request.getRequestDispatcher("peso.jsp").forward(request, response);
	}
 
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
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
	
	
}
