package br.com.fiap.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.fiap.conexao.ConexaoBDManager;
import br.com.fiap.dao.AtividadeDAO;
import br.com.fiap.exception.DBException;
import br.com.fiap.model.Atividade;

public class AtividadeDAPOImpl implements AtividadeDAO {

	private Connection conexao;

	@Override
	public List<Atividade> listarTodos() {
		List<Atividade> lista = new ArrayList<Atividade>();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conexao = ConexaoBDManager.getInstante().obterConexao();
			String sql = "SELECT ID_ATV ," 
					+ "	   tha.DT_CADASTRO ," 
					+ "	   tha.VL_TEMPO ," 
					+ "	   tha.VL_DISTANCIA , "
					+ "	   tha.T_HTL_TIPOATV_ID_TIPOATV ," 
					+ "	   tht.DS_TIPOATV ," 
					+ "	   tha.T_HTL_USUARIO_ID_USUARIO "
					+ "    FROM T_HTL_ATV tha ," 
					+ "	   T_HTL_TIPOATV tht "
					+ "	   WHERE tha.T_HTL_TIPOATV_ID_TIPOATV = tht.ID_TIPOATV";
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

				Atividade atividade = new Atividade(idAtividade, dtCadastro, vlTempo, vlDistancia, idTipoAtv, dsTipoAtv,
						idUsuario);

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
	public void cadastrar(Atividade atividade) throws DBException{
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
			stmt.setInt(4, atividade.getIdTipo());
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
	public void atualizar(Atividade atividade) throws DBException{
		// TODO Auto-generated method stub

	}

	@Override
	public void remover(int idAtividade) throws DBException{
		// TODO Auto-generated method stub

	}

	@Override
	public Atividade buscarPorId(int idAtividade) {
		// TODO Auto-generated method stub
		return null;
	}

}
