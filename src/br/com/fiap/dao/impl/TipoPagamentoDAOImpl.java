package br.com.fiap.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.conexao.ConexaoBDManager;
import br.com.fiap.dao.TipoPagamentoDAO;
import br.com.fiap.model.TipoPagamento;

public class TipoPagamentoDAOImpl implements TipoPagamentoDAO {

	private Connection conexao;

	@Override
	public List<TipoPagamento> listarTodos() {
		List<TipoPagamento> lista = new ArrayList<TipoPagamento>();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conexao = ConexaoBDManager.getInstante().obterConexao();
			String sql = "SELECT * FROM T_HTL_TIPO";
			stmt = conexao.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {
				int codigo = rs.getInt("ID_TIPO");
				String descricao = rs.getString("NM_TIPOPAG");
				TipoPagamento tp = new TipoPagamento(codigo, descricao);
				lista.add(tp);
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

}
