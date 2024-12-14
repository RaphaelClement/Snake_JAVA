package Test.Modele;

import Test.Controle.ControleJeu;
import java.awt.*;
import java.util.Random;

public class Jeu {
	protected int nbCases;
	protected int nbPixels;
	protected int score;
	protected int directionCourante;
	protected Random rand;
	protected Grille grille;
	protected Serpent serpent;
	protected ControleJeu controle;
	protected Pomme pomme;
	protected Ricin ricin;
	private final int DIAMETREFRUIT;
	private final int DIAMETRESERPENT;
	private static final Color ROUGE = new Color(255, 0, 0);

	public Jeu(ControleJeu cont, int nbPixels, int nbCases) {
		this.nbCases = nbCases;
		this.nbPixels = nbPixels;
		this.score = 0;
		this.directionCourante = 38;
		this.rand = new Random();
		this.grille = new Grille(nbCases, nbPixels);
		int centre = (nbCases / 2 - 1) * ControleJeu.tailleCase() + ControleJeu.tailleCase() / 2;
		Point tete = new Point(centre, centre);
		this.serpent = new Serpent(tete);
		this.controle = cont;
		this.pomme = new Pomme(centre, centre - 2 * ControleJeu.tailleCase());
		this.ricin = new Ricin(centre, centre + 2 * ControleJeu.tailleCase());
		this.DIAMETREFRUIT = (int) (ControleJeu.tailleCase() * 0.6);
		this.DIAMETRESERPENT = ControleJeu.tailleCase() - ControleJeu.tailleCase() / 10;
	}

	public void prochainePosition() {
		Point p = new Point(this.serpent.getTete());
		switch (this.directionCourante) {
			case 38:
				p.y -= ControleJeu.tailleCase();
				break;
			case 39:
				p.x += ControleJeu.tailleCase();
				break;
			case 40:
				p.y += ControleJeu.tailleCase();
				break;
			case 37:
				p.x -= ControleJeu.tailleCase();
				break;
		}
		if (p.equals(pomme.getPosition())) {
			this.serpent.grandir(p);
			this.placerPomme();
			this.placerRicin();
		} else if (p.equals(ricin.getPosition())) {
			this.serpent.avancer(p);
			this.serpent.reduire();
			this.placerPomme();
			this.placerRicin();
		} else {
			this.serpent.avancer(p);
		}
	}

	public boolean perdu() {
		if (this.serpent.size() == 0) {
			return true;
		}
		Point tete = this.serpent.getTete();
		return this.serpent.seMord() || tete.x < 0 || tete.y < 0 || tete.x > this.nbPixels || tete.y > this.nbPixels;
	}

	public int getScore() {
		return this.score;
	}

	private void placerPomme() {
		Point p;
		do {
			int x = rand.nextInt(nbCases - 1) * ControleJeu.tailleCase() + (ControleJeu.tailleCase() / 2);
			int y = rand.nextInt(nbCases - 1) * ControleJeu.tailleCase() + (ControleJeu.tailleCase() / 2);
			p = new Point(x, y);
		} while (this.serpent.contact(p) || p.equals(this.ricin.getPosition()));
		this.pomme.setPosition(p.x, p.y);
	}

	private void placerRicin() {
		Point p;
		do {
			int x = rand.nextInt(nbCases - 1) * ControleJeu.tailleCase() + (ControleJeu.tailleCase() / 2);
			int y = rand.nextInt(nbCases - 1) * ControleJeu.tailleCase() + (ControleJeu.tailleCase() / 2);
			p = new Point(x, y);
		} while (this.serpent.contact(p) || p.equals(this.pomme.getPosition()));
		this.ricin.setPosition(p.x, p.y);
	}

	public void draw(processing.core.PApplet processing) {
		processing.square(0, 0, this.nbPixels);
		this.grille.draw(processing);
		this.serpent.draw(processing, DIAMETRESERPENT);
		this.pomme.draw(processing, ROUGE, DIAMETREFRUIT);
		this.ricin.draw(processing, ROUGE, DIAMETREFRUIT);
	}

	public void keyPressed(int keyCode) {
		if (keyCode == 37 || keyCode == 38 || keyCode == 39 || keyCode == 40) {
			this.directionCourante = keyCode;
		} else {
			assert false;
		}
	}

	public String toString() {
		return "Jeu : Serpent" + this.serpent.toString() + " | Pomme : " + this.pomme.toString() + " | Ricin : " + this.ricin.toString();
	}
}