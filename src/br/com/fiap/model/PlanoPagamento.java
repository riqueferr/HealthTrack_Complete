package br.com.fiap.model;

public class PlanoPagamento {


    private String modalidade;
    private double valor;
    private Integer parcelas;

    
    public PlanoPagamento() {
    }

    public PlanoPagamento(String modalidade, double valor, Integer parcelas) {
        this.modalidade = modalidade;
        this.valor = valor;
        this.parcelas = parcelas;
    }

    public String getModalidade() {
        return modalidade;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Integer getParcelas() {
        return parcelas;
    }

    public void setParcelas(Integer parcelas) {
        this.parcelas = parcelas;
    }


    public void cadastrar(){
        //TODO
    }


    public void gerarBoleto(){
        //TODO
    }
	
}
