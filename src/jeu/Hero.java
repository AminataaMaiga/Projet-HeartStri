package jeu;

import cartes.Carte;

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
    private int manaHero=1;
    private int manaMax;
    //private String pouvoirBase; on le gère pas à l'étape 2
    

    /**
     * Constructeur du héros.
     * @param nom Le nom du héros (ex : "Mage", "Guerrier")
     * @param pouvoirBase Une description textuelle du pouvoir spécial du héros
     
     */

    public Hero(String nom, String pouvoirBase, int mana) {
        this.nom = nom;
        this.pointsDeVie = 30;
        this.manaHero=mana;
        //this.pouvoirBase = pouvoirBase;
    }
    public int getMana() {
        return manaHero;
    }

    public int getManaMax() {
        return manaMax;
    }
    public String getNom() {
    	return nom;
    }
 
    public int getPointsDeVie() {
    	return pointsDeVie;
    }
    
    public void augmenterMana() {
        if (manaHero< manaMax) {
            manaHero++;
        }
       
    }

    @Override
    public String toString() {
        return nom + " [PV: " + pointsDeVie + ", Mana: " + manaHero + "/" + manaMax + "]";
    }

    public boolean peutInvoquer(Carte carte) {
        return carte.getMana() <= manaHero;
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
    
    //Fonction décrémentant le mana du hero
    public void consommerMana(int montant) {
        manaHero -= montant;
        if (manaHero < 0) manaHero = 0;
    }

}
