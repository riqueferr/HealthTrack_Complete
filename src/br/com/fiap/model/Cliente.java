package br.com.fiap.model;

import java.util.Date;

public class Cliente {


    private String nome;
    private Integer idade;
    private Date dtNascimento;
    private Date dtCadastro;

    public Cliente(String nome, Integer idade, Date dtNascimento, Date dtCadastro) {
        this.nome = nome;
        this.idade = idade;
        this.dtNascimento = dtNascimento;
        this.dtCadastro = dtCadastro;
    }

    public Cliente() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Date getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(Date dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public Date getDtCadastro() {
        return dtCadastro;
    }

    public void setDtCadastro(Date dtCadastro) {
        this.dtCadastro = dtCadastro;
    }


 
    public void assinarPlano(){
        //TODO
    }


    public void verificarAlimento(){
        //TODO
    }
}
