package br.com.fiap.teste;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import br.com.fiap.dao.impl.PressaoArterialDAOImpl;
import br.com.fiap.exception.DBException;
import br.com.fiap.model.PressaoArterial;

public class TestePressao {

	public static void main(String[] args) throws DBException {

		PressaoArterialDAOImpl dao = new PressaoArterialDAOImpl();
		SimpleDateFormat formatacaoData = new SimpleDateFormat("dd/MM/yyyy");

		PressaoArterial pressaoArtB = new PressaoArterial();
		pressaoArtB.setDtCadastro(Calendar.getInstance());
		pressaoArtB.setIdUsuario(8001);
		pressaoArtB.setNrSistolica(11);
		pressaoArtB.setNrDiastolica(8);
		dao.cadastrar(pressaoArtB);
		
		PressaoArterial pressaoArtC = new PressaoArterial();
		pressaoArtC.setDtCadastro(Calendar.getInstance());
		pressaoArtC.setIdUsuario(8002);
		pressaoArtC.setNrSistolica(12);
		pressaoArtC.setNrDiastolica(7);
		dao.cadastrar(pressaoArtC);
		
		PressaoArterial pressaoArtA = new PressaoArterial();
		pressaoArtA.setDtCadastro(Calendar.getInstance());
		pressaoArtA.setIdUsuario(8003);
		pressaoArtA.setNrSistolica(14);
		pressaoArtA.setNrDiastolica(8);
		dao.cadastrar(pressaoArtA);
		
		PressaoArterial pressaoArtD = new PressaoArterial();
		pressaoArtD.setDtCadastro(Calendar.getInstance());
		pressaoArtD.setIdUsuario(8004);
		pressaoArtD.setNrSistolica(12);
		pressaoArtD.setNrDiastolica(8);
		dao.cadastrar(pressaoArtD);
		
		PressaoArterial pressaoArtE = new PressaoArterial();
		pressaoArtE.setDtCadastro(Calendar.getInstance());
		pressaoArtE.setIdUsuario(8005);
		pressaoArtE.setNrSistolica(11);
		pressaoArtE.setNrDiastolica(7);
		dao.cadastrar(pressaoArtE);

		List<PressaoArterial> lista = dao.listarTodos();
		for (PressaoArterial pressaoArterial : lista) {
			System.out.println("ID: " + pressaoArterial.getIdPressaoArterial() + " - Pressão: " + pressaoArterial.getNrSistolica() + "/"
					+ pressaoArterial.getNrDiastolica() + " - Data de Cadastro: "
					+ formatacaoData.format(pressaoArterial.getDtCadastro().getTime()) + " - ID do Usuário: "
					+ pressaoArterial.getIdUsuario());
		}

	}

}
