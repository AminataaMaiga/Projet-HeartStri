package cartes;
/**
 * 
 * Enumération représentant les différents types de sorts disponibles dans le jeu.
 * Chaque sort possède :
 * - un nom (pour l'affichage),
 * - un effet textuel (descriptif),
 * - une force (valeur numérique appliquée à l’effet).
 * 
 * Ces types sont utilisés dans la classe `Sort` pour déterminer le comportement
 * des cartes de type sort au moment de leur utilisation.
 * 
 * @author Aminata
 */
public enum TypeSort {
    DEGAT("Degat","Inflige des dégâts de 2 point",2),
    SOIN("Soin","Soigne le serviteur ou le hero de votre choix : ajoute 3 point de vie ",3),
    BOOST_ATTAQUE("Boost","Augmente l'attaque de 1",1);

	private final String nomCarte;
    private final String effet;
    private final int f;
    
    /**
     * Constructeur pour initialiser un type de sort.
     *
     * @param nomCarte le nom du sort
     * @param effet une description de son action
     * @param force la valeur chiffrée appliquée par le sort
     */
    
    TypeSort(String nomCarte, String effet,int force) {
        this.nomCarte = nomCarte;
        this.effet = effet;
        this.f=force;
    }

    public String getNomCarte() {
        return nomCarte;
    }

    public String getEffet() {
        return effet;
    }
    public int getForce() {
    	return f;
    }
}
