package jeu;
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
	    
	}


