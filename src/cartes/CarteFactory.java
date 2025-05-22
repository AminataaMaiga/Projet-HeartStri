package cartes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 * 
 * Classe utilitaire permettant de générer des cartes aléatoires ou prédéfinies.
 * Elle sert à initialiser les decks des joueurs ou le pool de cartes disponible.
 * Fournit des méthodes pour créer des serviteurs, sorts et armes de manière aléatoire.
 * 
 * @author fatoumata
 */
public class CarteFactory {

    private static final Random rand = new Random();

    
    /**
    * Retourne un entier aléatoire entre min et max inclus.
    *
    * @param min valeur minimale
    * @param max valeur maximale
    * @return un entier entre min et max
    */
    public static int rand(int min, int max) {
        return rand.nextInt(max - min + 1) + min;
    }

    
    /**
     * Génère un serviteur aléatoire parmi les types définis (sauf le type SOLDAT).
     *
     * @return une nouvelle instance de Serviteur
     */
    public static Serviteur genererServiteurAleatoire() {
        TypeServiteur[] types = TypeServiteur.values();

        // Filtrer les types pour exclure SOLDAT
        List<TypeServiteur> filtrés = new ArrayList<>();
        for (TypeServiteur t : types) {
            if (!t.equals(TypeServiteur.SOLDAT)) {
                filtrés.add(t);
            }
        }

        // Sélection aléatoire parmi les types filtrés
        TypeServiteur type = filtrés.get(rand.nextInt(filtrés.size()));
        return new Serviteur(type);
    }

    
    /**
     * Génère un sort aléatoire avec un coût en mana compris entre 1 et 3.
     *
     */
    public static Sort genererSortAleatoire() {
        TypeSort[] types = TypeSort.values();
        TypeSort type = types[rand.nextInt(types.length)];
        return new Sort( type, rand(1, 3));
    }

    /**
     * Génère une arme aléatoire parmi les types définis.
     */
    
    public static Arme genererArmeAleatoire() {
        TypeArme[] types = TypeArme.values();
        TypeArme type = types[rand.nextInt(types.length)];
        return new Arme( type);
    }

    /**
     * Génère un ensemble initial de cartes :
     * - 20 serviteurs
     * - 15 armes
     * - 15 sort
     */
    
    public static List<Carte> genererSetInitial() {
        List<Carte> toutes = new ArrayList<>();
        for (int i = 0; i < 20; i++) toutes.add(genererServiteurAleatoire());
        for (int i = 0; i < 15; i++) toutes.add(genererArmeAleatoire());
        for (int i = 0; i < 15; i++) toutes.add(genererSortAleatoire());
        return toutes;
    }

    /**
     * Génère un deck fixe de 30 cartes :
     * - 20 Serviteurs
     * - 5 Sorts
     * - 5 Armes
     */
    public static Deck genererDeckAleatoire() {
        List<Carte> deckCartes = new ArrayList<>();

        for (int i = 0; i < 20; i++) deckCartes.add(genererServiteurAleatoire());
        for (int i = 0; i < 5; i++) deckCartes.add(genererSortAleatoire());
        for (int i = 0; i < 5; i++) deckCartes.add(genererArmeAleatoire());

        Deck deck = new Deck();
        deck.setCartes(deckCartes);
        return deck;
    }

    
}
