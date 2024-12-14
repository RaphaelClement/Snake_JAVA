package Test.Modele;

public class Ricin extends Fruit {
	public Ricin(int x, int y) {
		super(x, y);
	}

	@Override
	public boolean estToxique() {
		return true;
	}
}