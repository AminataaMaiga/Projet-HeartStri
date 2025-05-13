package jeu;

import java.util.ArrayList;
import java.util.List;
import cartes.Carte;
/**
 * @author Amayel
 */

public class Main {
    private List<Carte> cartes;

    public Main() {
        cartes = new ArrayList<>();
    }
    
    public void ajouterCarte(Carte c) {
   
    }
    
    public void retirerCarte(Carte c) {
    	
    }
    
    public boolean estDansMain(Carte c) {
    	//a changer , focntion visant a savori si la carte c passer en paramettre est dans la main
    	//n'oublie pas de commenter tes focntion 
    	return true;
    }
 
    /**
     * Retourne la liste des cartes dans la main.
     * @return Liste de cartes
     */
    public List<Carte> getCartes() {
        return cartes;
    }

    /**
     * Affiche toutes les cartes présentes dans la main.
     */
    public void afficherMain() {
        for (Carte c : cartes) {
            System.out.println("");
        }
    }
}