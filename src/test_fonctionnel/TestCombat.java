package test_fonctionnel;

import cartes.Serviteur;
import jeu.Combat;

/**
 * Classe de test des differents combats 
 * @author Amayel
 */

public class TestCombat {

    public static void main(String[] args) {
    	
    	/*Test du combat entre deux serviteur 
    	 */
        // Création de deux serviteurs manuellement
    	Serviteur s1 = Serviteur.genererServiteurAleatoire();
    	Serviteur s2 = Serviteur.genererServiteurAleatoire();

        // Affichage des serviteurs
        System.out.println("=== Serviteurs prêts pour le combat ===");
        System.out.println(s1);
        System.out.println(s2);

        // Lancement du combat
        Combat combat = new Combat();
        combat.demarrerCombatServiteur(s1, s2);
        
        /*Test du combat entre deux Joueur
    	 */
    }
}
