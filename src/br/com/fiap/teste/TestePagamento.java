package br.com.fiap.teste;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import br.com.fiap.dao.impl.PagamentoDAOImpl;
import br.com.fiap.exception.DBException;
import br.com.fiap.model.Pagamento;

public class TestePagamento {

	public static void main(String[] args) throws DBException {
		
		PagamentoDAOImpl dao = new PagamentoDAOImpl();	
		SimpleDateFormat formatacaoData = new SimpleDateFormat("dd/MM/yyyy");
		
		
		Pagamento pagamentoA = new Pagamento();
		pagamentoA.setDtCadastro(Calendar.getInstance());
		pagamentoA.setIdTipoPag(1);
		pagamentoA.setIdUsuario(8002);
		pagamentoA.setVlTotal(478.50);
		pagamentoA.setQtdeParcela(7);
		dao.cadastrar(pagamentoA);
		
		Pagamento pagamentoB = new Pagamento();
		pagamentoB.setDtCadastro(Calendar.getInstance());
		pagamentoB.setIdTipoPag(2);
		pagamentoB.setIdUsuario(8001);
		pagamentoB.setVlTotal(508.20);
		pagamentoB.setQtdeParcela(1);
		dao.cadastrar(pagamentoB);
		
		Pagamento pagamentoC = new Pagamento();
		pagamentoC.setDtCadastro(Calendar.getInstance());
		pagamentoC.setIdTipoPag(2);
		pagamentoC.setIdUsuario(8003);
		pagamentoC.setVlTotal(249.98);
		pagamentoC.setQtdeParcela(1);
		dao.cadastrar(pagamentoC);
		
		Pagamento pagamentoD = new Pagamento();
		pagamentoD.setDtCadastro(Calendar.getInstance());
		pagamentoD.setIdTipoPag(3);
		pagamentoD.setIdUsuario(8004);
		pagamentoD.setVlTotal(272.11);
		pagamentoD.setQtdeParcela(1);
		dao.cadastrar(pagamentoD);
		
		Pagamento pagamentoE = new Pagamento();
		pagamentoE.setDtCadastro(Calendar.getInstance());
		pagamentoE.setIdTipoPag(3);
		pagamentoE.setIdUsuario(8005);
		pagamentoE.setVlTotal(564.96);
		pagamentoE.setQtdeParcela(1);
		dao.cadastrar(pagamentoE);

		List<Pagamento> lista = dao.listarTodos();
		for (Pagamento pagamentos: lista) {
			System.out.println("ID: "+ pagamentos.getIdPagamento()  + " - Parcelas: "
					+ pagamentos.getQtdeParcela() + " - Valor total: " + pagamentos.getVlTotal() +  " "
					+ " - Tipo de Pagamento: " + pagamentos.getDsTipoPag() + " - ID do Usuário: " + pagamentos.getIdUsuario() + " - Data de Registro Pagamento: " 
					+ formatacaoData.format(pagamentos.getDtCadastro().getTime()));
			}
	}
	
	


}
