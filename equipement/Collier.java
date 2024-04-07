package equipement;

public enum Collier{
    
    AUCUN("Aucun" ,0  ,0 ,0 ,0);

    private String nom;
    public float vie;
    private float voleVie;
    private float regenVie;
    private float vitality;

	private Collier(String nom, float vie, float voleVie, float regenVie, float vitality)
	{
        this.nom = nom;
        this.vie = vie;
        this.voleVie = voleVie;
        this.regenVie = regenVie;
        this.vitality = vitality;
	}
    
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public float getVie() {
        return vie;
    }
    public void setVie(float vie) {
        this.vie = vie;
    }

    public float getVoleVie() {
        return voleVie;
    }
    public void setVoleVie(float voleVie) {
        this.voleVie = voleVie;
    }

    public float getRegenVie() {
        return regenVie;
    }
    public void setRegenVie(float regenVie) {
        this.regenVie = regenVie;
    }

    public float getVitality() {
        return vitality;
    }
    public void setVitality(float vitality) {
        this.vitality = vitality;
    }
}
