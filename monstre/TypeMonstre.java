package monstre;

import joueur.Type;

public enum TypeMonstre
{
	BLOB("blob",Type.AUCUN , 8, 2, 2, 3 , 250, 1), BLOBFEU("blob",Type.FEU , 10, 4, 2, 6 , 25, 1),
	SQUELETTE("Squelette",Type.TENEBRE , 12, 4, 3, 6 , 30, 1),
	DRAGON("dragon",Type.PHYSIQUE , 5, 9, 5, 999, 200, 5);
	
	private String nom;
	private Type type;
	private int vie;
	private int atk;
	private int vitesse;
	private int gold;
	private int experience;
	private int difficulte;
	
	private TypeMonstre(String nom, Type type, int vie, int atk, int vitesse, int gold, int experience, int difficulte)
	{
	this.nom = nom;
	this.type = type;
	this.vie = vie;
	this.atk = atk;
	this.vitesse = vitesse;
	this.gold = gold;
	this.experience = experience;
	this.difficulte = difficulte;
	
	}
	
	public String getNom()
	{
		return nom;
	}
	public void setNom(String nom)
	{
		this.nom = nom;
	}
	
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	
	public int getVie()
	{
		return vie;
	}
	public void setVie(int vie)
	{
		this.vie = vie;
	}
	
	
	
	public int getAtk()
	{
		return atk;
	}
	public void setAtk(int atk)
	{
		this.atk = atk;
	}
	
	
	
	public int getVitesse()
	{
		return vitesse;
	}
	public void setVitesse(int vitesse)
	{
		this.vitesse = vitesse;
	}
	
	
	
	public int getGold()
	{
		return gold;
	}
	public void setGold(int gold)
	{
		this.gold = gold;
	}

	public int getExperience()
	{
		return experience;
	}
	public void setExperience(int experience)
	{
		this.experience = experience;
	}

	
	public int getDifficulte()
	{
		return difficulte;
	}
	public void setDifficulte(int difficulte)
	{
		this.difficulte = difficulte;
	}
	
}
