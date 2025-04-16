package test_unitaires;

// Import des annotations de JUnit 5
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// Import des assertions de test
import static org.junit.jupiter.api.Assertions.*;

// Import des classes à tester
import cartes.Deck;
import cartes.Serviteur;
/**
 * @author Aminata
 */

public class DeckTest {
    private Deck deck;

    @BeforeEach
    void setUp() {
        deck = new Deck();  // Initialisation du deck avant chaque test
        deck.ajouterCarte(new Serviteur("Serviteur 1", 1, 2, 3, "Aucune"));
        deck.ajouterCarte(new Serviteur("Serviteur 2", 2, 3, 4, "Aucune"));
        deck.ajouterCarte(new Serviteur("Serviteur 3", 3, 4, 5, "Aucune"));
    }

    @Test
    void testTirerCarteAleatoire() {
        assertNotNull(deck.tirerCarteAleatoire(), "La carte tirée ne doit pas être null");
        assertEquals(2, deck.getCartes().size(), "Le deck doit avoir une carte de moins après tirage");
    }

    @Test
    void testAjouterCarte() {
        Serviteur serviteur = new Serviteur("Nouveau Serviteur", 4, 5, 6, "Aucune");
        deck.ajouterCarte(serviteur);
        assertTrue(deck.getCartes().contains(serviteur), "Le serviteur ajouté doit être présent dans le deck");
    }

    @Test
    void testGenererDeckAleatoire() {
        deck.genererDeckAleatoire(5);
        assertEquals(8, deck.getCartes().size(), "Le deck doit contenir 8 cartes après ajout de 5 cartes aléatoires");
    }
}
