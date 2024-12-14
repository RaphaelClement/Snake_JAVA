package Test.Modele;

import java.awt.*;
import java.util.ArrayList;

public class Serpent {
	protected ArrayList<Point> vertebres;
	protected int tailleTete;

	public Serpent(Point tete) {
		this.vertebres = new ArrayList<>();
		this.vertebres.add(tete);
		this.tailleTete = tailleTete;
	}

	public void avancer(Point p) {
		this.vertebres.add(0, p);
		this.vertebres.remove(this.vertebres.size() - 1);
	}

	public void grandir(Point p) {
		this.vertebres.add(0, p);
	}

	public void reduire() {
		this.vertebres.remove(this.vertebres.size() - 1);
	}

	public Point getTete() {
		return this.vertebres.get(0);
	}

	public int size() {
		return this.vertebres.size();
	}

	public void draw(processing.core.PApplet processing, int diametre) {
		Color couleur = new Color(0, 155, 0);
		for (int i = 0; i < this.size(); i++) {
			Point vertebre = this.vertebres.get(i);
			processing.fill(couleur.getRGB());
			if (i == 0) { // Si c'est la tête du serpent
				dessinerTete(processing, vertebre.x, vertebre.y, diametre);
			} else {
				processing.circle(vertebre.x, vertebre.y, diametre);
			}
		}
	}

	public boolean contact(Point p) {
		for (Point vertebre : this.vertebres) {
			if (p.equals(vertebre)) {
				return true;
			}
		}
		return false;
	}

	public boolean seMord() {
		for (int i = 1; i < this.size(); i++) {
			if (this.getTete().equals(this.vertebres.get(i))) {
				return true;
			}
		}
		return false;
	}

	private void dessinerTete(processing.core.PApplet processing, int x, int y, int diametre) {
		processing.circle(x, y, diametre);
		processing.fill(0);
		int tailleYeux = diametre / 5;
		int decalageYeux = diametre / 4;
		processing.circle(x - decalageYeux, y + decalageYeux - 12, tailleYeux);
		processing.circle(x + decalageYeux, y + decalageYeux - 12, tailleYeux);
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder("[");
		for (Point vertebre : this.vertebres) {
			s.append(vertebre.toString());
		}
		s.append("]");
		return s.toString();
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass()) return false;
		Serpent serpent = (Serpent) o;
		return vertebres.equals(serpent.vertebres);
	}

	@Override
	public int hashCode() {
		return vertebres.hashCode();
	}
}