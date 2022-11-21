import java.io.IOException;
/* 
import java.text.SimpleDateFormat;
import java.util.Date;
*/
import java.util.Scanner;

public class Principal {
	
	static void menu() {
		System.out.println("\n********************************************************");
		System.out.println("**       DIGITE O NÚMERO DA OPERAÇÃO DESEJADA         **");
		System.out.println("********************************************************");
		System.out.println("*      1 - Cadastrar Aluno                   *");
		System.out.println("*      2 - Cadastrar Despesa Fixa            *");
		System.out.println("*      3 - Cadastrar Despesa Variada         *");
		System.out.println("*      4 - Listar Alunos Cadastrados         *");
		System.out.println("*      5 - Remover Cadastro                  *");
		System.out.println("*      6 - Reserva de Emergência             *");
		System.out.println("*      7 - Valor que Cada Morador Deve Pagar *");
		System.out.println("*      8 - Sair                              *");
		System.out.println("********************************************************");
		System.out.print("-> ");
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
		VariableExpense ve = new VariableExpense();
		FixedExpense fe = new FixedExpense();
		String ename, description, payday;
		float value, reserves = 0,pay = 0;
		int select = 0, fim = 0, i = 0;
		byte prior;	
		
		
		
		do {
			menu();
			select = scan.nextInt();
			scan.nextLine();

			switch (select) {
				case 1:
				String name, mail;
				float income;
				
				System.out.println("|||CADASTRAR ALUNO|||");
				System.out.print("Nome: ");
				name =  scan.nextLine();
				System.out.print("Email: ");
				mail = scan.nextLine();
				System.out.print("Renda: ");
				income = scan.nextFloat();
				
				student.registerPerson(name, mail, income);
				
				fim = 1;
				System.out.println("\n-- Cadastro de Aluno Registrado com sucesso!");
				scan.nextLine();
				break;
				
				case 2:
				
				
				System.out.println("|||CADASTRAR DESPESA FIXA|||");
				
				System.out.print("Nome da Despesa: ");
				ename =  scan.nextLine();
				System.out.print("Descrição da Despesa: ");
				description = scan.nextLine();
				System.out.print("Valor da Despesa:");
				value = scan.nextFloat();
				System.out.print("Data do pagamento: ");
				payday = scan.nextLine();
				
				fe.registerExpense(ename, description, value, payday);
				
				fim = 2;
				System.out.println("\n-- Cadastro de Despesa Fixa Registrada Com Sucesso!");
				scan.nextLine();
				break;
				
				case 3:
				System.out.println("|||CADASTRAR DESPESA VARIADA|||");
				
				System.out.print("Nome da Despesa: ");
				ename =  scan.nextLine();
				System.out.print("Descrição da Despesa: ");
				description = scan.nextLine();
				System.out.print("Valor da Despesa:");
				value = scan.nextFloat();
				System.out.print("Digite a prioridade da despesa [5(prioridade máxima) a 1[pode esperar]: ");
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
					System.out.printf("Nome do aluno: %s \nValor da contribuição: R$ %.2f\n"
					, student.nameList.get(s), student.taxStudent.get(s));
				}
				
				System.out.println("Total de Reserva de Emergência: R$ %.2f" + student.totalDeposit());
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