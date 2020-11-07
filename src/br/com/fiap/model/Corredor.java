package br.com.fiap.model;

public class Corredor {


    private double distancia;
    private String tenis;
    private Integer tamanhoPe;

    public Corredor() {
    }

    public Corredor(double distancia, String tenis, Integer tamanhoPe) {
        this.distancia = distancia;
        this.tenis = tenis;
        this.tamanhoPe = tamanhoPe;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public String getTenis() {
        return tenis;
    }

    public void setTenis(String tenis) {
        this.tenis = tenis;
    }

    public Integer getTamanhoPe() {
        return tamanhoPe;
    }

    public void setTamanhoPe(Integer tamanhoPe) {
        this.tamanhoPe = tamanhoPe;
    }

    public void colocarTenis(){
        //TODO
    }
}
