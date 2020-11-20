package br.com.fiap.model;

import java.util.Calendar;

public class Alimento {

	private Integer codigo;
	private String nmAlimento;
	private Integer qtdeAlimento;
	private Integer qtdeCaloria;
	private Integer idUsuario;
	private PeriodoAlimento periodoAlimento;
	private Calendar dtCadastro;

	public Alimento(Integer codigo, String nmAlimento, Integer qtdeAlimento, Integer qtdeCaloria, Integer idUsuario,
			Calendar dtCadastro) {
		super();
		this.codigo = codigo;
		this.nmAlimento = nmAlimento;
		this.qtdeAlimento = qtdeAlimento;
		this.qtdeCaloria = qtdeCaloria;
		this.idUsuario = idUsuario;
		this.dtCadastro = dtCadastro;
	}

	public Alimento() {
		super();
	}

	

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNmAlimento() {
		return nmAlimento;
	}

	public void setNmAlimento(String nmAlimento) {
		this.nmAlimento = nmAlimento;
	}

	public Integer getQtdeAlimento() {
		return qtdeAlimento;
	}

	public void setQtdeAlimento(Integer qtdeAlimento) {
		this.qtdeAlimento = qtdeAlimento;
	}

	public Integer getQtdeCaloria() {
		return qtdeCaloria;
	}

	public void setQtdeCaloria(Integer qtdeCaloria) {
		this.qtdeCaloria = qtdeCaloria;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Calendar getDtCadastro() {
		return dtCadastro;
	}

	public void setDtCadastro(Calendar dtCadastro) {
		this.dtCadastro = dtCadastro;
	}

	public PeriodoAlimento getPeriodoAlimento() {
		return periodoAlimento;
	}

	public void setPeriodoAlimento(PeriodoAlimento periodoAlimento) {
		this.periodoAlimento = periodoAlimento;
	}

}
