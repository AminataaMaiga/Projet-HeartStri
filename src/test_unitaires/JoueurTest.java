package test_unitaires;

import cartes.*;
import jeu.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe de test unitaire pour la classe Joueur.
 * Elle vérifie les comportements essentiels comme la pioche, la gestion des PV, la pose de carte, etc.
 * @author ---
 */
public class JoueurTest {

    private Joueur joueur1;
    private Joueur joueur2;
    private Deck deck1;
    private Deck deck2;

    /**
     * Initialise les joueurs avec des decks de 30 serviteurs et des héros différents avant chaque test.
     */
    @BeforeEach
    void setUp() {
        deck1 = new Deck();
        deck2 = new Deck();

        for (int i = 0; i < 30; i++) {
            deck1.ajouterCarte(new Serviteur(TypeServiteur.ORC));
            deck2.ajouterCarte(new Serviteur(TypeServiteur.DRAGON));
        }

        Hero hero1 = new Hero(HeroType.MAGE);
        Hero hero2 = new Hero(HeroType.GUERRIER);

        joueur1 = new Joueur("Alice", deck1, hero1, 1); // joueur 1 = 3 cartes au 1er tour
        joueur2 = new Joueur("Bob", deck2, hero2, 2);   // joueur 2 = 4 cartes au 1er tour
    }

    /**
     * Vérifie que les cartes sont bien tirées au premier tour :
     * 3 pour le joueur 1, 4 pour le joueur 2.
     */
    @Test
    void testTirerCarteTour1() {
        joueur1.tirerCarteTour1();
        assertEquals(3, joueur1.getMain().taille());

        joueur2.tirerCarteTour1();
        assertEquals(4, joueur2.getMain().taille());
    }

    /**
     * Vérifie qu’une carte est bien ajoutée à la main au moment de la pioche après le 1er tour.
     */
    @Test
    void testPiocherCarte() {
        joueur1.tirerCarteTour1(); // tour 1
        joueur1.piocherCarte();    // tour suivant
        assertEquals(4, joueur1.getMain().taille());
    }

    /**
     * Vérifie que la détection de la mort du joueur est correcte
     * après avoir infligé 30 dégâts au héros.
     */
    @Test
    void testEstMort() {
        assertFalse(joueur1.estMort());
        joueur1.getHero().recevoirDegats(30);
        assertTrue(joueur1.estMort());
    }

    

    
}
