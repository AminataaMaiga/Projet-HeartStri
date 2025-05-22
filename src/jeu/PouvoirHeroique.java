package jeu;


/**
 * Interface représentant un **pouvoir héroïque** dans le jeu HeartSTRI.
 * 
 * Tous les héros du jeu doivent implémenter cette interface afin de 
 * définir leur pouvoir spécifique, activable une fois par tour.
 * 
 * Chaque implémentation devra :
 *  - Définir le comportement du pouvoir (`activerPouvoir`)
 *  - Fournir une description du pouvoir pour affichage utilisateur (`DescriptionPouvoir`)
 *  - Spécifier une logique de sélection de cible si nécessaire (`choisirCible`)
 * 
 * Elle permet ainsi de garantir une structure homogène pour tous les types
 * de pouvoirs, tout en laissant une liberté d’implémentation par héros.
 * 
 * Méthodes :
 * - activerPouvoir(Joueur lanceur, Object cible) :
 *     Applique l’effet du pouvoir sur une cible spécifique (héros, serviteur...).
 * - DescriptionPouvoir() :
 *     Affiche dans la console une description textuelle du pouvoir.
 * - choisirCible(Joueur lanceur, Joueur adversaire) :
 *     Permet de déterminer dynamiquement la cible du pouvoir en fonction du héros.
 * @author Aminata
 */

public interface PouvoirHeroique {
	 void activerPouvoir(Joueur lanceur, Object cible);
	 void DescriptionPouvoir();
	 Object choisirCible(Joueur lanceur, Joueur adversaire);
}
