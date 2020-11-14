package br.com.fiap.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.conexao.ConexaoBDManager;
import br.com.fiap.dao.PeriodoAlimentoDAO;
import br.com.fiap.model.PeriodoAlimento;
import br.com.fiap.model.TipoPagamento;

public class PeriodoAlimentoDAOImpl implements PeriodoAlimentoDAO {

	private Connection conexao;

	@Override
	public List<PeriodoAlimento> listarTodos() {
		List<PeriodoAlimento> lista = new ArrayList<PeriodoAlimento>();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conexao = ConexaoBDManager.getInstante().obterConexao();
			String sql = " SELECT * FROM T_HTL_PERIODO";
			stmt = conexao.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {
				int codigo = rs.getInt("ID_PERIODO");
				String descricao = rs.getString("NM_PERIODO");
				PeriodoAlimento pa = new PeriodoAlimento(codigo, descricao);
				lista.add(pa);
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
