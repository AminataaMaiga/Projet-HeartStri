package cartes;

public class Arme extends Carte {
	 private int nbUtilisation;
	 private TypeArme type;

	    public Arme( int mana, int nbUtilisation, TypeArme type) {
	        super(type.getNom(), 0);
	        this.nbUtilisation = nbUtilisation;
	        this.type = type;
	    }

	    public String getEffetSpecial() {
	        return type.getEffetSpecial();
	    }

	    @Override
	    public String toString() {
	        return getNom() + " [Mana: " + getMana() + ", ATK: " + type.getdegat() +
	               ", Utilisations: " + nbUtilisation + ", Spé: " + type.getEffetSpecial() + "]";
	    }
	    
	    public TypeArme getTypeArme(){
	    	return type;
	    }
	    
	    public void setnbutilisation() {
	    	this.nbUtilisation--;
	    }

}
