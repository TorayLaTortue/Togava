package joueur;

public enum Armes
{
	AUCUNE("aucune", 1, 0) , EPEE("une épée", 3, 1) , CLAYMORE("une claymore", 9, 3);
	
	private String nom;
	private int dégats;
	private int couts;
	
	
	private Armes(String nom, int dégats, int couts)
	{
		this.nom = nom;
		this.dégats = dégats;
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

	
	
	
	public String getNom()
	{
		return nom;
	}

	public void setNom(String nom)
	{
		this.nom = nom;
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
