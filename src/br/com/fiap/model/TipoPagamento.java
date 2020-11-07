package br.com.fiap.model;

public class TipoPagamento {

    private Integer idTipo;
    private String dsTipoPagamento;

    public TipoPagamento(Integer idTipo, String dsTipoPagamento) {
        this.idTipo = idTipo;
        this.dsTipoPagamento = dsTipoPagamento;
    }

    public TipoPagamento() {
    }

    public Integer getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Integer idTipo) {
        this.idTipo = idTipo;
    }

    public String getDsTipoPagamento() {
        return dsTipoPagamento;
    }

    public void setDsTipoPagamento(String dsTipoPagamento) {
        this.dsTipoPagamento = dsTipoPagamento;
    }


}
