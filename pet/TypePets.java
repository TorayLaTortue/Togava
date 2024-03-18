package pet;

public enum TypePets {
    
    AUCUN("", 0, 0, 0),
    TORTUE("Tortue", 2 , 1, 5),
    BAT("chauve-souris", 4, 3, 7);
	
	private String nom;
	private int atk;
	private int vitesse;
    private int defense;
	
	private TypePets(String nom, int atk, int vitesse, int defense)
	{
	this.nom = nom;
	this.atk = atk;
	this.vitesse = vitesse;
	this.defense = defense;
	}
	
	public String getNom()
	{
		return nom;
	}
	public void setNom(String nom)
	{
		this.nom = nom;
	}
    public int getAtk() {
        return atk;
    }
    public void setAtk(int atk) {
        this.atk = atk;
    }
    public int getVitesse() {
        return vitesse;
    }
    public void setVitesse(int vitesse) {
        this.vitesse = vitesse;
    }
    public int getDefense() {
        return defense;
    }
    public void setDefense(int defense) {
        this.defense = defense;
    }
}


