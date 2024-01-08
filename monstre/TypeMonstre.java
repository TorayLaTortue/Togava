package monstre;

public enum TypeMonstre
{
	 BLOB("blob", 8, 2, 2, 3 , 1), Squelette("Squelette", 6, 4, 3, 6 , 1)
	,DRAGON("dragon", 5, 9, 5, 999, 5);
	
	private String nom;
	private int vie;
	private int atk;
	private int vitesse;
	private int gold;
	private int difficulte;
	
	private TypeMonstre(String nom, int vie, int atk, int vitesse, int gold, int difficulte)
	{
	this.nom = nom;
	this.vie = vie;
	this.atk = atk;
	this.vitesse = vitesse;
	this.gold = gold;
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
	
	public int getDifficulte()
	{
		return difficulte;
	}
	public void setDifficulte(int difficulte)
	{
		this.difficulte = difficulte;
	}
	
}
