package cartes;

import jeu.Hero;
import jeu.Joueur;
/**
 * 
 * /**
 * Classe représentant une carte de type Sort.
 * Un sort a un type (dégât, soin, boost), un nombre d'utilisations, et applique un effet
 * immédiat sur une cible (héros ou serviteur) lors de son activation.
 * 
 * @author Aminata
 */
public class Sort extends Carte {
	
	private TypeSort type;
    private int nbUtilisation;

    /**
     * Constructeur d’un sort à partir de son type et de son nombre d’utilisations.
     *
     * @param type le type du sort
     * @param nbUtilisation le nombre d’utilisations possibles
     */
    public Sort( TypeSort type, int nbUtilisation) {
        super(type.getNomCarte(), 0);
        this.type = type;
        this.nbUtilisation = nbUtilisation;
    }

    public String getEffet() {
        return type.getEffet();
    }
    
    public TypeSort getType() {
    	return this.type;
    }
    
    public int getNbUtilisation() {
    	return this.nbUtilisation;
    }
    public void setnb_utilisation() {
    	this.nbUtilisation--;
    }
    @Override
    public String toString() {
        return getNom() + " [Mana: " + getMana() + ", Type: " + type.name() +
               ", Effet: " + type.getEffet() + ", Utilisations: " + nbUtilisation + "]";
    }

    /**
     * Applique l'effet du sort à la cible (Serviteur ou Héros).
     * Le comportement dépend du type du sort (DÉGAT, SOIN, BOOST).
     * Après application, décrémente l’utilisation et retire le sort s’il est épuisé.
     *
     * @param cible l’objet ciblé (Serviteur ou Hero)
     * @param lanceur le joueur qui utilise le sort
     * @param cibleJoueur le joueur possédant la cible (utile pour retirer la carte morte)
     */
    public void appliquerEffet(Object cible, Joueur lanceur, Joueur cibleJoueur) {
        String nomSort = this.getType().getNomCarte();
        int force = this.getType().getForce();

        switch (this.getType()) {
            case DEGAT -> {
                if (cible instanceof Hero h) {
                    h.recevoirDegats(force);
                    System.out.println("→ " + nomSort + " inflige " + force + " dégâts au héros " + h.getNom());
                } else if (cible instanceof Serviteur s) {
                    s.recevoircoup(force);
                    System.out.println("→ " + nomSort + " inflige " + force + " dégâts à " + s.getNom());
                    if (s.estMort()) {
                        cibleJoueur.getMain().retirerCarte(s);
                        System.out.println("☠️ " + s.getNom() + " est mort.");
                    }
                }
            }

            case SOIN -> {
                if (cible instanceof Hero h) {
                    h.soigner(force);
                    System.out.println("→ " + nomSort + " soigne le héros " + h.getNom() + " de " + force + " PV");
                } else if (cible instanceof Serviteur s) {
                    s.soigner(force);
                    System.out.println("→ " + nomSort + " soigne " + s.getNom() + " de " + force + " PV");
                }
            }

            case BOOST_ATTAQUE -> {
                if (cible instanceof Serviteur s) {
                    s.augmenterAttaque(force);
                    System.out.println("→ " + nomSort + " augmente l'attaque de " + s.getNom() + " de " + force);
                } else {
                    System.out.println("Boost ne peut être appliqué que sur un serviteur.");
                    return;
                }
            }
        }

        // Consommer le sort
        this.setnb_utilisation();
        if (this.getNbUtilisation() <= 0) {
            lanceur.getMain().retirerCarte(this);
            System.out.println("️Le sort " + nomSort + " a été retiré (plus d'utilisations).");
        }
    }

    
}
