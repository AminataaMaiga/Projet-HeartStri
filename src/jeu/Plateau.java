package jeu;

import java.util.ArrayList;
import java.util.List;
import cartes.Serviteur;
/**
 * @author Fatoumata
 */

public class Plateau {
    private List<Serviteur> serviteurs;

    public Plateau() {
        serviteurs = new ArrayList<>();
    }

    public void ajouterServiteur(Serviteur s) {
        serviteurs.add(s);
    }

    public void retirerServiteur(Serviteur s) {
        serviteurs.remove(s);
    }

    public List<Serviteur> getServiteurs() {
        return serviteurs;
    }

    public void afficherPlateau() {
    	System.out.println("Vous disposez de : \n");
        for (Serviteur s : serviteurs) {
            System.out.println(" -" + s);
        }
    }
}
