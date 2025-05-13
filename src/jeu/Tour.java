// ===== TourDeJeu.java =====
package jeu;

import cartes.Carte;
import cartes.Serviteur;

/**
*
* @author aminata
*/
public class Tour {

    private Joueur joueur; // à chaque tour, le joueur pioche 1 carte supplémentaire
    private int numeroTour;
    private Combat combat;

    public Tour(Joueur joueur) {
        this.joueur = joueur;
        this.numeroTour = 1;
        this.combat = new Combat();
    }

    /**
     * Démarre un tour de jeu : incrémente le mana, pioche une carte
     */
    public void demarrerTour() {
        System.out.println("Tour " + numeroTour + " de " + joueur.getNom());
        joueur.augmenterMana();

        Carte piochee = joueur.getDeck().tirerCarteAleatoire();
        if (piochee != null) {
            joueur.getMain().ajouterCarte(piochee);
            System.out.println(joueur.getNom() + " pioche : " + piochee.getNom());
        } else {
            System.out.println(joueur.getNom() + " ne peut plus piocher, deck vide.");
        }

        numeroTour++;
    }

    /**
     * Permet d’engager un combat entre deux serviteurs
     */
    public void phaseCombat(Serviteur s1, Serviteur s2) {
        combat.demarrerCombatServiteur(s1, s2);
    }

    /**
     * Attaque directe sur le héros adverse
     */
    public void attaquerHero(Hero cible, int degats) {
        cible.recevoirDegats(degats);
        System.out.println("Le héros " + cible.getNom() + " subit " + degats + " dégâts. Il lui reste " + cible.getPointsDeVie() + " PV.");

        if (cible.estMort()) {
            System.out.println(" Le héros " + cible.getNom() + " est mort. Fin de la partie !");
        }
    }
}
