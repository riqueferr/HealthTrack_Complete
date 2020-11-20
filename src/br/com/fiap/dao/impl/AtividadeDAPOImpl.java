package br.com.fiap.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.fiap.conexao.ConexaoBDManager;
import br.com.fiap.dao.AtividadeDAO;
import br.com.fiap.exception.DBException;
import br.com.fiap.model.Atividade;
import br.com.fiap.model.Pagamento;
import br.com.fiap.model.TipoAtv;
import br.com.fiap.model.TipoPagamento;

public class AtividadeDAPOImpl implements AtividadeDAO {

	private Connection conexao;

	@Override
	public List<Atividade> listarTodos() {
		List<Atividade> lista = new ArrayList<Atividade>();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conexao = ConexaoBDManager.getInstante().obterConexao();
			String sql = "SELECT * FROM T_HTL_ATV"
					+ " INNER JOIN T_HTL_TIPOATV"
					+ " ON T_HTL_ATV.T_HTL_TIPOATV_ID_TIPOATV = T_HTL_TIPOATV.ID_TIPOATV";
			stmt = conexao.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {
				Integer idAtividade = rs.getInt("ID_ATV");
				java.sql.Date dtCad = rs.getDate("DT_CADASTRO");
				Calendar dtCadastro = Calendar.getInstance();
				dtCadastro.setTimeInMillis(dtCad.getTime());
				Integer vlTempo = rs.getInt("VL_TEMPO");
				Double vlDistancia = rs.getDouble("VL_DISTANCIA");
				Integer idUsuario = rs.getInt("T_HTL_USUARIO_ID_USUARIO");
				Integer idTipoAtv = rs.getInt("T_HTL_TIPOATV_ID_TIPOATV");
				String dsTipoAtv = rs.getString("DS_TIPOATV");

				Atividade atividade = new Atividade(idAtividade, dtCadastro, vlTempo, vlDistancia, idUsuario);
				TipoAtv tipoAtv = new TipoAtv(idTipoAtv, dsTipoAtv);
				atividade.setTipoAtv(tipoAtv);

				lista.add(atividade);
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
	public void cadastrar(Atividade atividade) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConexaoBDManager.getInstante().obterConexao();
			String sql = "INSERT INTO T_HTL_ATV (ID_ATV, DT_CADASTRO, VL_TEMPO, VL_DISTANCIA,"
					+ " T_HTL_TIPOATV_ID_TIPOATV, T_HTL_USUARIO_ID_USUARIO) VALUES (SEQ_ATIVIDADE.NEXTVAL, ?, ?, ?, ?, ?)";
			stmt = conexao.prepareStatement(sql);
			java.sql.Date dataAtual = new java.sql.Date(atividade.getDtCadastro().getTimeInMillis());
			stmt.setDate(1, dataAtual);
			stmt.setInt(2, atividade.getVlTempo());
			stmt.setDouble(3, atividade.getVlDistancia());
			stmt.setInt(4, atividade.getTipoAtv().getIdTipoAtv());
			stmt.setInt(5, atividade.getIdUsuario());
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
	public void atualizar(Atividade atividade) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConexaoBDManager.getInstante().obterConexao();
			String sql = "UPDATE T_HTL_ATV SET DT_CADASTRO = ?, VL_TEMPO = ?, VL_DISTANCIA = ?,"
					+ " T_HTL_TIPOATV_ID_TIPOATV = ?, T_HTL_USUARIO_ID_USUARIO = ?"
					+ " WHERE ID_ATV = ?";
			stmt = conexao.prepareStatement(sql);
			java.sql.Date data = new java.sql.Date(atividade.getDtCadastro().getTimeInMillis());
			stmt.setDate(1, data);
			stmt.setInt(2, atividade.getVlTempo());
			stmt.setDouble(3, atividade.getVlDistancia());
			stmt.setInt(4, atividade.getTipoAtv().getIdTipoAtv());
			stmt.setInt(5, atividade.getIdUsuario());
			stmt.setInt(6, atividade.getCodigo());

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
	public void remover(int idAtividade) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConexaoBDManager.getInstante().obterConexao();
			String sql = "DELETE FROM T_HTL_ATV WHERE ID_ATV = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, idAtividade);
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
	public Atividade buscarPorId(int id) {
		SimpleDateFormat formatacaoData = new SimpleDateFormat("dd/MM/yyyy");
		Atividade atividade = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conexao = ConexaoBDManager.getInstante().obterConexao();
			String sql = "SELECT * FROM T_HTL_ATV " + "INNER JOIN T_HTL_TIPOATV "
					+ "ON T_HTL_ATV.T_HTL_TIPOATV_ID_TIPOATV = T_HTL_TIPOATV.ID_TIPOATV "
					+ "WHERE T_HTL_ATV.ID_ATV = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();

			if (rs.next()) {
				Integer codigo = rs.getInt("ID_ATV");
				java.sql.Date dtCad = rs.getDate("DT_CADASTRO");
				Calendar dtCadastro = Calendar.getInstance();
				dtCadastro.setTimeInMillis(dtCad.getTime());
				Integer vlTempo = rs.getInt("VL_TEMPO");
				Double vlDistancia = rs.getDouble("VL_DISTANCIA");
				Integer idUsuario = rs.getInt("T_HTL_USUARIO_ID_USUARIO");
				Integer idTipoAtv = rs.getInt("T_HTL_TIPOATV_ID_TIPOATV");
				String dsTipoAtv = rs.getString("DS_TIPOATV");

				atividade = new Atividade(codigo, dtCadastro, vlTempo, vlDistancia, idUsuario);
				TipoAtv tp = new TipoAtv(idTipoAtv, dsTipoAtv);
				atividade.setTipoAtv(tp);

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

		return atividade;

	}

}
