package agaluno.mvc.entidades;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@Entity
public class Instituicao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	private String sigla;
	private int cep;
	private String rua;
	private String cidade;
	private String estado;
	
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant createdAt;
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant updateAt;

	public Instituicao(int id, String nome, String sigla, int cep, String rua, String cidade, String estado) {
		this.id = id;
		this.nome = nome;
		this.sigla = sigla;
		this.cep = cep;
		this.rua = rua;
		this.cidade = cidade;
		this.estado = estado;
	}
	public Instituicao() {
		
	}
	
	public Instant getCreatedAt() {
		return createdAt;
	}
	public Instant getUpdateAt() {
		return updateAt;
	}
	@PrePersist
	public void prePersit() {
		createdAt = Instant.now();
	}
	@PreUpdate
	public void preUpdate() {
		updateAt = Instant.now();
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
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
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

}
