package jeu;

import cartes.Serviteur;
import java.util.ArrayList;
import java.util.List;

public class Plateau {
    private List<Serviteur> cartesActives;//Carte serviteur invoquer sur le plateau 

    public Plateau() {
        this.cartesActives = new ArrayList<>();
    }

    /**|
     * 
     * @param s
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
     * @param s
     */
    public void retirerServiteur(Serviteur s) {
        cartesActives.remove(s);
    }
    /**
     * 
     * @return
     */
    public List<Serviteur> getServiteurs() {
        return cartesActives;
    }
    
    /**
     * 
     */
  
    public void afficherPlateau() {
        if (cartesActives.isEmpty()) {
            System.out.println("→ Aucun serviteur sur le plateau.");
        } else {
        	System.out.println("→ Serviteurs sur le plateau :");
            for (int i = 0; i < cartesActives.size(); i++) {
                System.out.println((i + 1) + " - " + cartesActives.get(i));
            }
        }
    }

}
