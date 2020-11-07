package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.exception.DBException;
import br.com.fiap.model.PressaoArterial;

public interface PressaoArterialDAO {
	
	public List<PressaoArterial> listarTodos();
	
	public void cadastrar(PressaoArterial pressaoArterial) throws DBException;
  	    
    public void atualizar(PressaoArterial pressaoArterial) throws DBException;
  
    public void remover(int idPressaoArterial) throws DBException;
    
    public PressaoArterial buscarPorId(int idPressaoArterial);
    

}
