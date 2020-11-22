package br.com.fiap.model;

import java.util.Calendar;

public class Pagamento {

	private Integer codigo;
	private Integer qtdeParcela;
	private Double vlTotal;
	private Integer idUsuario;
	private Calendar dtCadastro;
	private TipoPagamento tipoPagamento;

	public Pagamento(Integer codigo, Integer qtdeParcela, Double vlTotal, Integer idUsuario, Calendar dtCadastro) {
		super();
		this.codigo = codigo;
		this.qtdeParcela = qtdeParcela;
		this.vlTotal = vlTotal;
		this.idUsuario = idUsuario;
		this.dtCadastro = dtCadastro;
	}

	public Pagamento() {
		super();
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

	public TipoPagamento getTipoPagamento() {
		return tipoPagamento;
	}

	public void setTipoPagamento(TipoPagamento tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

}