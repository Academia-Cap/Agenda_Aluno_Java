package agaluno.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import agaluno.mvc.DTO.DisciplinaDTO;
import agaluno.mvc.entidades.Disciplina;
import agaluno.mvc.servicos.DisciplinaService;

@RestController
@RequestMapping("/disciplina")
@CrossOrigin
public class DisciplinaController {

	@Autowired
	DisciplinaService service;
	
	//mostra todos
	
	@GetMapping
	public ResponseEntity<List<DisciplinaDTO>> pegaDisciplina(){
		return ResponseEntity.ok(service.listarTodos());
	}
	
	//mostra por id
	
	@GetMapping("/{iddisciplina}")
	public ResponseEntity<DisciplinaDTO> pegaDisciplina(@PathVariable("iddisciplina") int iddisciplina){
		DisciplinaDTO discDTO = service.pegaDisciplina(iddisciplina);
		return ResponseEntity.status(HttpStatus.OK).body(discDTO);
	}
	
	//salvar
	
	@PostMapping
	public ResponseEntity<DisciplinaDTO> salvar(@RequestBody Disciplina disciplina){
		DisciplinaDTO disc = service.salvar(disciplina);
		return ResponseEntity.status(HttpStatus.CREATED).body(disc);
	}
	
	//alterar
	
	@PutMapping("/{iddisciplina}")
	public ResponseEntity<DisciplinaDTO> alterar(@PathVariable("iddisciplina") int iddisciplina, @RequestBody Disciplina disciplina){
		return ResponseEntity.status(HttpStatus.OK).body(service.alterar(iddisciplina, disciplina));
	}
	
	//delete
	
	@DeleteMapping("/{iddisciplina}")
	public ResponseEntity<DisciplinaDTO> excluir(@PathVariable("iddisciplina") int iddisciplina){
		try {
			service.delete(iddisciplina);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
}
