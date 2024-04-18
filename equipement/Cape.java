package equipement;

public enum Cape{
    
    AUCUN("Aucun" ,0  ,0 ,0 ,0);

    private String nom;
    public float vitesse;
    private float manaMax;
    private float bonusGold;
    private float bonusExp;

	private Cape(String nom, float vitesse, float manaMax, float bonusGold, float bonusExp)
	{
        this.nom = nom;
        this.vitesse = vitesse;
        this.manaMax = manaMax;
        this.bonusGold = bonusGold;
        this.bonusExp = bonusExp;
	}
    
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public float getVitesse() {
        return vitesse;
    }
    public void setVitesse(float vitesse) {
        this.vitesse = vitesse;
    }

    public float getmanaMax() {
        return manaMax;
    }
    public void setmanaMax(float manaMax) {
        this.manaMax = manaMax;
    }

    public float getbonusGold() {
        return bonusGold;
    }
    public void setbonusGold(float bonusGold) {
        this.bonusGold = bonusGold;
    }

    public float getbonusExp() {
        return bonusExp;
    }
    public void setbonusExp(float bonusExp) {
        this.bonusExp = bonusExp;
    }
}
