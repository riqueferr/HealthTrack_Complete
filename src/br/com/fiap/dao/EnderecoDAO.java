package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.exception.DBException;
import br.com.fiap.model.Endereco;

public interface EnderecoDAO {
	
	public List<Endereco> listarTodos();
	
	public void cadastrar(Endereco endereco) throws DBException;
  	    
    public void atualizar(Endereco endereco) throws DBException;
  
    public void remover(int idEndereco) throws DBException;
    
    public Endereco buscarPorId(int idEndereco);

}
