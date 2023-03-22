package Clinica;

import java.time.LocalDate;

public class Medico {
	private int crm;
	private String nome;
	private LocalDate dataNascimento;
	private LocalDate dataCadastro;

	

	public Medico(int crm, String nome, LocalDate dataNascimento, LocalDate dataCadastro) {
		super();
		this.crm = crm;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.dataCadastro = dataCadastro;
	}

	public int getCrm() {
		return crm;
	}

	public void setCrm(int crm) {
		this.crm = crm;
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
	
	

}
