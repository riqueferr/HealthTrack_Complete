package br.com.fiap.teste;

import java.util.List;

import br.com.fiap.dao.impl.EnderecoDAOImpl;
import br.com.fiap.exception.DBException;
import br.com.fiap.model.Endereco;

public class TesteEndereco {

	public static void main(String[] args) throws DBException {

		EnderecoDAOImpl dao = new EnderecoDAOImpl();

		Endereco enderecoA = new Endereco();
		enderecoA.setNmLogradouro("Rua");
		enderecoA.setDsEndereco("Tijuape");
		enderecoA.setNrEndereco("337");
		enderecoA.setNrCep("05873-380");
		enderecoA.setNmBairro("Morro do �ndio");
		enderecoA.setNmCidade("S�o Paulo");
		enderecoA.setNmUf("SP");
		enderecoA.setDsComplemento("");
		enderecoA.setIdUsuario(1);
		dao.cadastrar(enderecoA);
		
		Endereco enderecoB = new Endereco();
		enderecoB.setNmLogradouro("Avenida");
		enderecoB.setDsEndereco("Corifeu de Azevedo Marques");
		enderecoB.setNrEndereco("3920");
		enderecoB.setNrCep("05339-000");
		enderecoB.setNmBairro("Vila Butant�");
		enderecoB.setNmCidade("S�o Paulo");
		enderecoB.setNmUf("SP");
		enderecoB.setDsComplemento("Pr�ximo ao Port�o 3 da USP");
		enderecoB.setIdUsuario(8001);
		dao.cadastrar(enderecoB);
		
		Endereco enderecoC = new Endereco();
		enderecoC.setNmLogradouro("Avenida");
		enderecoC.setDsEndereco("Santo Ant�nio");
		enderecoC.setNrEndereco("57");
		enderecoC.setNrCep("06086-075");
		enderecoC.setNmBairro("Vila Osasco");
		enderecoC.setNmCidade("Osasco");
		enderecoC.setNmUf("SP");
		enderecoC.setIdUsuario(8002);
		enderecoC.setDsComplemento("Localizado pr�ximo a Igreja");
		dao.cadastrar(enderecoC);
		
		Endereco enderecoD = new Endereco();
		enderecoD.setNmLogradouro("Estrada");
		enderecoD.setDsEndereco("Campo Limpo");
		enderecoD.setNrEndereco("459");
		enderecoD.setNrCep("05777-001");
		enderecoD.setNmBairro("Vila Prel");
		enderecoD.setNmCidade("S�o Paulo");
		enderecoD.setNmUf("SP");
		enderecoD.setIdUsuario(8003);
		enderecoD.setDsComplemento("Ao lado da Sedinha");
		dao.cadastrar(enderecoD);
		
		Endereco enderecoE = new Endereco();
		enderecoE.setNmLogradouro("Avenida");
		enderecoE.setDsEndereco("Roque Petroni J�nior");
		enderecoE.setNrEndereco("1089");
		enderecoE.setNrCep("04707-900");
		enderecoE.setNmBairro("Jardim das Acacias");
		enderecoE.setNmCidade("S�o Paulo");
		enderecoE.setNmUf("SP");
		enderecoE.setIdUsuario(8004);
		enderecoE.setDsComplemento("Pr�ximo ao metr�");
		dao.cadastrar(enderecoE);
		
		List<Endereco> lista = dao.listarTodos();
		for (Endereco enderecos : lista) {
			System.out.println("ID: "+enderecos.getIdEndereco() + " - Endere�o: " + enderecos.getNmLogradouro() + " " + enderecos.getDsEndereco()
			+ " " + enderecos.getNrEndereco() + " - CEP: " + enderecos.getNrCep() + " - Bairro: " + enderecos.getNmBairro()
			+ " - Cidade: " + enderecos.getNmCidade() + " - UF: " + enderecos.getNmUf() + " - Complemento: " + enderecos.getDsComplemento() 
			+ " - ID do Usu�rio: " + enderecos.getIdUsuario());
		}
	}

}
