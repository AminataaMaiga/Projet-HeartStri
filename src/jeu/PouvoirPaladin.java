package jeu;

import cartes.Serviteur;
import cartes.TypeServiteur;

/**
 * @author Aminata 
 */
public class PouvoirPaladin implements PouvoirHeroique {

	/**
	 * Le paladin ets le seul her qui peut invoquer une carte serviteur de type soldat:
	 * il jouera donc a 31 cartes 
	 */
    @Override
    public void activerPouvoir(Joueur lanceur, Object cible) {
        // Invoque son fidele destrier le soldqt sur le plateau
        Serviteur soldat = new Serviteur(TypeServiteur.SOLDAT); 
        lanceur.getPlateau().ajouterServiteur(soldat);
        System.out.println("Le hero " + lanceur.getNom() + " invoque un soldat 1/1 grâce à son pouvoir héroïque !");
        // Pouvoir heroique plus utilisable 
        lanceur.getHero().setPouvoirHeroique(); 
    }

    @Override
    public void DescriptionPouvoir() {
        System.out.println("++++++ Le Paladin invoque un soldat au combat ! ++++++");
        System.out.println("Ce pouvoir place un serviteur 1/1 directement sur le plateau.\n");
    }

	@Override
	public Object choisirCible(Joueur lanceur, Joueur adversaire) {
		return null;
	}
}
