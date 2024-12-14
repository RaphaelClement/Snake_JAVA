package Test.Modele;

import java.awt.*;

public class Vertebre extends Element {
	public Vertebre(int x, int y) {
		super(x, y);
	}

	@Override
	public void draw(processing.core.PApplet processing, Color couleur, int diametre) {
		processing.fill(couleur.getRGB());
		int x = getX();
		int y = getY();
		processing.circle(x, y, diametre);
	}
}