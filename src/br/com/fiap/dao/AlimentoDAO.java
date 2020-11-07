package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.exception.DBException;
import br.com.fiap.model.Alimento;

public interface AlimentoDAO {
	
	public List<Alimento> listarTodos();
	
	public void cadastrar(Alimento alimento) throws DBException;
  	    
    public void atualizar(Alimento alimento) throws DBException;
  
    public void remover(int idAlimento) throws DBException;
    
    public Alimento buscarPorId(int idAlimento);
    


}
