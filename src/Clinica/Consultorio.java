package Clinica;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Consultorio {
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		ArrayList<Medico> medicos = new ArrayList<>();
		ArrayList<Paciente> pacientes = new ArrayList<>();
		ArrayList<Consulta> consultas = new ArrayList<>();

		while (true) {
			System.out
			.println("\n\n      ##### Controle de Consulta Médica #####");
	System.out.println("\n           ===============================");
	System.out.println("         |   1 - Cadastro de Médicos       |");
	System.out.println("         |   2 - Cadastro de Pacientes     |");
	System.out.println("         |   3 - Cadastro de Consultas     |");
	System.out.println("         |   4 - Cancelamento de Consultas |");
	System.out.println("         |   5 - Relatório Financeiro      |");
	System.out.println("         |   0 - Sair                      |");
	System.out.println("           ===============================\n");
	System.out.print("Opção: ");

			int opcao = scanner.nextInt();

			if (opcao == 0) {
				break;
			}

			switch (opcao) {
			case 1:
				cadastrarMedico(medicos);
				break;
			case 2:
				cadastrarPaciente(pacientes);
				break;
			case 3:
				cadastrarConsulta(medicos, pacientes, consultas);
				break;
			case 4:
				cancelarConsulta(consultas);
				break;
			case 5:
				gerarRelatorioFinanceiro(consultas);
				break;
			default:
				System.out.println("Opção inválida.");
			}
		}

		scanner.close();
	}

	private static void cadastrarMedico(ArrayList<Medico> medicos) {
		System.out.println("\n=== Cadastro de Médicos ===");
		
		
		System.out.print("CRM: ");
		int crm = scanner.nextInt();
		Medico medico = buscarMedicoPorCRM(crm, medicos);
		if(medico != null) {
			System.out.println("CRM já cadastrado.");
			return;
		}
		scanner.nextLine();

		System.out.print("Nome: ");
		String nome = scanner.nextLine();

		System.out.print("Data de Nascimento (dd/mm/aaaa): ");
		String dataNascimentoStr = scanner.nextLine();
		LocalDate dataNascimento = LocalDate.parse(dataNascimentoStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

		LocalDate dataCadastro = LocalDate.now();

		medicos.add(new Medico(crm, nome, dataNascimento, dataCadastro));

		System.out.println("Médico cadastrado com sucesso.");
	}

	private static void cadastrarPaciente(ArrayList<Paciente> pacientes) {
		System.out.println("\n=== Cadastro de Pacientes ===");
		
		scanner.nextLine();
		System.out.print("CPF: ");
		String cpf = scanner.nextLine();

		System.out.print("Nome: ");
		String nome = scanner.nextLine();

		System.out.print("Data de Nascimento (dd/mm/aaaa): ");
		String dataNascimentoStr = scanner.nextLine();
		LocalDate dataNascimento = LocalDate.parse(dataNascimentoStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

		LocalDate dataCadastro = LocalDate.now();

		System.out.print("Endereço: ");
		String endereco = scanner.nextLine();

		pacientes.add(new Paciente(cpf, nome, dataNascimento, dataCadastro, endereco));

		System.out.println("Paciente cadastrado com sucesso.");
	}

	private static void cadastrarConsulta(ArrayList<Medico> medicos, ArrayList<Paciente> pacientes, ArrayList<Consulta> consultas) {
		
		System.out.println("\n=== Cadastro de Consultas ===");
		System.out.print("CRM do Médico: ");
		int crm = scanner.nextInt();
		scanner.nextLine();
		Medico medico = buscarMedicoPorCRM(crm, medicos);
		if (medico == null) {
			System.out.println("Médico não encontrado.");
			return;
		}

		System.out.print("CPF do Paciente: ");
		String cpf = scanner.nextLine();
		Paciente paciente = buscarPacientePorCPF(cpf, pacientes);
		if (paciente == null) {
			System.out.println("Paciente não encontrado.");
			return;
		}

		System.out.print("Data da consulta (dd/mm/aaaa): ");
		String dataStr = scanner.nextLine();
		LocalDate data = LocalDate.parse(dataStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

		System.out.print("Hora da consulta (hh:mm): ");
		String horaStr = scanner.nextLine();
		LocalTime hora = LocalTime.parse(horaStr, DateTimeFormatter.ofPattern("HH:mm"));

		System.out.print("Primeira consulta (S/N): ");
		boolean primeiraConsulta = scanner.nextLine().equalsIgnoreCase("S");

		String status = "Agendada";
		double valor = primeiraConsulta ? 350.0 : 300.0;

		consultas.add(new Consulta(medico, paciente, data, hora, primeiraConsulta, status, valor));

		System.out.println("Consulta cadastrada com sucesso.");
	}

	private static Paciente buscarPacientePorCPF(String cpf, ArrayList<Paciente> pacientes) {
		for (Paciente pacienteI : pacientes) {
			if (pacienteI.getCpf().equals(cpf)) {
				return pacienteI;
			}

		}
		return null;
	}

	private static Medico buscarMedicoPorCRM(int crm, ArrayList<Medico> medicos) {
		for (Medico medicoI : medicos) {
			if (medicoI.getCrm() == crm) {
				return medicoI;
			}
			
		}
		return null;

	}
	
    private static void cancelarConsulta(ArrayList<Consulta> consultas) {
        System.out.println("\n=== Cancelamento de Consultas ===");
        
        scanner.nextLine();
        System.out.print("CPF do Paciente: ");
        String cpf = scanner.nextLine();

        System.out.print("Data da consulta (dd/mm/aaaa): ");
        String dataStr = scanner.nextLine();
        LocalDate data = LocalDate.parse(dataStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        System.out.print("CRM do Médico: ");
        int crm = scanner.nextInt();
        scanner.nextLine();

        Consulta consulta = buscarConsulta(cpf, data, crm, consultas);
        if (consulta == null) {
            System.out.println("Consulta não encontrada.");
            return;
        }

        if (consulta.getStatus().equalsIgnoreCase("Cancelada")) {
            System.out.println("Consulta já cancelada anteriormente.");
            return;
        }

        consulta.setStatus("Cancelada");
        double valor = consulta.getValor();
        if (!consulta.isPrimeiraConsulta()) {
            valor *= 0.9;
        }

        System.out.printf("Consulta cancelada com sucesso. Valor a ser reembolsado: R$ %.2f\n", valor);
    }

    private static Consulta buscarConsulta(String cpf, LocalDate data, int crm, ArrayList<Consulta> consultas) {
        for (Consulta consulta : consultas) {
            if (consulta.getPaciente().getCpf().equals(cpf)
                    && consulta.getData().equals(data)
                    && consulta.getMedico().getCrm() == crm) {
                return consulta;
            }
        }
        return null;
    }
    
    private static void gerarRelatorioFinanceiro(ArrayList<Consulta> consultas) {
        System.out.println("\n=== Relatório Financeiro ===");
        
        scanner.nextLine();
        System.out.print("Data de início (dd/mm/aaaa): ");
        String dataInicioStr = scanner.nextLine();
        LocalDate dataInicio = LocalDate.parse(dataInicioStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        System.out.print("Data de fim (dd/mm/aaaa): ");
        String dataFimStr = scanner.nextLine();
        LocalDate dataFim = LocalDate.parse(dataFimStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        double total = 0.0;
        System.out.println("\nConsultas realizadas:");
        for (Consulta consulta : consultas) {
            LocalDate dataConsulta = consulta.getData();
            if (dataConsulta.isAfter(dataInicio.minusDays(1)) && dataConsulta.isBefore(dataFim.plusDays(1))) {
                double valor = consulta.getValor();
                if (!consulta.isPrimeiraConsulta()) {
                    valor *= 0.9;
                }
                total += valor;

                System.out.printf("- %s - %s - %s - R$ %.2f\n", consulta.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                        consulta.getMedico().getNome(), consulta.getPaciente().getNome(), valor);
            }
        }
        System.out.printf("\nValor total: R$ %.2f\n", total);
    }


	

}