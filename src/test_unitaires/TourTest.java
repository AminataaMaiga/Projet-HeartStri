package test_unitaires;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import cartes.Deck;
import jeu.Hero;
import jeu.Joueur;
import jeu.Tour;

public class TourTest {

    @Test
    public void testDemarrerTour() {
        Deck deck = new Deck();
        deck.genererDeckAleatoire(10);
        Hero hero = new Hero("Mage", " ",1);
        Joueur joueur = new Joueur("Aminata", deck, hero);

        Tour tour = new Tour(joueur);
        tour.demarrerTour();

        assertEquals(9, joueur.getHero().getMana()); // après 1 tour
        assertTrue(joueur.getMain().taille() > 0);
    }
}
