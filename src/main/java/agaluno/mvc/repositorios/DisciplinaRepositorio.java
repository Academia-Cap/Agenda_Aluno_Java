package agaluno.mvc.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import agaluno.mvc.entidades.Disciplina;

@Repository
public interface DisciplinaRepositorio extends JpaRepository<Disciplina, Integer> {
	
}
