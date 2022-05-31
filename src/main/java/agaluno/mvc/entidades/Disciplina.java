package agaluno.mvc.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Disciplina {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String disciplina;
	private String abreviacao;
	private String docente;
	private String anotacao;

	@OneToOne
	@JoinColumn(name = "id_aluno")
	private Aluno aluno;

	@OneToOne
	@JoinColumn(name = "id_instituicao")
	private Instituicao instituicao;

	public Disciplina() {
	}

	public Disciplina(int id, String disciplina, String abreviacao, String docente, String anotacao, Aluno aluno,
			Instituicao instituicao) {
		this.id = id;
		this.disciplina = disciplina;
		this.abreviacao = abreviacao;
		this.docente = docente;
		this.anotacao = anotacao;
		this.aluno = aluno;
		this.instituicao = instituicao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
	}

	public String getAbreviacao() {
		return abreviacao;
	}

	public void setAbreviacao(String abreviacao) {
		this.abreviacao = abreviacao;
	}

	public String getDocente() {
		return docente;
	}

	public void setDocente(String docente) {
		this.docente = docente;
	}

	public String getAnotacao() {
		return anotacao;
	}

	public void setAnotacao(String anotacao) {
		this.anotacao = anotacao;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Instituicao getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(Instituicao instituicao) {
		this.instituicao = instituicao;
	}

}
