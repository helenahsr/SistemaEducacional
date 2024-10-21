package br.com.sys.models;

public class Professor extends Pessoa {
	private double salario;

	@Override
	public String toString() {
		return "Professor [salario=" + salario + ", Codigo()=" + getCodigo() + ", Cpf()=" + getCpf()
				+ ", Nome()=" + getNome() + "]";
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	public Professor() {
		
	}
	
	public Professor(int codigo, int cpf, String nome, double salario) {
		super();
		this.setCodigo(codigo);
		this.setCpf(cpf);
		this.setNome(nome);
		this.salario = salario;
	}
}
