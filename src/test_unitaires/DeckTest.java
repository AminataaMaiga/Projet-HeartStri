package test_unitaires;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cartes.Deck;
import cartes.Serviteur;

public class DeckTest {
    private Deck deck;

    @BeforeEach
    void setUp() {
        deck = new Deck();  // Utilise la variable d'instance, ne pas redéclarer localement
        deck.ajouterCarte(new Serviteur("Serviteur 1", 1, 2, 3, "Aucune"));
        deck.ajouterCarte(new Serviteur("Serviteur 2", 2, 3, 4, "Aucune"));
        deck.ajouterCarte(new Serviteur("Serviteur 3", 3, 4, 5, "Aucune"));
    }

    @Test
    void testTirerCarteAleatoire() {
        assertNotNull(deck.tirerCarteAleatoire());
        assertEquals(2, deck.getCartes().size()); // Vérifie que la taille du deck diminue
    }

    @Test
    void testAjouterCarte() {
        Serviteur serviteur = new Serviteur("Nouveau Serviteur", 4, 5, 6, "Aucune");
        deck.ajouterCarte(serviteur);
        assertTrue(deck.getCartes().contains(serviteur));
    }

    @Test
    void testGenererDeckAleatoire() {
        deck.genererDeckAleatoire(5);
        assertEquals(8, deck.getCartes().size()); // Vérifie que 5 nouvelles cartes ont été ajoutées
    }
}