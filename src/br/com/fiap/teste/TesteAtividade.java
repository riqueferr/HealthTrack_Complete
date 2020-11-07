package br.com.fiap.teste;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import br.com.fiap.dao.impl.AtividadeDAPOImpl;
import br.com.fiap.exception.DBException;
import br.com.fiap.model.Atividade;

public class TesteAtividade {

	public static void main(String[] args) throws DBException {
		AtividadeDAPOImpl dao = new AtividadeDAPOImpl();
		SimpleDateFormat formatacaoData = new SimpleDateFormat("dd/MM/yyyy");
		
		Atividade atividadeA = new Atividade();
		atividadeA.setDtCadastro(Calendar.getInstance());
		atividadeA.setIdTipo(1);
		atividadeA.setIdUsuario(8001);
		atividadeA.setVlDistancia(0.7);
		atividadeA.setVlTempo(5);
		dao.cadastrar(atividadeA);

		Atividade atividadeB = new Atividade();
		atividadeB.setDtCadastro(Calendar.getInstance());
		atividadeB.setIdTipo(2);
		atividadeB.setIdUsuario(8002);
		atividadeB.setVlDistancia(9.1);
		atividadeB.setVlTempo(76);
		dao.cadastrar(atividadeB);

		Atividade atividadeC = new Atividade();
		atividadeC.setDtCadastro(Calendar.getInstance());
		atividadeC.setIdTipo(3);
		atividadeC.setIdUsuario(8003);
		atividadeC.setVlDistancia(1.2);
		atividadeC.setVlTempo(17);
		dao.cadastrar(atividadeC);

		Atividade atividadeD = new Atividade();
		atividadeD.setDtCadastro(Calendar.getInstance());
		atividadeD.setIdTipo(4);
		atividadeD.setIdUsuario(8004);
		atividadeD.setVlDistancia(0.7);
		atividadeD.setVlTempo(5);
		dao.cadastrar(atividadeD);

		Atividade atividadeE = new Atividade();
		atividadeE.setDtCadastro(Calendar.getInstance());
		atividadeE.setIdTipo(5);
		atividadeE.setIdUsuario(8005);
		atividadeE.setVlDistancia(2.0);
		atividadeE.setVlTempo(21);
		dao.cadastrar(atividadeE);

		List<Atividade> lista = dao.listarTodos();
		for (Atividade atividade : lista) {
			System.out.println("ID: " + atividade.getIdAtividade() + " - Data de Cadastro:  "
					+ formatacaoData.format(atividade.getDtCadastro().getTime()) + " - Minutos: " + atividade.getVlTempo() + " "
					+ atividade.getVlDistancia() + " - Atividade: " + atividade.getDsTipoAtv() + " - ID do Usuário: "
					+ atividade.getIdUsuario());
		}

	}

}
