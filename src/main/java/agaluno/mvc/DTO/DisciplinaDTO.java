package agaluno.mvc.DTO;

import agaluno.mvc.entidades.Disciplina;

public class DisciplinaDTO {

	private String disciplina;
	private String abreviacao;
	private String docente;
	private String anotacao;

	public DisciplinaDTO(Disciplina disciplina) {
		this.disciplina = disciplina.getDisciplina();
		this.abreviacao = disciplina.getAbreviacao();
		this.docente = disciplina.getDocente();
		this.anotacao = disciplina.getAnotacao();
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
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

	

}
