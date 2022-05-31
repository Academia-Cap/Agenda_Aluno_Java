package agaluno.mvc.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import agaluno.mvc.entidades.Tarefa;

public interface TarefaRepositorio  extends JpaRepository<Tarefa, Integer>{

}
