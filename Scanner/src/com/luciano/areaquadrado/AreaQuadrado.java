package com.luciano.areaquadrado;

import java.util.Locale;
import java.util.Scanner;

public class AreaQuadrado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in) ;
	
		System.out.println("Digite o tamanho do lado do quadrado para obter a sua área:");
		
		double ladoQuadrado = sc.nextDouble();
		double area = Math.pow(ladoQuadrado, 2);
		
		System.out.println("A area do quadrado é: " + area);
		sc.close();
	}

}
