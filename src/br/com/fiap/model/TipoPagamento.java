package br.com.fiap.model;

public class TipoPagamento {

    private Integer codigo;
    private String dsTipoPagamento;

    public TipoPagamento(Integer codigo, String dsTipoPagamento) {
        this.setCodigo(codigo);
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

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}


}
