package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.exception.DBException;
import br.com.fiap.model.Pagamento;

public interface PagDAO {
	
	public List<Pagamento> listarTodos();
	
	public void cadastrar(Pagamento pagamento) throws DBException;
  	    
    public void atualizar(Pagamento pagamento) throws DBException;
  
    public void remover(int idPagamento) throws DBException;
    
    public Pagamento buscarPorId(int idPagamento);

}
