package jeu;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import cartes.Serviteur;
/**
 * @author Aminata 
 */
public class PouvoirPretre implements PouvoirHeroique {

	@Override
	public void activerPouvoir(Joueur lanceur, Object cible) {
        if (cible instanceof Hero h) {
            h.soigner(2);
            System.out.println("Le prêtre soigne le héros " + h.getNom() + " de 2 PV.");
        } else if (cible instanceof Serviteur s) {
            s.soigner(2);
            System.out.println("Le prêtre soigne le serviteur " + s.getNom() + " de 2 PV.");
        } else {
            System.out.println("Cible invalide pour le soin.");
            return;}
        lanceur.getHero().setPouvoirHeroique();}

	@Override
	public void DescriptionPouvoir() {
        System.out.println("++++++ La Lumière brille sur les justes ! ++++++");
        System.out.println("L’activation du pouvoir héroïque du prêtre restaure 2 points de vie à n’importe quelle cible sur le plateau.\n");	
	}

	@Override
	public Object choisirCible(Joueur lanceur, Joueur adversaire) {
	    Scanner scanner = new Scanner(System.in);
	    Map<Integer, Object> mapping = new HashMap<>();
	    int index = 1;
	    System.out.println("\n→ Choisissez une cible à soigner :");
	    // Héros du lanceur
	    System.out.println(index + " - [Votre Héros] " + lanceur.getHero());
	    mapping.put(index++, lanceur.getHero());
	    // Serviteurs du lanceur
	    for (Serviteur s : lanceur.getPlateau().getServiteurs()) {
	        System.out.println(index + " - [Votre Serviteur] " + s);
	        mapping.put(index++, s);}

	    // Lecture de l'entrée utilisateur avec validation
	    int choix;
	    while (true) {
	        System.out.print("→ Votre choix : ");
	        try {
	            choix = Integer.parseInt(scanner.nextLine());
	            if (mapping.containsKey(choix)) {
	                return mapping.get(choix);
	            } else {
	                System.out.println("Choix invalide. Veuillez réessayer.");
	            }
	        } catch (NumberFormatException e) {
	            System.out.println("Entrée non valide. Entrez un nombre.");
	        }
	    }
	}
}


