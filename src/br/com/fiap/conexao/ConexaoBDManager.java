package br.com.fiap.conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoBDManager {

	private static ConexaoBDManager conexaoBDManager;

	private ConexaoBDManager() {

	}

	public static ConexaoBDManager getInstante() {
		if(conexaoBDManager == null) {
			conexaoBDManager = new ConexaoBDManager();
		}
		return conexaoBDManager;
	}

	public Connection obterConexao() {

		Connection conexao = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conexao = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", "RM84106",
					"fiap20");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return conexao;
	}
}
