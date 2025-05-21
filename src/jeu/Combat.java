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


	public String simulerCombat(Joueur joueur1, Joueur joueur2) {
        int scoreJoueur1 = 0;
        int scoreJoueur2 = 0;

        // Comparer les cartes une par une
        for (int i = 0; i < Math.min(joueur1.getMain().taille(), joueur2.getMain().taille()); i++) {
            Carte carteJoueur1 = joueur1.getMain().getCartes().get(i);
            Carte carteJoueur2 = joueur2.getMain().getCartes().get(i);

            if (carteJoueur1.getMana() > carteJoueur2.getMana()) {
                scoreJoueur1++;
            } else if (carteJoueur1.getMana() < carteJoueur2.getMana()) {
                scoreJoueur2++;
            }
        }

        // Déterminer le vainqueur
        if (scoreJoueur1 > scoreJoueur2) {
            return joueur1.getNom() + " remporte le combat !";
        } else if (scoreJoueur1 < scoreJoueur2) {
            return joueur2.getNom() + " remporte le combat !";
        } else {
            return "Le combat est un match nul !";
        }
    }
	// Tour d'un joueur
    private void effectuerTour(Joueur attaquant, Joueur defenseur) {
        System.out.println("\nTour de " + attaquant.getNom());
        attaquant.augmenterMana();
        attaquant.piocherCarte();

        // Exemple : utiliser un sort si disponible
        if (attaquant.getMain().taille() > 0) {
            Sort sort = (Sort) attaquant.getMain().getCartes().stream()
                                         .filter(carte -> carte instanceof Sort)
                                         .findFirst()
                                         .orElse(null);

            if (sort != null && attaquant.getMana() >= sort.getMana()) {
                attaquant.utiliserSort(sort, defenseur.getPlateau().getServiteurs().get(0));; // Cible un serviteur
            }
        }

        // Exemple : attaquer avec une arme
        if (attaquant.getHero().getPointsDeVie() > 0 && attaquant.getArmeEquipee() != null) {
            attaquant.attaquerHeroAvecArme(defenseur.getHero());
        }
          
        }
    }



