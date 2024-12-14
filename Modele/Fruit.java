package Test.Modele;

import java.awt.*;

public abstract class Fruit extends Element {
    public Fruit(int x, int y) {
        super(x, y);
    }

    public abstract boolean estToxique();

    @Override
    public void draw(processing.core.PApplet processing, Color c, int diametre) {
        processing.fill(c.getRGB());
        processing.circle(getX(), getY(), diametre);
    }
}