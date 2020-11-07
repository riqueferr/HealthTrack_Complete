package br.com.fiap.model;

public class Triatletas {

    private String tipoPercurso;
    private Integer distanciaKm;
    private Integer dificuldade;

    public Triatletas(String tipoPercurso, Integer distanciaKm, Integer dificuldade) {
        this.tipoPercurso = tipoPercurso;
        this.distanciaKm = distanciaKm;
        this.dificuldade = dificuldade;
    }

    public Triatletas() {
    }

    public String getTipoPercurso() {
        return tipoPercurso;
    }

    public void setTipoPercurso(String tipoPercurso) {
        this.tipoPercurso = tipoPercurso;
    }

    public Integer getDistanciaKm() {
        return distanciaKm;
    }

    public void setDistanciaKm(Integer distanciaKm) {
        this.distanciaKm = distanciaKm;
    }

    public Integer getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(Integer dificuldade) {
        this.dificuldade = dificuldade;
    }

    public void nadar(){
        //TODO
    }

    public void correr(){
        //TODO
    }

    public void pedalar(){
        //TODO
    }

}
