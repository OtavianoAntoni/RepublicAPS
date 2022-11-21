import java.io.IOException;
/* 
import java.text.SimpleDateFormat;
import java.util.Date;
*/
import java.util.Scanner;

public class Principal {
	
	static byte menu() {
		try (Scanner scan = new Scanner(System.in)) {
			byte opcao;
			System.out.println("\n********************************************************");
			System.out.println("**     DIGITE O NÚMERO DA OPERAÇÃO DESEJADA      **");
			System.out.println("********************************************************");
			System.out.println("*                1 - Cadastrar Aluno                   *");
			System.out.println("*                2 - Cadastrar Despesa Fixa            *");
			System.out.println("*                3 - Cadastrar Despesa Variada         *");
			System.out.println("*                4 - Listar Alunos Cadastrados         *");
			System.out.println("*                5 - Remover Cadastro                  *");
			System.out.println("*                6 - Reserva de Emergência             *");
			System.out.println("*                7 - Valor que Cada Morador Deve Pagar *");
			System.out.println("*                8 - Sair                              *");
			System.out.println("********************************************************");
			System.out.print("-> ");
			opcao = scan.nextByte();
			return opcao;
		}
	}

	public static void main(String[] args) throws IOException {
		/*
		public static Boolean apresentacao(boolean d) {
			SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy HH:mm");
			Date data = new Date();
			if (d == false) {
				System.out.println("Programa iniciado em: " + formatador.format(data));
			} else {
				System.out.println("\nPrograma finalizado em: " + formatador.format(data));
			}
		}
		*/
		
		Scanner scan = new Scanner(System.in);
		Student student = new Student();
		FixedExpense fe = new FixedExpense();
		VariableExpense ve = new VariableExpense();
		String ename, description, payday;
		float value;
		byte prior;	
		int fim = 0;
		int i = 0;
		float reserves = 0;
		float pay = 0;

		do {
			switch (menu()) {
				case 1:
				String name, mail;
				float income;
				
				System.out.println("|||CADASTRAR ALUNO|||");
				System.out.println("Nome: ");
				name =  scan.nextLine();
				System.out.println("Email: ");
				mail = scan.nextLine();
				System.out.println("Renda: ");
				income = scan.nextFloat();
				
				student.registerPerson(name, mail, income);
				
				fim = 1;
				System.out.println("\n-- Cadastro de Aluno Registrado com sucesso!");
				scan.nextLine();
				break;
				
				case 2:
				
				
				System.out.println("|||CADASTRAR DESPESA FIXA|||");
				
				System.out.println("Nome da Despesa: ");
				ename =  scan.nextLine();
				System.out.println("Descrição da Despesa: ");
				description = scan.nextLine();
				System.out.println("Valor da Despesa:");
				value = scan.nextFloat();
				System.out.println("Data do pagamento: ");
				payday = scan.nextLine();
				
				fe.registerExpense(ename, description, value, payday);
				
				fim = 2;
				System.out.println("\n-- Cadastro de Despesa Fixa Registrada Com Sucesso!");
				scan.nextLine();
				break;
				
				case 3:
				System.out.println("|||CADASTRAR DESPESA VARIADA|||");
				
				System.out.println("Nome da Despesa: ");
				ename =  scan.nextLine();
				System.out.println("Descrição da Despesa: ");
				description = scan.nextLine();
				System.out.println("Valor da Despesa:");
				value = scan.nextFloat();
				System.out.println("Digite a prioridade da despesa [5(prioridade máxima) a 1[pode esperar]: ");
				prior = scan.nextByte();
				
				ve.registerExpense(ename, description, value, prior);
				
				fim = 3;
				System.out.println("-- Cadastro de Despesa Variada Registrada Com Sucesso!");
				scan.nextLine();
				break;
				
				case 4:
				System.out.println("|||LISTAGEM DOS ALUNOS CADASTRADOS|||");
				for (i = 0; i < student.nameList.size(); i++) {
					System.out.println("ID do Aluno: " + student.idStudent.get(i) + "\nAluno: "
					+ student.nameList.get(i) + "\nEmail: " + student.emailList.get(i) +
					"\nRenda: " + student.incomeList.get(i));
					System.out.println("\n-------------------------------------------------------------\n");
				}
				fim = 4;
				break;
				
				case 5:
				System.out.println("\n-----Digite o ID do Aluno que você quer remover do cadastro: ");
				student.deleteAccount(scan.nextByte());
				fim = 5;
				break;
				
				case 6:
				System.out.println("|||LISTA RESERVA DE EMERGÊNCIA|||");
				
				//prints the list containing information about student name and contribution
				for (int s = 0; s < student.taxStudent.size(); s++) {
					System.out.printf("Nome do aluno: %s \nValor da contribuição: %f"
					, student.nameList.get(s), student.taxStudent.get(s));
				}
				
				System.out.println("Total de Reserva de Emergência = " + student.totalDeposit());
				fim = 6;
				break;
				
				case 7:
				
				reserves = ve.totalExpensesVPrior() + fe.totalExpensesF();
				pay = (reserves / student.nameList.size());
				System.out.printf(
				"Valor Total de Despesas Fixas + Variadas (prioridade 5 e 4): \nR$ %.2f", reserves);
				System.out.printf("\nValor Que cada Cada Aluno Deverá Pagar Pelas Despesas: \nR$ %.2f", pay);
				
				case 8:
				fim = 8;
				break;
				default:
				System.out.println("\n-- Digite um número correspondente a operação desejada --");
			}
		} while (fim < 8);
		scan.close();
	}
	}
	
	