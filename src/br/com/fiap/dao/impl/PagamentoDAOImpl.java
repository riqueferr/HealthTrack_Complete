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
import br.com.fiap.dao.PagDAO;
import br.com.fiap.exception.DBException;
import br.com.fiap.model.Alimento;
import br.com.fiap.model.Pagamento;
import br.com.fiap.model.PeriodoAlimento;
import br.com.fiap.model.TipoPagamento;
import br.com.fiap.model.Usuario;

public class PagamentoDAOImpl implements PagDAO {

	private Connection conexao;

	@Override
	public List<Pagamento> listarTodos() {
		List<Pagamento> lista = new ArrayList<Pagamento>();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conexao = ConexaoBDManager.getInstante().obterConexao();
			String sql = "SELECT thp.ID_PAG ," 
					+ "	   thp.QT_PARCELA ," 
					+ "	   thp.VL_TOTAL ,"
					+ "	   thp.T_HTL_TIPO_ID_TIPO ," 
					+ "	   tht.NM_TIPOPAG ,"
					+ "	   thp.T_HTL_USUARIO_ID_USUARIO , " 
					+ "	   thp.DT_CADASTRO" 
					+ "    FROM T_HTL_PAG thp ,"
					+ "	   T_HTL_TIPO tht " 
					+ "    WHERE tht.ID_TIPO = thp.T_HTL_TIPO_ID_TIPO ";
			stmt = conexao.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {
				Integer idPagamento = rs.getInt("ID_PAG");
				Integer qtdeParcela = rs.getInt("QT_PARCELA");
				Double vlTotal = rs.getDouble("VL_TOTAL");
				Integer idUsuario = rs.getInt("T_HTL_USUARIO_ID_USUARIO");
				java.sql.Date dtCad = rs.getDate("DT_CADASTRO");
				Calendar dtCadastro = Calendar.getInstance();
				dtCadastro.setTimeInMillis(dtCad.getTime());
				
				Integer idTipoPag = rs.getInt("T_HTL_TIPO_ID_TIPO");
				String dsTipoPag = rs.getString("NM_TIPOPAG");

				Pagamento pagamento = new Pagamento(idPagamento, qtdeParcela, vlTotal, idUsuario, dtCadastro);
				TipoPagamento tp = new TipoPagamento(idTipoPag, dsTipoPag);
				pagamento.setTipoPagamento(tp);

				lista.add(pagamento);
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
	public void cadastrar(Pagamento pagamento) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConexaoBDManager.getInstante().obterConexao();
			String sql = "INSERT INTO T_HTL_PAG (ID_PAG, QT_PARCELA, VL_TOTAL,"
					+ " T_HTL_TIPO_ID_TIPO, T_HTL_USUARIO_ID_USUARIO, DT_CADASTRO)"
					+ " VALUES (SEQ_PAGAMENTO.NEXTVAL, ?, ?, ?, ?, ?)";
			stmt = conexao.prepareStatement(sql);

			stmt.setInt(1, pagamento.getQtdeParcela());
			stmt.setDouble(2, pagamento.getVlTotal());
			stmt.setInt(3, pagamento.getTipoPagamento().getIdTipo());
			stmt.setInt(4, pagamento.getIdUsuario());
			java.sql.Date dataAtual = new java.sql.Date(pagamento.getDtCadastro().getTimeInMillis());
			stmt.setDate(5, dataAtual);
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
	public void atualizar(Pagamento pagamento) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConexaoBDManager.getInstante().obterConexao();
			String sql = "UPDATE T_HTL_PAG SET QT_PARCELA = ?, VL_TOTAL = ?, T_HTL_TIPO_ID_TIPO = ?,"
					+ " T_HTL_USUARIO_ID_USUARIO ?, DT_CADASTRO = ?"
					+ " WHERE ID_PAG = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, pagamento.getQtdeParcela());
			stmt.setDouble(2, pagamento.getVlTotal());
			stmt.setInt(3, pagamento.getTipoPagamento().getIdTipo());
			stmt.setInt(4, pagamento.getIdUsuario());
			java.sql.Date data = new java.sql.Date(pagamento.getDtCadastro().getTimeInMillis());
			stmt.setDate(5, data);
			stmt.setInt(6, pagamento.getIdPagamento());

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
	public void remover(int idPagamento) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConexaoBDManager.getInstante().obterConexao();
			String sql = "DELETE FROM T_HTL_PAG WHERE ID_PAG = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, idPagamento);
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
	public Pagamento buscarPorId(int codigo) {
		SimpleDateFormat formatacaoData = new SimpleDateFormat("dd/MM/yyyy");
		Pagamento pagamento = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conexao = ConexaoBDManager.getInstante().obterConexao();
			String sql = "SELECT * FROM T_HTL_PAG "
					+ "INNER JOIN T_HTL_TIPO "
					+ "ON T_HTL_PAG.T_HTL_TIPO_ID_TIPO = T_HTL_TIPO.ID_TIPO "
					+ "WHERE ID_PAG = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, codigo);
			rs = stmt.executeQuery();

			if (rs.next()) {
				Integer idPagamento = rs.getInt("ID_PAG");
				Integer qtdeParcela = rs.getInt("QT_PARCELA");
				Double vlTotal = rs.getDouble("VL_TOTAL");
				Integer idUsuario = rs.getInt("T_HTL_USUARIO_ID_USUARIO");
				java.sql.Date dtCad = rs.getDate("DT_CADASTRO");
				Calendar dtCadastro = Calendar.getInstance();
				dtCadastro.setTimeInMillis(dtCad.getTime());
				Integer idTipoPag = rs.getInt("T_HTL_TIPO_ID_TIPO");
				String dsTipoPag = rs.getString("NM_TIPOPAG");

				pagamento = new Pagamento(idPagamento, qtdeParcela, vlTotal, idUsuario, dtCadastro);
				TipoPagamento tp = new TipoPagamento(idTipoPag, dsTipoPag);
				pagamento.setTipoPagamento(tp);

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

		return pagamento;

	}

}
