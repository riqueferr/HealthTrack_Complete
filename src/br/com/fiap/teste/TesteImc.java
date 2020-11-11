package br.com.fiap.teste;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import br.com.fiap.DAOFactory.DAOFactory;
import br.com.fiap.dao.ImcDAO;
import br.com.fiap.dao.UsuarioDAO;
import br.com.fiap.dao.impl.ImcDAOImpl;
import br.com.fiap.exception.DBException;
import br.com.fiap.model.Imc;

public class TesteImc {

	public static void main(String[] args) throws DBException {

		ImcDAOImpl dao = new ImcDAOImpl();
		SimpleDateFormat formatacaoData = new SimpleDateFormat("dd/MM/yyyy");

//		Imc imc1 = new Imc();
//		imc1.setValor(35.0);
//		imc1.setDtCadastro(Calendar.getInstance());
//		imc1.setPeso(72.5);
//		imc1.setAltura(1.62);
//		imc1.setIdUsuario(8002);
//		dao.cadastrar(imc1);
//		
//		Imc imc2 = new Imc();
//		imc2.setValor(15.0);
//		imc2.setDtCadastro(Calendar.getInstance());
//		imc2.setPeso(90.0);
//		imc2.setAltura(1.42);
//		imc2.setIdUsuario(8003);
//		dao.cadastrar(imc2);
//
//
//		Imc imc3 = new Imc();
//		imc3.setValor(40.0);
//		imc3.setDtCadastro(Calendar.getInstance());
//		imc3.setPeso(105.0);
//		imc3.setAltura(1.80);
//		imc3.setIdUsuario(8003);
//		dao.cadastrar(imc3);
//
//
//		Imc imc4 = new Imc();
//		imc4.setValor(26.2);
//		imc4.setDtCadastro(Calendar.getInstance());
//		imc4.setPeso(85.0);
//		imc4.setAltura(1.65);
//		imc4.setIdUsuario(8004);
//		dao.cadastrar(imc4);
//		System.out.println("passou");
////
//		Imc imc5 = new Imc();
//		imc5.setValor(28.5);
//		imc5.setDtCadastro(Calendar.getInstance());
//		imc5.setPeso(58.2);
//		imc5.setAltura(1.68);
//		imc5.setIdUsuario(8005);
//		dao.cadastrar(imc5);
//		System.out.println("passou");
//		
//		
//		
//		
//		ImcDAO d = DAOFactory.getImcDAO();
//		Calendar dtCadastro = Calendar.getInstance();
//		Double altura = 2.02;
//		Double peso = 80.1;
//		Double valor = peso / (altura * altura);
//		Integer idUsuario = 8004;
//	
//		ImcDAO d = DAOFactory.getImcDAO();
//		Imc imc5 = new Imc();
//		imc5.setValor(28.5);
//		imc5.setDtCadastro(Calendar.getInstance());
//		imc5.setPeso(58.2);
//		imc5.setAltura(1.60);
//		imc5.setIdUsuario(8001);
//		d.cadastrar(imc5);
//		
//		
		
		
	

		List<Imc> lista = dao.listarTodos();
		for (Imc imcc1 : lista) {
			System.out.println("ID: " + imcc1.getIdImc() + " - IMC: " + imcc1.getValor() + " - Altura: " + imcc1.getAltura() + " - Peso: " + imcc1.getPeso()
					+ " - Data do Cadastro: " + formatacaoData.format(imcc1.getDtCadastro().getTime()) + " - ID do Usuário: " + imcc1.getIdUsuario());
		}


	}

}
