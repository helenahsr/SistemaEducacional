package br.com.sys.repositorys;
import java.util.ArrayList;
import java.util.List;

import br.com.sys.interfaces.*;
import br.com.sys.models.Professor;

public class RepositoryProfessorImpl implements IRepository{
	private List<Professor> professores;

    public RepositoryProfessorImpl() {
        this.professores = new ArrayList<>();
    }

	@Override
	public int getIdSequencia() {
		return professores.size() + 1;
	}

	@Override
	public int getTotalItens() {
		return professores.size();
	}
	
	public Professor getProfessor(int cpf) {
		for (Professor p : professores) {
			if(p.getCpf() == cpf) {
				return p;		
			}
		}
		return null;
	}
	
	public void addProfessor(Professor p) {
		professores.add(p);		
	}
	
	public void removeProfessor(Professor p) {
		professores.remove(p);
	}
	
	public List<Professor> listALL() {
		return professores;
	}
}
