package com.luciano.leituradearquivos;

import java.io.File;
import java.util.Scanner;

public class LendoArquivosComScanner {

	public static void main(String[] args) {
		
		String user = "luciano";
		
		File file = new File("/home/" + user + "/luciano.txt");
		Scanner sc = null;
		
		try {
			sc = new Scanner(file);
			while (sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			if(sc != null) {
				sc.close();
			}
		}
	}
}
