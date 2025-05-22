package jeu;

import cartes.Serviteur;

/**
 * 
 */
public class PouvoirChasseur implements PouvoirHeroique {

	@Override
	public void activerPouvoir(Joueur lanceur, Object cible) {
		if(cible instanceof Hero h){
			System.out.println("Le hero "+ lanceur.getNom() + "utilise sont pouvoir de Chasseur pour envoyer des fleches ensanglantees au hero "+ h.getNom());
			h.recevoirDegats(2);
			lanceur.getHero().setPouvoirHeroique();
		}
		else {
			System.out.println("Vous ne pouvez attaquer qu'un hero ");
		
		}
		
	}

	@Override
	public void DescriptionPouvoir() {
		System.out.println("++++++ Que la traque commence  !++++++");
		System.out.println("L’activation du pouvoir héroïque du chasseur inflige 2 point de dégâts au hero adverse.");
		
	}

	@Override
	public Object choisirCible(Joueur lanceur, Joueur adversaire) {
		// TODO Auto-generated method stub
		return null;
	}

}
