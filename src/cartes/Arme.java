package cartes;

import jeu.Hero;
import jeu.Joueur;
/**
 * Classe représentant une carte Arme dans le jeu.
 * Une Arme permet à un héros d’infliger des dégâts à une cible (Serviteur ou Héros).
 * Elle possède un nombre limité d’utilisations, des dégâts, et un effet spécial.
 *
 *@author Amayel
 */
public class Arme extends Carte {
	 private int nbUtilisation;  
	 private TypeArme type;    

 /**
* Constructeur d'une carte Arme.
* Initialise une arme à partir de son type.
* Le nom et le mana sont hérités depuis le type.
* @param type le TypeArme contenant les caractéristiques de l’arme
 */
	    public Arme( TypeArme type) {
	        super(type.getNom(), 0);   
	        this.nbUtilisation = type.getNbUtilisation();  
	        this.type = type;     
	    }
 /**
* Retourne la description de l'effet spécial de l'arme.
* @return une chaîne décrivant l’effet spécial
*/
	    public String getEffetSpecial() {
	        return type.getEffetSpecial();
	    }
/**
* Représente l’arme sous forme de texte pour affichage console ou interface.
*
* @return une chaîne avec le nom, les caractéristiques et l’effet
 */
	    @Override
	    public String toString() {
	        return getNom() + " [Mana: " + getMana() + ", ATK: " + type.getdegat() +
	               ", Utilisations: " + nbUtilisation + ", Spé: " + type.getEffetSpecial() + "]";
	    }
	    /**
	     * Retourne le type d’arme associé à cette carte.
	     *
	     * @return un objet TypeArme
	     */
	    
	    public TypeArme getTypeArme(){
	    	return type;
	    }
	    /**
	     * Décrémente le nombre d’utilisations de l’arme.
	     */
	    public void setnbutilisation() {
	    	this.nbUtilisation--;
	    }
	    /**
	     * Retourne le nombre d’utilisations restantes.
	     *
	     * @return un entier représentant les utilisations restantes
	     */
	    public int getNbuUtilisation() {
	    	return this.nbUtilisation;
	    }
	    
	    /**
	     * Applique l’effet de l’arme sur une cible (Serviteur ou Héros).
	     * Inflige des dégâts, puis réduit les utilisations restantes.
	     * Détruit l’arme si elle n’a plus d’utilisations.
	     *
	     * @param cible      la cible (Serviteur ou Héros)
	     * @param lanceur    le joueur qui utilise l’arme
	     * @param adversaire le joueur qui reçoit l’effet
	     */
	    
	    public void appliquerEffet(Object cible, Joueur lanceur, Joueur adversaire) {
	        int degats = this.getTypeArme().getdegat();

	     // Si la cible est un serviteur, on lui inflige les dégâts
	        if (cible instanceof Serviteur s) {
	            s.recevoircoup(degats);
	            System.out.println("Le serviteur " + s.getNom() + " a subi " + degats + " dégâts de l’arme " + this.getNom());
	            
	      // Si le serviteur meurt, on le retire de la main de l’adversaire
	            if (s.estMort()) {
	                adversaire.getMain().retirerCarte(s);
	            }

	        } else if (cible instanceof Hero h) {
	        	// Si la cible est un héros, on applique les dégâts au héros
	            h.recevoirDegats(degats);
	            System.out.println("Le héros " + h.getNom() + " a subi " + degats + " dégâts de l’arme " + this.getNom());
	        }

	     // On réduit le nombre d’utilisations après l’attaque
	        this.setnbutilisation();

	     // Si l’arme est usée, on la retire de la main du lanceur
	        if (this.nbUtilisation <= 0) {
	            lanceur.getMain().retirerCarte(this);
	            System.out.println("L'arme " + this.getNom() + " a été détruite.");
	        }
	    }


}
