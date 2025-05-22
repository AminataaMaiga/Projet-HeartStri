package test_unitaires;

// Import des annotations de JUnit 5
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// Import des assertions de test
import static org.junit.jupiter.api.Assertions.*;

// Import des classes à tester
import cartes.Deck;
import cartes.Serviteur;
import cartes.TypeServiteur;
/**
 * @author Aminata
 */

public class DeckTest {
    private Deck deck;

    @BeforeEach
    void setUp() {
        deck = new Deck();  // Initialisation du deck avant chaque test
        deck.ajouterCarte(new Serviteur(TypeServiteur.DRAGON));
        deck.ajouterCarte(new Serviteur(TypeServiteur.PACIFISTE));
        deck.ajouterCarte(new Serviteur(TypeServiteur.ORC));
    }

    @Test
    void testTirerCarteAleatoire() {
        assertNotNull(deck.tirerCarteAleatoire(), "La carte tirée ne doit pas être null");
        assertEquals(2, deck.getCartes().size(), "Le deck doit avoir une carte de moins après tirage");
    }

    @Test
    void testAjouterCarte() {
        Serviteur serviteur = new Serviteur(TypeServiteur.SPECTRE);
        deck.ajouterCarte(serviteur);
        assertTrue(deck.getCartes().contains(serviteur), "Le serviteur ajouté doit être présent dans le deck");
    }

   
}
