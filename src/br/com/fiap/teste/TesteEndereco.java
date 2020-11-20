package br.com.fiap.teste;

import java.util.List;

import br.com.fiap.DAOFactory.DAOFactory;
import br.com.fiap.dao.EnderecoDAO;
import br.com.fiap.exception.DBException;
import br.com.fiap.model.Endereco;

public class TesteEndereco {

	public static void main(String[] args) throws DBException {

		EnderecoDAO dao = DAOFactory.getEnderecoDAO();
		List<Endereco> lista = dao.listarTodos();
		for (Endereco endereco : lista) {
			System.out.println(endereco.getIdEndereco() + endereco.getNmLogradouro() + endereco.getNmBairro() + endereco.getUsuario().getNome());
		}
		
	}

}
