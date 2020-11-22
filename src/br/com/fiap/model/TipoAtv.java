package br.com.fiap.model;

public class TipoAtv {
	
	private Integer codigo;
	private String dsTipoAtv;
	
	
	
	public TipoAtv(Integer codigo, String dsTipoAtv) {
		super();
		this.setCodigo(codigo);
		this.dsTipoAtv = dsTipoAtv;
	}
	
	
	
	public TipoAtv() {
		super();
	}

	
	public String getDsTipoAtv() {
		return dsTipoAtv;
	}
	public void setDsTipoAtv(String dsTipoAtv) {
		this.dsTipoAtv = dsTipoAtv;
	}



	public Integer getCodigo() {
		return codigo;
	}



	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
	

}
