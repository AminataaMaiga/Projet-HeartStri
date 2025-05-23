package jeu;
import java.io.Serializable;
import java.util.List;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import cartes.*;

/**
 * Classe gérant le combat.
 * @author Amayel
 */

public class Combat implements Serializable{
	private static final long serialVersionUID = 1L;
	/**
      Démarre le combat entre deux serviteurs, tour par tour.
     *Affiche l'état de chaque tour et arrête le combat dès qu'un serviteur meurt.
      @param s1 Serviteur 1
      @param s2 Serviteur 2
     */
	public void demarrerCombatServiteur(Serviteur s1, Serviteur s2) {
        int tour = 1;
        System.out.println(" Début du combat entre :");
        System.out.println("Serviteur " + s1.getNom());
        System.out.println("Serviteur " + s2.getNom());

        while (!s1.estMort() && !s2.estMort()) {
            System.out.println("\n----- Tour " + tour + " -----");

            System.out.println(s1.getNom() + " attaque " + s2.getNom());
            s1.attaquer(s2);
            System.out.println("→ " + s2);

            if (s2.estMort()) {
                System.out.println( s2.getNom() + " est mort. " + s1.getNom() + " remporte le combat !");
                break;
            }

            System.out.println(s2.getNom() + " contre-attaque " + s1.getNom());
            s2.attaquer(s1);
            System.out.println("→ " + s1);

            if (s1.estMort()) {
                System.out.println( s1.getNom() + " est mort. " + s2.getNom() + " remporte le combat !");
                break;
            }

            tour++;
        }

        System.out.println("\n Combat terminé.");
    }


	/**
	 * Foncteur permettant de lancer un combat entre 2 joueur , il prends en parametre 2 
	 * joueurs et fait l'affichage de toutes les etapes de leurs affrontement
	 * @param joueur1
	 * @param joueur2
	 */
	public void simulerCombat(Joueur joueur1, Joueur joueur2) {
		boolean tour=true;//boolean pour savoir quel jouer doit jouer pour une manche donner (Le joueur1 est toujours le premier a jouer)
		boolean tour1=true;//boolean pour indiquer que c'est le premier tour 
		
		joueur1.tirerCarteTour1();
		joueur2.tirerCarteTour1();
		int numTour=1;
		System.out.println("------------- Début du combat -------------\n");
		
		while(!joueur1.estMort()&&!joueur2.estMort()){
			if(tour) {
				 System.out.println("\n============================ TOUR "+ numTour +" ============================");
				if (!tour1){
					joueur1.piocherCarte();
				}
				Tour(joueur1,joueur2);
				this.afficher_etat(joueur1);
				tour=false;//Passe la main au joueur suivant
				joueur1.getHero().augmenterMana();
			}else {
				if (!tour1){
					joueur2.piocherCarte();
				}
				Tour(joueur2,joueur1);
				this.afficher_etat(joueur2);
				tour=true;
				joueur2.getHero().augmenterMana();
				tour1=false;
				System.out.println("\n============================ FIN TOUR "+ numTour +" ============================");
				numTour++;
				}
		}
		if(joueur1.estMort()) {
			System.out.println("Felicitaiton "+ joueur2.getNom() +", vous avez remporter la partie !! :) ");}
		else {
			System.out.println("Felicitaiton "+ joueur1.getNom() +", vous avez remporter la partie !! :) ");}  
    }
	
	
	public static void reprendrePartieSauvegardee() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Nom du fichier de sauvegarde à charger : ");
    String nomFichier = scanner.nextLine();
    try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(nomFichier))) {
        Joueur joueur1 = (Joueur) in.readObject();
        Joueur joueur2 = (Joueur) in.readObject();
        System.out.println("✔ Partie chargée avec succès !");
        Combat combat = new Combat();
        combat.simulerCombat(joueur1, joueur2);
    } catch (Exception e) {
        System.err.println("Erreur lors du chargement : " + e.getMessage());
    }
}
	
	public static void ligneSeparatrice() {
	    System.out.println("\n--------------------------------------------------\n");
	}

	
	
	/**
	 * Simule le deroulements d'un tour 
	 * @param j
	 * @param j2
	 */
	public void Tour(Joueur joueur1, Joueur joueur2) {
		 
	    Scanner scanner = new Scanner(System.in);
	    boolean continuerTour = true;
	    while (continuerTour) {
	    	System.out.println("\n============== TOUR DE " + joueur1.getNom().toUpperCase() + " ==============");
	    	System.out.println("→ Héros : " + joueur1.getHero());
	    	Combat.ligneSeparatrice();

	    	joueur1.getMain().afficherMain();
	    	joueur1.getPlateau().afficherPlateau();
	    	Combat.ligneSeparatrice();


	    	System.out.println("  Que voulez-vous faire ?");
	    	System.out.println("   0 - Invoquer une carte depuis la main");
	    	System.out.println("   1 - Attaquer avec un serviteur sur le plateau");
	    	System.out.println("   2 - Utiliser le pouvoir héroïque");
	    	System.out.println("   3 - Passer le tour");
	    	System.out.println("   4 - Sauvegarder la partie");
			System.out.println("   5 - Reprendre une partie sauvegardée");

			

	    	System.out.print("→ Votre choix : ");


	        int choix = scanner.nextInt();

	        switch (choix) {
	            case 0 -> {
	                if (joueur1.getMain().estVide()) {
	                    System.out.println(" Vous n'avez pas de carte en main !");
	                } else {
	                    System.out.println(" Choisissez une carte à jouer : ");
	                    int index = scanner.nextInt();
	                    Carte carte = joueur1.getMain().getCarte(index);
	                    if (carte != null) {
	                        boolean success = joueur1.jouerCarte(carte, joueur2);
	                        if (success) {
	                            continuerTour = false; 
	                        }
	                    }
	                }
	            }
	            case 1 -> {
	                List<Serviteur> serviteurs = joueur1.getPlateau().getServiteurs();
	                if (serviteurs.isEmpty()) {
	                    System.out.println(" Aucun serviteur sur le plateau.");
	                } else {
	                    System.out.println(" Choisissez un de vos serviteurs à utiliser pour attaquer :");
	                    for (int i = 0; i < serviteurs.size(); i++) {
	                        System.out.println((i + 1) + " - " + serviteurs.get(i));
	                    }
	                    int choixServiteur = scanner.nextInt();
	                    if (choixServiteur > 0 && choixServiteur <= serviteurs.size()) {
	                        Serviteur s = serviteurs.get(choixServiteur - 1);
	                        joueur1.attaquer_serviteur(s, joueur2);
	                    } else {
	                        System.out.println("Choix invalide.");
	                    }
	                    continuerTour = false;
	                }
	              
	            }
	            case 2 ->{
	            	//Utilisation du pouvoir heroique
	            	if(joueur1.getHero().getPouvoirutiliser()) {
	            		System.out.println("Le pouvoir heroique de "+ joueur1.getHero().getNom()+" a deja ete utiliser !");
	            	}else {
	            		joueur1.getHero().getPouvoirHeroique().DescriptionPouvoir();
	            		Object cible = joueur1.getHero().getPouvoirHeroique().choisirCible(joueur1, joueur2);
	            		joueur1.getHero().getPouvoirHeroique().activerPouvoir(joueur1, cible);
	            	}
	            }
	            case 3 -> continuerTour = false;
	            case 4 -> {
	                System.out.print("Voulez-vous sauvegarder la partie ? (o/n) : ");
	                scanner.nextLine(); // Consommer le retour à la ligne
	                String reponse = scanner.nextLine();
	                if (reponse.equalsIgnoreCase("o")) {
	                    System.out.print("Nom du fichier de sauvegarde : ");
	                    String nomFichier = scanner.nextLine();
	                    sauvegarderPartie(joueur1, joueur2, nomFichier);
	                } else {
	                    System.out.println("Sauvegarde annulée.");
	                }
	            }
				case 5 -> {
					System.out.print("Voulez-vous reprendre une partie sauvegardée ? (o/n) : ");
					scanner.nextLine();
					String reponse = scanner.nextLine();
					if (reponse.equalsIgnoreCase("o")) {
						System.out.print("Nom du fichier de sauvegarde à charger : ");
						String nomFichier = scanner.nextLine();
						try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(nomFichier))) {
							Joueur joueur1Sauvegarde = (Joueur) in.readObject();
							Joueur joueur2Sauvegarde = (Joueur) in.readObject();
							System.out.println("✔ Partie chargée avec succès !");
							simulerCombat(joueur1Sauvegarde, joueur2Sauvegarde);
						} catch (Exception e) {
							System.err.println("Erreur lors du chargement : " + e.getMessage());
						}
					} else {
						System.out.println("Reprise annulée.");
					}
				}
				default -> System.out.println(" Entrée invalide, veuillez réessayer.");
			}
		}
	}
		
	
	
	public void afficher_etat(Joueur j) {
		System.out.println("\n============== FIN TOUR DE " + j.getNom().toUpperCase() + " ==============");
		System.out.println("→ État du héros : " + j.getHero().toString());
		System.out.println("→ Cartes restantes : " + j.getMain().taille()+"\n");
	}
	
	
	/**
	 * Sauvegarde la partie en cours dans un fichier.
	 * @param joueur1 Le joueur 1
	 * @param joueur2 Le joueur 2
	 * @param nomFichier Le nom du fichier de sauvegarde
	 */
	private void sauvegarderPartie(Joueur joueur1, Joueur joueur2, String nomFichier) {
	    try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(nomFichier))) {
	        out.writeObject(joueur1);
	        out.writeObject(joueur2);
	        System.out.println("✔ Partie sauvegardée avec succès !");
	    } catch (Exception e) {
	        System.err.println("Erreur lors de la sauvegarde : " + e.getMessage());
	    }
	}
}



