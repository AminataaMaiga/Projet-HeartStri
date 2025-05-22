package jeu;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import cartes.Serviteur;

/**
 * @author Aminata 
 */
public class PouvoirMage implements PouvoirHeroique {
	
	@Override
	public void activerPouvoir(Joueur lanceur, Object cible) {
		if(cible instanceof Hero h) {
			System.out.println("Le hero "+ lanceur.getNom() + " utilise sont pouvoir de Mage pour envoyer un boule de feu magic au hero "+ h.getNom());
			h.recevoirDegats(1);
		}
		else if (cible instanceof Serviteur s){
			System.out.println("Le hero "+ lanceur.getNom() + " utilise sont pouvoir de Mage pour envoyer un boule de feu magic au serviteur "+ s.getNom());
			s.recevoircoup(1);
	
		}
		lanceur.getHero().setPouvoirHeroique();
	}

	@Override
	public void DescriptionPouvoir() {
		System.out.println("++++++ Ma magie va vous mettre en pièces ! ++++++");
		System.out.println("L’activation du pouvoir héroïque du mage inflige 1 point de dégâts à n’importe quelle cible de votre choix.\n");
		}
	
	@Override
	public Object choisirCible(Joueur lanceur, Joueur adversaire) {
	    Scanner scanner = new Scanner(System.in);
	    Map<Integer, Object> mapping = new HashMap<>();
	    int index = 1;

	    System.out.println("→ Choisissez une cible Mage :");
	    System.out.println(index + " - [Héros adverse] " + adversaire.getHero());
	    mapping.put(index++, adversaire.getHero());

	    for (Serviteur s : adversaire.getPlateau().getServiteurs()) {
	        System.out.println(index + " - [Serviteur adverse] " + s);
	        mapping.put(index++, s);}
	    

	    System.out.print(" Votre choix : ");
	    int choix = scanner.nextInt();
	    return mapping.getOrDefault(choix, null);
	}


}
