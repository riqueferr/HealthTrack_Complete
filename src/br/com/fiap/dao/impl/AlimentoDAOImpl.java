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
import br.com.fiap.dao.AlimentoDAO;
import br.com.fiap.exception.DBException;
import br.com.fiap.model.Alimento;
import br.com.fiap.model.PeriodoAlimento;
import br.com.fiap.model.Usuario;

public class AlimentoDAOImpl implements AlimentoDAO {

	private Connection conexao;

	@Override
	public List<Alimento> listarTodos() {
		List<Alimento> lista = new ArrayList<Alimento>();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conexao = ConexaoBDManager.getInstante().obterConexao();
			String sql = "SELECT * FROM T_HTL_ALMT " 
					+ "INNER JOIN T_HTL_PERIODO "
					+ "ON T_HTL_ALMT.T_HTL_PERIODO_ID_PERIODO  = T_HTL_PERIODO.ID_PERIODO "
					+ "ORDER BY DT_CADASTRO DESC ";
			stmt = conexao.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {
				Integer codigo = rs.getInt("ID_ALIMENTO");
				String nmAlimento = rs.getString("NM_ALIMENTO");
				Integer qtdeAlimento = rs.getInt("QT_ALIMENTO");
				Integer qtdeCaloria = rs.getInt("QT_CALORIA");
				Integer idUsuario = rs.getInt("T_HTL_USUARIO_ID_USUARIO");
				java.sql.Date dtCad = rs.getDate("DT_CADASTRO");
				Calendar dtCadastro = Calendar.getInstance();
				dtCadastro.setTimeInMillis(dtCad.getTime());
				Integer idPeriodo = rs.getInt("T_HTL_PERIODO_ID_PERIODO");
				String dsPeriodo = rs.getString("NM_PERIODO");

				Alimento alimento = new Alimento(codigo, nmAlimento, qtdeAlimento, qtdeCaloria, idUsuario,
						dtCadastro);
				PeriodoAlimento pa = new PeriodoAlimento(idPeriodo, dsPeriodo);
				alimento.setPeriodoAlimento(pa);
				lista.add(alimento);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
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
			stmt.setInt(5, alimento.getPeriodoAlimento().getIdPeriodo());
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
		PreparedStatement stmt = null;

		try {
			conexao = ConexaoBDManager.getInstante().obterConexao();
			String sql = "UPDATE T_HTL_ALMT SET NM_ALIMENTO = ?," + " QT_ALIMENTO = ?," + " QT_CALORIA = ?,"
					+ " T_HTL_USUARIO_ID_USUARIO = ?," + " T_HTL_PERIODO_ID_PERIODO = ?," + " DT_CADASTRO = ?"
					+ " WHERE ID_ALIMENTO = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, alimento.getNmAlimento());
			stmt.setInt(2, alimento.getQtdeAlimento());
			stmt.setDouble(3, alimento.getQtdeCaloria());
			stmt.setInt(4, alimento.getIdUsuario());
			stmt.setInt(5, alimento.getPeriodoAlimento().getIdPeriodo());
			java.sql.Date data = new java.sql.Date(alimento.getDtCadastro().getTimeInMillis());
			stmt.setDate(6, data);
			stmt.setInt(7, alimento.getCodigo());

			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao atualizar.");
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
	public void remover(int idAlimento) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConexaoBDManager.getInstante().obterConexao();
			String sql = "DELETE FROM T_HTL_ALMT WHERE ID_ALIMENTO = ?";
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
	public Alimento buscarPorId(int codigo) {
		SimpleDateFormat formatacaoData = new SimpleDateFormat("dd/MM/yyyy");
		Alimento alimento = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conexao = ConexaoBDManager.getInstante().obterConexao();
			String sql = "SELECT * FROM T_HTL_ALMT " + "INNER JOIN T_HTL_PERIODO "
					+ "ON T_HTL_ALMT.T_HTL_PERIODO_ID_PERIODO = T_HTL_PERIODO.ID_PERIODO " + "WHERE ID_ALIMENTO = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, codigo);
			rs = stmt.executeQuery();

			if (rs.next()) {
				int idAlimento = rs.getInt("ID_ALIMENTO");
				String nmAlimento = rs.getString("NM_ALIMENTO");
				Integer qtdeAlimento = rs.getInt("QT_ALIMENTO");
				Integer qtdeCaloria = rs.getInt("QT_CALORIA");
				Integer idUsuario = rs.getInt("T_HTL_USUARIO_ID_USUARIO");
				java.sql.Date dtCad = rs.getDate("DT_CADASTRO");
				Calendar dtCadastro = Calendar.getInstance();
				dtCadastro.setTimeInMillis(dtCad.getTime());
				Integer idPeriodo = rs.getInt("T_HTL_PERIODO_ID_PERIODO");
				String dsPeriodo = rs.getString("NM_PERIODO");

				alimento = new Alimento(idAlimento, nmAlimento, qtdeAlimento, qtdeCaloria, idUsuario, dtCadastro);
				PeriodoAlimento periodoAlimento = new PeriodoAlimento(idPeriodo, dsPeriodo);
				alimento.setPeriodoAlimento(periodoAlimento);

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

		return alimento;
	}

}
