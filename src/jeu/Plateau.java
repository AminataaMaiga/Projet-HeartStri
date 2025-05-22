package jeu;

import cartes.Serviteur;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe representant le plateau d'un joeur, c'est a dire l'ensenble des cartes de type serviteur que il a invoquer 
 * @author fatoumata
 */
public class Plateau implements Serializable{
	//Carte invoquer sur le plateau 
	private static final long serialVersionUID = 1L;
	private List<Serviteur> cartesActives;
    public Plateau() {
        this.cartesActives = new ArrayList<>();
    }

    /**|
     * 
     * @param s : le serviteur que l'on souhaite ajouter au plateau 
     */
    public void ajouterServiteur(Serviteur s) {
        if (cartesActives.size() < 3) { // Limite de 7 serviteurs sur le plateau, comme dans Hearthstone
            cartesActives.add(s);
            System.out.println("Le serviteur " + s.getNom() + " est invoqué sur le plateau.");
        } else {
            System.out.println("Plateau plein ! Impossible d'invoquer d'autres serviteurs.");
        }
    }
    /**
     * 
     * @param s : le serviteur que l'on souhaite retirer du du plateau 
     */
    public void retirerServiteur(Serviteur s) {
        cartesActives.remove(s);
    }
    /**
     * 
     * @return la liste de cartes de type serviteurs present sur le plateau
     */
    public List<Serviteur> getServiteurs() {
        return cartesActives;
    }
    
    /**
     * @return fait un jolie affichage du plateau du joueur 
     */
    public void afficherPlateau() {
        if (cartesActives.isEmpty()) {
            System.out.println("→ Aucun serviteur sur le plateau.");
        } else {
        	System.out.println("→ Serviteurs sur le plateau :");
            for (int i = 0; i < cartesActives.size(); i++) {
                System.out.println((i + 1) + " - " + cartesActives.get(i));
            }}}

}
