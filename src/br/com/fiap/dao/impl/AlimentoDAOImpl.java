package br.com.fiap.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.fiap.conexao.ConexaoBDManager;
import br.com.fiap.dao.AlimentoDAO;
import br.com.fiap.exception.DBException;
import br.com.fiap.model.Alimento;

public class AlimentoDAOImpl implements AlimentoDAO {

	private Connection conexao;

	@Override
	public List<Alimento> listarTodos() {
		List<Alimento> lista = new ArrayList<Alimento>();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conexao = ConexaoBDManager.getInstante().obterConexao();
			String sql = "SELECT * FROM T_HTL_ALMT";
			stmt = conexao.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {
				Integer idAlimento = rs.getInt("ID_ALIMENTO");
				String nmAlimento = rs.getString("NM_ALIMENTO");
				Integer qtdeAlimento = rs.getInt("QT_ALIMENTO");
				Integer qtdeCaloria = rs.getInt("QT_CALORIA");
				Integer idUsuario = rs.getInt("T_HTL_USUARIO_ID_USUARIO");
				Integer idPeriodo = rs.getInt("T_HTL_PERIODO_ID_PERIODO");
				java.sql.Date dtCad = rs.getDate("DT_CADASTRO");
				Calendar dtCadastro = Calendar.getInstance();
				dtCadastro.setTimeInMillis(dtCad.getTime());

				Alimento alimento = new Alimento(idAlimento, nmAlimento, qtdeAlimento, qtdeCaloria, idUsuario,
						idPeriodo, dtCadastro);

				lista.add(alimento);
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
	public void cadastrar(Alimento alimento) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConexaoBDManager.getInstante().obterConexao();
			String sql = "INSERT INTO T_HTL_ALMT (ID_ALIMENTO, NM_ALIMENTO, QT_ALIMENTO, QT_CALORIA,"
					+ " T_HTL_USUARIO_ID_USUARIO, T_HTL_PERIODO_ID_PERIODO, DT_CADASTRO) VALUES (SEQ_ALIMENTO.NEXTVAL, ?, ?, ?, ?, ?, ?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, alimento.getNmAlimento());
			stmt.setInt(2, alimento.getQtdeAlimento());
			stmt.setInt(3, alimento.getQtdeCaloria());
			stmt.setInt(4, alimento.getIdUsuario());
			stmt.setInt(5, alimento.getIdPeriodo());
			java.sql.Date dataAtual = new java.sql.Date(alimento.getDtCadastro().getTimeInMillis());
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
	public void atualizar(Alimento alimento) throws DBException {
		// TODO Auto-generated method stub

	}

	@Override
	public void remover(int idAlimento) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConexaoBDManager.getInstante().obterConexao();
			String sql = "DELETE FROM T_HTL_ALMT WHERE ID_ALMT = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, idAlimento);
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
	public Alimento buscarPorId(int idAlimento) {
		// TODO Auto-generated method stub
		return null;
	}

}
