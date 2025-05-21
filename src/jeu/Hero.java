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
    private int pointsDeVie;
    private int manaHero=1;
    private int manaMax=10;
    private HeroType typeHero;
 

    /**
     * Constructeur du héros.
     * @param nom Le nom du héros (ex : "Mage", "Guerrier")
     * @param pouvoirBase Une description textuelle du pouvoir spécial du héros
     * Constructeur du héros.
     * @param typeHero Le type de héros (ex: MAGE, PALADIN, etc.)
     * @param mana Le mana de départ
     */
    public Hero(HeroType typeHero) {
        this.typeHero = typeHero;
        this.pointsDeVie = 30;
    }
    
    
    
    public int getMana() {
        return manaHero;
    }

    public int getManaMax() {
        return manaMax;
    }
    public String getNom() {
        return typeHero.name(); // Exemple : "MAGE"
    }
 
    public int getPointsDeVie() {
    	return pointsDeVie;
    }
    
    public void augmenterMana() {
        if (manaHero< manaMax) {
            manaHero++;
        }   
    }
    

    public String getPouvoirHeroique() {
    	return typeHero.getPouvoir();
    }

    @Override
    public String toString() {
        return getNom() + " [PV: " + pointsDeVie + ", Mana: " + manaHero + "]";
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
    
    public void soigner(int montant) {
        this.pointsDeVie += montant;
        if (pointsDeVie > 30) pointsDeVie = 30;
    }

    

}
