package cartes;

import jeu.Hero;
import jeu.Joueur;

public class Arme extends Carte {
	 private int nbUtilisation;
	 private TypeArme type;

	    public Arme( TypeArme type) {
	        super(type.getNom(), 0);
	        this.nbUtilisation = type.getNbUtilisation();
	        this.type = type;
	    }

	    public String getEffetSpecial() {
	        return type.getEffetSpecial();
	    }

	    @Override
	    public String toString() {
	        return getNom() + " [Mana: " + getMana() + ", ATK: " + type.getdegat() +
	               ", Utilisations: " + nbUtilisation + ", Spé: " + type.getEffetSpecial() + "]";
	    }
	    
	    public TypeArme getTypeArme(){
	    	return type;
	    }
	    
	    public void setnbutilisation() {
	    	this.nbUtilisation--;
	    }
	    public int getNbuUtilisation() {
	    	return this.nbUtilisation;
	    }
	    public void appliquerEffet(Object cible, Joueur lanceur, Joueur adversaire) {
	        int degats = this.getTypeArme().getdegat();

	        if (cible instanceof Serviteur s) {
	            s.recevoircoup(degats);
	            System.out.println("Le serviteur " + s.getNom() + " a subi " + degats + " dégâts de l’arme " + this.getNom());

	            if (s.estMort()) {
	                adversaire.getMain().retirerCarte(s);
	            }

	        } else if (cible instanceof Hero h) {
	            h.recevoirDegats(degats);
	            System.out.println("Le héros " + h.getNom() + " a subi " + degats + " dégâts de l’arme " + this.getNom());
	        }

	        this.setnbutilisation();

	        // Supprimer l'arme si plus utilisable
	        if (this.nbUtilisation <= 0) {
	            lanceur.getMain().retirerCarte(this);
	            System.out.println("L'arme " + this.getNom() + " a été détruite.");
	        }
	    }


}
