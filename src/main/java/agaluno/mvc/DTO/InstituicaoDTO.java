package agaluno.mvc.DTO;

import java.util.Optional;

import agaluno.mvc.entidades.Instituicao;

public class InstituicaoDTO {
	
	private int id;
	private String nome;
	private String sigla;
	private int cep;
	private String rua;
	private String cidade;
	private String estado;
	

	public InstituicaoDTO(Instituicao instituicao) {
		this.id = instituicao.getId();
		this.nome = instituicao.getNome();
		this.sigla = instituicao.getSigla();
		this.cep = instituicao.getCep();
		this.rua = instituicao.getRua();
		this.cidade = instituicao.getCidade();
		this.estado = instituicao.getEstado();
	}
	
	public InstituicaoDTO() {
	
	}
	
	public InstituicaoDTO(Optional<Instituicao> inst) {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getCep() {
		return cep;
	}
	public void setCep(int cep) {
		this.cep = cep;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	
}
