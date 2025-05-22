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
        s1 = new Serviteur(TypeServiteur.DRAGON);
        deck.ajouterCarte(s1);
        Hero hero = new Hero(HeroType.GUERRIER);
        joueur = new Joueur("Fatoumata", deck, hero,1);
        joueur.getMain().ajouterCarte(s1);
    }

    @Test
    void testAugmenterMana() {
        joueur.getHero().augmenterMana();
        assertEquals(2, joueur.getHero().getMana());
        joueur.getHero().augmenterMana();
        assertEquals(3, joueur.getHero().getMana());
    }

    @Test
    void testInvoquerServiteurAvecSuffisantMana() {
        joueur.getHero().augmenterMana(); // mana = 2
        joueur.jouerCarte(s1, null);
        assertTrue(joueur.getPlateau().getServiteurs().contains(s1));
        assertFalse(joueur.getMain().getCartes().contains(s1));
        assertEquals(0, joueur.getHero().getMana());
    }

    @Test
    void testInvoquerServiteurSansMana() {
        joueur.jouerCarte(s1,null);
        assertFalse(joueur.getPlateau().getServiteurs().contains(s1));
    }

    @Test
    void testEstMort() {
        assertFalse(joueur.estMort());
        joueur.getHero().recevoirDegats(30);
        assertTrue(joueur.estMort());
    }
} 