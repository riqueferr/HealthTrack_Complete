package br.com.fiap.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.fiap.conexao.ConexaoBDManager;
import br.com.fiap.dao.PressaoArterialDAO;
import br.com.fiap.exception.DBException;
import br.com.fiap.model.PressaoArterial;

public class PressaoArterialDAOImpl implements PressaoArterialDAO {

	private Connection conexao;

	@Override
	public List<PressaoArterial> listarTodos() {
		List<PressaoArterial> lista = new ArrayList<PressaoArterial>();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conexao = ConexaoBDManager.getInstante().obterConexao();
			String sql = "SELECT * FROM T_HTL_PRESSAO";
			stmt = conexao.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {
				Integer idPressaoArterial = rs.getInt("ID_PRESSAO");
				Integer nrSistolica = rs.getInt("NR_SISTOLICA");
				Integer nrDiastolica = rs.getInt("NR_DIASTOLICA");
				java.sql.Date dtCad = rs.getDate("DT_CADASTRO");
				Calendar dtCadastro = Calendar.getInstance();
				dtCadastro.setTimeInMillis(dtCad.getTime());
				Integer idUsuario = rs.getInt("T_HTL_USUARIO_ID_USUARIO");

				PressaoArterial pressaoArterial = new PressaoArterial(idPressaoArterial, nrSistolica, nrDiastolica,
						dtCadastro, idUsuario);

				lista.add(pressaoArterial);
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
	public void cadastrar(PressaoArterial pressaoArterial) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConexaoBDManager.getInstante().obterConexao();
			String sql = "INSERT INTO T_HTL_PRESSAO (ID_PRESSAO, NR_SISTOLICA, NR_DIASTOLICA, DT_CADASTRO,"
					+ " T_HTL_USUARIO_ID_USUARIO) VALUES (SEQ_PRESSAOARTERIAL.NEXTVAL, ?, ?, ?, ?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, pressaoArterial.getNrSistolica());
			stmt.setInt(2, pressaoArterial.getNrDiastolica());
			java.sql.Date dataAtual = new java.sql.Date(pressaoArterial.getDtCadastro().getTimeInMillis());
			stmt.setDate(3, dataAtual);
			stmt.setInt(4, pressaoArterial.getIdUsuario());
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
	public void atualizar(PressaoArterial pressaoArterial) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConexaoBDManager.getInstante().obterConexao();
			String sql = "UPDATE T_HTL_USUARIO SET NR_SISTOLICA = ?, NR_DIASTOLICA = ?,"
					+ " DT_CADASTRO = ? WHERE ID_PRESSAO = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, pressaoArterial.getNrSistolica());
			stmt.setInt(2, pressaoArterial.getNrDiastolica());
			java.sql.Date dataAtual = new java.sql.Date(pressaoArterial.getDtCadastro().getTimeInMillis());
			stmt.setDate(3, dataAtual);
			stmt.setInt(4, pressaoArterial.getIdPressaoArterial());
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
	public void remover(int idPressaoArterial) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConexaoBDManager.getInstante().obterConexao();
			String sql = "DELETE FROM T_HTL_PRESSAO WHERE ID_PRESSAO = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, idPressaoArterial);
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
	public PressaoArterial buscarPorId(int codigo) {

		PressaoArterial pressaoArterial = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConexaoBDManager.getInstante().obterConexao();
			String sql = "SELECT * FROM T_HTL_PRESSAO WHERE ID_PRESSAO = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, codigo);
			rs = stmt.executeQuery();

			if (rs.next()) {

				Integer idPressaoArterial = rs.getInt("ID_PRESSAO");
				Integer nrSistolica = rs.getInt("NR_SISTOLICA");
				Integer nrDiastolica = rs.getInt("NR_DIASTOLICA");
				java.sql.Date dtCad = rs.getDate("DT_CADASTRO");
				Calendar dtCadastro = Calendar.getInstance();
				dtCadastro.setTimeInMillis(dtCad.getTime());
				Integer idUsuario = rs.getInt("T_HTL_USUARIO_ID_USUARIO");

				pressaoArterial = new PressaoArterial(idPressaoArterial, nrSistolica, nrDiastolica, dtCadastro,
						idUsuario);

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

		return pressaoArterial;
	}
}
