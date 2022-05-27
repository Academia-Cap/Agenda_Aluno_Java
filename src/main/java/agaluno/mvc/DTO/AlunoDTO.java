package agaluno.mvc.DTO;

import agaluno.mvc.entidades.Aluno;

public class AlunoDTO {
	private String nome;
	private String telefone;
	private String email;
	private String usuario;

	public AlunoDTO(Aluno aluno) {
		this.nome = aluno.getNome();
		this.telefone = aluno.getTelefone();
		this.email = aluno.getEmail();
		this.usuario = aluno.getUsuario();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
}
