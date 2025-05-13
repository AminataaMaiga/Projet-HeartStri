package test_unitaires;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import cartes.Deck;
import cartes.Serviteur;
import jeu.Hero;
import jeu.Joueur;

public class JoueurTest {

    @Test
    public void testAugmenterMana() {
        Deck deck = new Deck();
        Hero hero = new Hero("Mage", "");
        Joueur joueur = new Joueur("Aminata", deck, hero);

        joueur.augmenterMana();
        assertEquals(2, joueur.getMana());
    }

    @Test
    public void testInvoquerServiteur() {
        Deck deck = new Deck();
        deck.genererDeckAleatoire(10);
        Hero hero = new Hero("Mage", "");
        Joueur joueur = new Joueur("Aminata", deck, hero);

        Serviteur s = deck.tirerCarteAleatoire();
        joueur.getMain().ajouterCarte(s);

        joueur.invoquerServiteur(s);
        assertTrue(joueur.getPlateau().getServiteurs().contains(s));
    }
}
