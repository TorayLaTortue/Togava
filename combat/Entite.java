package combat;

public class Entite {
    private float action;
    private String nom;

    // Constructeur
    public Entite() {
        
    }

    // Méthode pour récupérer l'action
    public float getAction() {
        return action;
    }
    public void setAction(float action) {
        this.action = action;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
}
