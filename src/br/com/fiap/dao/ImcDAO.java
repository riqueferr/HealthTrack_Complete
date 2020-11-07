package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.exception.DBException;
import br.com.fiap.model.Imc;


public interface ImcDAO {

	public List<Imc> listarTodos();
	
	public void cadastrar(Imc imc) throws DBException;
  	    
    public void atualizar(Imc imc) throws DBException;
  
    public void remover(int idImc) throws DBException;
    
    public Imc buscarPorId(int idImc);
    
    
}
