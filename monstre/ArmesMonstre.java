package monstre;

import type.Type;

public enum ArmesMonstre
{
	AUCUNE("aucune",Type.AUCUN, 0, 0, 0, 0, 0),
	EPEEBOIS("une épée en bois",Type.PHYSIQUE , 2, 1, 0, 0, 25),
	ARCBOIS("un arc en bois",Type.PHYSIQUE , 3, 0, 0, 0, 25);
	
	private String nom;
	private int dégats;
	private int vitesse;
	private int durabilite;
	private int coutMana;
	private int couts;
	private Type type;
	
	
	private ArmesMonstre(String nom,Type type, int dégats, int vitesse, int coutMana, int couts, int durabilite)
	{
		this.nom = nom;
		this.type = type;
		this.dégats = dégats;
		this.vitesse = vitesse;
		this.coutMana = coutMana;
		this.couts = couts;
		this.durabilite = durabilite;
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

	public int getCouts()
	{
		return couts;
	}


	public void setCouts(int couts)
	{
		this.couts = couts;
	}

	public int getDurabilite() {
		return durabilite;
	}
	public void setDurabilite(int durabilite) {
		this.durabilite = durabilite;
	}
	
}
