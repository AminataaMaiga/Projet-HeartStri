package jeu;

import cartes.Deck;
import cartes.Carte;
import cartes.Serviteur;

import java.util.ArrayList;
import java.util.List;
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
            System.out.println(" La carte n'est pas un sort !");
            return;
        }
    	Scanner scanner = new Scanner(System.in);
    	System.out.println("Sur quel carte ou heros voulez-vous utiliser le sort ?");
    	System.out.println("Joueur"+this.ordre_joueur+" : "+ this.nom_joueur);
    	System.out.println("100 -"+this.hero.toString());
    	this.main.afficherMain();
    	
    	System.out.println("Joueur"+adversaire.getOrdre()+" : "+ this.nom_joueur);
    	System.out.println("200 -"+adversaire.getHero().toString());
    	adversaire.getMain().afficherMain();
    	
    	int cible = scanner.nextInt();
    	
    	if(cible==100){
    		Hero cible_h=this.hero;
    		appliquer_sort(sort,cible_h,adversaire);
    	}else if(cible==200) {
    		Hero cible_h2=adversaire.getHero();
    		appliquer_sort(sort,cible_h2,adversaire);
    	}else if(cible<=this.main.nombreCarteMain()) {
    		//effet sur le joueur lui meme	
    		Carte cible_c = this.main.getCarte(cible);
    		appliquer_sort(sort,cible_c,adversaire);
    	}
    	else {
    		//effect sur l'adversaire 
    		Carte cible_a=adversaire.getMain().getCarte(cible);
    		appliquer_sort(sort,cible_a,adversaire);
    	}
    	
    }
    
    /**
     * 
     * @param carte
     * @param adversaire
     * Permet.....
     */
    public void attaquer_arme(Carte carte, Joueur adversaire) {
    	if (!(carte instanceof Arme arme)) {
            System.out.println(" La carte n'est pas un sort !");
            return;
        }
    	Scanner scanner = new Scanner(System.in);
    	System.out.println("Sur quel carte ou heros  de votre adveraire voulez-vous utiliser l'arme ?");
    	System.out.println("Joueur"+adversaire.getOrdre()+" : "+ this.nom_joueur);
    	System.out.println("200 -"+adversaire.getHero().toString());
    	List<Carte> c = adversaire.getMain().getCartes();
    	int i=1;
    	List<Carte> s = new ArrayList<>();
    	for (Carte cte : c) {
    	    if (cte instanceof Serviteur serviteur) {
    	        System.out.println(i + " - " + serviteur);
    	        s.add(cte);
    	        i++;
    	    }}
    	int cible = scanner.nextInt();
    	
    	if (cible==200){
    		this.appliquer_arme(arme, adversaire.getHero(),adversaire);	
    	}else {
    		appliquer_arme(arme,s.get(cible),adversaire);
    	}
    }
    
    /**
     * 
     * @param carte
     * @param adversaire
     * Permet.....
     */
      public void attaquer_serviteur(Carte carte, Joueur adversaire) {
    	  if (!(carte instanceof Serviteur serviteur)) {
              System.out.println(" La carte n'est pas un sort !");
              return;
          }
      	Scanner scanner = new Scanner(System.in);
      	System.out.println("Sur quel carte ou heros  de votre adveraire voulez-vous utiliser l'arme ?");
      	System.out.println("Joueur"+adversaire.getOrdre()+" : "+ this.nom_joueur);
      	System.out.println("200 -"+adversaire.getHero().toString());
      	List<Carte> c = adversaire.getMain().getCartes();
    	int i=1;
    	List<Carte> s = new ArrayList<>();
    	for (Carte cte : c) {
    	    if (cte instanceof Serviteur serviteur1) {
    	        System.out.println(i + " - " + serviteur1);
    	        s.add(cte);
    	        i++;
    	    }}
    	int cible = scanner.nextInt();
    	
    	if (cible==200){
    		this.appliquer_serviteur(serviteur, adversaire.getHero(),adversaire);	
    	}else {
    		appliquer_serviteur(serviteur,s.get(cible),adversaire);}
  }     
    
    private void appliquer_sort(Sort sort,Object cible,Joueur adversaire) {
        if (cible instanceof Serviteur s) {
            s.recevoircoup(sort.getType().getForce());
            System.out.println(" Effet infligés au serviteur " + s.getNom()+"par le sort "+ sort.getType().getNomCarte());
            System.out.println(s.toString());
            if (s.estMort()) {
 	   		    adversaire.getMain().retirerCarte(s);
        } else if (cible instanceof Hero h) {
            h.recevoirDegats(sort.getType().getForce());
            System.out.println(" Effet infligés au héros " + h.getNom()+" par le sort "+ sort.getType().getNomCarte());
        }
        sort.setnb_utilisation();}}
    
    private void appliquer_arme(Arme m, Object cible,Joueur adversaire) {
    	int degat=m.getTypeArme().getdegat();
    	 if (cible instanceof Serviteur s){
    		 s.recevoircoup(degat);
    		 System.out.println("Le serviteur " + s.getNom() + " a subit une attaque de "+ degat + "de l'arme "+ m.getNom());
    		 if (s.estMort()) {
 	   		    adversaire.getMain().retirerCarte(s);
 	   		}
         } else if (cible instanceof Hero h){
        	 h.recevoirDegats(degat);
        	 System.out.println("Le Hero " + h.getNom() + " a subit une attaque de "+ degat+ "de l'arme "+ m.getNom());
         }
         m.setnbutilisation();
    }
    
    private void appliquer_serviteur(Serviteur serviteur,Object cible,Joueur adversaire) {
    	if (cible instanceof Serviteur s){
	   		 s.recevoircoup(serviteur.getPointAttaque());
	   		 System.out.println("Le serviteur " + s.getNom() + " a subit une attaque de "+ serviteur.getNom());
	   		 serviteur.recevoircoup(s.getPointAttaque());
	   		if (s.estMort()) {
	   		    adversaire.getMain().retirerCarte(s);
	   		}
        } else if (cible instanceof Hero h){
	       	 h.recevoirDegats(serviteur.getPointAttaque());
	       	 System.out.println("Le Hero " + h.getNom() + " a subit une attaque de "+ serviteur.getNom());
        }
    }
    
    
    public void tirerCarteTour1() {
    	int nbc=0;
    	if(this.ordre_joueur==1) {
    		nbc=3;
    	}else {
    		nbc=4;
    	}
    	for (int i=0;i<nbc;i++)
		{
			this.main.ajouterCarte(this.deck_joueur.tirerCarteAleatoire());
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
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
  