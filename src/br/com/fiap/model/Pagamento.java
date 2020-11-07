package br.com.fiap.model;

import java.util.Calendar;

public class Pagamento {

	private Integer idPagamento;
	private Integer qtdeParcela;
	private Double vlTotal;
	private Integer idTipoPag;
	private String dsTipoPag;
	private Integer idUsuario;
	private Calendar dtCadastro;
	
	public Pagamento(Integer idPagamento, Integer qtdeParcela, Double vlTotal, Integer idTipoPag, String dsTipoPag, Integer idUsuario, Calendar dtCadastro) {
		super();
		this.idPagamento = idPagamento;
		this.qtdeParcela = qtdeParcela;
		this.vlTotal = vlTotal;
		this.idTipoPag = idTipoPag;
		this.dsTipoPag = dsTipoPag;
		this.idUsuario = idUsuario;
		this.dtCadastro = dtCadastro;
	}

	public Pagamento() {
		super();
	}

	public Integer getIdPagamento() {
		return idPagamento;
	}

	public void setIdPagamento(Integer idPagamento) {
		this.idPagamento = idPagamento;
	}

	public Integer getQtdeParcela() {
		return qtdeParcela;
	}

	public void setQtdeParcela(Integer qtdeParcela) {
		this.qtdeParcela = qtdeParcela;
	}

	public Double getVlTotal() {
		return vlTotal;
	}

	public void setVlTotal(Double vlTotal) {
		this.vlTotal = vlTotal;
	}

	public Integer getIdTipoPag() {
		return idTipoPag;
	}

	public void setIdTipoPag(Integer idTipoPag) {
		this.idTipoPag = idTipoPag;
	}

		
	public String getDsTipoPag() {
		return dsTipoPag;
	}

	public void setDsTipoPag(String dsTipoPag) {
		this.dsTipoPag = dsTipoPag;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Calendar getDtCadastro() {
		return dtCadastro;
	}

	public void setDtCadastro(Calendar dtCadastro) {
		this.dtCadastro = dtCadastro;
	}
	
	
	
	
}