package jeu;

import java.util.ArrayList;
import java.util.List;
import cartes.*;
import java.io.Serializable;
/**
 * Classe represenant les cartes dans la main d'un joueur au cour du jeu  
 * @author Amayel
 */

public class Main implements Serializable {
    private static final long serialVersionUID = 1L;
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
     * Retourne la carte à l'indice donné dans la main.
     * @param index position de la carte (0-based)
     * @return la carte à cette position, ou null si l'indice est invalide
     */
    public Carte getCarte(int index) {
        if (index >= 1 && index <= cartesEnMain.size()) {
            return cartesEnMain.get(index - 1);
        } else {
            System.out.println(" Indice invalide : " + index);
            return null;
        } }
    
    public int nombreCarteMain() {
    	return this.cartesEnMain.size();}

    /**
     * Affiche les cartes en main.
     */
    public void afficherMain() {
    	if(estVide()) {
    		System.out.println("→ Votre main est vide.");
    	}else {
    		System.out.println("→ Cartes en main :");
    		for (int i = 0; i < cartesEnMain.size(); i++) {
                Carte c = cartesEnMain.get(i);
                String type = (c instanceof Sort) ? "[Sort]" : (c instanceof Arme) ? "[Arme]" : "[Serviteur]";
                System.out.printf("   %d - %s %s%n", i + 1, type, c);
            }}}
    /**
     * Récupère uniquement les cartes de type Serviteur dans la main.
     * @return liste des serviteurs.
     */
    public List<Carte> getServiteurs() {
        List<Carte> serviteurs = new ArrayList<>();
        for (Carte c : cartesEnMain) {
            if (c instanceof Serviteur) {
                serviteurs.add(c);
            }
        }
        return serviteurs;
    }

    /**
     * Récupère uniquement les cartes de type Sort dans la main.
     * @return liste des sorts.
     */
    public List<Carte> getSorts() {
        List<Carte> sorts = new ArrayList<>();
        for (Carte c : cartesEnMain) {
            if (c instanceof Sort) {
                sorts.add(c);
            }}
        return sorts;}

    /**
     * Récupère uniquement les cartes de type Arme dans la main.
     * @return liste des armes.
     */
    public List<Carte> getArmes() {
        List<Carte> armes = new ArrayList<>();
        for (Carte c : cartesEnMain) {
            if (c instanceof Arme) {
                armes.add(c);
            }}
        return armes;}
}