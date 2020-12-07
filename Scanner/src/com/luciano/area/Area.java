package com.luciano.area;

import java.util.Locale;
import java.util.Scanner;

public class Area {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in) ;
	
		System.out.println("Digite dois numeros para obter a sua área!");
		
		System.out.print("Primeiro número: ");
		double lado1 = sc.nextDouble();
		System.out.print("Segundo número: ");
		double lado2 = sc.nextDouble();

		double area = lado1 * lado2;
		
		System.out.println();
		System.out.println("A área do objeto informado é: " + area);
		sc.close();
	}

}
