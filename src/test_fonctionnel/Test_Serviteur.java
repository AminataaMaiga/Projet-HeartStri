package test_fonctionnel;

import cartes.*;

/**
 * Classe de test pour la classe Serviteur.
 * Version mise à jour avec TypeServiteur et CarteFactory.
 * @author Fatoumata
 */
public class Test_Serviteur {

    public static void main(String[] args) {

        // Création de deux serviteurs avec un TypeServiteur
        Serviteur s1 = new Serviteur(TypeServiteur.ORC);
        Serviteur s2 = new Serviteur( TypeServiteur.DRAGON);

        System.out.println(" Début du test des Serviteurs\n");

        // Affichage des infos initiales
        System.out.println("Serviteur 1 : " + s1);
        System.out.println("Serviteur 2 : " + s2);

        // s1 attaque s2
        System.out.println("\n️ " + s1.getNom() + " attaque " + s2.getNom());
        s1.attaquer(s2);
        System.out.println("État de " + s2.getNom() + " : " + s2 + " | Mort ? " + s2.estMort());

        // s2 attaque s1
        System.out.println("\n➡ " + s2.getNom() + " attaque " + s1.getNom());
        s2.attaquer(s1);
        System.out.println("État de " + s1.getNom() + " : " + s1 + " | Mort ? " + s1.estMort());

        // Frappe fatale
        System.out.println("\n☠ Attaque fatale sur " + s1.getNom());
        s1.recevoircoup(100);
        System.out.println("Est-il mort ? " + s1.estMort());

        // Génération d’un serviteur aléatoire via CarteFactory
        System.out.println("\n Génération aléatoire d’un serviteur :");
        Serviteur s3 = CarteFactory.genererServiteurAleatoire();
        System.out.println("Serviteur généré : " + s3);
    }
}
