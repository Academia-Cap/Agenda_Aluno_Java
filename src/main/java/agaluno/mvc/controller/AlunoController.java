package agaluno.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import agaluno.mvc.DTO.AlunoDTO;
import agaluno.mvc.entidades.Aluno;
import agaluno.mvc.servicos.AlunoServico;

@Controller
@RequestMapping("/aluno")
@CrossOrigin
public class AlunoController {
	@Autowired
	AlunoServico servico;

	@GetMapping("/{id}")
	public ResponseEntity<AlunoDTO> getAluno(@PathVariable("id") int id) {
		AlunoDTO alunoDTO = servico.getAluno(id);
		return ResponseEntity.status(HttpStatus.OK).body(alunoDTO);
	}
	
	@PostMapping
	public ResponseEntity<AlunoDTO> salvar(@RequestBody Aluno aluno){
		AlunoDTO alunoDTO = servico.salvar(aluno);
		return ResponseEntity.status(HttpStatus.OK).body(alunoDTO);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<AlunoDTO> alterar(@PathVariable("id") int id, @RequestBody Aluno aluno){
		AlunoDTO alunoDTO = servico.alterar(id, aluno);
		return ResponseEntity.status(HttpStatus.OK).body(alunoDTO);
	}
}
