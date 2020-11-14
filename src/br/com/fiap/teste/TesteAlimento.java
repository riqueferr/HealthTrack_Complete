package br.com.fiap.teste;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import br.com.fiap.DAOFactory.DAOFactory;
import br.com.fiap.dao.PeriodoAlimentoDAO;
import br.com.fiap.dao.impl.AlimentoDAOImpl;
import br.com.fiap.exception.DBException;
import br.com.fiap.model.Alimento;
import br.com.fiap.model.PeriodoAlimento;

public class TesteAlimento {

	public static void main(String[] args) throws DBException {

		AlimentoDAOImpl dao = new AlimentoDAOImpl();
		SimpleDateFormat formatacaoData = new SimpleDateFormat("dd/MM/yyyy");

//		Alimento alimentoA = new Alimento();
//		alimentoA.setNmAlimento("Mandioca");
//		alimentoA.setDtCadastro(Calendar.getInstance());
//		alimentoA.setIdPeriodo(1);
//		alimentoA.setIdUsuario(8001);
//		alimentoA.setQtdeAlimento(5);
//		alimentoA.setQtdeCaloria(105);
//		dao.cadastrar(alimentoA);
//		
//		Alimento alimentoB = new Alimento();
//		alimentoB.setNmAlimento("Batata");
//		alimentoB.setDtCadastro(Calendar.getInstance());
//		alimentoB.setIdPeriodo(2);
//		alimentoB.setIdUsuario(8002);
//		alimentoB.setQtdeAlimento(2);
//		alimentoB.setQtdeCaloria(105);
//		dao.cadastrar(alimentoB);
//		
//		Alimento alimentoC = new Alimento();
//		alimentoC.setNmAlimento("Salgadinho");
//		alimentoC.setDtCadastro(Calendar.getInstance());
//		alimentoC.setIdPeriodo(2);
//		alimentoC.setIdUsuario(8005);
//		alimentoC.setQtdeAlimento(2);
//		alimentoC.setQtdeCaloria(726);
//		dao.cadastrar(alimentoC);
//		
//		Alimento alimentoD = new Alimento();
//		alimentoD.setNmAlimento("Pastel");
//		alimentoD.setDtCadastro(Calendar.getInstance());
//		alimentoD.setIdPeriodo(3);
//		alimentoD.setIdUsuario(8003);
//		alimentoD.setQtdeAlimento(1);
//		alimentoD.setQtdeCaloria(143);
//		dao.cadastrar(alimentoD);
//
//		Alimento alimentoE = new Alimento();
//		alimentoE.setNmAlimento("Ovo");
//		alimentoE.setDtCadastro(Calendar.getInstance());
//		alimentoE.setIdPeriodo(2);
//		alimentoE.setIdUsuario(8004);
//		alimentoE.setQtdeAlimento(12);
//		alimentoE.setQtdeCaloria(273);
//		dao.cadastrar(alimentoE);
//		System.out.print("Cadastrado " + alimentoE);
//
//		List<Alimento> lista = dao.listarTodos();
//		for (Alimento alimentos : lista) {
//			System.out.println("ID: " + alimentos.getIdAlimento() + " - Alimento: " + alimentos.getNmAlimento()
//					+ " - Qtde: " + alimentos.getQtdeAlimento() + " - Calorias: " + alimentos.getQtdeCaloria()
//					+ " ID do Usuário: " + alimentos.getIdUsuario() + " - Período: " + alimentos.getIdPeriodo()
//					+ " - Data de Cadastro: " + formatacaoData.format(alimentos.getDtCadastro().getTime()));
//		}
		
		PeriodoAlimentoDAO dao1 = DAOFactory.getPeriodoAlimento();
				List<PeriodoAlimento> lista1 = dao1.listarTodos();
				for (PeriodoAlimento p : lista1) {
					System.out.println(p.getDsPeriodo());
				}
	}
	
	

}
