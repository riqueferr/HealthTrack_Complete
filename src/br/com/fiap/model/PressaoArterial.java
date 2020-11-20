package br.com.fiap.model;

import java.util.Calendar;

public class PressaoArterial {

	private Integer codigo;
	private Integer nrSistolica;
	private Integer nrDiastolica;
	private Calendar dtCadastro;
	private Integer idUsuario;
	
	
	public PressaoArterial(Integer codigo, Integer nrSistolica, Integer nrDiastolica, Calendar dtCadastro,
			Integer idUsuario) {
		super();
		this.codigo = codigo;
		this.nrSistolica = nrSistolica;
		this.nrDiastolica = nrDiastolica;
		this.dtCadastro = dtCadastro;
		this.idUsuario = idUsuario;
	}


	public PressaoArterial() {
		super();
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


	public Integer getCodigo() {
		return codigo;
	}


	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
	
	
	
}
