package br.com.fiap.model;

import java.util.Calendar;

public class PressaoArterial {

	private Integer idPressaoArterial;
	private Integer nrSistolica;
	private Integer nrDiastolica;
	private Calendar dtCadastro;
	private Integer idUsuario;
	
	
	public PressaoArterial(Integer idPressaoArterial, Integer nrSistolica, Integer nrDiastolica, Calendar dtCadastro,
			Integer idUsuario) {
		super();
		this.idPressaoArterial = idPressaoArterial;
		this.nrSistolica = nrSistolica;
		this.nrDiastolica = nrDiastolica;
		this.dtCadastro = dtCadastro;
		this.idUsuario = idUsuario;
	}


	public PressaoArterial() {
		super();
	}


	public Integer getIdPressaoArterial() {
		return idPressaoArterial;
	}


	public void setIdPressaoArterial(Integer idPressaoArterial) {
		this.idPressaoArterial = idPressaoArterial;
	}


	public Integer getNrSistolica() {
		return nrSistolica;
	}


	public void setNrSistolica(Integer nrSistolica) {
		this.nrSistolica = nrSistolica;
	}


	public Integer getNrDiastolica() {
		return nrDiastolica;
	}


	public void setNrDiastolica(Integer nrDiastolica) {
		this.nrDiastolica = nrDiastolica;
	}


	public Calendar getDtCadastro() {
		return dtCadastro;
	}


	public void setDtCadastro(Calendar dtCadastro) {
		this.dtCadastro = dtCadastro;
	}


	public Integer getIdUsuario() {
		return idUsuario;
	}


	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	
	
	
}
