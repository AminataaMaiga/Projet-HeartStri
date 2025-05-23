package jeu;
import java.io.Serializable;

/**
 * @author 
 */
public class PouvoirChasseur implements PouvoirHeroique, Serializable {
	private static final long serialVersionUID = 1L;

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
		System.out.println("L’activation du pouvoir héroïque du chasseur inflige 2 point de dégâts au hero adverse.\n");
		
	}

	@Override
	public Object choisirCible(Joueur lanceur, Joueur adversaire) {
		return null;
	}

}
