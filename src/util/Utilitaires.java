package util;

import java.util.Random;
import java.util.Scanner;

public class Utilitaires {

	public static int enregistrerInt() {
		Scanner sc = new Scanner(System.in);
		try {
			return sc.nextInt();
		} catch (Exception e) {
			System.out.println("Erreur de saisie");
			return 0000;
		}
	}

	public static String enregistrerString() {
		Scanner sc = new Scanner(System.in);
		return sc.nextLine();
	}

	public static int nbRandom() {
		Random randomNb = new Random();

		return (randomNb.nextInt(8999) + 1000);
	}
}