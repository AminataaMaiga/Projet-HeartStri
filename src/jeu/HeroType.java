package jeu;

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
