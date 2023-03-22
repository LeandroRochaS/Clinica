package Clinica;

import java.time.LocalDate;

public class Paciente {
	private String cpf;
	private String nome;
	private LocalDate dataNascimento;
	private LocalDate dataCadastro;
	private String endereco;
	
	
	


	public Paciente(String cpf, String nome, LocalDate dataNascimento, LocalDate dataCadastro, String endereco) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.dataCadastro = dataCadastro;
		this.endereco = endereco;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public LocalDate getDataNascimento() {
		return dataNascimento;
	}


	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}


	public LocalDate getDataCadastro() {
		return dataCadastro;
	}


	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}


	public String getEndereco() {
		return endereco;
	}


	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	

}
