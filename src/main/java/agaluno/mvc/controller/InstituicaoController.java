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

import agaluno.mvc.DTO.InstituicaoDTO;
import agaluno.mvc.entidades.Instituicao;
import agaluno.mvc.servicos.InstituicaoServico;

@RestController
@RequestMapping("/instituicao")
@CrossOrigin
public class InstituicaoController {
	@Autowired
	InstituicaoServico service;
	
	@GetMapping
	public ResponseEntity<List<InstituicaoDTO>> listarTodos(){
		return ResponseEntity.ok(service.buscarTodos());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<InstituicaoDTO> listarId(@PathVariable("id") int id){
		InstituicaoDTO idDTO = service.buscarId(id);
		return ResponseEntity.status(HttpStatus.OK).body(idDTO);
	}
	
	@PostMapping
	public ResponseEntity<InstituicaoDTO> salvar(@RequestBody Instituicao instituicao) {
		InstituicaoDTO inst = service.salvar(instituicao);
        return ResponseEntity.status(HttpStatus.CREATED).body(inst);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<InstituicaoDTO> alterar(@PathVariable("id") int id, @RequestBody Instituicao instituicao){
		InstituicaoDTO inst = service.alterar(id,instituicao);
		return ResponseEntity.status(HttpStatus.CREATED).body(inst);
	}
	
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable("id") int id) {
		service.deletar(id);
	}
}
