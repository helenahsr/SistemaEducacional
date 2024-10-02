package br.com.sys.services;
import java.util.List;

import br.com.sys.interfaces.IService;
import br.com.sys.models.Aluno;
import br.com.sys.repositorys.*;

public class AlunoServiceImpl implements IService{
	private RepositoryAlunoImpl repositoryAluno;
	
	@Override
	public void add() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove() {
		
	}

	@Override
	public int getTotalItens() {
		return repositoryAluno.getTotalItens();
	}
	
	public Aluno getAluno(int cpf) {
		return repositoryAluno.getAluno(cpf);
		
	}
	
	public List<Aluno> getALLAlunos() {
		return repositoryAluno.listALL();
		
	}
	
	public void getResultado() { //Olhar com o professor
		
	}

}