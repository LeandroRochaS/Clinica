package Clinica;

import java.time.LocalDate;
import java.time.LocalTime;

public class Consulta {
	
	private Medico medico;
	private Paciente paciente;
	private LocalDate data;
	private LocalTime hora;
	boolean primeiraConsulta;
	private String status;
	private double valor;
	
	public Consulta(Medico medico, Paciente paciente, LocalDate data, LocalTime hora, boolean primeiraConsulta,
			String status, double valor) {
		super();
		this.medico = medico;
		this.paciente = paciente;
		this.data = data;
		this.hora = hora;
		this.primeiraConsulta = primeiraConsulta;
		this.status = status;
		this.valor = valor;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public boolean isPrimeiraConsulta() {
		return primeiraConsulta;
	}

	public void setPrimeiraConsulta(boolean primeiraConsulta) {
		this.primeiraConsulta = primeiraConsulta;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
   







}
