package jeu;

import java.util.ArrayList;
import java.util.List;
import cartes.*;
/**
 * @author Amayel
 */

public class Main {
    private List<Carte> cartesEnMain;

    public Main() {
        cartesEnMain= new ArrayList<>();
    }
    /**
     * Ajout d'une carte à la main
     * @param c La carte à jouer
     */
    public void ajouterCarte(Carte c) {
    	if (cartesEnMain.size() < 10) { // Limite de 10 cartes en main
    		cartesEnMain.add(c);
         } else {
             System.out.println("La main est pleine ! Impossible d'ajouter la carte : " + c.getNom());
         }
   
    }
    
    /**
     * Retire une carte de la main.
     * @param c La carte à retirer.
     */
    
    public void retirerCarte(Carte c) {
    	cartesEnMain.remove(c);
    }
    
    
    /**
     * Vérifie si une carte est présente dans la main.
     * @param c La carte à vérifier.
     * @return true si présente, false sinon.
     */
    
    public boolean estDansMain(Carte c) {
        return cartesEnMain.contains(c);
    }

    /**
     * Donne la taille actuelle de la main.
     * @return nombre de cartes.
     */
    
    public int taille() {
        return cartesEnMain.size();
    }

    /**
     * Vérifie si la main est vide.
     * @return true si vide, false sinon.
     */
    
    public boolean estVide() {
        return cartesEnMain.isEmpty();
    }

    /**
     * Récupère les cartes présentes en main.
     * @return liste des cartes.
     */
    
    public List<Carte> getCartes() {
        return cartesEnMain;
    }

    /**
     * Affiche les cartes en main.
     */
    
    public void afficherMain() {
        System.out.println("Cartes en main :");
        for (Carte c : cartesEnMain) {
            System.out.println("- " + c.getNom() + " (Mana : " + c.getMana() + ")");
        }
    }
 
    /**
     * Retourne la liste des cartes dans la main.
     * @return Liste de cartes
     */
   
}