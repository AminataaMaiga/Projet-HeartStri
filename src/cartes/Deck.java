package cartes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {
    private List<Carte> cartes = new ArrayList<>();

    public List<Carte> getCartes() {
        return cartes;
    }

    public void ajouterCarte(Carte c) {
        cartes.add(c);
    }

    public Carte tirerCarteAleatoire() {
        if (cartes.isEmpty()) return null;
        Random rand = new Random();
        int index = rand.nextInt(cartes.size());
        return cartes.remove(index);
    }

    public void setCartes(List<Carte> cartes) {
        this.cartes = cartes;
    }

    public void afficherDeck() {
        for (Carte c : cartes) {
            System.out.println(" - " + c);
        }
    }
}
