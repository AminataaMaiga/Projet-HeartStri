package jeu;

/**
 *
 * @author Aminata 
 */

//etape2 
	//actuel; 
	
//etqpe 4 --> pouvoirs speciaux

public class Hero {
    private String nom;
    private int pointsDeVie;
    //private String pouvoirBase; on le gère pas à l'étape 2
    

    /**
     * Constructeur du héros.
     * @param nom Le nom du héros (ex : "Mage", "Guerrier")
     * @param pouvoirBase Une description textuelle du pouvoir spécial du héros
     
     */

    public Hero(String nom, String pouvoirBase) {
        this.nom = nom;
        this.pointsDeVie = 30;
        //this.pouvoirBase = pouvoirBase;
    }
    
    public String getNom() {
    	return nom;
    }
 
    public int getPointsDeVie() {
    	return pointsDeVie;
    }

    /**
     * Méthode qui fait perdre des PV au héros.
     * @param degats Nombre de points de dégâts reçus.
     */
    public void recevoirDegats(int degats) {
        pointsDeVie -= degats;
        if (pointsDeVie < 0) pointsDeVie = 0;
    }
    
    /**
     * Vérifie si le héros est mort (PV <= 0).
     * @return true si mort, false sinon.
     */
    
    public boolean estMort() {
        return pointsDeVie <= 0;
    }
}
