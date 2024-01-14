package joueur;

import objet.Armes;

public enum TypeJoueur
{
	CHEVALIER("Chevalier", 10,10, 2, 3, Armes.EPEEBOIS, 3, 3, 2 ,0 ,0 ,100 ,1)
	,CHEVALIERDUNEANT("Chevalier  du neant", 6, 6, 4, 5, Armes.EPEEBOIS, 8, 8, 2 ,0 ,0 ,100 ,1)
	,BANDIT("Bandit", 8, 8, 4, 5, Armes.DAGUEROUILLE, 5, 5, 2 ,5 ,0 ,100 ,1)
	,VAMPIRE("Vampire", 7, 7, 3, 2, Armes.DAGUEROUILLE, 5, 5, 2 ,0 ,0 ,100 ,1)
	,MAGE("Mage", 4, 4, 7, 4, Armes.SCEPTRET1, 20, 20, 2 ,0, 0 ,100 ,1)
	, ADEPTE("Adepte", 5, 5, 5, 5, Armes.SCEPTRET1, 10, 10, 2 ,3 ,0 ,100 ,1);
	
	private String nom;
	private int vie;
	private int vieMax;
	private int atk;
	private int vitesse;
	private Armes arme;
	private int mana;
	private int manaMax;
	private int ancienTableau;
	private int gold;
	private int experience;
	private int experienceRequis;
	private int level;
	
	
	private TypeJoueur(String nom, int vie, int vieMax, int atk, int vitesse, Armes arme, int mana, int manaMax, int tableauStart, int gold, int experience, int experienceRequis, int level)
	{
	this.nom = nom;
	this.vie = vie;
	this.vieMax = vieMax;
	this.atk = atk;
	this.vitesse = vitesse;
	this.arme = arme;
	this.mana = mana;
	this.manaMax = manaMax;
	this.ancienTableau = tableauStart;
	this.gold = gold;
	this.experience = experience;
	this.experienceRequis = experienceRequis;
	this.level=level;
	
	
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
		if(vie > vieMax)
		{
			setVie(vieMax);
		}
		return vie;
	}
	public void setVie(int vie)
	{
		this.vie = vie;
	}

	public int getVieMax()
	{
		return vie;
	}
	public void setVieMax(int vieMax)
	{
		this.vieMax = vieMax;
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
		if(mana > manaMax)
		{
			setMana(manaMax);
		}
		return mana;
	}
	public void setMana(int mana)
	{
		this.mana = mana;
	}

	public int getManaMax()
	{
		return manaMax;
	}
	public void setManaMax(int manaMax)
	{
		this.manaMax = manaMax;
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
	
	public int getExperience()
	{
		return experience;
	}
	public void setExperience(int experience)
	{
		this.experience = experience;
	}

	public int getLevel()
	{
		return level;
	}
	public void setLevel(int level)
	{
		this.level = level;
	}

	public int getExperienceRequis()
	{
		return experienceRequis;
	}
	public void setExperienceRequis(int experienceRequis)
	{
		this.experienceRequis = experienceRequis;
	}
	
}
