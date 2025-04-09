package cartes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Représente un deck de cartes pour le jeu. Ce deck est capable de gérer un ensemble de serviteurs.
 */
public class Deck {
    // Liste pour stocker les cartes du deck.
    private List<Serviteur> cartes = new ArrayList<>();

    /**
     * Ajoute une carte au deck.
     *
     * @param s Le serviteur à ajouter au deck.
     */
    public void ajouterCarte(Serviteur s) {
        getCartes().add(s);
    }

    /**
     * Tire une carte aléatoire du deck et la supprime de la liste.
     *
     * @return Le serviteur tiré aléatoirement du deck, ou null si le deck est vide.
     */
    public Serviteur tirerCarteAleatoire() {
        if (getCartes().isEmpty()) {
            return null; // Gestion du cas où le deck est vide.
        }
        Random rand = new Random();
        int index = rand.nextInt(getCartes().size());
        return getCartes().remove(index);
    }

    /**
     * Génère un deck de serviteurs de manière aléatoire.
     *
     * @param nbCartes Le nombre de cartes à générer aléatoirement et à ajouter au deck.
     */
    public void genererDeckAleatoire(int nbCartes) {
        for (int i = 0; i < nbCartes; i++) {
            Serviteur serviteur = this.creerServiteurAleatoire();
            ajouterCarte(serviteur);
        }
    }

    /**
     * Crée un serviteur avec des attributs aléatoires. Cette méthode est temporaire
     * et devrait être remplacée par une méthode appropriée fournie par une autre classe.
     *
     * @return Un nouveau serviteur avec des attributs aléatoires.
     */
    private Serviteur creerServiteurAleatoire() {
        Random rand = new Random();
        String nom = "Serviteur " + rand.nextInt(100);
        int mana = rand.nextInt(10) + 1;  // Mana entre 1 et 10
        int attaque = rand.nextInt(5) + 1;  // Attaque entre 1 et 5
        int vie = rand.nextInt(10) + 1;  // Vie entre 1 et 10
        return new Serviteur(nom, mana, attaque, vie, "Aucune");
    }

    /**
     * Affiche les informations de toutes les cartes dans le deck.
     */
    public void afficherDeck() {
        for (Serviteur s : getCartes()) {
            System.out.println(s);
        }
    }

	public List<Serviteur> getCartes() {
		return cartes;
	}

	public void setCartes(List<Serviteur> cartes) {
		this.cartes = cartes;
	}
}
