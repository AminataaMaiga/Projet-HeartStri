package jeu;

import cartes.Deck;
import cartes.Carte;
import cartes.Serviteur;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

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
    private int ordre_joueur;
    private boolean tour1=true;

    /*
     * Constructeur de la classe Joueur 
     */
    public Joueur(String nom, Deck deck, Hero hero,int numj) {
        this.nom_joueur = nom;
        this.deck_joueur = deck;
        this.hero = hero;
        this.main = new Main();
        this.ordre_joueur=numj;
    }

    public String getNom() {
        return nom_joueur;}

    public Deck getDeck() {
        return deck_joueur;}

    public Main getMain() {
        return main;}


    public Hero getHero() {
        return hero;}
    
    public int getOrdre() {
    	return this.ordre_joueur;
    }
    public boolean getTour1() {
    	return this.tour1;
    }

    @Override
    public String toString() {
        return nom_joueur + " | Héros: " + hero + " | Cartes en main: " + main.taille();}

    public boolean estMort() {
        return hero.estMort(); }
    
    
    public void jouerCarte(Carte carte, Joueur adversaire) {
        if (!main.estDansMain(carte)) {
            System.out.println( carte.getNom() + " n'est pas dans la main.");
            return;
        }

        if (hero.getMana() < carte.getMana()) {
            System.out.println(" Mana insuffisant pour jouer " + carte.getNom());
            return;
        }
       
        if (carte instanceof Sort sort) {
        	attaquer_sort(carte,adversaire);//OK
        } 
        else if (carte instanceof Arme arme) {
        	attaquer_arme(carte,adversaire);
        }
        else if (carte instanceof Serviteur s) {
        	attaquer_serviteur(carte,adversaire);
        }
        hero.consommerMana(carte.getMana());
    }
    
    /**
     * 
     * @param carte
     * @param adversaire
     * Permet.....
     */
    public void attaquer_sort(Carte carte, Joueur adversaire) {
        if (!(carte instanceof Sort sort)) {
            System.out.println("La carte n'est pas un sort !");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        Map<Integer, Object> mapping = new HashMap<>();
        int index = 1;

        System.out.println("\n→ Choisissez la cible du sort :");

        // Ciblage joueur actuel
        System.out.println("Joueur " + this.nom_joueur + " (vous)");
        System.out.println(index + " - [Héros] " + this.hero);
        mapping.put(index++, this.hero);
        for (Carte c : this.main.getServiteurs()) {
            System.out.println(index + " - [Serviteur] " + c);
            mapping.put(index++, c);
        }

        // Ciblage adversaire
        System.out.println("Joueur " + adversaire.getNom());
        System.out.println(index + " - [Héros] " + adversaire.getHero());
        mapping.put(index++, adversaire.getHero());
        for (Carte c : adversaire.getMain().getServiteurs()) {
            System.out.println(index + " - [Serviteur] " + c);
            mapping.put(index++, c);
        }

        int choix = scanner.nextInt();

        Object cible = mapping.get(choix);
        if (cible == null) {
            System.out.println("Choix invalide.");
            return;
        }

        appliquer_sort(sort, cible, adversaire);
    }

    /**
     * 
     * @param carte
     * @param adversaire
     * Permet.....
     */
    public void attaquer_arme(Carte carte, Joueur adversaire) {
        if (!(carte instanceof Arme arme)) {
            System.out.println("La carte n'est pas une arme !");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        Map<Integer, Object> mapping = new HashMap<>();
        int index = 1;

        System.out.println("\n→ Choisissez la cible de l'arme :");

        System.out.println(index + " - [Héros] " + adversaire.getHero());
        mapping.put(index++, adversaire.getHero());

        for (Carte c : adversaire.getMain().getServiteurs()) {
            System.out.println(index + " - [Serviteur adverse] " + c);
            mapping.put(index++, c);
        }

        int choix = scanner.nextInt();
        Object cible = mapping.get(choix);
        if (cible == null) {
            System.out.println("Choix invalide.");
            return;
        }

        appliquer_arme(arme, cible, adversaire);
    }

    /**
     * 
     * @param carte
     * @param adversaire
     * Permet.....
     */
    public void attaquer_serviteur(Carte carte, Joueur adversaire) {
        if (!(carte instanceof Serviteur serviteur)) {
            System.out.println("La carte n'est pas un serviteur !");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        Map<Integer, Object> mapping = new HashMap<>();
        int index = 1;

        System.out.println("\n→ Choisissez la cible du serviteur attaquant :");

        System.out.println(index + " - [Héros] " + adversaire.getHero());
        mapping.put(index++, adversaire.getHero());

        for (Carte c : adversaire.getMain().getServiteurs()) {
            System.out.println(index + " - [Serviteur adverse] " + c);
            mapping.put(index++, c);
        }

        int choix = scanner.nextInt();
        Object cible = mapping.get(choix);
        if (cible == null) {
            System.out.println("Choix invalide.");
            return;
        }

        appliquer_serviteur(serviteur, cible, adversaire);
    }
     
    
    private void appliquer_sort(Sort sort, Object cible, Joueur adversaire) {
        sort.appliquerEffet(cible, this, adversaire);
    }

    
    private void appliquer_arme(Arme arme, Object cible,Joueur adversaire) {
    	arme.appliquerEffet(cible, this, adversaire);
    }
    
    private void appliquer_serviteur(Serviteur serviteur,Object cible,Joueur adversaire) {
    	serviteur.appliquerEffet(cible, this, adversaire);
    }
    
    public void tirerCarteTour1() {
    	if(this.tour1)
    	{
    		int nbc=0;
        	if(this.ordre_joueur==1) {
        		nbc=3;}else {
        		nbc=4;}
        	for (int i=0;i<nbc;i++){
    			this.main.ajouterCarte(this.deck_joueur.tirerCarteAleatoire());}
        	this.tour1=false;//Traitement prevu que pour le premier tour
    	}
    	else {
    		//On pioche une carte par tour 
    		Carte carte_piocher=this.deck_joueur.tirerCarteAleatoire();
    		this.main.ajouterCarte(carte_piocher);
    		System.out.println("La carte"+carte_piocher.getNom()+" a bien etet ajouter a votre main ! \n");
    	}
    	 }
    
    public void piocherCarte() {
        Carte piochee = deck_joueur.tirerCarteAleatoire();
        if (piochee != null) {
            if (main.taille() < 10) {
                main.ajouterCarte(piochee);
                System.out.println( nom_joueur + " pioche : " + piochee.getNom());
                System.out.println(piochee); // Affiche les stats
            } else {
                System.out.println("️ Main pleine ! La carte " + piochee.getNom() + " est défaussée.");
            }
        } else {
            System.out.println(" Deck vide, impossible de piocher.");
        }
    }

    ///Fin classe 
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
  