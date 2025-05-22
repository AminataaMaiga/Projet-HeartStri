package cartes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarteFactory {

    private static final Random rand = new Random();

    public static int rand(int min, int max) {
        return rand.nextInt(max - min + 1) + min;
    }

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


    public static Sort genererSortAleatoire() {
        TypeSort[] types = TypeSort.values();
        TypeSort type = types[rand.nextInt(types.length)];
        return new Sort( type, rand(1, 3));
    }

    public static Arme genererArmeAleatoire() {
        TypeArme[] types = TypeArme.values();
        TypeArme type = types[rand.nextInt(types.length)];
        return new Arme( type);
    }

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

    /**
    // Ancienne méthode conservée si tu veux encore générer un deck à partir d'une pool
    public static Deck genererDeckAleatoire(List<Carte> pool, int nbCartes) {
        List<Carte> copie = new ArrayList<>(pool);
        List<Carte> deckCartes = new ArrayList<>();
        for (int i = 0; i < nbCartes && !copie.isEmpty(); i++) {
            int index = rand.nextInt(copie.size());
            deckCartes.add(copie.remove(index));
        }
        Deck deck = new Deck();
        deck.setCartes(deckCartes);
        return deck;
    }
    */
}
