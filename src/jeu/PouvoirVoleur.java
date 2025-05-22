package jeu;

/**
 * @author fatoumata
 */
public class PouvoirVoleur implements PouvoirHeroique {

	@Override
	public void activerPouvoir(Joueur lanceur, Object cible) {
        if (!(cible instanceof Hero adversaire)) {
            System.out.println("La cible doit être un héros.");
            return;
        }

        System.out.println("Le voleur " + lanceur.getNom() + " active Vol de Vie !");
        
        // Dégâts à l'adversaire
        adversaire.recevoirDegats(5);
        System.out.println("→ " + adversaire.getNom() + " perd 5 points de vie.");

        // Soin du lanceur
        lanceur.getHero().soigner(5);
        System.out.println("→ " + lanceur.getNom() + " récupère 5 points de vie.");

        // Marque le pouvoir comme utilisé
        lanceur.getHero().setPouvoirHeroique();
    }

	@Override
	public void DescriptionPouvoir() {
		System.out.println("++++++ Surveillez vos arrières ! ++++++");
		System.out.println("-> Inflige 5 point de vie au hero adverse.\n");
		
	}

	@Override
	public Object choisirCible(Joueur lanceur, Joueur adversaire) {
		return adversaire.getHero();
	}

}
