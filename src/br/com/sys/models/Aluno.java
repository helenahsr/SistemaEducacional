package br.com.sys.models;

public class Aluno extends Pessoa {
	private double nota;

	@Override
	public String toString() {
		return "Aluno [nota=" + nota + ", Codigo()=" + getCodigo() + ", Cpf()=" + getCpf() + ", Nome()="
				+ getNome() + "]";
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}
	
	public Aluno() {
		
	}
	
	public Aluno(int codigo, int cpf, String nome, double nota) {
		super();
		this.setCodigo(codigo);
		this.setCpf(cpf);
		this.setNome(nome);
		this.nota = nota;
	}
}
