package com.luciano.pesoideal;

import java.util.Locale;
import java.util.Scanner;

public class PesoIdeal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in) ;
		
		System.out.println("Digite a sua altura: ");
		double altura = sc.nextDouble();
		double pesoIdeal = (72.7 * altura) - 58;
		System.out.println();
		
		System.out.println("Seu peso ideal é: " + pesoIdeal);
		sc.close();
	}

}
