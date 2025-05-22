package jeu;
import java.util.List;
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
		int numTour=1;
		
		while(!joueur1.estMort()&&!joueur2.estMort()){
			if(tour) {
				 System.out.println("\n============================ TOUR "+ numTour +" ============================");
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
				System.out.println("\n============================ FIN TOUR "+ numTour +" ============================");
				numTour++;
				
			}
			
		}
		
		if(joueur1.estMort()) {
			System.out.println("Felicitaiton "+ joueur2.getNom() +", vous avez remporter la partie !! :) ");
		}
		else {
			System.out.println("Felicitaiton "+ joueur1.getNom() +", vous avez remporter la partie !! :) ");
		}
        
    }
	public static void ligneSeparatrice() {
	    System.out.println("\n--------------------------------------------------\n");
	}

	public void Tour(Joueur j, Joueur j2) {
	    Scanner scanner = new Scanner(System.in);
	    boolean continuerTour = true;
	    while (continuerTour) {
	    	System.out.println("\n============== TOUR DE " + j.getNom().toUpperCase() + " ==============");
	    	System.out.println("→ Héros : " + j.getHero());
	    	Combat.ligneSeparatrice();

	    	j.getMain().afficherMain();
	    	j.getPlateau().afficherPlateau();
	    	Combat.ligneSeparatrice();


	    	System.out.println("  Que voulez-vous faire ?");
	    	System.out.println("   0 - Invoquer une carte depuis la main");
	    	System.out.println("   1 - Attaquer avec un serviteur sur le plateau");
	    	System.out.println("   2 - Utiliser le pouvoir héroïque");
	    	System.out.println("   3 - Passer le tour");

	    	System.out.print("→ Votre choix : ");


	        int choix = scanner.nextInt();

	        switch (choix) {
	            case 0 -> {
	                if (j.getMain().estVide()) {
	                    System.out.println("Vous n'avez pas de carte en main !");
	                } else {
	                    System.out.println("Choisissez une carte à jouer : ");
	                    int index = scanner.nextInt();
	                    Carte carte = j.getMain().getCarte(index);
	                    if (carte != null) {
	                        boolean success = j.jouerCarte(carte, j2);
	                        if (success) {
	                            continuerTour = false; 
	                        }
	                    }
	                }
	            }
	            case 1 -> {
	                List<Serviteur> serviteurs = j.getPlateau().getServiteurs();
	                if (serviteurs.isEmpty()) {
	                    System.out.println("Aucun serviteur sur le plateau.");
	                } else {
	                    System.out.println("Choisissez un de vos serviteurs à utiliser pour attaquer :");
	                    for (int i = 0; i < serviteurs.size(); i++) {
	                        System.out.println((i + 1) + " - " + serviteurs.get(i));
	                    }
	                    int choixServiteur = scanner.nextInt();
	                    if (choixServiteur > 0 && choixServiteur <= serviteurs.size()) {
	                        Serviteur s = serviteurs.get(choixServiteur - 1);
	                        j.attaquer_serviteur(s, j2);
	                    } else {
	                        System.out.println("Choix invalide.");
	                    }
	                    continuerTour = false;
	                }
	              
	            }
	            case 2 ->{
	            	//Utilisation du pouvoir heroique
	            	if(j.getHero().getPouvoirutiliser()) {
	            		System.out.println("Le pouvoir heroique de "+ j.getHero().getNom()+" a deja ete utiliser !");
	            	}else {
	            		Object cible = j.getHero().getPouvoirHeroique().choisirCible(j, j2);
	                    j.getHero().getPouvoirHeroique().activerPouvoir(j, cible);
	            	}
	            }
	            case 3 -> continuerTour = false;
	            default -> System.out.println("Entrée invalide, veuillez réessayer.");
	        }
	    }
	}
		
	
	
	public void afficher_etat(Joueur j) {
		System.out.println("\n============== FIN TOUR DE " + j.getNom().toUpperCase() + " ==============");
		System.out.println("→ État du héros : " + j.getHero().toString());
		System.out.println("→ Cartes restantes : " + j.getMain().taille()+"\n");
	}
	
	
	
}



