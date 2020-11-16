package br.com.fiap.model;

public class TipoAtv {
	
	private Integer idTipoAtv;
	private String dsTipoAtv;
	
	
	
	public TipoAtv(Integer idTipoAtv, String dsTipoAtv) {
		super();
		this.idTipoAtv = idTipoAtv;
		this.dsTipoAtv = dsTipoAtv;
	}
	
	
	
	public TipoAtv() {
		super();
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
	
	

}
