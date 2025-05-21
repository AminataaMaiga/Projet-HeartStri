package cartes;

/**
 * 
 * @author Fatoumata
 */

public class Carte {
	private String nom;
	private int mana;
	
	protected Carte(String n,int m) {
		nom=n;
		mana=m;
	}
	
	public String getNom(){
		return nom;
	}
	
	public int getMana() {
		return mana;
	}

}
