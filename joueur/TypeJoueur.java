package joueur;

public enum TypeJoueur
{
	CHEVALIER("Chevalier", 10, 2, 3, Armes.EPEEBOIS, 3, 2 ,0)
	,BANDIT("Bandit", 8, 4, 5, Armes.DAGUEROUILLE, 5, 2 ,5)
	,Mage("Mage", 4, 7, 4, Armes.DAGUEROUILLE, 20, 2 ,0);
	
	private String nom;
	private int vie;
	private int atk;
	private int vitesse;
	private Armes arme;
	private int mana;
	private int ancienTableau;
	private int gold;
	
	
	private TypeJoueur(String nom, int vie, int atk, int vitesse, Armes arme, int mana, int tableauStart, int gold)
	{
	this.nom = nom;
	this.vie = vie;
	this.atk = atk;
	this.vitesse = vitesse;
	this.arme = arme;
	this.mana = mana;
	this.ancienTableau = tableauStart;
	this.gold = gold;
	
	
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
	
	public Armes getArme()
	{
		return arme;
	}

	public void setArme(Armes arme)
	{
		this.arme = arme;
	}

	public int getMana()
	{
		return mana;
	}
	public void setMana(int mana)
	{
		this.mana = mana;
	}
	

	public int getAncienTableau()
	{
		return ancienTableau;
	}

	public void setAncienTableau(int ancienTableau)
	{
		this.ancienTableau = ancienTableau;
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
