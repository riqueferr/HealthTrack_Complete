package br.com.fiap.controller;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.DAOFactory.DAOFactory;
import br.com.fiap.dao.PagDAO;
import br.com.fiap.dao.TipoPagamentoDAO;
import br.com.fiap.exception.DBException;
import br.com.fiap.model.Alimento;
import br.com.fiap.model.Pagamento;
import br.com.fiap.model.PeriodoAlimento;
import br.com.fiap.model.TipoPagamento;

/**
 * Servlet implementation class PagamentoServlet
 */
@WebServlet("/pagamento")
public class PagamentoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	private PagDAO dao;
	private TipoPagamentoDAO tipoPagDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PagamentoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    
    
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		dao = DAOFactory.getPagDAO();
		tipoPagDAO = DAOFactory.getTipoPagamentoDAO();
	}




	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
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
		List<Pagamento> listaPagamento = dao.listarTodos();
		request.setAttribute("pagamentos", listaPagamento);
		request.getRequestDispatcher("pagamento.jsp").forward(request, response);
	}

	private void abrirFormCadastro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<TipoPagamento> listaTipoPag = tipoPagDAO.listarTodos();
		carregarOpcoesPagamento(request);
		request.getRequestDispatcher("cadastrarPagamento.jsp").forward(request, response);
	}

	private void abrirFormEdicao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("codigo"));
		Pagamento pagamento = dao.buscarPorId(id);
		request.setAttribute("pagamento", pagamento);
		request.getRequestDispatcher("editarPagamento.jsp").forward(request, response);
		;
	}

	private void carregarOpcoesPagamento(HttpServletRequest request) {
		List<TipoPagamento> lista = tipoPagDAO.listarTodos();
		request.setAttribute("tipos", lista);
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
			Integer qtdeParcela = Integer.parseInt(request.getParameter("qtdeParcela"));
			Double vlTotal = Double.parseDouble(request.getParameter("vlTotal"));
			Integer idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
			Integer idTipo = Integer.parseInt(request.getParameter("tipoPagamento"));
			Calendar dtCadastro = Calendar.getInstance();

			TipoPagamento tp = new TipoPagamento();
			tp.setCodigo(idTipo);
			
			Pagamento pagamento = new Pagamento(0, qtdeParcela, vlTotal, idUsuario, dtCadastro);
			pagamento.setTipoPagamento(tp);
			
			dao.cadastrar(pagamento);
			
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
