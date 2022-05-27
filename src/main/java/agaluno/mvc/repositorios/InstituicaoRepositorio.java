package agaluno.mvc.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import agaluno.mvc.entidades.Instituicao;

@Repository
public interface InstituicaoRepositorio extends JpaRepository<Instituicao,Integer>{

}
