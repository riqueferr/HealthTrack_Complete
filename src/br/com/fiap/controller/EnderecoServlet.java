package br.com.fiap.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.DAOFactory.DAOFactory;
import br.com.fiap.dao.EnderecoDAO;
import br.com.fiap.dao.UsuarioDAO;
import br.com.fiap.model.Alimento;
import br.com.fiap.model.Endereco;

/**
 * Servlet implementation class EnderecoServlet
 */
@WebServlet("/endereco")
public class EnderecoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private EnderecoDAO dao;
	private UsuarioDAO usuarioDao;
    @Override
	public void init() throws ServletException {
		dao = DAOFactory.getEnderecoDAO();
		usuarioDao = DAOFactory.getUsuarioDAO();
		super.init();
	}

	public EnderecoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String acao = request.getParameter("acao");
		
		switch (acao) {
		case "listar":
			listar(request, response);
			break;

		default:
			break;
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	
	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Endereco> lista = dao.listarTodos();
		request.setAttribute("enderecos", lista);
		request.getRequestDispatcher("endereco.jsp").forward(request, response);
	}
}
