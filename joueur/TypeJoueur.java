package joueur;

import objet.Armes;
import pet.TypePets;

public enum TypeJoueur
{
	CHEVALIER("Chevalier", Type.PHYSIQUE, TypePets.AUCUN, 10, 2, 10, 2, 3, Armes.EPEEBOIS, 3, 3, 2 ,0 ,0 ,100 ,1)
	,CHEVALIERDUNEANT("Chevalier  du neant", Type.PHYSIQUE, TypePets.AUCUN, 6, 2, 6, 4, 5, Armes.EPEEBOIS, 8, 8, 2 ,0 ,0 ,100 ,1)
	,BANDIT("Bandit", Type.TENEBRE, TypePets.AUCUN, 8, 2, 8, 4, 5, Armes.DAGUEROUILLE, 5, 5, 2 ,5 ,0 ,100 ,1)
	,VAMPIRE("Vampire", Type.TENEBRE, TypePets.BAT, 7, 2, 7, 3, 2, Armes.DAGUEROUILLE, 5, 5, 2 ,0 ,0 ,100 ,1)
	,MAGE("Mage", Type.LUMIERE, TypePets.AUCUN, 5, 2, 5, 7, 4, Armes.SCEPTRET1, 20, 20, 2 ,0, 0 ,100 ,1)
	,ADEPTE("Adepte", Type.LUMIERE, TypePets.AUCUN, 5, 2, 5, 5, 5, Armes.SCEPTRET1, 10, 10, 2 ,3 ,0 ,100 ,1);
	
	private String nom;
	private Type type;
	private TypePets typePets;
	private int vie;
	private int defense;
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
	
	
	
	private TypeJoueur(String nom, Type type, TypePets typePets, int vie, int defense, int vieMax, int atk, int vitesse, Armes arme, int mana, int manaMax, int tableauStart, int gold, int experience, int experienceRequis, int level)
	{
	this.nom = nom;
	this.type = type;
	this.typePets = typePets;
	this.vie = vie;
	this.defense = defense;
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
	this.level = level;
	
	
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
	public TypePets getTypePets() {
		return typePets;
	}
	public void setTypePets(TypePets typePets) {
		this.typePets = typePets;
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
	public int getDefense() {
		return defense;
	}
	public void setDefense(int defense) {
		this.defense = defense;
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
