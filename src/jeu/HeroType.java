package jeu;
/**
 * Classe representant les differents type de heros implementer dans notre jeu 
 * Chaqeu type accopager du nom de sont pouvoir heroique, une description plus en details
 *  du pouvoir heroique sera accessible par la suite 
 *  @author Aminata
 */
public enum HeroType {
	MAGE("Explosion de feu"),
	 GUERRIER("Gain d’armure !"),
	 CHASSEUR("Tir assuré"),
	 DRUIDE("Change Forme"),
	 VOLEUR("Maitrise des dagues"),
	 PRÊTRE("Energie divine"),
	 PALADIN("Renfort"),
	 DÉMONISTE("Connexion");

	    private final String pouvoir;

	    HeroType(String pouvoir) {
	        this.pouvoir = pouvoir;
	    }

	    public String getPouvoir() {
	        return pouvoir;
	    }

}
