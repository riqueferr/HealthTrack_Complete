package br.com.fiap.model;

public class Administrador {

	private String senhaAdm;


    public Administrador(String senhaAdm) {
        this.senhaAdm = senhaAdm;
    }

    public Administrador(){

    }

    public String getSenhaAdm() {
        return senhaAdm;
    }

    public void setSenhaAdm(String senhaAdm) {
        this.senhaAdm = senhaAdm;
    }

    public void atualizarSistema(){
        //TODO
    }
    
}
