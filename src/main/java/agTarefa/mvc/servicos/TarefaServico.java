package agTarefa.mvc.servicos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import agaluno.mvc.DTO.TarefaDTO;
import agaluno.mvc.entidades.Tarefa;
import agaluno.mvc.repositorios.TarefaRepositorio;
import agaluno.mvc.servicos.exceptions.RecursoNaoEncontrado;

@Service
public class TarefaServico {
	@Autowired
	TarefaRepositorio repo;
	
	public TarefaDTO salvar(Tarefa tarefa) {
		Tarefa obj = repo.save(tarefa);
		return new TarefaDTO(obj);
	}

	public List<TarefaDTO> getTodas(int idtarefa) {
		List<Tarefa> tarefa = repo.findAll();
		List<TarefaDTO> tarefaDTO = new ArrayList<>();		
		
		for(Tarefa tar : tarefa) {
			tarefaDTO.add(new TarefaDTO(tar));
		}		
		return tarefaDTO;
	}
	
	public TarefaDTO getTarefa(int idtarefa) {
		Optional<Tarefa> obj = repo.findById(idtarefa);
		Tarefa tar = obj.orElseThrow(() -> new RecursoNaoEncontrado("Tarefa não encontrada"));
		return new TarefaDTO(tar);
	}
	
	public TarefaDTO alterar(int idtarefa, Tarefa tarefa) {
		Optional<Tarefa> obj = repo.findById(idtarefa);
		Tarefa tar = obj.orElseThrow( () -> new RecursoNaoEncontrado("Não foi possivel alterar"));
		tar.setPeriodo(tarefa.getPeriodo());
		tar.setHoraInicio(tarefa.getHoraInicio());
		tar.setHoraFinal(tarefa.getHoraFinal());
		tar.setDisciplina(tarefa.getDisciplina());
		tar.setAluno(tarefa.getAluno());
		tar = repo.save(tar);
		return new TarefaDTO(tar);
	}
	
	public void excluir(int idtarefa) {
		repo.deleteById(idtarefa);
	}
	
}
