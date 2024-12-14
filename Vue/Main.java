package Test.Vue;

import Test.Controle.ControleJeu;
import processing.core.PApplet;

public class Main extends PApplet {
	private final int BG = 255;
	private static final int NB_CASES = 10;
	private static final int TAILLE = 500;
	private static final int TIMER = 50;
	private int compte;
	private static ControleJeu controleJeu;

	public Main() {
		controleJeu = new ControleJeu(this, NB_CASES, TAILLE);
		compte = 0;
	}

	public static void main(String[] args) {
		PApplet.main("Test.Vue.Main", args);
	}

	public void settings() {
		size(TAILLE, TAILLE);
	}

	public void setup() {
		surface.setTitle("Snake with Processing");
		colorMode(HSB, BG, BG, BG);
		frameRate(100);
		controleJeu.draw();
	}

	public void draw() {
		if (compte % (TIMER + 1) == TIMER) {
			controleJeu.deplacement();
			controleJeu.draw();
			if (controleJeu.perdu()) {
				exit();
			}
		}
		compte++;
	}

	public void keyPressed() {
		if (key == CODED) {
			controleJeu.keyPressed(keyCode);
		}
	}
}