package br.com.fiap.model;

import java.sql.Date;
import java.util.Calendar;

public class Usuario {
	
	private Integer idUsuario;
    private String nome;
    private String sobrenome;
    private String email;
    private String senha;
    private Date dtNasc;
    private Calendar dtCadastro;
    
    
    


    public Usuario(Integer idUsuario, String nome, String sobrenome, String email, String senha, Date dtNasc,
			Calendar dtCadastro) {
		super();
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.senha = senha;
		this.dtNasc = dtNasc;
		this.dtCadastro = dtCadastro;
	}

    
    
	public Usuario() {
		super();
	}


	public Integer getIdUsuario() {
		return idUsuario;
	}


	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getSobrenome() {
		return sobrenome;
	}


	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public Date getDtNasc() {
		return dtNasc;
	}


	public void setDtNasc(Date dtNasc) {
		this.dtNasc = dtNasc;
	}


	public Calendar getDtCadastro() {
		return dtCadastro;
	}


	public void setDtCadastro(Calendar dtCadastro) {
		this.dtCadastro = dtCadastro;
	}


//	public boolean isLogado() {
//		return logado;
//	}
//
//
//	public void setLogado(boolean logado) {
//		this.logado = logado;
//	}
//
//
//	public String logar() {
//        if(this.getNome() == "Henrique" && this.getSenha() == "123456") {
//            this.logado = true;
//            return "Você está logado!";
//        }else {
//            return "Você informou algo errado!";
//        }
//
//    }
//
//
//    public String deslogar() {
//        if (this.logado) {
//            this.logado = false;
//            return "Você deslogou";
//        } else {
//            return "Por favor, logue antes de tentar sair!";
//        }
//    }

}
