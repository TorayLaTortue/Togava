package equipement;

public enum Cape{
    
    AUCUN("Aucun" ,0  ,0 ,0 ,0);

    private String nom;
    public float vie;
    private float voleVie;
    private float regenVie;
    private float vitality;



	private Cape(String nom, float vie, float voleVie, float regenVie, float vitality)
	{
        this.nom = nom;
        this.vie = vie;
        this.voleVie = voleVie;
        
	}
    
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
}
