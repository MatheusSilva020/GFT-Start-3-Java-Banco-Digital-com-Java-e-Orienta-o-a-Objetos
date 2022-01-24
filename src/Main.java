import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		//Criando o banco digital:
		Banco bd = new Banco();
		bd.setNome("Banco Digital");
		
		//Criando os clientes:
		Cliente joao = new Cliente();
		joao.setNome("Joao da Silva");
		Cliente marcos = new Cliente();
		marcos.setNome("Marcos Allen");
			
		//Criando as contas:
		Conta cc = new ContaCorrente(joao);
		Conta cp = new ContaPoupanca(marcos);
		
		//Executando o menu de opcoes:
		int opcao;
		Scanner s = new Scanner(System.in);
		do {
			menu();
			opcao = s.nextInt();
			opcoesMenu(opcao, cc, cp);
		} while(opcao != 5);
		s.close();
	}
	
	//menu: Menu de operacoes.
	public static void menu() {
		System.out.println("--- BANCO DIGITAL ---");
		System.out.println("1 - Sacar");
		System.out.println("2 - Depositar");
		System.out.println("3 - Transferir");
		System.out.println("4 - Mostrar contas");
		System.out.println("5 - Sair");
		System.out.println("Escolha uma opcao:");
	}
	
	//opcoesMenu: Opcoes de caminhos do menu.
	public static void opcoesMenu(int opcao, Conta cc, Conta cp) {
		Scanner s = new Scanner(System.in);
		double valor;
		switch(opcao) {
			case 1:
				System.out.println("Valor saque:");
				valor = s.nextDouble();
				if(cc.saldoValido(valor) == false) {
					System.out.println("Saldo insuficiente!!!");
				} else {
					cc.sacar(valor);
					System.out.println("Operacao finalizada com sucesso!!!");
				}
				exitMenu(s);
			break;
			case 2:
				System.out.println("Valor deposito:");
				valor = s.nextDouble();
				cc.depositar(valor);
				System.out.println("Operacao finalizada com sucesso!!!");
				exitMenu(s);
			break;
			case 3:
				System.out.println("Valor transferencia:");
				valor = s.nextDouble();
				if(cc.saldoValido(valor) == false) {
					System.out.println("Saldo insuficiente!!!");
				} else {
					cc.transferir(valor, cp);
					System.out.println("Operacao finalizada com sucesso!!!");
				}
				exitMenu(s);
			break;
			case 4:
				cc.imprimirExtrato();
				cp.imprimirExtrato();
				exitMenu(s);
			break;
			case 5:
				System.out.println("Encerrando.... Ate logo!!!");
			break;
			default:
				System.out.println("Erro! Opcao invalida!!!");
				exitMenu(s);
		}
	}
	
	//exitMenu: mantem a operacao até que seja finalizado a operacao.
	public static void exitMenu(Scanner s) {
		int opcao;
		do {
			System.out.println("Pressione 0 para continuar: ");	
			opcao = s.nextInt();
		} while(opcao!=0);
	}
	
}
