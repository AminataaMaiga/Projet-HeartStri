package cartes;

/**
 * 
 * * Enumération représentant les types de serviteurs disponibles dans le jeu.
 * Chaque type définit un modèle de serviteur avec :
 * - un nom
 * - une action spéciale (textuelle)
 * - une puissance d’attaque
 * - un coût en mana
 * - un nombre de points de vie
 *
 * Ces types sont utilisés comme base pour instancier les objets `Serviteur`.
 * 
 * @author fatimata
 */
public enum TypeServiteur {
    ORC("Orc", "Charge",3,2,10),
    DRAGON("Dragon", "Vol de vie",2,5,15),
    TROLL("Troll", "Provocation",5,4,9),
    SPECTRE("Spectre", "Râle d’agonie",4,3,8),
    PACIFISTE("Pacifiste", "Aucun effet",1,0,5),
	SOLDAT("Soldat","Aucun effet", 2, 1, 1 );


    private final String nomCarte;
    private final String actionSpeciale;
    private int point_attaque;
    private int Mana;
    private int pointdevie;
    
    /**
     * Constructeur de l’énumération TypeServiteur.
     *
     * @param nomCarte nom affiché de la carte
     * @param actionSpeciale effet spécial associé au type
     * @param pa points d’attaque
     * @param mana coût en mana
     * @param pdvie points de vie
     */
    TypeServiteur(String nomCarte, String actionSpeciale,int pa,int mana,int pdvie) {
        this.nomCarte = nomCarte;
        this.actionSpeciale = actionSpeciale;
        this.point_attaque=pa;
        this.Mana=mana;
        this.pointdevie=pdvie;
    }

    public String getNomCarte() {
        return nomCarte;
    }

    public String getActionSpeciale() {
        return actionSpeciale;
    }
    
    public int getpointAttaque() {
    	return this.point_attaque;
    }
    
    public int getMana() {
    	return Mana;
    }
    
    public void setpointAttaque(int x) {
    	this.point_attaque+=x;
    }
    public int getPointdevie() {
    	return this.pointdevie;
    }
}
