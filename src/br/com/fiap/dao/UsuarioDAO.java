package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.exception.DBException;
import br.com.fiap.model.Usuario;

public interface UsuarioDAO {
	  
		public List<Usuario> listarTodos();
	
		public void cadastrar(Usuario usuario) throws DBException;
	  	    
	    public void atualizar(Usuario usuario) throws DBException;
	  
	    public void remover(int idUsuario) throws DBException;
	    
	    public Usuario buscarPorId(int idUsuario);
	  
}
