package br.com.sys.repositorys;

import java.util.ArrayList;
import java.util.List;

import br.com.sys.interfaces.IRepository;
import br.com.sys.models.Aluno;

public class RepositoryAlunoImpl implements IRepository{
	private List<Aluno> alunos;
	
    public RepositoryAlunoImpl() {
        this.alunos = new ArrayList<>();
    }

	@Override
	public int getIdSequencia() {
		return alunos.size() + 1; 
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
