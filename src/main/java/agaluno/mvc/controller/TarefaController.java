package agaluno.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import agaluno.mvc.DTO.TarefaDTO;
import agaluno.mvc.entidades.Tarefa;
import agaluno.mvc.servicos.TarefaServico;

@Controller
@RequestMapping("/tarefa")
@CrossOrigin
public class TarefaController {
	@Autowired
	TarefaServico servico;
	
	@GetMapping
	public ResponseEntity<List<TarefaDTO>> getTodos() {
		List<TarefaDTO> tarefaDTO = servico.getTodas();
		return ResponseEntity.status(HttpStatus.OK).body(tarefaDTO);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TarefaDTO> getAluno(@PathVariable("id") int id) {
		TarefaDTO tarefaDTO = servico.getTarefa(id);
		return ResponseEntity.status(HttpStatus.OK).body(tarefaDTO);
	}
	
	@PostMapping
	public ResponseEntity<TarefaDTO> salvar(@RequestBody Tarefa tarefa){
		TarefaDTO tarefaDTO = servico.salvar(tarefa);
		return ResponseEntity.status(HttpStatus.OK).body(tarefaDTO);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<TarefaDTO> alterar(@PathVariable("id") int id, @RequestBody Tarefa tarefa){
		TarefaDTO tarefaDTO = servico.alterar(id, tarefa);
		return ResponseEntity.status(HttpStatus.OK).body(tarefaDTO);
	}
	
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable("id") int id){
		servico.excluir(id);
	}
}
