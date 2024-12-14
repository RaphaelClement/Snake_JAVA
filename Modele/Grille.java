package Test.Modele;

import java.awt.*;

public class Grille {
	protected int nbCases;
	protected int nbPixels;

	public Grille(int nbCases, int nbPixels) {
		this.nbCases = nbCases;
		this.nbPixels = nbPixels;
	}

	public void draw(processing.core.PApplet processing) {
		Color c = new Color(255, 255, 255);
		processing.fill(c.getRGB());
		processing.square(0, 0, this.nbPixels);
		float step = (float) this.nbPixels / this.nbCases;
		for (int i = 0; i < this.nbCases; i++) {
			float x = i * step;
			float y = i * step;
			processing.line(x, 0, x, this.nbPixels);
			processing.line(0, y, this.nbPixels, y);
		}
	}
}