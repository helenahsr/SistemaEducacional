package br.com.sys.controllers;

import javax.swing.JOptionPane;

public abstract class ControllerAluno {
	public boolean controleLoop;
	
	public void menu() {
		
		String[] opcoes = {
				"Cadastrar",
				"Deletar",
				"Listar",
				"Pesquisar",
				"Sair"
	        };
	        
	        int opcao;
	        //do while
		do {
			opcao = JOptionPane.showOptionDialog(null,
	                "Menu aluno", 
	                "Menu Aluno\n\n", 
	                JOptionPane.DEFAULT_OPTION, 
	                JOptionPane.INFORMATION_MESSAGE, 
	                null, 
	                opcoes, 
	                opcoes[0]);
		} while(opcao == 5);
	}
}
