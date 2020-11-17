package br.com.fiap.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.conexao.ConexaoBDManager;
import br.com.fiap.dao.TipoAtvDAO;
import br.com.fiap.model.PeriodoAlimento;
import br.com.fiap.model.TipoAtv;

public class TipoAtvDAOImpl implements TipoAtvDAO{
	
	private Connection conexao;

	@Override
	public List<TipoAtv> listarTodos() {
		List<TipoAtv> lista = new ArrayList<TipoAtv>();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conexao = ConexaoBDManager.getInstante().obterConexao();
			String sql = " SELECT * FROM T_HTL_TIPOATV";
			stmt = conexao.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {
				int codigo = rs.getInt("ID_TIPOATV");
				String descricao = rs.getString("DS_TIPOATV");
				TipoAtv ta = new TipoAtv(codigo, descricao);
				lista.add(ta);
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
