package jeu;
import java.util.Scanner;

import cartes.*;

/**
 * Classe gérant le combat.
 * @author Amayel
 */

public class Combat {

		/**
	      Démarre le combat entre deux serviteurs, tour par tour.
	     *Affiche l'état de chaque tour et arrête le combat dès qu'un serviteur meurt.
	      @param s1 Serviteur 1
	      @param s2 Serviteur 2
	     */
	public void demarrerCombatServiteur(Serviteur s1, Serviteur s2) {
        int tour = 1;
        System.out.println(" Début du combat entre :");
        System.out.println("Serviteur " + s1.getNom());
        System.out.println("Serviteur " + s2.getNom());

        while (!s1.estMort() && !s2.estMort()) {
            System.out.println("\n----- Tour " + tour + " -----");

            System.out.println(s1.getNom() + " attaque " + s2.getNom());
            s1.attaquer(s2);
            System.out.println("→ " + s2);

            if (s2.estMort()) {
                System.out.println( s2.getNom() + " est mort. " + s1.getNom() + " remporte le combat !");
                break;
            }

            System.out.println(s2.getNom() + " contre-attaque " + s1.getNom());
            s2.attaquer(s1);
            System.out.println("→ " + s1);

            if (s1.estMort()) {
                System.out.println( s1.getNom() + " est mort. " + s2.getNom() + " remporte le combat !");
                break;
            }

            tour++;
        }

        System.out.println("\n Combat terminé.");
    }


	public void simulerCombat(Joueur joueur1, Joueur joueur2) {
		boolean tour=true;
		boolean tour1=true;//boolean pour indiquer que c'est le premier tour 
		joueur1.tirerCarteTour1();
		joueur2.tirerCarteTour1();
		
		
		while(!joueur1.estMort()&&!joueur2.estMort()){
			
			if(tour) {
				if (!tour1){
					joueur1.piocherCarte();
				}
				Tour(joueur1,joueur2);
				this.afficher_etat(joueur1);
				tour=false;//Passe la main 
				joueur1.getHero().augmenterMana();
			}else {
				if (!tour1){
					joueur2.piocherCarte();
				}
				Tour(joueur2,joueur1);
				this.afficher_etat(joueur2);
				tour=true;
				joueur2.getHero().augmenterMana();
				tour1=false;
			}
			
		}
		
		if(joueur1.estMort()) {
			System.out.println("Felicitaiton "+ joueur2.getNom() +", vous avez remporter la partie !! :) ");
		}
		else {
			System.out.println("Felicitaiton "+ joueur1.getNom() +", vous avez remporter la partie !! :) ");
		}
        
    }
	
	public void Tour(Joueur j,Joueur j2) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("\n============== Tour de " + j.getNom() + " ==============");
		System.out.println("Héros : " + j.getHero());
		j.getMain().afficherMain();
		

		System.out.println("Que voulez-vous faire ? : \n");
		System.out.println("0 - Jouer une carte");
		System.out.println("1 - Passer le tour\n");

		System.out.println("");
		int choix=scanner.nextInt();
		while(choix>1||choix<0) {
			System.out.println("Entrée invalide, veuillez réessayer : \n");
			choix=scanner.nextInt();
		}
		
		if(choix==0) 
		{
			System.out.println("Veuillez choisir la carte de votre main que vous voulez jouer \n");
	    	int carte_a_jouer= scanner.nextInt();
	    	Carte c=j.getMain().getCarte(carte_a_jouer);
	    	if (c != null) {
	    	    j.jouerCarte(c, j2);}
		}
		
	}
	
	public void afficher_etat(Joueur j) {
		System.out.println("\nFin du tour de " + j.getNom());
		System.out.println("→ État du héros : " + j.getHero().toString());
		System.out.println("→ Cartes restantes : " + j.getMain().taille()+"\n");
	}
	
	
	
}



