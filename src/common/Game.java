package common;

import model.Joueur;
import service.GameService;
import util.Utilitaires;

public class Game {

	public void game() {
		Joueur joueur = new Joueur();
		boolean gameOn = true;

		System.out.println("== Nombre Mystère ==");
		System.out.println("Quel est votre nom");
		joueur.setNom(Utilitaires.enregistrerString());

		while (gameOn) {

			int saisie = menu();

			switch (saisie) {
			case 1:
				trouverNombre(joueur, gameOn);
				break;
			case 2:
				faireDevinerNombre(joueur, gameOn);
				break;
			case 3:
				gameOn = false;
				break;
			}
		}
	}

	private int menu() {

		System.out.println("1 - Trouver le nombre, 2 - Faire deviner le nombre, 3 - Exit");

		return Utilitaires.enregistrerInt();
	}

	private void trouverNombre(Joueur joueur, boolean gameOn) {
		joueur.setTentative(0);
		int nbCpu = Utilitaires.nbRandom();
		int nbJoueur = 0;
		String symbols = "xxxx";

		do {
			joueur.setTentative(joueur.getTentative() + 1);
			System.out.println("Tentative " + joueur.getTentative() + "/10");
			System.out.println("Indiquez nombre à 4 chiffres");

			nbJoueur = Utilitaires.enregistrerInt();

			symbols = GameService.controlerNombre(nbCpu, nbJoueur);

			System.out.println(symbols);
		} while (nbJoueur != nbCpu && joueur.getTentative() < 10);

		if (joueur.getTentative() >= 10 && symbols != "====") {
			System.out.println("Perdu, nombre de tentatives dépassées");
			System.out.println("Solution : " + nbCpu);
		} else {
			joueur.setScore(joueur.getScore() + 10);
			System.out.println("Vous avez trouvé! En " + joueur.getTentative() + " tentatives.");
			System.out.println("Votre score : " + joueur.getScore());
		}
		gameOn = false;
	}

	private void faireDevinerNombre(Joueur joueur, boolean gameOn) {
		Joueur cpu = new Joueur();
		cpu.setTentative(0);
		int nbJoueur = 0;
		String symbols = "xxxx";
		char[] signs = new char[4];

		do {
			System.out.println("Indiquez un nombre à 4 chiffres");
			nbJoueur = Utilitaires.enregistrerInt();
		} while (nbJoueur < 1000 || nbJoueur > 9999);
		System.out.println("Votre nombre est :" + nbJoueur);

		do {
			cpu.setTentative(cpu.getTentative() + 1);
			
			System.out.println("Tentative " + cpu.getTentative() + "/20");

			symbols = GameService.genererNombre(nbJoueur, signs);

			System.out.println(symbols);
		} while (!symbols.contains("====") && cpu.getTentative() < 20);

		if (cpu.getTentative() >= 20 && !symbols.contains("====")) {
			joueur.setScore(joueur.getScore() + 10);
			System.out.println("L'ordinateur n'a pas trouvé votre nombre!");
			System.out.println("Votre score : " + joueur.getScore());
		} else {
			joueur.setScore(joueur.getScore() - 10);
			System.out.println("Perdu! L'ordinateur a trouvé votre nombre! En " + cpu.getTentative() + " tentatives");
			System.out.println("Votre score : " + joueur.getScore());
		}
		gameOn = false;
	}
}
