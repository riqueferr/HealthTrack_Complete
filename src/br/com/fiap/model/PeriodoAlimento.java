package br.com.fiap.model;

public class PeriodoAlimento {

	private Integer codigo;
	private String dsPeriodo;

	public PeriodoAlimento(Integer codigo, String dsPeriodo) {
		super();
		this.codigo = codigo;
		this.dsPeriodo = dsPeriodo;
	}

	public PeriodoAlimento() {
		super();
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDsPeriodo() {
		return dsPeriodo;
	}

	public void setDsPeriodo(String dsPeriodo) {
		this.dsPeriodo = dsPeriodo;
	}

}
