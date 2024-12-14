package Test.Modele;

public class Pomme extends Fruit {
    public Pomme(int x, int y) {
        super(x, y);
    }

    @Override
    public boolean estToxique() {
        return false;
    }
}