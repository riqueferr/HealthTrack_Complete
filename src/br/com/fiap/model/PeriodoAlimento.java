package br.com.fiap.model;

public class PeriodoAlimento {

	private Integer idPeriodo;
	private String dsPeriodo;

	public PeriodoAlimento(Integer idPeriodo, String dsPeriodo) {
		super();
		this.idPeriodo = idPeriodo;
		this.dsPeriodo = dsPeriodo;
	}

	public PeriodoAlimento() {
		super();
	}

	public Integer getIdPeriodo() {
		return idPeriodo;
	}

	public void setIdPeriodo(Integer idPeriodo) {
		this.idPeriodo = idPeriodo;
	}

	public String getDsPeriodo() {
		return dsPeriodo;
	}

	public void setDsPeriodo(String dsPeriodo) {
		this.dsPeriodo = dsPeriodo;
	}

}
