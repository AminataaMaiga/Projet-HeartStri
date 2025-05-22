package cartes;

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

    TypeArme(String nom,String effet,int degats,int nbutilisation) {
        this.effetSpecial = effet;
        this.nomCarte=nom;
        this.degats=degats;
        this.nbUtilisation=nbutilisation;
    }

    public String getEffetSpecial() {
        return effetSpecial;
    }
    
    public String getNom() {
    	return this.nomCarte;
    }
    public int getdegat() {
    	return degats;
    }
    public int getNbUtilisation() {
    	return this.nbUtilisation;
    }
}

