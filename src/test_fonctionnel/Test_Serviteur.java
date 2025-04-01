package test_fonctionnel;
import cartes.*;

/**
 * Classe de test pour la classe Serviteur.
 */
public class Test_Serviteur {

    public static void main(String[] args) {
    	
    	
    	/////////// Test pour l'etape 1
    	/////////////////////////////////////
    	
        // Création de deux serviteurs
        Serviteur s1 = new Serviteur("Chevalier d'argent", 3, 4, 5, "Charge");
        Serviteur s2 = new Serviteur("Ogre brutal", 5, 6, 6, "");

        // Affichage des infos initiales
        System.out.println("Début du test :");
        System.out.println("Serviteur 1 : " + s1.getNom());
        System.out.println("Serviteur 2 : " + s2.getNom());

        // s1 attaque s2
        System.out.println("\n" + s1.getNom() + " attaque " + s2.getNom());
        s1.attaquer(s2);

        // Test des points de vie après attaque
        System.out.println("État de " + s2.getNom() + " après l'attaque : ");
        System.out.println("Est-il mort ? :" + s2.estMort());
        System.out.println(s2.toString());
        // s2 attaque s1 en retour
        System.out.println("\n" + s2.getNom() + " attaque " + s1.getNom());
        s2.attaquer(s1);
        System.out.println(s1.toString());

        System.out.println("État de " + s1.getNom() + " après l'attaque : ");
        System.out.println("Est-il mort ? :" + s1.estMort());

        // Frappe fatale
        System.out.println("\nAttaque fatale sur!"+ s1.getNom());
        s1.recevoircoup(100);
        System.out.println("Est-il mort ? :" + s1.estMort());
        
        
        /////////// Test pour l'etape 1
        /////////////////////////////////////
    }
}
