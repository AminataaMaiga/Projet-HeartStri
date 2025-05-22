package jeu;

import cartes.Carte;
import cartes.*;

/**
 * @author Aminata 
 */
public class PouvoirDemoniste implements PouvoirHeroique{
	
	
	/**
	 * Description:
	 * 	- Le joueur pioche un serviteur dans son deck 
	 * 	-Le joueur serviteur sera mit dans la main du jouer et il poura decider si il jouer cette carte ou une autre 
	 */

	  @Override
	    public void activerPouvoir(Joueur lanceur, Object cible) {
	        System.out.println("Le Hero " + lanceur.getNom() + " active la Connexion démoniaque...");
	        lanceur.getHero().recevoirDegats(2);
	        System.out.println("→ Le héros perd 2 points de vie !");

	        if(lanceur.getDeck().existeServiteur())
	        {
		        Carte piochee = lanceur.getDeck().tirerCarteAleatoire();
		        while(!(piochee instanceof Serviteur)) {
		        	lanceur.getDeck().ajouterCarte(piochee);
		        	piochee = lanceur.getDeck().tirerCarteAleatoire();
		        }
		         if (lanceur.getMain().taille() < 10) {
		                lanceur.getMain().ajouterCarte(piochee);
		                System.out.println("→ Le démoniste pioche : " + piochee.getNom());
		            } else {
		                System.out.println("La Main pleine ! La carte piochée est défaussée.");
		            }
		        // on marque le pouvoir comme utilisé
		        lanceur.getHero().setPouvoirHeroique();
	        }else {
	        	System.out.println("Le deck ne contient pas de serviteur , dommage !!");
	        }
	       
	    }

	@Override
	public void DescriptionPouvoir() {
		System.out.println("++++++ Je serai votre cauchemar ! ++++++");
		System.out.println("L’activation du pouvoir héroïque du démoniste permet de piocher une carte en échange de 2 points de vie.\n");}
	
	@Override
	public Object choisirCible(Joueur lanceur, Joueur adversaire) {
		return null;
	}

}
