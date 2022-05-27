package agaluno.mvc.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import agaluno.mvc.entidades.Aluno;

public interface AlunoRepositrio extends JpaRepository<Aluno, Integer>{
	
}
