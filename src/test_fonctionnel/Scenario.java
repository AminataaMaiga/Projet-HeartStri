package test_fonctionnel;
import cartes.*;
import jeu.*;

public class Scenario {
	
	public static void main(String[] args) {
	    // Création des héros
	    Hero h1 = new Hero(HeroType.MAGE);
	    Hero h2 = new Hero(HeroType.CHASSEUR);

	    // Création de decks personnalisés avec 5 cartes
	    Deck deck1 = new Deck();
	    deck1.ajouterCarte(new Serviteur(TypeServiteur.ORC));
	    deck1.ajouterCarte(new Serviteur(TypeServiteur.TROLL));
	    deck1.ajouterCarte(new Serviteur(TypeServiteur.SPECTRE));
	    deck1.ajouterCarte(new Sort( TypeSort.DEGAT, 2));
	    deck1.ajouterCarte(new Arme(TypeArme.LAME_RUNIQUE));

	    Deck deck2 = new Deck();
	    deck2.ajouterCarte(new Serviteur(TypeServiteur.DRAGON));
	    deck2.ajouterCarte(new Serviteur(TypeServiteur.PACIFISTE));
	    deck2.ajouterCarte(new Serviteur(TypeServiteur.TROLL));
	    deck2.ajouterCarte(new Sort( TypeSort.SOIN, 2));
	    deck2.ajouterCarte(new Arme( TypeArme.EPEE_DU_DESTIN));

	    // Création des joueurs
	    Joueur joueur1 = new Joueur("Aminata", deck1, h1, 1);
	    Joueur joueur2 = new Joueur("Balla", deck2, h2, 2);

	    // Début du combat
	    Combat combat = new Combat();
	    System.out.println("============ DÉMONSTRATION DU COMBAT ============");
	    combat.simulerCombat(joueur1, joueur2);
	}

	
}
