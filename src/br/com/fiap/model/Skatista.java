package br.com.fiap.model;

public class Skatista {


    private Integer rolamento;
    private String shape;
    private Integer rodas;

    public Skatista(Integer rolamento, String shape, Integer rodas) {
        this.rolamento = rolamento;
        this.shape = shape;
        this.rodas = rodas;
    }

    public Skatista() {
    }

    public Integer getRolamento() {
        return rolamento;
    }

    public void setRolamento(Integer rolamento) {
        this.rolamento = rolamento;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public Integer getRodas() {
        return rodas;
    }

    public void setRodas(Integer rodas) {
        this.rodas = rodas;
    }


    public void remar(){
        //TODO
    }


    public void ollie(){
        //TODO
    }


    public void freiar(){
        //TODO
    }
    
}
