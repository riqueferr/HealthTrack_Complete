package br.com.fiap.model;

public class TipoPagamento {

    private Integer codigotp;
    private String dsTipoPagamento;

    public TipoPagamento(Integer codigotp, String dsTipoPagamento) {
        this.codigotp = codigotp;
        this.dsTipoPagamento = dsTipoPagamento;
    }

    public TipoPagamento() {
    }



    public String getDsTipoPagamento() {
        return dsTipoPagamento;
    }

    public void setDsTipoPagamento(String dsTipoPagamento) {
        this.dsTipoPagamento = dsTipoPagamento;
    }

	public Integer getCodigotp() {
		return codigotp;
	}

	public void setCodigotp(Integer codigotp) {
		this.codigotp = codigotp;
	}




}
