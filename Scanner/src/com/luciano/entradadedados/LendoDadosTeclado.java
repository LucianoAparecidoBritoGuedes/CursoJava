package com.luciano.entradadedados;

import java.util.Locale;
import java.util.Scanner;

public class LendoDadosTeclado {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in) ;
		
		/*
			System.out.println("Digite o seu nome completo!");
			String nomeCompleto = sc.nextLine();
			System.out.println("Seu nome completo é: " + nomeCompleto);
			System.out.println();
		*/
		
		System.out.println("Digite o seu nome, idade, altura e se é casado ou não!");
		String nome = sc.next();
		int idade = sc.nextInt();
		Double altura = sc.nextDouble();
		Boolean casado = sc.nextBoolean();
		
		// exemplo de como digitar: Luciano 29 1.84 true
		
		System.out.println();
		
		System.out.println("Seu nome é: " + nome);
		System.out.println("Idade: " + idade);
		System.out.println("Altura: " + altura);
		System.out.println("Casado: " + casado);
		
		sc.close();
	}

}
