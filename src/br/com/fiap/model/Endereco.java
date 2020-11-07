package br.com.fiap.model;

public class Endereco {

	private Integer idEndereco;
	private String nmLogradouro;
	private String dsEndereco;
	private String nrEndereco;
	private String nrCep;
	private String nmUf;
	private String nmCidade;
	private String nmBairro;
	private String dsComplemento;
	private Integer idUsuario;

	public Endereco(Integer idEndereco, String nmLogradouro, String dsEndereco, String nrEndereco, String nrCep,
			String nmUf, String nmCidade, String nmBairro, String dsComplemento, Integer idUsuario) {
		super();
		this.idEndereco = idEndereco;
		this.nmLogradouro = nmLogradouro;
		this.dsEndereco = dsEndereco;
		this.nrEndereco = nrEndereco;
		this.nrCep = nrCep;
		this.nmUf = nmUf;
		this.nmCidade = nmCidade;
		this.nmBairro = nmBairro;
		this.dsComplemento = dsComplemento;
		this.idUsuario = idUsuario;
	}

	public Endereco() {
		super();
	}

	public Integer getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(Integer idEndereco) {
		this.idEndereco = idEndereco;
	}

	public String getNmLogradouro() {
		return nmLogradouro;
	}

	public void setNmLogradouro(String nmLogradouro) {
		this.nmLogradouro = nmLogradouro;
	}

	public String getDsEndereco() {
		return dsEndereco;
	}

	public void setDsEndereco(String dsEndereco) {
		this.dsEndereco = dsEndereco;
	}

	public String getNrEndereco() {
		return nrEndereco;
	}

	public void setNrEndereco(String nrEndereco) {
		this.nrEndereco = nrEndereco;
	}

	public String getNrCep() {
		return nrCep;
	}

	public void setNrCep(String nrCep) {
		this.nrCep = nrCep;
	}

	public String getNmUf() {
		return nmUf;
	}

	public void setNmUf(String nmUf) {
		this.nmUf = nmUf;
	}

	public String getNmCidade() {
		return nmCidade;
	}

	public void setNmCidade(String nmCidade) {
		this.nmCidade = nmCidade;
	}

	public String getNmBairro() {
		return nmBairro;
	}

	public void setNmBairro(String nmBairro) {
		this.nmBairro = nmBairro;
	}

	public String getDsComplemento() {
		return dsComplemento;
	}

	public void setDsComplemento(String dsComplemento) {
		this.dsComplemento = dsComplemento;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	
	
}
