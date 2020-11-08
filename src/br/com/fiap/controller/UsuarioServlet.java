package br.com.fiap.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.DAOFactory.DAOFactory;
import br.com.fiap.dao.UsuarioDAO;
import br.com.fiap.exception.DBException;
import br.com.fiap.model.Usuario;

/**
 * Servlet implementation class UsuarioServlet
 */
@WebServlet("/usuario")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UsuarioDAO dao;

	public UsuarioServlet() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		super.init();
		dao = DAOFactory.getUsuarioDAO();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			String nome = req.getParameter("nome");
			String sobrenome = req.getParameter("sobrenome");
			String email = req.getParameter("email");
			String senha = req.getParameter("senha");

			Date dataf = format.parse(req.getParameter("dtNasc"));
			java.sql.Date dtNasc = new java.sql.Date(dataf.getTime());

			Calendar dtCadastro = Calendar.getInstance();
			dtCadastro.setTime(format.parse(req.getParameter("dtCadastro")));

			Usuario usuario = new Usuario(0, nome, sobrenome, email, senha, dtNasc, dtCadastro);
			dao.cadastrar(usuario);

			req.setAttribute("mensagemUsuario", "Usuario cadastrado!");
		} catch (DBException db) {
			db.printStackTrace();
			req.setAttribute("erroUsuario", "Erro ao cadastrar usuário.");
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("erroUsuario", "Por favor, valide as informações.");
		}
		req.getRequestDispatcher("register.jsp").forward(req, resp);
	}
}
