package jeu;

import cartes.Deck;
import cartes.Carte;
import cartes.Serviteur;

/**
 * Classe représentant un joueur dans le jeu HeartSTRI.
 * Il possède un nom, un deck, un héros, une main de cartes,
 * un plateau (cartes en jeu) et une gestion du mana.
 * 
 * @author Fatoumata
 */
public class Joueur {

    private String nom_joueur;
    private Deck deck_joueur; // tout les joueur on un deck de 30 cartes
    private Hero hero;          // Le héros associé au joueur
    private Main main;          // Cartes en main : 3 pour le joueur1 et 4 pour le joueur2
    private Plateau plateau;    // Serviteurs invoqués
    private int mana = 1;
    private int manaMax = 1;

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

    public void augmenterMana() {
        if (manaMax < 10) {
            manaMax++;
        }
        mana = manaMax;
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
            System.out.println(nom_joueur + ": La carte "+ s.getNom() +" ne se trouve pas dans la main");
        } else {
            System.out.println("Mana insuffisant pour invoquer " + s.getNom());
        }
    }

    public boolean estMort() {
        return hero.estMort();
    }
}