package joueur;

public enum TypeJoueur
{
	Chevalier("Chevalier", 10, 2, 3, Armes.AUCUNE, 2 ,0) ,Bandit("Bandit", 8, 4, 5, Armes.DAGUEROUILLE, 2 ,0);
	
	private String nom;
	private int vie;
	private int atk;
	private int vitesse;
	private Armes arme;
	private int ancienTableau;
	private int gold;
	private boolean mort;
	
	private TypeJoueur(String nom, int vie, int atk, int vitesse, Armes arme, int tableauStart, int gold)
	{
	this.nom = nom;
	this.vie = vie;
	this.atk = atk;
	this.vitesse = vitesse;
	this.ancienTableau = tableauStart;
	this.gold = gold;
	this.mort = false;
	
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
	
	
	
}
