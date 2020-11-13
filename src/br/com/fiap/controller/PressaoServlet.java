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
import br.com.fiap.model.PressaoArterial;
import br.com.fiap.model.Usuario;

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
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			Integer nrSistolica = Integer.parseInt(req.getParameter("sistolica"));
			Integer nrDiastolica = Integer.parseInt(req.getParameter("diastolica"));
			Calendar dtCadastro = Calendar.getInstance();
			Integer idUsuario = Integer.parseInt(req.getParameter("idusuario"));
 
			PressaoArterial pressao = new PressaoArterial (0, nrSistolica, nrDiastolica, dtCadastro, idUsuario);
			dao.cadastrar(pressao);
			
			req.setAttribute("mensagemPressao", "Pressão cadastrada!");
		} catch (DBException db) {
			db.printStackTrace();
			req.setAttribute("erroPressao", "Erro ao cadastrar pressão.");
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("erroPressao", "Por favor, valide as informações.");
		}
		req.getRequestDispatcher("pressao.jsp").forward(req, resp);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<PressaoArterial> listaPressao = dao.listarTodos();
		request.setAttribute("pressoes", listaPressao);
		request.getRequestDispatcher("pressao.jsp").forward(request, response);
		}

}
