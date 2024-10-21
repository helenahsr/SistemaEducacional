package br.com.sys.controllers;

import javax.swing.JOptionPane;

import br.com.sys.models.*;
import br.com.sys.services.*;

public abstract class ControllerProfessor {
	public boolean controleLoop;
	
	public static void menu(ProfessorServiceImpl professorServiceImpl) {
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
	                ":: Menu professores ::\n\n"
	                + "Professores cadastrados: "
	                + professorServiceImpl.getTotalItens()
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
				professorServiceImpl.add();
				break;
			case 1:
				professorServiceImpl.remove();
				break;
			case 2:
				String lista1 = "";
				for (Professor p : professorServiceImpl.getALLProfessores()) {
					lista1 += "ID: " + p.getCodigo()  + " | Nome: " + p.getNome() + " | CPF: " + p.getCpf() + "\n";
				}
				if(lista1 != "") {
					JOptionPane.showMessageDialog(null, "Exibindo lista de professores:\n" + lista1);
				}
				else {
					JOptionPane.showMessageDialog(null, "Não há professores!");
				}
			break;
			case 3:
				Professor p = professorServiceImpl.getProfessor(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o CPF do professor que deseja buscar.")));
				if (p != null)
				{
					JOptionPane.showMessageDialog(null, "ID: " + p.getCodigo()  + " | Nome: " + p.getNome() + " | CPF: " + p.getCpf());
				}
				else {
					JOptionPane.showMessageDialog(null, "Professor não encontrado!");
				}
				break;
			case 4:
				 controleLoop = true;
				break;
			}
		} while(controleLoop != true);
	}
}
