package cartes;
/**
 * 
 * Classe représentant un deck.
 * Il contient une liste de cartes jouables, et permet d’ajouter, tirer ou afficher des cartes.
 * Utilisé comme bibliothèque personnelle d’un joueur au début de la partie.
 * 
 * @author fatoumata
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {
	private List<Carte> cartes = new ArrayList<>();

	/**
     * Renvoie la liste complète des cartes du deck.
     * @return une liste de cartes
     */
	
    public List<Carte> getCartes() {
        return cartes;
    }

    /**
    * Ajoute une carte au deck.
    * @param c la carte à ajouter
    */
    public void ajouterCarte(Carte c) {
        cartes.add(c);
    }
    
    /**
     * Tire une carte aléatoire du deck et la retire de la liste.
     * @return une carte tirée aléatoirement ou null si le deck est vide
     */

    public Carte tirerCarteAleatoire() {
        if (cartes.isEmpty()) return null;
        Random rand = new Random();
        int index = rand.nextInt(cartes.size());
        return cartes.remove(index);
    }

    /**
     * Remplace la liste des cartes du deck par une nouvelle.
     * @param cartes la nouvelle liste à affecter
     */
    public void setCartes(List<Carte> cartes) {
        this.cartes = cartes;
    }

    /**
     * Affiche toutes les cartes du deck dans la console.
     */
    public void afficherDeck() {
        for (Carte c : cartes) {
            System.out.println(" - " + c);
        }
    }
    
    /**
    * Vérifie si au moins un serviteur est présent dans le deck.
    * Utile pour certains pouvoir heroique ou règles du jeu.
    *
    * @return true s’il existe au moins un serviteur, false sinon
    */
    public boolean existeServiteur() {
        for (Carte c : cartes) {
            if (c instanceof Serviteur) {
                return true;
            }
        }
        return false;
    }

}
