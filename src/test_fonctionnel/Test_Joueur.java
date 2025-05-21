package test_fonctionnel;

import jeu.*;
import cartes.*;

public class Test_Joueur {
    public static void main(String[] args) {
        // Création d’un deck simple
        Deck deck = new Deck();
        for (int i = 0; i < 5; i++) {
            deck.ajouterCarte(new Serviteur("Serviteur " + (i+1), 1 + i, 2, 4, ""));
        }

        Hero hero = new Hero("Chasseur", "Tir explosif",1);
        Joueur joueur = new Joueur("Fatoumata", deck, hero);

        // Simulation d’un tour
        joueur.getHero().augmenterMana();
        joueur.piocherCarte();
        joueur.piocherCarte();

        System.out.println(" -Cartes en main :");
        joueur.getMain().afficherMain();

        // Invoquer une carte si possible
        if (!joueur.getMain().getCartes().isEmpty()) {
            Carte c = joueur.getMain().getCartes().get(0);
            if (c instanceof Serviteur) {
                joueur.invoquerServiteur((Serviteur) c);
            }
        }

        // Affichage du plateau
        System.out.println("- Plateau du joueur :");
        joueur.getPlateau().afficherPlateau();
    }
}