 package application;

import java.util.Locale;
import java.util.Scanner;

import entites.ContaBancaria;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		ContaBancaria cb;
			
		System.out.println("Olá, você deseja criar uma conta?");
		System.out.print("Digite S ou N: ");
		
		Character res = (Character) sc.next().toLowerCase().charAt(0);
		
		
		if (res.equals('s')) {
			sc.nextLine();
			System.out.println("\nDeseja realizar um depósito inicial?");
			System.out.print("Digite S ou N: ");
			Character res1 = (Character) sc.next().toLowerCase().charAt(0);
			
			double dep = 0;
			
			if (res1.equals('s')) {
				sc.nextLine();
				System.out.print("\nDigite o valor do depósito: ");
				dep = sc.nextDouble(); 				
			}
			
			sc.nextLine();
			System.out.print("\nDigite o nome do titular da conta: ");
			String nome = sc.nextLine();
			
			System.out.println();
			cb = new ContaBancaria(nome, dep);
			
			System.out.println("Conta criada com sucesso no nome de " + cb.getTitular() + '!');
			System.out.format("O número da conta é %d e o saldo é R$ %.2f", cb.getConta(), cb.getSaldo());
			
		} // + Character.toUpperCase(res)
		
		
		if (res.equals('n')) {
			System.out.println("\nNenhum registro foi alterado!");
			// + Character.toUpperCase(res)
		}

		sc.close();
	}

}
