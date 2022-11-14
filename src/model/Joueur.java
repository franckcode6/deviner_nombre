package model;

public class Joueur {

	private String nom;

	private int score;

	private int tentative;

	public Joueur() {
		this.score = 0;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getTentative() {
		return tentative;
	}

	public void setTentative(int tentative) {
		this.tentative = tentative;
	}

}
