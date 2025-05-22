package jeu;

import cartes.Serviteur;
import cartes.TypeServiteur;

public class PouvoirPaladin implements PouvoirHeroique {

    @Override
    public void activerPouvoir(Joueur lanceur, Object cible) {
        // Crée un serviteur 1/1 sans effet spécial
        Serviteur soldat = new Serviteur(TypeServiteur.SOLDAT); // Assure-toi que SOLDAT existe
        lanceur.getPlateau().ajouterServiteur(soldat);
        System.out.println("Le hero " + lanceur.getNom() + " invoque un soldat 1/1 grâce à son pouvoir héroïque !");
        
        lanceur.getHero().setPouvoirHeroique(); // Marque comme utilisé
    }

    @Override
    public void DescriptionPouvoir() {
        System.out.println("++++++ Le Paladin invoque un soldat au combat ! ++++++");
        System.out.println("Ce pouvoir place un serviteur 1/1 directement sur le plateau.");
    }

	@Override
	public Object choisirCible(Joueur lanceur, Joueur adversaire) {
		return null;
	}
}
