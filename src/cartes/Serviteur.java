package cartes;

import java.util.Random;

import jeu.Hero;
import jeu.Joueur;

/**
 * Classe qui represente les cartes de types Serviteurs
 * @author Fatoumata
 */

public class Serviteur extends Carte{
	
    private int point_de_vie;
    private TypeServiteur type;
	
	
	/**
	 * Constructeur de la classe Serviteur.
	 * Initialise un nouveau serviteur avec un nom, un coût en mana, une puissance d'attaque,
	 * un nombre de points de vie et une action spéciale(eventuellement).
	 * @param n le nom du serviteur
	 * @param m le coût en mana pour jouer cette carte
	 * @param pa les points d'attaque du serviteur
	 * @param pv les points de vie du serviteur
	 * @param as l'action spéciale que peut effectuer ce serviteur (peut être vide)
	 * @author fatoumatasaliatraore
	 */
    public Serviteur(TypeServiteur type) {
        super(type.getNomCarte(), type.getMana());
        this.point_de_vie = type.getPointdevie();
        this.type = type;
    }
    
	public int getPointAttaque() {
		return type.getpointAttaque();
	}
	
	public int getPointVie() {
		return point_de_vie;
	}
	public String getActionSpeciale() {
        return type.getActionSpeciale();
    }
	
	@Override
	public String toString() {
	    return this.getNom() + " [Mana: " + this.getMana() + ", ATK: " + this.getPointAttaque()+
	           ", PV: " + point_de_vie + ", Spé: " + getActionSpeciale() + "]";
	}
	
	/**
	 * Inflige un coup à ce serviteur, en réduisant ses points de vie.
	 * Si les points de vie tombent à zéro ou moins, le serviteur est considéré comme mort.
	 *
	 * @param force la quantité de dégâts reçus
	 */
	public void recevoircoup(int force) {
		point_de_vie=point_de_vie-force;
		if (this.estMort()) {
			System.out.println("Le serviteur"+getNom()+" est mort dans d'attroces souffrance !");
			point_de_vie=0;
		}
	}
	
	/**
	 * Attaque un serviteur adverse en lui infligeant des dégâts
	 * équivalents à la puissance d'attaque de ce serviteur.
	 *
	 * @param cible le serviteur adverse ciblé par l'attaque
	 */
	public void attaquer(Serviteur cible) {
		cible.recevoircoup(type.getpointAttaque());
	}
	
	
	/**
	 * Vérifie si ce serviteur est mort (points de vie égaux à zéro).
	 *
	 * @return true si le serviteur est mort, false sinon
	 */
	public boolean estMort() {
		return point_de_vie<=0;
	}
	
	public void soigner(int montant) {
	    this.point_de_vie += montant;
	}
	
	public void augmenterAttaque(int montant) {
	    type.setpointAttaque(montant);
	}
	
	/**
	 * Fonctionnalite montrant le comportement d'un carte de type serviteur lors d'une attaque 
	 * @param cible
	 * @param lanceur
	 * @param adversaire
	 */
	public void appliquerEffet(Object cible, Joueur lanceur, Joueur adversaire) {
	    if (cible instanceof Serviteur s) {
	        s.recevoircoup(this.getPointAttaque());
	        System.out.println("Le serviteur " + s.getNom() + " a subi une attaque de " + this.getNom());
	        this.recevoircoup(s.getPointAttaque());  // effet 
	        //si le Serviteur adverse meurt il est retirer du plateau du jeu 
	        if (s.estMort()) {
	            adversaire.getPlateau().retirerServiteur(s);
	        }
	        if (this.estMort()) {
	            lanceur.getPlateau().retirerServiteur(this);
	        }

	    } else if (cible instanceof Hero h) {
	        h.recevoirDegats(this.getPointAttaque());
	        System.out.println("Le héros " + h.getNom() + " a subi une attaque de " + this.getNom());
	    }
	}

}
