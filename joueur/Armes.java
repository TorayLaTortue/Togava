package joueur;

public enum Armes
{
	AUCUNE("aucune", 0, 0, 0, 0)
	, EPEEBOIS("une épée en bois", 2, 0, 0, 0), EPEEPIERRE("une épée en pierre", 3, 1, 0, 1) , CLAYMORE("une claymore", 9, 0, 0, 3)
	, DAGUEROUILLE("une dague rouillé", 1, 2, 0, 0)
	, SCEPTRET1("un sceptre magique de débutant", 3, 2,  1, 0);
	
	private String nom;
	private int dégats;
	private int vitesse;
	private int coutMana;
	private int couts;
	
	
	private Armes(String nom, int dégats, int vitesse, int coutMana, int couts)
	{
		this.nom = nom;
		this.dégats = dégats;
		this.vitesse = vitesse;
		this.coutMana = coutMana;
		this.setCouts(couts);
	}

	
	public int getDégats()
	{
		return dégats;
	}

	public void setDégats(int dégats)
	{
		this.dégats = dégats;
	}

	public int getVitesse()
	{
		return vitesse;
	}

	public void setVitesse(int vitesse)
	{
		this.vitesse  = vitesse;
	}
	
	
	public String getNom()
	{
		return nom;
	}

	public void setNom(String nom)
	{
		this.nom = nom;
	}

	public int getCoutMana()
	{
		return coutMana;
	}

	public void setCoutMana(int coutMana)
	{
		this.coutMana = coutMana;
	}

	public int getCouts()
	{
		return couts;
	}


	public void setCouts(int couts)
	{
		this.couts = couts;
	}

	
	
}
