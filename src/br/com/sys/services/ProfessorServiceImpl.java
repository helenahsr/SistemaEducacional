package br.com.sys.services;
import java.util.List;

import br.com.sys.interfaces.IService;
import br.com.sys.models.Professor;
import br.com.sys.repositorys.*;

public class ProfessorServiceImpl implements IService<Professor>{
	private RepositoryProfessorImpl repositoryProfessor;

	@Override
	public int getTotalItens() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public Professor getProfessor(int cpf) {
		return null;
		
	}
	
	public List<Professor> getALLProfessores() {
		return null;
		
	}

	@Override
	public void add(Professor entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Professor entity) {
		// TODO Auto-generated method stub
		
	}
	
}
