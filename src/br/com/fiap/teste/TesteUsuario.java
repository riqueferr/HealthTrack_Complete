package br.com.fiap.teste;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import br.com.fiap.DAOFactory.DAOFactory;
import br.com.fiap.dao.UsuarioDAO;
import br.com.fiap.dao.impl.UsuarioDAOImpl;
import br.com.fiap.exception.DBException;
import br.com.fiap.model.Usuario;

public class TesteUsuario {

	public static void main(String[] args) throws ParseException, DBException {

		SimpleDateFormat formatacaoData = new SimpleDateFormat("dd/MM/yyyy");
		UsuarioDAO d = DAOFactory.getUsuarioDAO();
		
		Usuario usuarioA = new Usuario();
		usuarioA.setSenha("teste");
		System.out.println(usuarioA.getSenha());
//		usuarioA.setNome("Paola");
//		usuarioA.setSobrenome("Assis");
//		usuarioA.setEmail("assispaola.dev@gmail.com");
//		usuarioA.setSenha("Lola@2020");
//		String data = "11/11/1993";
//		Date dataf = formatacaoData.parse(data);
//		java.sql.Date dataSql = new java.sql.Date(dataf.getTime());
//		usuarioA.setDtNasc(dataSql);
//		usuarioA.setDtCadastro(Calendar.getInstance());
//		
//		try {
//			d.cadastrar(usuarioA);
//			System.out.println("Usuario " + usuarioA.getNome() + " cadastrado.");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		
//
//
//
//		List<Usuario> lista = d.listarTodos();
//		for (Usuario usuario : lista) {
//			System.out.println("ID: " + usuario.getIdUsuario() + " - Nome: " + usuario.getNome() + " - Sobrenome: " + usuario.getSobrenome() + " - E-mail: "
//					+ usuario.getEmail() + " - Senha: " + usuario.getSenha() + " - Data de Nascimento: " + formatacaoData.format(usuario.getDtNasc()) + " - Data de Cadastro: "
//					+ formatacaoData.format(usuario.getDtCadastro().getTime()));
//		}

	}

}
