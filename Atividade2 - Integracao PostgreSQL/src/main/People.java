package main;

public class People {
	private int codigo;
	private String trabalho;
	private int idade;
	private String nome;
	
	public People() {
		this.codigo = -1;
		this.trabalho = "";
		this.idade = 0;
		this.nome = "";
	}
	
	public People(int codigo, String trabalho, int idade, String nome) {
		this.codigo = codigo;
		this.trabalho = trabalho;
		this.idade = idade;
		this.nome = nome;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getTrabalho() {
		return trabalho;
	}
	
	public void setTrabalho(String trabalho) {
		this.trabalho = trabalho;
	}
	
	public int getIdade() {
		return idade;
	}
	
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		return "people [codigo=" + codigo + ", trabalho=" + trabalho + ", idade=" + idade + ", nome=" + nome + "]";
	}	

	
	
}
