package agaluno.mvc.servicos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import agaluno.mvc.DTO.InstituicaoDTO;
import agaluno.mvc.entidades.Instituicao;
import agaluno.mvc.repositorios.InstituicaoRepositorio;
import agaluno.mvc.servicos.exceptions.RecursoNaoEncontrado;



@Service
public class InstituicaoServico {
	@Autowired
	InstituicaoRepositorio repo;
	
	public List<InstituicaoDTO> buscarTodos(){
		List<InstituicaoDTO> instDTO = new ArrayList<>();
		
		List<Instituicao> inst = repo.findAll();
		for(Instituicao instituto : inst) {
			instDTO.add(new InstituicaoDTO(instituto));
		}
		
		return instDTO;
	}
	
	public InstituicaoDTO alterar(int id, Instituicao instituicao) {
		Optional<Instituicao> obj = repo.findById(id);
		Instituicao inst = obj.orElseThrow(() -> new RecursoNaoEncontrado("Usuário não encontrado"));
		inst.setNome(instituicao.getNome());
		inst.setSigla(instituicao.getSigla());
		inst.setCep(instituicao.getCep());
		inst.setRua(instituicao.getRua());
		inst.setCidade(instituicao.getCidade());
		inst.setEstado(instituicao.getEstado());
		
		return new InstituicaoDTO(repo.save(inst));
	}
	
	public InstituicaoDTO buscarId(int id) {
		Optional<Instituicao> obj = repo.findById(id);	
		 Instituicao inst = obj.orElseThrow(() -> new RecursoNaoEncontrado("Usuário não encontrado"));
		 return new InstituicaoDTO(inst);
	} 
	
	public InstituicaoDTO salvar(Instituicao instituicao) {
		Instituicao inst = repo.save(instituicao);
		return new InstituicaoDTO(inst);
	}
	
	public void deletar(int id) {
		repo.deleteById(id);
	}
}
