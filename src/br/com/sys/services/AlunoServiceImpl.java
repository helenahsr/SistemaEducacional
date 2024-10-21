package br.com.sys.services;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.sys.interfaces.IService;
import br.com.sys.models.Aluno;
import br.com.sys.repositorys.*;

public class AlunoServiceImpl implements IService{
	private RepositoryAlunoImpl repositoryAluno;
	
    public AlunoServiceImpl(RepositoryAlunoImpl repository) {
        this.repositoryAluno = repository;
    }

	public int getTotalItens() {
		return repositoryAluno.getTotalItens();
	}
	
	public Aluno getAluno(int cpf) {
		return repositoryAluno.getAluno(cpf);
		
	}
	
	public List<Aluno> getALLAlunos() {
		return repositoryAluno.listALL();
		
	}
	
	public void getResultado() { 
		int item = 0;
		if(repositoryAluno.listALL() != null)	
		{
			item = Integer.parseInt(JOptionPane.showInputDialog ("Digite o CPF do aluno que deseja saber o resultado:"));
			for (Aluno a : repositoryAluno.listALL()) {
				if(a.getCpf() == item) {
					if(a.getNota() < 40)
					{
						JOptionPane.showMessageDialog(null, "Resultado de " + a.getNome() + ". Nota: " + a.getNota() + "\nResultdo: Reprovado.");
					}
					else if(a.getNota() < 60) {
						JOptionPane.showMessageDialog(null, "Resultado de " + a.getNome() + ". Nota: " + a.getNota() + "\nResultdo: Exame especial.");
					}
					else {
						JOptionPane.showMessageDialog(null, "Resultado de " + a.getNome() + ". Nota: " + a.getNota() + "\nResultdo: Aprovado.");
					}
					return;
				}
			}
			JOptionPane.showMessageDialog(null, "Aluno não encontrado!");
		}
		else {
			JOptionPane.showMessageDialog(null, "Não há alunos cadastrados!");
		}
	}

	@Override
	public void add() {
		Aluno aluno = new Aluno();
		int codigo = repositoryAluno.getIdSequencia();
		int cpf = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o CPF do aluno:"));
        if (repositoryAluno.getAluno(cpf) != null) {
            JOptionPane.showMessageDialog(null, "Já existe um aluno cadastrado com este CPF.");
            return; 
        }
		String nome = JOptionPane.showInputDialog(null, "Digite o nome do aluno:");
		double nota = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite a nota do aluno:"));
		if(nota < 0)
		{
			JOptionPane.showMessageDialog(null, "A nota precisa se maior que zero!");
            return;
		}
		aluno = new Aluno(codigo, cpf, nome, nota);
		

		
		repositoryAluno.addAluno(aluno);
	}

	@Override
	public void remove() {
		int item = 0;
		if(repositoryAluno.listALL() != null)	
		{
			item = Integer.parseInt(JOptionPane.showInputDialog ("Digite o CPF do aluno que deseja remover:"));
			for (Aluno a : repositoryAluno.listALL()) {
				if(a.getCpf() == item) {
					repositoryAluno.removeAluno(a);
					JOptionPane.showMessageDialog(null, "Aluno removido!");
					return;
				}
			}
			JOptionPane.showMessageDialog(null, "Aluno não encontrado!");
		}
		else {
			JOptionPane.showMessageDialog(null, "Não há alunos cadastrados!");
		}
		
	}
	
	


}