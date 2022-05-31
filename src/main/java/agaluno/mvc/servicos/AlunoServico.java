package agaluno.mvc.servicos;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import agaluno.mvc.DTO.AlunoDTO;
import agaluno.mvc.entidades.Aluno;
import agaluno.mvc.repositorios.AlunoRepositrio;
import agaluno.mvc.servicos.excessoes.RecursoNaoEncontrado;

@Service
public class AlunoServico {
	@Autowired
	AlunoRepositrio repo;

	public AlunoDTO salvar(Aluno aluno) {
		Aluno obj = repo.save(aluno);
		return new AlunoDTO(obj);
	}

	public AlunoDTO getAluno(int idaluno) {
		Optional<Aluno> obj = repo.findById(idaluno);
		Aluno alu = obj.orElseThrow(() -> new RecursoNaoEncontrado("Aluno não encontrado"));
		return new AlunoDTO(alu);
	}
	
	public AlunoDTO alterar(int idaluno, Aluno aluno) {
		Optional<Aluno> obj = repo.findById(idaluno);
		Aluno user = obj.orElseThrow( () -> new RecursoNaoEncontrado("Não foi possivel alterar"));
		user.setNome(aluno.getNome());
		user.setEmail(aluno.getEmail());
		user.setTelefone(aluno.getTelefone());
		user.setUsuario(aluno.getUsuario());
		user.setSenha(aluno.getSenha());
		user = repo.save(user);
		return new AlunoDTO(user);
	}

}
