package cartes;

public enum TypeSort {
    DEGAT("Degat","Inflige des dégâts de 2 point",2),
    SOIN("Soin","Soigne le serviteur ou le hero de votre choix : ajoute 3 point de vie ",3),
    BOOST_ATTAQUE("Boost","Augmente l'attaque de 1",1);

	private final String nomCarte;
    private final String effet;
    private final int f;

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
