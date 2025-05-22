package test_fonctionnel;

import jeu.*;
import cartes.*;
/**
 * fonction test permettant de verifier les fonctionnalite d'un joueur 
 */
public class Test_Joueur {
    public static void main(String[] args) {
        // Génération d'un deck avec le factory (20 serviteurs, 5 sorts, 5 armes)
        Deck deck = CarteFactory.genererDeckAleatoire();

        // Création d’un héros de type CHASSEUR
        Hero hero = new Hero(HeroType.CHASSEUR);

        // Création du joueur
        Joueur joueur = new Joueur("Fatoumata", deck, hero, 1);

        // Simule le début de partie (pioche de départ)
        joueur.tirerCarteTour1();

        // Affiche le mana et les cartes en main
        System.out.println("Mana actuel : " + joueur.getHero().getMana());
        System.out.println("→ Cartes en main :");
        joueur.getMain().afficherMain();

        // Tente d'invoquer un serviteur si assez de mana
        for (Carte c : joueur.getMain().getCartes()) {
            if (c instanceof Serviteur s && joueur.getHero().peutInvoquer(c)) {
                joueur.jouerCarte(c, null); // pas d'adversaire dans ce test
                break; // on joue une seule carte
            }
        }

        // Affiche l’état du plateau
        System.out.println("\n→ Plateau après invocation :");
        joueur.getPlateau().afficherPlateau();
        
      
    }
}
