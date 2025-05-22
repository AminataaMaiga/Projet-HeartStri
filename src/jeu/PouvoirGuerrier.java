package jeu;

public class PouvoirGuerrier implements PouvoirHeroique{

	@Override
	public void activerPouvoir(Joueur lanceur, Object cible) {
		System.out.println("Le hero "+ lanceur.getNom() + "utilise sont pouvoir de Guerrier pour augmenter son point de vie de 2 ");
		lanceur.getHero().soigner(2);
		
	}

	@Override
	public void DescriptionPouvoir() {
		System.out.println("++++++ La victoire ou la mort  !++++++");
		System.out.println("L’activation du pouvoir héroïque du guerrier « Gain d’armure » confère 2 points d’armure qui fonctionnent comme des points de vie supplémentaires cumulable.");
				
	}

	@Override
	public Object choisirCible(Joueur lanceur, Joueur adversaire) {
		// TODO Auto-generated method stub
		return null;
	}

}
