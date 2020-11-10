package br.com.fiap.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.conexao.ConexaoBDManager;
import br.com.fiap.dao.EnderecoDAO;
import br.com.fiap.exception.DBException;
import br.com.fiap.model.Endereco;

public class EnderecoDAOImpl implements EnderecoDAO {

	private Connection conexao;

	@Override
	public List<Endereco> listarTodos() {
		List<Endereco> lista = new ArrayList<Endereco>();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conexao = ConexaoBDManager.getInstante().obterConexao();
			String sql = "SELECT * FROM T_HTL_ENDERECO";
			stmt = conexao.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {
				Integer idEndereco = rs.getInt("ID_ENDERECO");
				String nmLogradouro = rs.getString("DS_LOGRADOURO");
				String dsEndereco = rs.getString("DS_ENDERECO");
				String nrEndereco = rs.getString("NR_ENDERECO");
				String nrCep = rs.getString("NR_CEP");
				String nmUf = rs.getString("NM_UF");
				String nmCidade = rs.getString("NM_CIDADE");
				String nmBairro = rs.getString("NM_BAIRRO");
				String dsComplemento = rs.getString("DS_COMPLEMENTO");
				Integer idUsuario = rs.getInt("T_HTL_USUARIO_ID_USUARIO");

				Endereco endereco = new Endereco(idEndereco, nmLogradouro, dsEndereco, nrEndereco, nrCep, nmUf,
						nmCidade, nmBairro, dsComplemento, idUsuario);

				lista.add(endereco);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
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
	public void cadastrar(Endereco endereco) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConexaoBDManager.getInstante().obterConexao();
			String sql = "INSERT INTO T_HTL_ENDERECO"
					+ " (ID_ENDERECO, T_HTL_USUARIO_ID_USUARIO, NR_CEP, DS_LOGRADOURO, DS_ENDERECO, NM_UF,"
					+ " NM_CIDADE, NM_BAIRRO, DS_COMPLEMENTO, NR_ENDERECO)"
					+ " VALUES(SEQ_ENDERECO.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			stmt = conexao.prepareStatement(sql);

			stmt.setInt(1, endereco.getIdUsuario());
			stmt.setString(2, endereco.getNrCep());
			stmt.setString(3, endereco.getNmLogradouro());
			stmt.setString(4, endereco.getDsEndereco());
			stmt.setString(5, endereco.getNmUf());
			stmt.setString(6, endereco.getNmCidade());
			stmt.setString(7, endereco.getNmBairro());
			stmt.setString(8, endereco.getDsComplemento());
			stmt.setString(9, endereco.getNrEndereco());
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
	public void atualizar(Endereco endereco) throws DBException {
		// TODO Auto-generated method stub

	}

	@Override
	public void remover(int idEndereco) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConexaoBDManager.getInstante().obterConexao();
			String sql = "DELETE FROM T_HTL_ENDERECO WHERE ID_ENDERECO = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, idEndereco);
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
	public Endereco buscarPorId(int idEndereco) {
		// TODO Auto-generated method stub
		return null;
	}

}
