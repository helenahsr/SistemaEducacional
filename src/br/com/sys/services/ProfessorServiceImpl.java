package br.com.sys.services;
import java.util.List;

import br.com.sys.interfaces.IService;
import br.com.sys.models.Professor;
import br.com.sys.repositorys.*;

public class ProfessorServiceImpl implements IService<Professor>{
	private RepositoryProfessorImpl repositoryProfessor;

	@Override
	public int getTotalItens() {
		return repositoryProfessor.getTotalItens();
	}
	
	public Professor getProfessor(int cpf) {
		return repositoryProfessor.getProfessor(cpf);
		
	}
	
	public List<Professor> getALLProfessores() {
		return repositoryProfessor.listALL();
	}

	@Override
	public void add(Professor entity) {
		repositoryProfessor.addProfessor(entity);
		
	}

	@Override
	public void remove(Professor entity) {
		repositoryProfessor.removeProfessor(entity);
	}
	
}
