package br.com.fiap.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import br.com.fiap.conexao.ConexaoBDManager;
import br.com.fiap.dao.UsuarioDAO;
import br.com.fiap.exception.DBException;
import br.com.fiap.model.Usuario;
import oracle.jdbc.connector.OracleConnectionManager;

public class UsuarioDAOImpl implements UsuarioDAO {

	private Connection conexao;

	@Override
	public List<Usuario> listarTodos() {
		List<Usuario> lista = new ArrayList<Usuario>();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conexao = ConexaoBDManager.getInstante().obterConexao();
			stmt = conexao.prepareStatement("SELECT * FROM T_HTL_USUARIO");
			rs = stmt.executeQuery();

			while (rs.next()) {
				Integer idUsuario = rs.getInt("ID_USUARIO");
				String nome = rs.getString("NM_NOME");
				String sobrenome = rs.getString("NM_SOBRENOME");
				String email = rs.getString("DS_EMAIL");
				String senha = rs.getString("DS_SENHA");
				Date dtNasc = rs.getDate("DT_NASCIMENTO");
				java.sql.Date dtCad = rs.getDate("DT_CADASTRO");
				Calendar dtCadastro = Calendar.getInstance();
				dtCadastro.setTimeInMillis(dtCad.getTime());

				Usuario usuario = new Usuario(idUsuario, nome, sobrenome, email, senha, dtNasc, dtCadastro);

				lista.add(usuario);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				rs.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return lista;

	}

	@Override
	public void atualizar(Usuario usuario) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConexaoBDManager.getInstante().obterConexao();
			String sql = "UPDATE T_HTL_USUARIO SET NM_NOME = ?, NM_SOBRENOME = ?, "
					+ "DS_EMAIL = ?, DS_SENHA = ?, DT_NASCIMENTO = ?, DT_CADASTRO = ? WHERE ID_USUARIO = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getSobrenome());
			stmt.setString(3, usuario.getEmail());
			stmt.setString(4, usuario.getSenha());
			stmt.setDate(5, usuario.getDtNasc());
			java.sql.Date dataAtual = new java.sql.Date(usuario.getDtCadastro().getTimeInMillis());
			stmt.setDate(6, dataAtual);
			stmt.setInt(7, usuario.getIdUsuario());
			stmt.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void remover(int idUsuario) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConexaoBDManager.getInstante().obterConexao();
			String sql = "DELETE FROM T_HTL_USUARIO WHERE ID_USUARIO = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, idUsuario);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public Usuario buscarPorId(int codigo) {
		SimpleDateFormat formatacaoData = new SimpleDateFormat("dd/MM/yyyy");
		Usuario usuario = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conexao = ConexaoBDManager.getInstante().obterConexao();
			String sql = "SELECT * FROM T_HTL_USUARIO WHERE ID_USUARIO = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, codigo);
			rs = stmt.executeQuery();

			if (rs.next()) {
				int idUsuario = rs.getInt("ID_USUARIO");
				String nome = rs.getString("NM_NOME");
				String sobrenome = rs.getString("NM_SOBRENOME");
				String email = rs.getString("DS_EMAIL");
				String senha = rs.getString("DS_SENHA");
				Date dtNasc = rs.getDate("DT_NASCIMENTO");
				java.sql.Date dtCad = rs.getDate("DT_CADASTRO");
				Calendar dtCadastro = Calendar.getInstance();
				dtCadastro.setTimeInMillis(dtCad.getTime());

				usuario = new Usuario(idUsuario, nome, sobrenome, email, senha, dtNasc, dtCadastro);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return usuario;
	}

	@Override
	public void cadastrar(Usuario usuario) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConexaoBDManager.getInstante().obterConexao();
			String sql = "INSERT INTO T_HTL_USUARIO (ID_USUARIO, NM_NOME, NM_SOBRENOME, DS_EMAIL,"
					+ " DS_SENHA, DT_NASCIMENTO, DT_CADASTRO) VALUES (SEQ_USUARIO.NEXTVAL, ?, ?, ?, ?, ?, ?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getSobrenome());
			stmt.setString(3, usuario.getEmail());
			stmt.setString(4, usuario.getSenha());
			stmt.setDate(5, usuario.getDtNasc());
			java.sql.Date dataAtual = new java.sql.Date(usuario.getDtCadastro().getTimeInMillis());
			stmt.setDate(6, dataAtual);
			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public boolean validarUsuario(Usuario usuario) {
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conexao = ConexaoBDManager.getInstante().obterConexao();
			String sql = "SELECT * FROM T_HTL_USUARIO WHERE DS_EMAIL = ? AND DS_SENHA = ?;";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, usuario.getEmail());
			stmt.setString(2, usuario.getSenha());
			rs = stmt.executeQuery();

			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				rs.close();
				conexao.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}

}
