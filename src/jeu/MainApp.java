package jeu;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;
import java.util.Scanner;

import cartes.*;

/**
 * La classe MainApp est le point d’entrée principal du jeu HeartSTRI.
 *  Elle représente le menu interactif permettant à l’utilisateur de lancer une partie, 
 *  explorer les héros, voir les cartes, ou quitter la jeu .
 * @author fatoumatasaliatraore
 */
public class MainApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CarteFactory factory = new CarteFactory();
        Combat combat = new Combat();

        System.out.println("====================================================");
        System.out.println("            Bienvenue sur HeartSTRI              ");
        System.out.println("====================================================");

        boolean enCours = true;

        while (enCours) {
            System.out.println("\n Que voulez-vous faire ?");
            System.out.println(" 1 - Jouer une partie");
            System.out.println(" 2 - Voir notre catalogue de héros");
            System.out.println(" 3 - Voir notre catalogue de cartes");
            System.out.println(" 4 - Reprendre une partie sauvegardée");
            System.out.println(" 5 - Quitter");

            System.out.print("→ Votre choix : ");
            int choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1 -> {
                    System.out.print("Entrez le nom du Joueur 1 : ");
                    String nom1 = scanner.nextLine();
                    System.out.print("Entrez le nom du Joueur 2 : ");
                    String nom2 = scanner.nextLine();
                    System.out.println("Joueur 1 :");
                    Hero h1 = choisirHeroDepuisConsole(scanner);
                    System.out.println("Joueur 2 :");
                    Hero h2 = choisirHeroDepuisConsole(scanner);

                    Deck d1 = factory.genererDeckAleatoire();
                    Deck d2 = factory.genererDeckAleatoire();

                    Joueur joueur1 = new Joueur(nom1, d1, h1, 1);
                    Joueur joueur2 = new Joueur(nom2, d2, h2, 2);

                    combat.simulerCombat(joueur1, joueur2);
                }
                case 2 -> {
                    System.out.println("===️ Catalogue des Héros disponibles ===");
                    for (HeroType type : HeroType.values()) {
                        System.out.println("- " + type.name() + " : " + type.getPouvoir());
                    }
                }
                case 3 -> {
                    System.out.println("===  Catalogue des Cartes ===");
                    System.out.println("→ Serviteurs :");
                    for (TypeServiteur ts : TypeServiteur.values()) {
                        System.out.println("  - " + ts.getNomCarte() + " (" + ts.getActionSpeciale() + ")");
                    }
                    System.out.println("→ Sorts :");
                    for (TypeSort ts : TypeSort.values()) {
                        System.out.println("  - " + ts.name());
                    }
                    System.out.println("→ Armes :");
                    for (TypeArme ta : TypeArme.values()) {
                        System.out.println("  - " + ta.name());
                    }
                }
                
                case 4 ->{
                	System.out.print("Voulez-vous reprendre une partie sauvegardée ? (o/n) : ");
					String reponse = scanner.nextLine();
					if (reponse.equalsIgnoreCase("o")) {
						System.out.print("Nom du fichier de sauvegarde à charger : ");
						String nomFichier = scanner.nextLine();
						try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(nomFichier))) {
							Joueur joueur1Sauvegarde = (Joueur) in.readObject();
							Joueur joueur2Sauvegarde = (Joueur) in.readObject();
							System.out.println("✔ Partie chargée avec succès !");
							Combat c= new Combat();
							c.simulerCombat(joueur1Sauvegarde, joueur2Sauvegarde);
						} catch (Exception e) {
							System.err.println("Erreur lors du chargement : " + e.getMessage());
						}
					} else {
						System.out.println("Reprise annulée.");
					}
                	
                }
                case 5 -> {
                    System.out.println("Merci d'avoir joué à HeartSTRI !");
                    enCours = false;
                }
                default -> System.out.println(" Choix invalide. Essayez encore.");
            }
        }
    }
    public static Hero choisirHeroDepuisConsole(Scanner scanner) {
        System.out.println("=== Choisissez un type de héros ===");
        HeroType[] types = HeroType.values();
        for (int i = 0; i < types.length; i++) {
            System.out.println((i + 1) + " - " + types[i].name() + " : " + types[i].getPouvoir());
        }

        int choix = -1;
        while (choix < 1 || choix > types.length) {
            System.out.print("→ Entrez le numéro du héros souhaité : ");
            if (scanner.hasNextInt()) {
                choix = scanner.nextInt();
                if (choix < 1 || choix > types.length) {
                    System.out.println(" Choix invalide, réessayez.");
                }
            } else {
                System.out.println("Entrée non valide. Veuillez entrer un nombre.");
                scanner.next(); 
            }
        }

        return new Hero(types[choix - 1]);
    }

}
