package test_unitaires;
import cartes.Carte;
import cartes.Deck;
import org.junit.jupiter.api.Test;
import jeu.Combat;
import jeu.Joueur;
import jeu.Main;
import jeu.Hero;

import static org.junit.jupiter.api.Assertions.*;

public class CombatTest {

	public static void main(String[] args) {
		
		// initialisation des joueurs
		
		Deck deck1 = new Deck();
        Deck deck2 = new Deck();
        Hero hero1 = new Hero("Mage", "Boule de feu",1);
        Hero hero2 = new Hero("Guerrier", "Cri de guerre",1);
        Joueur joueur1 = new Joueur("Amayel", deck1, hero1);
        Joueur joueur2 = new Joueur("Rival", deck2, hero2);

        // Création de cartes
        Carte carte1 = new Carte("Dragon", 10);
        Carte carte2 = new Carte("Phoenix", 8);
        Carte carte3 = new Carte("Golem", 7);

        Carte carte4 = new Carte("Vampire", 6);
        Carte carte5 = new Carte("Sorcière", 9);
        Carte carte6 = new Carte("Zombie", 5);

        // Ajout des cartes dans les mains des joueurs
        joueur1.getMain().ajouterCarte(carte1);
        joueur1.getMain().ajouterCarte(carte2);
        joueur1.getMain().ajouterCarte(carte3);

        joueur2.getMain().ajouterCarte(carte4);
        joueur2.getMain().ajouterCarte(carte5);
        joueur2.getMain().ajouterCarte(carte6);

        // Simulation du combat
        Combat combat = new Combat();
        String resultat = combat.simulerCombat(joueur1, joueur2);

        // Assertion sur le résultat
        assertTrue(hero1.getPointsDeVie() < 30 || hero2.getPointsDeVie() < 30);
        assertTrue(resultat.contains("remporte le combat") || resultat.equals("Le combat est un match nul !"));

	}
	}


