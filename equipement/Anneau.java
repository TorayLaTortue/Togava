package equipement;

public enum Anneau{
    
    AUCUN("Aucun" ,0  ,0 ,0 ,0),
    ANNEAUJADE("Baguue de jade", 1, 5, 10, 20);

    private String nom;
    public float atk;
    private float tauxCrit;
    private float degatCrit;
    private float ferocity; //Changer cela par de la fero

	private Anneau(String nom, float atk, float tauxCrit, float degatCrit, float ferocity)
	{
        this.nom = nom;
        this.atk = atk;
        this.tauxCrit = tauxCrit;
        this.degatCrit = degatCrit;
        this.ferocity = ferocity;
	}
    
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public float getAtk() {
        return atk;
    }
    public void setAtk(float atk) {
        this.atk = atk;
    }

    public float getTauxCrit() {
        return tauxCrit;
    }
    public void setTauxCrit(float tauxCrit) {
        this.tauxCrit = tauxCrit;
    }

    public float getDegatCrit() {
        return degatCrit;
    }
    public void setDegatCrit(float degatCrit) {
        this.degatCrit = degatCrit;
    }

    public float getFerocity() {
        return ferocity;
    }
    public void setFerocity(float ferocity) {
        this.ferocity = ferocity;
    }
}
