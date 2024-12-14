package Test.Controle;

import Test.Modele.*;
import processing.core.PApplet;

public class ControleJeu {
	private Jeu jeu;
	private final int localTimer;
	private final int nbCases;
	private final int taille;
	private final PApplet processing;
	private static int TAILLE_CASE;

	public ControleJeu(PApplet processing, int nbCases, int taille) {
		this.processing = processing;
		this.nbCases = nbCases;
		this.taille = taille;
		this.localTimer = 10;
		TAILLE_CASE = (int) taille / nbCases;
		this.jeu = new Jeu(this, taille, nbCases);
	}

	public void draw() {
		jeu.draw(processing);
	}

	public static int tailleCase() {
		return TAILLE_CASE;
	}

	public boolean perdu() {
		return jeu.perdu();
	}

	public void keyPressed(int keyCode) {
		jeu.keyPressed(keyCode);
	}

	public void deplacement() {
		jeu.prochainePosition();
	}

	public String toString() {
		return jeu.toString();
	}
}