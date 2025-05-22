package jeu;

public interface PouvoirHeroique {
	 void activerPouvoir(Joueur lanceur, Object cible);
	 void DescriptionPouvoir();
	 Object choisirCible(Joueur lanceur, Joueur adversaire);
}
