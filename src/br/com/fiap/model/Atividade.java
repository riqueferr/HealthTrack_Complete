package br.com.fiap.model;

import java.util.Calendar;


public class Atividade {



    private Integer idAtividade;
    private Calendar dtCadastro;
    private Integer vlTempo;
    private Double vlDistancia;
    private Integer idTipoAtv;
    private String dsTipoAtv;
    private Integer idUsuario;
    
    
    

    public Atividade(Integer idAtividade, Calendar dtCadastro, Integer vlTempo, Double vlDistancia, Integer idTipoAtv, String dsTipoAtv,
			Integer idUsuario) {
		super();
		this.idAtividade = idAtividade;
		this.dtCadastro = dtCadastro;
		this.vlTempo = vlTempo;
		this.vlDistancia = vlDistancia;
		this.idTipoAtv = idTipoAtv;
		this.dsTipoAtv = dsTipoAtv;
		this.idUsuario = idUsuario;
	}
    

	public Atividade() {
		super();
	}

	public Integer getIdAtividade() {
        return idAtividade;
    }

    public void setIdAtividade(Integer idAtividade) {
        this.idAtividade = idAtividade;
    }


	public Calendar getDtCadastro() {
		return dtCadastro;
	}


	public void setDtCadastro(Calendar dtCadastro) {
		this.dtCadastro = dtCadastro;
	}


	public Integer getVlTempo() {
		return vlTempo;
	}


	public void setVlTempo(Integer vlTempo) {
		this.vlTempo = vlTempo;
	}


	public Double getVlDistancia() {
		return vlDistancia;
	}


	public void setVlDistancia(Double vlDistancia) {
		this.vlDistancia = vlDistancia;
	}


	public Integer getIdTipo() {
		return idTipoAtv;
	}


	public void setIdTipo(Integer idTipo) {
		this.idTipoAtv = idTipo;
	}
	
	
	public Integer getIdTipoAtv() {
		return idTipoAtv;
	}


	public void setIdTipoAtv(Integer idTipoAtv) {
		this.idTipoAtv = idTipoAtv;
	}


	public String getDsTipoAtv() {
		return dsTipoAtv;
	}


	public void setDsTipoAtv(String dsTipoAtv) {
		this.dsTipoAtv = dsTipoAtv;
	}


	public Integer getIdUsuario() {
		return idUsuario;
	}


	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
    
    

	
}
