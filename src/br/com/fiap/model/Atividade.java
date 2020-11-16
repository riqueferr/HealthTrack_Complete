package br.com.fiap.model;

import java.util.Calendar;

public class Atividade {

	private Integer idAtividade;
	private Calendar dtCadastro;
	private Integer vlTempo;
	private Double vlDistancia;
	private Integer idUsuario;
	private TipoAtv tipoAtv;

	public Atividade(Integer idAtividade, Calendar dtCadastro, Integer vlTempo, Double vlDistancia, Integer idUsuario) {
		super();
		this.idAtividade = idAtividade;
		this.dtCadastro = dtCadastro;
		this.vlTempo = vlTempo;
		this.vlDistancia = vlDistancia;
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

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public TipoAtv getTipoAtv() {
		return tipoAtv;
	}

	public void setTipoAtv(TipoAtv tipoAtv) {
		this.tipoAtv = tipoAtv;
	}

}
