package cartes;
/**
 * 
 * Enumération représentant les différents types d’armes disponibles dans le jeu.
 * Chaque arme a un nom, un effet spécial, une puissance (dégâts) et un nombre d’utilisations.
 * Ces constantes sont utilisées dans la classe `Arme` pour définir leur comportement.
 * 
 * @author Amayel
 */
public enum TypeArme {
    LAME_RUNIQUE("Lame Runique","Effet rune impie",1,3),
    MARTEAU_GUERRE("Marteau de Guerre","Durabilité +",4,1),
    DAGUE_EMPOISONNEE("Dague empoisonnée", "Détruit les serviteurs attaqués",3,2),
    EPEE_DU_DESTIN("Epee du destin","inflige 2 degat au heros adverse",2,2),
	GANT_DE_THANOS("Gant de Thanos","Tue le heros, Mort subite ",15,1);
	

    private final String effetSpecial;
    private final String nomCarte;
    private final int degats;
    private  int nbUtilisation;
    
    /**
     * Constructeur de chaque type d’arme.
     *
     * @param nom le nom de la carte
     * @param effet la description de l’effet spécial
     * @param degats les points de dégâts infligés par l’arme
     * @param nbutilisation le nombre d’utilisations autorisées
     */
    TypeArme(String nom,String effet,int degats,int nbutilisation) {
        this.effetSpecial = effet;
        this.nomCarte=nom;
        this.degats=degats;
        this.nbUtilisation=nbutilisation;
    }

    /**
     * Retourne l’effet spécial de l’arme.
     * @return une chaîne descriptive
     */
    public String getEffetSpecial() {
        return effetSpecial;
    }
    
    public String getNom() {
    	return this.nomCarte;
    }
    
    /**
     * Retourne les dégâts de l’arme.
     * @return un entier représentant la force de l’arme
     */
    
    public int getdegat() {
    	return degats;
    }
    /**
    * Retourne le nombre d’utilisations autorisées.
    */
    public int getNbUtilisation() {
    	return this.nbUtilisation;
    }
}

