package jeu;

import cartes.Carte;

/**
 *La classe Hero permet d'observer les attribut et comportement d'un hero dans le projet Heartstri
 * @author Aminata 
 */
public class Hero {
    private int pointsDeVie;
    private int manaHero=1;
    private int manaMax=10;
    private HeroType typeHero;
    private PouvoirHeroique pouvoir;
    ///Certain hero ne peuvent utiliser leur pouvoir heroique aue une fois par tour
    private boolean pouvoirUtilise = false; 

 

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
        this.pouvoir = initialiserPouvoir(typeHero);
    }
    
    
    ///Getter et setter sur les attributs de la classe 
    
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
            manaHero+=1;
        }   
    }
    
    public boolean getPouvoirutiliser() {
    	return this.pouvoirUtilise;
    }
    
    public HeroType getTypeHero() {
    	return this.typeHero;
    }

    public PouvoirHeroique getPouvoirHeroique() {
    	return pouvoir;
    }

    @Override
    public String toString() {
        return getNom() + " [PV: " + pointsDeVie + ", Mana: " + manaHero + "]";
    }

    /**
     * Fonction permettant de savoir si un hero peut invoquer une carte 
     * @param carte
     * @return
     */
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
    
    /**
     * Focntion qui permet de decrementer le mana d'un hero (suite a uen attaque ou a une invocation)
     * @param montant
     */
    public void consommerMana(int montant) {
        manaHero -= montant;
        if (manaHero < 0) manaHero = 0;
    }
    
    
    /**
     * Fonction permettant de soigner un hero en augmentant son point de vie 
     * @param montant
     */
    public void soigner(int montant) {
        this.pointsDeVie += montant;
        if (pointsDeVie > 30) pointsDeVie = 30;
    }
    
    /**
     * Fonciton de sceller l'appel du pouvoir heroique d'un hero 
     */
    public void setPouvoirHeroique() {
    	this.pouvoirUtilise=true;
    }

    /**
     * Initialise le pouvoir Heroique en focntion du tyoe d'hero 
     * @param type
     * @return
     */
    private PouvoirHeroique initialiserPouvoir(HeroType type) {
        return switch (type) {
            case MAGE -> new PouvoirMage();
            case CHASSEUR -> new PouvoirChasseur();
            case GUERRIER -> new PouvoirGuerrier();
            case PALADIN -> new PouvoirPaladin();
            case PRÊTRE -> new PouvoirPretre();
            case DÉMONISTE -> new PouvoirDemoniste();
            case VOLEUR -> new PouvoirVoleur();
            default -> null;
        };
    }


}
