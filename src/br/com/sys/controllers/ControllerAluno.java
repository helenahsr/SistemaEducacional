package br.com.sys.controllers;

import javax.swing.JOptionPane;
import br.com.sys.services.*;
import br.com.sys.models.*;

public abstract class ControllerAluno {
	public static void menu(AlunoServiceImpl alunoServiceImpl) {
		String[] opcoes = {
				"Cadastrar",
				"Deletar",
				"Listar",
				"Pesquisar",
				"Sair"
	        };
		 boolean controleLoop = false;

	        int opcao;
		do {
			opcao = JOptionPane.showOptionDialog(null,
	                ":: Menu aluno ::\n\n"
	                + "Alunos cadastrados: "
	                + alunoServiceImpl.getTotalItens()
	                + "\n\n"
	                + "Defina sua opção:", 
	                "Sistema POO", 
	                JOptionPane.DEFAULT_OPTION, 
	                JOptionPane.INFORMATION_MESSAGE, 
	                null, 
	                opcoes, 
	                opcoes[0]);
			switch(opcao) {
			case 0:
				alunoServiceImpl.add();
				break;
			case 1:
				alunoServiceImpl.remove();
				break;
			case 2:
				String lista1 = "";
				for (Aluno a : alunoServiceImpl.getALLAlunos()) {
					lista1 += "ID: " + a.getCodigo()  + " | Nome: " + a.getNome() + " | CPF: " + a.getCpf() + " | Nota: " + a.getNota() + "\n";
				}
				if(lista1 != "") {
					JOptionPane.showMessageDialog(null, "Exibindo lista de alunos:\n" + lista1);
				}
				else {
					JOptionPane.showMessageDialog(null, "Não há alunos cadastrados!");
				}
			break;
			case 3:
				Aluno a = alunoServiceImpl.getAluno(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o CPF do aluno que deseja buscar.")));
				if(a != null)
				{
					JOptionPane.showMessageDialog(null, "ID: " + a.getCodigo()  + " | Nome: " + a.getNome() + " | CPF: " + a.getCpf() + " | Nota: " + a.getNota());
				}
				else {
					JOptionPane.showMessageDialog(null, "Aluno não encontrado!");
				}
				break;
			case 4:
				 controleLoop = true;
				break;
			}
		} while(controleLoop != true);
	}
}
