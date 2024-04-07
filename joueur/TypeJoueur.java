package joueur;

import objet.Armes;
import pet.TypePets;
import type.Type;

public enum TypeJoueur
{
	CHEVALIER("Chevalier", Type.PHYSIQUE, TypePets.AUCUN, 10, 2, 10, 2, 120, Armes.EPEEBOIS, 3, 3, 2 ,0 ,0 ,100 ,1)
	,CHEVALIERDUNEANT("Chevalier  du neant", Type.PHYSIQUE, TypePets.AUCUN, 6, 2, 6, 4, 120, Armes.EPEEBOIS, 8, 8, 2 ,0 ,0 ,100 ,1)
	,BANDIT("Bandit", Type.TENEBRE, TypePets.AUCUN, 8, 2, 8, 4, 120, Armes.DAGUEROUILLE, 5, 5, 2 ,5 ,0 ,100 ,1)
	,VAMPIRE("Vampire", Type.TENEBRE, TypePets.BAT, 7, 2, 7, 3, 120, Armes.DAGUEROUILLE, 5, 5, 2 ,0 ,0 ,100 ,1)
	,MAGE("Mage", Type.LUMIERE, TypePets.AUCUN, 50, 2, 50, 70, 120, Armes.SCEPTRET1, 20, 20, 2 ,0, 0 ,100 ,1)
	,ADEPTE("Adepte", Type.LUMIERE, TypePets.AUCUN, 500, 2, 500, 50, 115, Armes.SCEPTRET1, 10, 10, 2 ,300 ,0 ,100 ,1);
	
	private String nom;
	private Type type;
	private TypePets typePets;
	private float vie;
	private float defense;
	private float vieMax;
	private float atk;
	private float vitesse;
	private Armes arme;
	private float mana;
	private float manaMax;
	private int ancienTableau;
	private float gold;
	private float experience;
	private float experienceRequis;
	private int level;
	
	
	
	private TypeJoueur(String nom, Type type, TypePets typePets, float vie, float defense, float vieMax, float atk, float vitesse, Armes arme, float mana, float manaMax, int tableauStart, float gold, float experience, float experienceRequis, int level)
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

	public float getVie()
	{
		if(vie > vieMax)
		{
			setVie(vieMax);
		}
		return vie;
	}
	public void setVie(float vie)
	{
		this.vie = vie;
	}
	public float getDefense() {
		return defense;
	}
	public void setDefense(float defense) {
		this.defense = defense;
	}

	public float getVieMax()
	{
		return vie;
	}
	public void setVieMax(float vieMax)
	{
		this.vieMax = vieMax;
	}
	
	
	
	public float getAtk()
	{
		return atk;
	}
	public void setAtk(float atk)
	{
		this.atk = atk;
	}
	
	
	
	public float getVitesse()
	{
		return vitesse;
	}
	public void setVitesse(float vitesse)
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

	public float getMana()
	{
		if(mana > manaMax)
		{
			setMana(manaMax);
		}
		return mana;
	}
	public void setMana(float mana)
	{
		this.mana = mana;
	}

	public float getManaMax()
	{
		return manaMax;
	}
	public void setManaMax(float manaMax)
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
	
	public float getGold()
	{
		return gold;
	}
	public void setGold(float gold)
	{
		this.gold = gold;
	}
	
	public float getExperience()
	{
		return experience;
	}
	public void setExperience(float experience)
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

	public float getExperienceRequis()
	{
		return experienceRequis;
	}
	public void setExperienceRequis(float experienceRequis)
	{
		this.experienceRequis = experienceRequis;
	}
	
}
