public class Pile {
    private int[] elements;
    private int tailleMax; 
    private int sommet;  

    public Pile(int tailleMax) {
        this.tailleMax = tailleMax;
        this.elements = new int[tailleMax];
        this.sommet = -1; 
    }

    public void empiler(int element) {
        if (estPleine()) {
            System.out.println("Erreur : La pile est pleine. Impossible d'empiler.");
        } else {
            sommet++;
            elements[sommet] = element;
        }
    }

    public int depiler() {
        if (estVide()) {
            System.out.println("Erreur : La pile est vide. Impossible de dépiler.");
            return -1;
        } else {
            int elementDepile = elements[sommet];
            sommet--;
            return elementDepile;
        }
    }

    public boolean estVide() {
        return sommet == -1;
    }

    public boolean estPleine() {
        return sommet == tailleMax - 1;
    }
}
