package service;

import java.util.Random;

public class GameService {

	public static String controlerNombre(int nbModele, int nbDonne) {

		char[] nbM = String.valueOf(nbModele).toCharArray();
		char[] nbD = String.valueOf(nbDonne).toCharArray();
		char[] signs = new char[4];

		if (nbD.length != 4) {
			System.out.println("Le nombre doit être de quatre chiffres");
		} else {
			for (int i = 0; i < nbM.length; i++) {
				if (nbD[i] > nbM[i]) {
					signs[i] = '-';
				} else if (nbD[i] < nbM[i]) {
					signs[i] = '+';
				} else {
					signs[i] = '=';
				}
			}
		}
		return new String(signs);
	}

	public static String genererNombre(int nbDonne, char[] signs) {

		char[] nbD = String.valueOf(nbDonne).toCharArray();

		for (int i = 0; i < nbD.length; i++) {
			if (signs[i] != '=') {
				int nbCpu = new Random().nextInt(10);
				int nbJoueur = Integer.parseInt(String.valueOf(nbD[i]));
				if (nbCpu > nbJoueur) {
					signs[i] = '-';
				} else if (nbCpu < nbJoueur) {
					signs[i] = '+';
				} else {
					signs[i] = '=';
				}
			}
		}
		return new String(signs);
	}

}
