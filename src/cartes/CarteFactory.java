package cartes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Classe utilitaire pour générer aléatoirement des cartes du jeu :
 * - Serviteurs
 * - Sorts
 * - Armes
 * Elle permet aussi de constituer un set initial et des decks personnalisés.
 */
public class CarteFactory {

    private static final Random rand = new Random();

    /**
     * Génère un entier aléatoire entre min et max (inclus).
     * @param min valeur minimale
     * @param max valeur maximale
     * @return nombre aléatoire entre min et max
     */
    public static int rand(int min, int max) {
        return rand.nextInt(max - min + 1) + min;
    }

    public static Serviteur genererServiteurAleatoire() {
        TypeServiteur[] types = TypeServiteur.values();
        TypeServiteur type = types[rand.nextInt(types.length)];

        String nom = type.getNomCarte(); // nom fixe directement lié au type
        int mana = rand(2, 6);
        int attaque = rand(1, 5);
        int pv = rand(3, 7);

        return new Serviteur(type);
    }


    /**
     * Génère un sort aléatoire en fonction des types définis dans l'enum.
     * @return une instance de Sort
     */
    public static Sort genererSortAleatoire() {
        TypeSort[] types = TypeSort.values();
        TypeSort type = types[rand.nextInt(types.length)];
        return new Sort(rand(1, 5), type, rand(1, 3));
    }

    /**
     * Génère une arme aléatoire avec un type et des stats diverses.
     * @return une instance de Arme
     */
    public static Arme genererArmeAleatoire() {
        TypeArme[] types = TypeArme.values();
        TypeArme type = types[rand.nextInt(types.length)];
        return new Arme(rand(1, 4), rand(1, 3), type);
    }

    /**
     * Génère un set initial de cartes contenant :
     * - 20 serviteurs
     * - 15 sorts
     * - 15 armes
     * @return une liste de 50 cartes aléatoires de différents types
     */
    public static List<Carte> genererSetInitial() {
        List<Carte> toutes = new ArrayList<>();

        for (int i = 0; i < 20; i++) toutes.add(genererServiteurAleatoire());
        for (int i = 0; i < 15; i++) toutes.add(genererArmeAleatoire());
        for (int i = 0; i < 15; i++) toutes.add(genererSortAleatoire());

        return toutes;
    }

    /**
     * Construit un deck aléatoire à partir d'une liste de cartes (pool).
     * Les cartes sélectionnées sont supprimées de la copie locale du pool.
     * @param pool la liste de cartes disponible
     * @param nbCartes le nombre de cartes à inclure dans le deck
     * @return un objet Deck contenant les cartes choisies
     */
    public static Deck genererDeckAleatoire(List<Carte> pool, int nbCartes) {
        List<Carte> copie = new ArrayList<>(pool); // pour ne pas modifier la liste originale
        List<Carte> deckCartes = new ArrayList<>();

        for (int i = 0; i < nbCartes && !copie.isEmpty(); i++) {
            int index = rand.nextInt(copie.size());
            deckCartes.add(copie.remove(index)); // extrait une carte au hasard
        }

        Deck deck = new Deck();
        deck.setCartes(deckCartes);
        return deck;
    }
}
