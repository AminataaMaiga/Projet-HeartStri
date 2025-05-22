package jeu;

import cartes.Deck;
import cartes.Carte;
import cartes.Serviteur;

import java.io.Serializable;
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
 * Un joueur peut effectuer principalement 2 actions:
 * -jouerCarte
 * 
 * 
 * @author Fatoumata
 */
public class Joueur implements Serializable{
	private static final long serialVersionUID = 1L;
	//etape 1
    private String nom_joueur;
    private Deck deck_joueur; // tout les joueur on un deck de 30 cartes
    
    //etape 2
    private Hero hero;          // Le héros associé au joueur
    private Main main;          // Cartes en main : 3 pour le joueur1 et 4 pour le joueur2
    private int ordre_joueur;
    private boolean tour1=true;
    private Plateau plateau;

    /*
     * Constructeur de la classe Joueur 
     */
    public Joueur(String nom, Deck deck, Hero hero,int numj) {
        this.nom_joueur = nom;
        this.deck_joueur = deck;
        this.hero = hero;
        this.main = new Main();
        this.ordre_joueur=numj;
        this.plateau=new Plateau();
    }
    ///Getter et Setter sur la classe 
    public String getNom() {
        return nom_joueur;}

    public Deck getDeck() {
        return deck_joueur;}

    public Main getMain() {
        return main;}

    public Hero getHero() {
        return hero;}
    
    public int getOrdre() {
    	return this.ordre_joueur;}
    
    public boolean getTour1() {
    	return this.tour1;}

    @Override
    public String toString() {
        return nom_joueur + " | Héros: " + hero + " | Cartes en main: " + main.taille();}

    /**
     * Fonction permettant de savoir si un joueur est mort
     * @return true si le hero du joueur n'as plus de poitn de vie 
     */
    public boolean estMort() {
        return hero.estMort(); }
  
    /**
     * Focntion permetant q un joueur d'utiliser une de ses cartes (serviteur/Sort/Arme) pour attaquer un autre joueur ,se soigner lui meme, etc..
     * @param carte carte que le joeur veut utiliser 
     * @param adversaire adversaire sur lequel il va potentiellemnent utiliser les effets de la carte 
     * @return true si l'action a bien etet realiser et false sinon 
     */
    public boolean jouerCarte(Carte carte, Joueur adversaire) {
        if (!main.estDansMain(carte)) {
            System.out.println(carte.getNom() + " n'est pas dans la main.");
            return false;}

        if (hero.getMana() < carte.getMana()) {
            System.out.println("Mana insuffisant pour jouer " + carte.getNom());
            return false;}
        hero.consommerMana(carte.getMana());
        if (carte instanceof Sort sort) {
            attaquer_sort(carte, adversaire);
        } else if (carte instanceof Arme arme) {
            attaquer_arme(carte, adversaire);
        } else if (carte instanceof Serviteur s) {
            plateau.ajouterServiteur(s);
            main.retirerCarte(s);
            attaquer_serviteur(carte, adversaire);}
        // La carte a bien été jouée
        return true;  }
    
    /**
     * Permet de lancer une carte de types sort avec les differents possibilites, represente la premiere etapes du processus  
     * @param carte
     * @param adversaire
     */
    public void attaquer_sort(Carte carte, Joueur adversaire) {
        if (!(carte instanceof Sort sort)) {
            System.out.println("La carte n'est pas un sort !");
            return;}
        
        Scanner scanner = new Scanner(System.in);
        Map<Integer, Object> mapping = new HashMap<>();
        int index = 1;

        System.out.println("\n→ Choisissez la cible du sort :");
        switch (sort.getType()) {
            case DEGAT -> {
                index=this.afficherCiblesAdversaire(adversaire, mapping, index);
            }
            case SOIN -> {
                index=this.afficherCiblesSoin(adversaire, mapping, index);
            }
            case BOOST_ATTAQUE -> {
               index=this.afficherCiblesBooster(adversaire, mapping, index);
            }
            default -> {
                System.out.println("Type de sort non géré.");
                return;}}
        // Choix utilisateur
        int choix = scanner.nextInt();
        Object cible = mapping.get(choix);
        if (cible == null) {
            System.out.println("Choix invalide.");
            return;
        }
        appliquer_sort(sort, cible, adversaire);}

    /**
     * 
     * @return le plateau du joueur ou se trouve tout les serviteurs qui on etet invoquer 
     */
    public Plateau getPlateau() {
        return plateau;}
    
    /**
     * Permet d'utiliser une carte de type arme, represente la premiere etapes du processus  
     * @param carte
     * @param adversaire
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

        for (Carte c : adversaire.getPlateau().getServiteurs()) {
            System.out.println(index + " - [Plateau joueur adverse] " + c);
            mapping.put(index++, c);}
       
        
        int choix = scanner.nextInt();
        Object cible = mapping.get(choix);
        if (cible == null) {
            System.out.println("Choix invalide.");
            return;
        }

        appliquer_arme(arme, cible, adversaire);}

    /**
     * Permet d'utiliser une carte de type serviteurs, represente la premiere etapes du processus  
     * @param carte
     * @param adversaire
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

        for (Serviteur s : adversaire.getPlateau().getServiteurs()) {
            System.out.println(index + " - [Serviteur adverse] " + s);
            mapping.put(index++, s);
        }

        int choix = scanner.nextInt();
        Object cible = mapping.get(choix);
        if (cible == null) {
            System.out.println("Choix invalide.");
            return;
        }

        appliquer_serviteur(serviteur, cible, adversaire); }
  
    
    private void appliquer_sort(Sort sort, Object cible, Joueur adversaire) {
        sort.appliquerEffet(cible, this, adversaire);}
    
    private void appliquer_arme(Arme arme, Object cible,Joueur adversaire) {
    	arme.appliquerEffet(cible, this, adversaire);}
    
    private void appliquer_serviteur(Serviteur serviteur,Object cible,Joueur adversaire) {
    	serviteur.appliquerEffet(cible, this, adversaire);}
    
    
    /**
     * Permet de faire les pioche des joueur pour le tour1
     */
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
    	}}
    
    /**
     * Permete de faire les pioche tout au long du tour
     */
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
        }}
    /**
     * Fonction permettant d'afficher les cibles en cas d'invocation d'une carte Sort de type degat 
     * @param adversaire
     * @param mapping
     * @param index
     * @return le decompte necesaire a l'affichage et la l'identification de la cible 
     */
    private int afficherCiblesAdversaire(Joueur adversaire, Map<Integer, Object> mapping, int index) {
        System.out.println("→ Cibles chez l'adversaire : " + adversaire.getNom());
        System.out.println(index + " - [Héros] " + adversaire.getHero());
        mapping.put(index++, adversaire.getHero());

        for (Serviteur s : adversaire.getPlateau().getServiteurs()) {
            System.out.println(index + " - [Serviteur adverse] " + s);
            mapping.put(index++, s);
        }return index; }
    /**
     * Fonction permettant d'afficher les cibles en cas d'invocation d'une carte Sort de type Soin 
     * @param adversaire
     * @param mapping
     * @param index
     * @return le decompte necesaire a l'affichage et la l'identification de la cible 
     */
    private int afficherCiblesSoin(Joueur adversaire, Map<Integer, Object> mapping, int index) {
    	 System.out.println("→ Cibles soignables pour " + this.nom_joueur + " :");
         System.out.println(index + " - [Héros] " + this.hero);
         mapping.put(index++, this.hero);

         for (Serviteur s : this.plateau.getServiteurs()) {
             System.out.println(index + " - [Serviteur] " + s);
             mapping.put(index++, s);
         }
         return index;}
    /**
     * Fonction permettant d'afficher les cibles en cas d'invocation d'une carte Sort de type Bosst 
     * @param adversaire
     * @param mapping
     * @param index
     * @return le decompte necesaire a l'affichage et la l'identification de la cible 
     */
    private int  afficherCiblesBooster(Joueur adversaire, Map<Integer, Object> mapping, int index){
    	System.out.println("→ Cibles pour boost : uniquement vos serviteurs");
        for (Serviteur s : this.plateau.getServiteurs()) {
            System.out.println(index + " - [Serviteur] " + s);
            mapping.put(index++, s);
        }
        for (Carte s : this.main.getServiteurs()) {
            System.out.println(index + " - [Serviteur] " + s);
            mapping.put(index++, s);
        }
        return index;
    }
    


    ///Fin classe 
}
  