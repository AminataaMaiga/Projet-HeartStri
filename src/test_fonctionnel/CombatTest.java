package test_fonctionnel;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;

import org.junit.jupiter.api.Test;

import cartes.Carte;
import cartes.CarteFactory;
import cartes.Deck;
import jeu.Combat;
import jeu.Hero;
import jeu.HeroType;
import jeu.Joueur;


/**
 * Classe de test pour simuler et vérifier le déroulement d’un combat entre deux joueurs.
 * Inclut à la fois un test interactif (main) et un test automatisé (JUnit).
 */
public class CombatTest {

    /**
     * Test manuel – Permet de jouer un combat complet dans la console.
     */
    public static void main(String[] args) {
        // Génération des cartes
        CarteFactory factory = new CarteFactory();
        List<Carte> setInitial = factory.genererSetInitial();

        // Création des héros
        Hero h1 = new Hero(HeroType.MAGE);
        Hero h2 = new Hero(HeroType.CHASSEUR);

        // Création des decks
        Deck deck1 = factory.genererDeckAleatoire();
        Deck deck2 = factory.genererDeckAleatoire();

       
        // Création des joueurs
        Joueur aminata = new Joueur("aminata", deck1, h1, 1);
        Joueur balla = new Joueur("balla", deck2, h2, 2);

       

        // Lancement du combat
       
        Combat combat = new Combat();
      
        combat.simulerCombat(aminata, balla);
    }
    /**
     * Test automatique – Vérifie qu’un combat peut se lancer et se terminer sans erreur.
     */
    @Test
    public void testCombatSeDerouleSansErreur() {
        CarteFactory factory = new CarteFactory();
        List<Carte> setInitial = factory.genererSetInitial();

        Hero h1 = new Hero(HeroType.MAGE);
        Hero h2 = new Hero(HeroType.GUERRIER);

        Deck deck1 = factory.genererDeckAleatoire();
        Deck deck2 = factory.genererDeckAleatoire();
       

        Joueur j1 = new Joueur("Testeur1", deck1, h1, 1);
        Joueur j2 = new Joueur("Testeur2", deck2, h2, 2);

        j1.tirerCarteTour1();
        j2.tirerCarteTour1();

        Combat combat = new Combat();

        // Vérifie que le combat ne lève pas d'exception
        assertDoesNotThrow(() -> combat.simulerCombat(j1, j2));
    }
}