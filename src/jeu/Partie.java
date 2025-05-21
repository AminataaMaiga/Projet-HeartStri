package jeu;

import cartes.*;

public class Partie {

    private Joueur joueur1;
    private Joueur joueur2;

    public Partie(Joueur joueur1, Joueur joueur2) {
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
    }

    public void demarrer() {
        System.out.println("=== Début de la partie ===");

        int tour = 1;
        boolean partieTerminee = false;

        // Boucle de jeu
        while (!partieTerminee) {
            System.out.println("\n===== Tour " + tour + " =====");

            // Tour du joueur 1
            partieTerminee = tourDeJeu(joueur1, joueur2);
            if (partieTerminee) break;

            // Tour du joueur 2
            partieTerminee = tourDeJeu(joueur2, joueur1);
            tour++;
        }

        System.out.println("Fin de la partie !");
    }

    private boolean tourDeJeu(Joueur actif, Joueur adverse) {
        Tour tour = new Tour(actif);
        tour.demarrerTour();

        // Invocation automatique d'un serviteur (si possible)
        for (Carte c : actif.getMain().getCartes()) {
            if (c instanceof Serviteur && actif.peutInvoquer(c)) {
                actif.invoquerServiteur((Serviteur) c);
                break; // On en invoque qu’un pour simplifier
            }
        }

        // Phase d'attaque : on prend le 1er serviteur du plateau s'il existe
        if (!actif.getPlateau().getServiteurs().isEmpty()) {
            Serviteur attaquant = actif.getPlateau().getServiteurs().get(0);

            if (!adverse.getPlateau().getServiteurs().isEmpty()) {
                Serviteur cible = adverse.getPlateau().getServiteurs().get(0);
                attaquant.attaquer(cible);
                if (cible.estMort()) {
                    adverse.getPlateau().retirerServiteur(cible);
                }
            } else {
                tour.attaquerHero(adverse.getHero(), attaquant.getPointAttaque());
            }
        }

        // Vérification de victoire
        return adverse.estMort();
    }
}
