package equipement;

public enum Anneau{
    
    AUCUN("Aucun" ,0  ,0 ,0 ,0),
    ANNEAUJADE("Baguue de jade", 1, 5, 10, 20);

    private String nom;
    public float atk;
    private float tauxCrit;
    private float degatCrit;
    private float atkSuivie;

	private Anneau(String nom, float atk, float tauxCrit, float degatCrit, float atkSuivie)
	{
        this.nom = nom;
        this.atk = atk;
        this.tauxCrit = tauxCrit;
        this.degatCrit = degatCrit;
        this.atkSuivie = atkSuivie;
	}
    
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public float getatk() {
        return atk;
    }
    public void setatk(float atk) {
        this.atk = atk;
    }

    public float gettauxCrit() {
        return tauxCrit;
    }
    public void settauxCrit(float tauxCrit) {
        this.tauxCrit = tauxCrit;
    }

    public float getdegatCrit() {
        return degatCrit;
    }
    public void setdegatCrit(float degatCrit) {
        this.degatCrit = degatCrit;
    }

    public float getatkSuivie() {
        return atkSuivie;
    }
    public void setatkSuivie(float atkSuivie) {
        this.atkSuivie = atkSuivie;
    }
}
