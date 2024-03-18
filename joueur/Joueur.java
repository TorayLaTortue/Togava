package joueur;

import monstre.Monstre;
import objet.Armes;
import pet.TypePets;

public class Joueur
{
	private String nom;
	private int vie;
	private int defense;
	private int vieMax;
	private int atk;
	private int vitesse;
	private Armes arme;
	private TypePets typePets;
	private int mana;
	private int manaMax;
	private int ancienTableauX;
	private int ancienTableauY;
	private int gold;
	private int experience;
	private int experienceRequis;
	private int level;
	private boolean mort;
	
	private static Joueur joueur;  
	
	public Joueur(TypeJoueur typeJoueur)
	{
		this.nom = typeJoueur.getNom();
		this.vie = typeJoueur.getVie();
		this.defense = typeJoueur.getDefense();
		this.vieMax = typeJoueur.getVieMax();
		this.atk = typeJoueur.getAtk();
		this.vitesse = typeJoueur.getVitesse();
		this.arme = typeJoueur.getArme();
		this.typePets = typeJoueur.getTypePets();
		this.mana = typeJoueur.getMana();
		this.manaMax = typeJoueur.getManaMax();
		this.gold = typeJoueur.getGold();
		this.mort = false;
		this.experience = typeJoueur.getExperience();
		this.experienceRequis = typeJoueur.getExperienceRequis();
		this.level = typeJoueur.getLevel();
		joueur = this;
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
	public int getDefense() {
		defense = defense + typePets.getDefense();
		return defense;
	}
	public void setDefense(int defense) {
		this.defense = defense;
	}

	public int getVieMax()
	{
		return vieMax;
	}

	public void setVieMax(int vieMax)
	{
		this.vieMax = vieMax;
	}

	public int getAtk()
	{
		atk = atk + arme.getDégats() + typePets.getAtk();
		return atk;
	}
	public void setAtk(int atk)
	{
		this.atk = atk;
	}


	public void attaque(Monstre victime) 
	{
		int degatTotal = victime.getDefense() - getAtk();
		if(degatTotal < 1)
		{
			degatTotal = 1;
		}

		victime.setVie(victime.getVie() - degatTotal);
		System.out.println("Vous avez infligez " + degatTotal+ " dégats au " + victime.getNom() + ".\n");
		setMana(getMana() - getArme().getCoutMana());
		if(joueur.getArme().getCoutMana() >= 1)
		{	
		System.out.println("Vous avez utilisez " + getArme().getCoutMana() + " mana, il vous reste " + getMana() + " mana.");
		}
	}
	
	
	public int getVitesse()
	{
		return vitesse + arme.getVitesse() + typePets.getVitesse();
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
	public TypePets getTypePets() {
		return typePets;
	}
	public void setTypePets(TypePets typePets) {
		this.typePets = typePets;
	}

	public void setMana(int mana)
	{
		this.mana = mana;
	}

	public int getManaMax()
	{
		if(mana > manaMax)
		{
			setMana(manaMax);
		}
		return mana;
	}

	public void setManaMax(int manaMax)
	{
		this.manaMax = manaMax;
	}
	
	public static Joueur get()
	{
		return joueur;
	}

	
	
	
	public boolean isMort()
	{
		return mort;
	}

	public void setMort(boolean mort)
	{
		this.mort = mort;
	}

	public int getAncienTableauX()
	{
		return ancienTableauX;
	}

	public void setAncienTableauX(int ancienTableauX)
	{
		this.ancienTableauX = ancienTableauX;
	}

	public int getAncienTableauY()
	{
		return ancienTableauY;
	}

	public void setAncienTableauY(int ancienTableauY)
	{
		this.ancienTableauY = ancienTableauY;
	}

	public int getGold()
	{
		return gold;
	}

	public void setGold(int gold)
	{
		this.gold = gold;
	}
	public void addGold(int gold)
	{
		setGold(getGold() + gold);
	}
	public void subGold(int gold)
	{
		setGold(getGold() - gold);
	}

	public int getExperience()
	{
		return experience;
	}

	public void setExperience(int experience)
	{
		this.experience = experience;
	}

	public void addExperience(int experience)
	{
		setExperience(getExperience() + experience);
	}

	public int getExperienceRequis()
	{
		return experienceRequis;
	}

	public void setExperienceRequis(int level)
	{
		double result = experienceRequis * (1 + (level / 10.0));
    	this.experienceRequis = (int) Math.round(result);
	}

	public int getLevel()
	{
		return level;
	}

	public void setLevel(int level)
	{
		this.level = level;
	}
	
}
