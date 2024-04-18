package objet;

import type.Type;

public enum Armes
{
	AUCUNE("aucune",Type.AUCUN, 0, 0, 0, 0)
	, EPEEBOIS("une épée en bois",Type.PHYSIQUE , 2, 0, 0, 0), EPEEPIERRE("une épée en pierre",Type.PHYSIQUE , 3, 1, 0, 1)
	, DAGUEROUILLE("une dague rouillé",Type.TENEBRE , 1, 2, 0, 0), DAGUE("une dague basique",Type.TENEBRE , 2, 3, 0, 0)
	, SCEPTRET1("un sceptre magique de débutant",Type.LUMIERE , 3, 2,  1, 0), SCEPTRET2("un sceptre magique puissant",Type.LUMIERE , 6, 2,  2, 0)
	, CLAYMORE("une claymore sombre",Type.PHYSIQUE , 25, -2, 0, 30), KARAMBIT("un karambit sombre",Type.TENEBRE , 20, 10, 0, 30) ,SCEPTRELUMIERE("un sceptre magique infusé de néant",Type.LUMIERE , 30, 2,  5, 30);
	
	private String nom;
	private int dégats;
	private int vitesse;
	private int coutMana;
	private float couts;
	private Type type;
	
	
	private Armes(String nom,Type type, int dégats, int vitesse, int coutMana, float couts)
	{
		this.nom = nom;
		this.type = type;
		this.dégats = dégats;
		this.vitesse = vitesse;
		this.coutMana = coutMana;
		this.couts = couts;
	}

	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
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

	public float getCouts()
	{
		return couts;
	}


	public void setCouts(float couts)
	{
		this.couts = couts;
	}

	
	
}
