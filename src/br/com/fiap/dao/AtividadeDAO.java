package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.exception.DBException;
import br.com.fiap.model.Atividade;

public interface AtividadeDAO {
	
	public List<Atividade> listarTodos();
	
	public void cadastrar(Atividade atividade) throws DBException;
  	    
    public void atualizar(Atividade atividade) throws DBException;
  
    public void remover(int idAtividade) throws DBException;
    
    public Atividade buscarPorId(int idAtividade) throws DBException;
    


}
