package test_unitaires;

import jeu.*;
import cartes.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JoueurTest {

    private Joueur joueur;
    private Serviteur s1;

    @BeforeEach
    void setUp() {
        Deck deck = new Deck();
        s1 = new Serviteur("Orc Guerrier", 2, 3, 4, "");
        deck.ajouterCarte(s1);
        Hero hero = new Hero("Guerrier","Armure");
        joueur = new Joueur("Fatoumata", deck, hero);
        joueur.getMain().ajouterCarte(s1);
    }

    @Test
    void testAugmenterMana() {
        joueur.augmenterMana();
        assertEquals(2, joueur.getMana());
        joueur.augmenterMana();
        assertEquals(3, joueur.getMana());
    }

    @Test
    void testInvoquerServiteurAvecSuffisantMana() {
        joueur.augmenterMana(); // mana = 2
        joueur.invoquerServiteur(s1);
        assertTrue(joueur.getPlateau().getServiteurs().contains(s1));
        assertFalse(joueur.getMain().getCartes().contains(s1));
        assertEquals(0, joueur.getMana());
    }

    @Test
    void testInvoquerServiteurSansMana() {
        joueur.invoquerServiteur(s1);
        assertFalse(joueur.getPlateau().getServiteurs().contains(s1));
    }

    @Test
    void testEstMort() {
        assertFalse(joueur.estMort());
        joueur.getHero().recevoirDegats(30);
        assertTrue(joueur.estMort());
    }
} 