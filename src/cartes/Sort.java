package cartes;

public class Sort extends Carte {
	 public Sort(String nom, int mana) {
	        super(nom, mana); // Appelle le constructeur de la classe Carte
	    }

	    /**
	     * Méthode pour appliquer les effets du sort sur un serviteur.
	     *
	     * @param cible Le serviteur ciblé par le sort.
	     */
	    public void lancerSort(Serviteur cible) {
	        // Exemple : inflige 5 points de dégâts au serviteur
	        cible.recevoircoup(5);
	        System.out.println("Le sort " + getNom() + " inflige 5 dégâts à " + cible.getNom());
	    }

}
