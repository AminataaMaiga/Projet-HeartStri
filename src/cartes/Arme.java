package cartes;

public class Arme extends Carte {
	 private int degats; // Dégâts infligés par l'arme

	public Arme(String nom, int mana, int degats) {
		super(nom, mana); // Appelle le constructeur de la classe Carte
        this.degats = degats;
	}
	/**
     * Retourne les dégâts de l'arme.
     * 
     * @return Le nombre de dégâts infligés par l'arme.
     */
    public int getDegats() {
        return degats;
    }

}
