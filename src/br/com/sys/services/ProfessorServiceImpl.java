package br.com.sys.services;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.sys.interfaces.IService;
import br.com.sys.models.Professor;
import br.com.sys.repositorys.*;

public class ProfessorServiceImpl implements IService{
	private RepositoryProfessorImpl repositoryProfessor;

    public ProfessorServiceImpl(RepositoryProfessorImpl repository) {
        this.repositoryProfessor = repository;
    }
	
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
	public void add() {
		Professor professor = new Professor();
		int codigo = repositoryProfessor.getIdSequencia();
		int cpf = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o CPF do professor:"));
		 if (repositoryProfessor.getProfessor(cpf) != null) {
	            JOptionPane.showMessageDialog(null, "Já existe um professor cadastrado com este CPF.");
	            return;
	        }
		String nome = JOptionPane.showInputDialog(null, "Digite o nome do professor:");
		double salario = 2380.00;
		professor = new Professor(codigo, cpf, nome, salario);
		repositoryProfessor.addProfessor(professor);
	}

	@Override
	public void remove() {
		int item = 0;
		if(repositoryProfessor.listALL() != null)	
		{
			item = Integer.parseInt(JOptionPane.showInputDialog ("Digite o CPF do professor que deseja remover:"));
			for (Professor p : repositoryProfessor.listALL()) {
				if(p.getCpf() == item) {
					repositoryProfessor.removeProfessor(p);
					JOptionPane.showMessageDialog(null, "Professor removido!");
					return;
				}
			}
			JOptionPane.showMessageDialog(null, "Professor não encontrado!");
		}
		else {
			JOptionPane.showMessageDialog(null, "Não há professores cadastrados!");
		}
		
	}
	
	
}
