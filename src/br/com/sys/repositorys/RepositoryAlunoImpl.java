package br.com.sys.repositorys;

import java.util.List;

import br.com.sys.interfaces.IRepository;
import br.com.sys.models.Aluno;
import br.com.sys.models.Professor;

public class RepositoryAlunoImpl implements IRepository{
	private List<Aluno> alunos;

	@Override
	public int getIdSequencia() {
		return alunos.size() + 1; //Tá errado, conserta depois.
	}

	@Override
	public int getTotalItens() {
		return alunos.size();
	}
	
	public Aluno getAluno(int cpf) {
		for(Aluno a : alunos) {
			if (a.getCpf() == cpf) {
				return a;
			}
		}
		return null;
	}
	
	public void addAluno(Aluno a) {
		alunos.add(a);
	}
	
	public void removeAluno(Aluno a) {
		alunos.remove(a);
	}
	
	public List<Aluno> listALL() {
		return alunos;
	}	
}
