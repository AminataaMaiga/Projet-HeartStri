package jeu;

/**
 *
 * @author Aminata 
 */

//etape2 
	//actuel; 
	
//etqpe 4 --> pouvori speciaux

public class Hero {
    private String nom;
    private int pointsDeVie;
    private String pouvoirBase;

    public Hero(String nom, String pouvoirBase) {
        this.nom = nom;
        this.pointsDeVie = 30;
        this.pouvoirBase = pouvoirBase;
    }
    
    public String getNom() {
    	return nom;
    }
 
    public int getPointsDeVie() {
    	return pointsDeVie;
    }
    public void recevoirDegats(int degats) {
    	
    }
    
    public boolean estMort(){
    	return pointsDeVie<=0;
    }
}
