package cartes;

import java.util.Random;

public class Serviteur extends Carte{
	
	protected int point_attaque;
	private int point_de_vie;
	private String action_speciale;
	
	
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
	public Serviteur(String n,int m,int pa,int pv,String as) {
   // TODO document why this constructor is empty
		super(n,m);
		point_attaque=pa;
		point_de_vie=pv;
		action_speciale=as;
	}
	
	public int getPointAttaque() {
		return point_attaque;
	}
	
	public int getPointVie() {
		return point_de_vie;
	}
	 public String getActionSpeciale() {
	        return action_speciale;
	    }
	
	@Override
	public String toString() {
	    return this.getNom() + " [Mana: " + this.getMana() + ", ATK: " + point_attaque +
	           ", PV: " + point_de_vie + ", Spé: " + action_speciale + "]";
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
		cible.recevoircoup(this.point_attaque);
	}
	
	
	/**
	 * Vérifie si ce serviteur est mort (points de vie égaux à zéro).
	 *
	 * @return true si le serviteur est mort, false sinon
	 */
	public boolean estMort() {
		return point_de_vie<=0;
	}
	
	/**
     * Génère un serviteur aléatoire.
     * @return un nouveau serviteur aléatoire
     */
    public static Serviteur genererServiteurAleatoire() {
        String[] noms = {"Soldat Orc", "Mage du Néant", "Chasseur Troll", "Chevalier Spectral"};
        String[] actionsSpe = {"", "Charge", "Provocation", "Râle d’agonie"};
        Random rand = new Random();

        String nom = noms[rand.nextInt(noms.length)];
        int mana = rand.nextInt(6) + 1; // 1 à 6
        int attaque = rand.nextInt(6) + 1;
        int pv = rand.nextInt(6) + 2; // 2 à 7
        String action = actionsSpe[rand.nextInt(actionsSpe.length)];

        return new Serviteur(nom, mana, attaque, pv, action);
    }

}
