package cartes;

public class Sort extends Carte {
	
	private TypeSort type;
    private int nbUtilisation;

    public Sort( int mana, TypeSort type, int nbUtilisation) {
        super(type.getNomCarte(), 0);
        this.type = type;
        this.nbUtilisation = nbUtilisation;
    }

    public String getEffet() {
        return type.getEffet();
    }
    
    public TypeSort getType() {
    	return this.type;
    }
    public void setnb_utilisation() {
    	this.nbUtilisation--;
    }
    @Override
    public String toString() {
        return getNom() + " [Mana: " + getMana() + ", Type: " + type.name() +
               ", Effet: " + type.getEffet() + ", Utilisations: " + nbUtilisation + "]";
    }


    
}
