package br.com.sys;

import javax.swing.JOptionPane;

import br.com.sys.services.*;
import br.com.sys.controllers.*;
import br.com.sys.models.*;
import br.com.sys.repositorys.*;

public class App {
	private boolean controleLoop;
	private ProfessorServiceImpl professorServiceImpl;
	private AlunoServiceImpl alunoServiceImpl;
	private RepositoryAlunoImpl repositoryAlunoImpl;
	private RepositoryProfessorImpl repositoryProfessorImpl;

	public static void main(String[] args) {
		App app = new App();
		app.repositoryAlunoImpl = new RepositoryAlunoImpl();
		app.repositoryProfessorImpl = new RepositoryProfessorImpl();
		app.alunoServiceImpl = new AlunoServiceImpl(app.repositoryAlunoImpl);
		app.professorServiceImpl = new ProfessorServiceImpl(app.repositoryProfessorImpl);
		app.menuPrincipal();
	}

	public void menuPrincipal() {
		 controleLoop = false;

		String[] opcoes = { "Alunos", "Professores", "Situação do Aluno", "Salário Professor", "Sair" };

		int opcao;
		do {
			opcao = JOptionPane.showOptionDialog(null,
					"Sistema realizado na disciplina de POO\n\n" + "Dados:\n" + "Alunos: "+ repositoryAlunoImpl.getTotalItens() +"\n" + "Professores: " + repositoryProfessorImpl.getTotalItens() +"\n\n"
							+ "-------- Menu Principal --------",
					"Sistema POO", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes,
					opcoes[0]);
			switch (opcao) {
			case 0:
				ControllerAluno.menu(alunoServiceImpl);
				break;
			case 1:
				ControllerProfessor.menu(professorServiceImpl);
				break;
			case 2:
				alunoServiceImpl.getResultado();
				break;
			case 3:
				getSalario();
				break;
			case 4:
				 controleLoop = true;
				break;
			}
		} while (controleLoop != true);
	}
	
	public void getSalario() { 
		int item = 0;
		if(professorServiceImpl.getALLProfessores() != null)	
		{
			item = Integer.parseInt(JOptionPane.showInputDialog ("Digite o CPF do professor que deseja saber o salário:"));
			for (Professor p : professorServiceImpl.getALLProfessores()) {
				if(p.getCpf() == item) {
					double porcentagem = (p.getSalario() * 3) / 100;
					double salario = p.getSalario() + (porcentagem * alunoServiceImpl.getTotalItens());
					JOptionPane.showMessageDialog(null, "ID: " + p.getCodigo()  + " | Nome: " + p.getNome() + " | CPF: " + p.getCpf() + "\n"
							+ "O salário é: " + salario);
					return;
				}
			}
			JOptionPane.showMessageDialog(null, "Professor não encontrado!");
			return;
		}
		else {
			JOptionPane.showMessageDialog(null, "Não há professores cadastrados!");
		}
	}
	
}

