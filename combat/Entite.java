package combat;

public class Entite {
    private float action;
    private String nom;

    public Entite() {
        
    }

    public float getAction() {
        action = (float) Math.round(action * 10.0f) / 10.0f;
        return action;
    }
    public void setAction(float action) {
        if(action < 0)
        {
            action = 0;
        }
        action = (float) Math.round(action * 10.0f) / 10.0f;
        this.action = action;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
}
