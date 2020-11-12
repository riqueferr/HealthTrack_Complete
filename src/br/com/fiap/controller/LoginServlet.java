package br.com.fiap.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.DAOFactory.DAOFactory;
import br.com.fiap.bo.EmailBO;
import br.com.fiap.dao.UsuarioDAO;
import br.com.fiap.exception.EmailException;
import br.com.fiap.model.Usuario;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UsuarioDAO dao;
	private EmailBO bo;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		dao = DAOFactory.getUsuarioDAO();
		bo = new EmailBO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");

		Usuario usuario = new Usuario(email, senha);

		if (dao.validarUsuario(usuario)) {
			HttpSession session = request.getSession();
			session.setAttribute("user", email);
			String mensagem = "Um login foi realizado!";

			try {
				bo.enviarEmail(email, "Login Realizado!", mensagem);
			} catch (EmailException e) {
				e.printStackTrace();
				;
			}
		} else {
			request.setAttribute("erro", "Usuário e/ou senha incorreto(s)...");
		}
		request.getRequestDispatcher("dashboard.jsp").forward(request, response);
	}

//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		HttpSession session = request.getSession();
//		session.invalidate();
//		request.getRequestDispatcher("dashboard.jsp").forward(request, response);
//	}
}
