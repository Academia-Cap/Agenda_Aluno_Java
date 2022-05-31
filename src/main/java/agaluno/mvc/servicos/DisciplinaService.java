package agaluno.mvc.servicos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import agaluno.mvc.DTO.DisciplinaDTO;
import agaluno.mvc.entidades.Disciplina;
import agaluno.mvc.repositorios.DisciplinaRepositorio;
import agaluno.mvc.servicos.exceptions.RecursoNaoEncontrado;

@Service
public class DisciplinaService {

	@Autowired
	DisciplinaRepositorio repo;
	
	//lista todos
	
	public List<DisciplinaDTO> listarTodos(){
		List<Disciplina> disciplina = repo.findAll();
		
		List<DisciplinaDTO> disciplinaDTOs = new ArrayList<>();
		
		for (Disciplina disc : disciplina) {
			disciplinaDTOs.add(new DisciplinaDTO(disc));
		}
		
		return disciplinaDTOs;
		
	}
	
	//salvar
	
	public DisciplinaDTO salvar(Disciplina disciplina) {
		Disciplina disc = repo.save(disciplina);
		
		return new DisciplinaDTO(disc);
	}
	
	//lista por disciplina
	
	public DisciplinaDTO pegaDisciplina(int iddisciplina) {
		Optional<Disciplina> obj = repo.findById(iddisciplina);
		
		Disciplina disc = obj.orElseThrow(() -> new RecursoNaoEncontrado("Disciplina não encontrada"));
		return new DisciplinaDTO(disc);
	}

	//alterar

	public DisciplinaDTO alterar(int iddisciplina, Disciplina disciplina) {
		Optional<Disciplina> obj = repo.findById(iddisciplina);
		Disciplina disc = obj.orElseThrow(() -> new RecursoNaoEncontrado("Disciplina não encontrada"));
		
		disc.setDisciplina(disciplina.getDisciplina());
		disc.setAbreviacao(disciplina.getAbreviacao());
		disc.setDocente(disciplina.getDocente());
		disc.setAnotacao(disciplina.getAnotacao());
		disc = repo.save(disc);
		return new DisciplinaDTO(disc);
	}
	
	//delete
	
	public void delete(int iddisciplina) {
		repo.deleteById(iddisciplina);
	}
	
}
