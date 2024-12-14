package Test.Modele;

import java.awt.*;

public abstract class Element {
	protected Point position;

	Element(int x, int y) {
		this.position = new Point(x, y);
	}

	public void setPosition(int x, int y) {
		position.setLocation(x, y);
	}

	public Point getPosition() {
		return position;
	}

	public int getX() {
		return position.x;
	}

	public int getY() {
		return position.y;
	}

	public abstract void draw(processing.core.PApplet processing, Color couleur, int diametre);

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Element element = (Element) o;
		return position.equals(element.position);
	}

	@Override
	public int hashCode() {
		return position.hashCode();
	}

	@Override
	public String toString() {
		return "(" + getX() + ", " + getY() + ")";
	}
}