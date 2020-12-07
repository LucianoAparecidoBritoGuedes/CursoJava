package com.luciano.array;

import java.util.Locale;
import java.util.Scanner;

public class Array {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in) ;
		
		double[] notas = new double[4];
		double media = 0;
		
		System.out.println("Média anual do aluno:");
		System.out.println("");
				
		for (int i = 0; i < notas.length; i++) {
			System.out.printf("Digite a %dª nota do aluno: ", i+1);
			notas[i] = sc.nextDouble();
			media += notas[i];
		}
		
		sc.close();
		media = media / 4;
		System.out.println("A média do aluno é: " + media);
		System.out.println();
		
	}

}
