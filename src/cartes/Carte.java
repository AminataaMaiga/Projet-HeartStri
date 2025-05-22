package cartes;

/**
 * 
 * Classe abstraite représentant une carte générique dans le jeu.
 * C’est la superclasse de toutes les cartes : Serviteur, Arme, Sort.
 * Elle contient les attributs communs : nom de la carte et coût en mana.
 * @author Fatoumata
 */

public abstract class Carte {
	private String nom;
	private int mana;
	
	
	/**
    * Constructeur de base pour une carte.
    * Il est protégé car seules les sous-classes peuvent créer une carte
    */
	
	protected Carte(String n,int m) {
		nom=n;
		mana=m;
	}
	
	// Renvoit le nom de la carte 
	public String getNom(){
		return nom;
	}
	
	// Renvoit le cout en mana de la carte
	public int getMana() {
		return mana;
	}

	 public abstract String toString(); // ou autre méthode utile pour l'affichage a redefinir dans les classe filles 
	
}

