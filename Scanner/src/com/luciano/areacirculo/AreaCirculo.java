package com.luciano.areacirculo;

import java.util.Locale;
import java.util.Scanner;

public class AreaCirculo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in) ;
		
		System.out.println("Digite o raio de um circulo para obter a sua área:");
		
		double raio = sc.nextDouble();
		double area = Math.PI * Math.pow(raio, 2);
		
		System.out.println("A area do circulo informado é: " + area);
		
		sc.close();
	}

}
