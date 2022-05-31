package agaluno.mvc.DTO;

import java.sql.Date;
import java.sql.Time;

import agaluno.mvc.entidades.Aluno;
import agaluno.mvc.entidades.Disciplina;
import agaluno.mvc.entidades.Tarefa;

public class TarefaDTO {
	private Date periodo;
	private Time horaInicio;
	private Time horaFinal;
	private Disciplina disciplina;
	private Aluno aluno;

	public TarefaDTO() {
	}

	public TarefaDTO(Tarefa tarefa) {
		this.periodo = tarefa.getPeriodo();
		this.horaInicio = tarefa.getHoraInicio();
		this.horaFinal = tarefa.getHoraFinal();
		this.disciplina = tarefa.getDisciplina();
		this.aluno = tarefa.getAluno();
	}

	public Date getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Date periodo) {
		this.periodo = periodo;
	}

	public Time getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Time horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Time getHoraFinal() {
		return horaFinal;
	}

	public void setHoraFinal(Time horaFinal) {
		this.horaFinal = horaFinal;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
}
