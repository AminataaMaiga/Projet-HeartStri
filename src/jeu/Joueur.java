package jeu;

import cartes.Deck;
import cartes.Carte;
import cartes.Serviteur;
import cartes.*;


/**
 * Classe représentant un joueur dans le jeu HeartSTRI.
 * Il possède un nom, un deck, un héros, une main de cartes,
 * un plateau (cartes en jeu) et une gestion du mana.
 * 
 * @author Fatoumata
 */
public class Joueur {
	
	 //etape 1
    private String nom_joueur;
    private Deck deck_joueur; // tout les joueur on un deck de 30 cartes
    
    //etape 2
    private Hero hero;          // Le héros associé au joueur
    private Main main;          // Cartes en main : 3 pour le joueur1 et 4 pour le joueur2
    private Plateau plateau;    // Serviteurs invoqués
    private int mana = 1;
    private int manaMax = 10;    
    
    //etape 3
    public  Arme armeEquipee;     
    
    //un jourt a un ou  des cartes sort et armes , il peut, il ne peut avoir que une armes a la fois 
    //par consequent lacer un sort , et une arme peut attaquer un heros ou un serviteur 
    //les sorts agissent que sur les serviteur
    

    /*
     * Constructeur de la classe Joueur 
     */
    public Joueur(String nom, Deck deck, Hero hero) {
        this.nom_joueur = nom;
        this.deck_joueur = deck;
        this.hero = hero;
        this.main = new Main();
        this.plateau = new Plateau();

        // Pioche initiale : à gérer dans le contrôleur de partie
    }

    public String getNom() {
        return nom_joueur;
    }

    public int getMana() {
        return mana;
    }

    public int getManaMax() {
        return manaMax;
    }

    public Deck getDeck() {
        return deck_joueur;
    }

    public Main getMain() {
        return main;
    }

    public Plateau getPlateau() {
        return plateau;
    }

    public Hero getHero() {
        return hero;
    }
    public Arme getArmeEquipee() {
        return armeEquipee;
    }

    public void augmenterMana() {
        if (mana< manaMax) {
            mana++;
        }
       
    }

    public boolean peutInvoquer(Carte carte) {
        return carte.getMana() <= mana;
    }

    public void invoquerServiteur(Serviteur s) {
        if (peutInvoquer(s)) {
        	if(main.estDansMain(s))
        	{
    		 main.retirerCarte(s);
             plateau.ajouterServiteur(s);
             mana -= s.getMana();
             System.out.println(nom_joueur + " invoque " + s.getNom() + " !");
        	}
        	else {
            System.out.println(nom_joueur + ": La carte "+ s.getNom() +" ne se trouve pas dans la main");
        	}
        } else {
            System.out.println("Mana insuffisant pour invoquer " + s.getNom());
        }
    }

    public boolean estMort() {
        return hero.estMort();
    }
    
    public void piocherCarte() {
        Carte piochee = deck_joueur.tirerCarteAleatoire();
        if (piochee != null) {
            main.ajouterCarte(piochee);
            System.out.println(nom_joueur + " pioche : " + piochee.getNom());
        } else {
            System.out.println("Deck vide, impossible de piocher.");
        }
    }
    // Méthode pour équiper une arme
    public void equiperArme(Arme arme) {
        if (main.estDansMain(arme)) {
            this.armeEquipee = arme;
            main.retirerCarte(arme);
            System.out.println(nom_joueur + " équipe l'arme : " + arme.getNom());
        } else {
            System.out.println("L'arme " + arme.getNom() + " n'est pas dans la main !");
        }
    }

    // Méthode pour utiliser un sort
    public void utiliserSort(Sort sort, Serviteur cible) {
        if (main.estDansMain(sort) && mana >= sort.getMana()) {
            sort.lancerSort(cible);
            mana -= sort.getMana();
            main.retirerCarte(sort);
            System.out.println(nom_joueur + " utilise le sort : " + sort.getNom() + " sur " + cible.getNom());
        } else if (mana < sort.getMana()) {
            System.out.println("Mana insuffisant pour utiliser le sort : " + sort.getNom());
        } else {
            System.out.println("Le sort " + sort.getNom() + " n'est pas dans la main !");
        }
    }

    // Méthode pour attaquer un héros avec une arme
    public void attaquerHeroAvecArme(Hero cible) {
        if (armeEquipee != null) {
            cible.recevoirDegats(armeEquipee.getDegats());
            System.out.println(nom_joueur + " attaque le héros " + cible.getNom() + " avec l'arme " + armeEquipee.getNom());
            armeEquipee = null; // L'arme est détruite après utilisation
        } else {
            System.out.println("Aucune arme équipée pour attaquer !");
        }
    }
   
}