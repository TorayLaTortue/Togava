package joueur;

import java.math.RoundingMode;
import java.text.DecimalFormat;

import combat.Entite;
import monstre.Monstre;
import objet.Armes;
import pet.TypePets;

public class Joueur extends Entite
{
	private String nom;
	private Type type;
	private float vie;
	private float defense;
	private float vieMax;
	private float atk;
	private float vitesse;
	private float action;
	private Armes arme;
	private TypePets typePets;
	private float mana;
	private float manaMax;
	private int ancienTableauX;
	private int ancienTableauY;
	private float gold;
	private float experience;
	private float experienceRequis;
	private int level;
	private boolean mort;

	
	private static Joueur joueur;  
	
	public Joueur(TypeJoueur typeJoueur)
	{
		super.setAction(10000 / typeJoueur.getVitesse());
		this.nom = typeJoueur.getNom();
		this.type = typeJoueur.getType();
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
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
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
		if(vie > vieMax)
		{
			vie = vieMax;
		}
		this.vie = vie;
	}
	public float getDefense() {
		defense = defense + typePets.getDefense();
		return defense;
	}
	public void setDefense(float defense) {
		this.defense = defense;
	}

	public float getVieMax()
	{
		return vieMax;
	}

	public void setVieMax(float vieMax)
	{
		this.vieMax = vieMax;
	}

	public float getAtk()
	{
		atk = atk + arme.getDégats() + typePets.getAtk();
		return atk;
	}
	public void setAtk(float atk)
	{
		this.atk = atk;
	}


	public void attaque(Monstre victime) 
	{
		float degatTotal = getAtk();
		degatTotal = victime.estFaible(arme.getType(), getType(), degatTotal) - victime.getDefense();
		
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
	
	
	public float getVitesse()
	{
		return vitesse + arme.getVitesse() + typePets.getVitesse();
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
		return mana;
	}
	public TypePets getTypePets() {
		return typePets;
	}
	public void setTypePets(TypePets typePets) {
		this.typePets = typePets;
	}

	public void setMana(float mana)
	{
		if(mana > manaMax)
		{
			mana = manaMax;
		}
		this.mana = mana;
	}

	public float getManaMax()
	{
		if(mana > manaMax)
		{
			setMana(manaMax);
		}
		return mana;
	}

	public void setManaMax(float manaMax)
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

	public float getGold()
	{
		return gold;
	}

	public void setGold(float gold)
	{
		this.gold = gold;
	}
	public void addGold(float gold)
	{
		setGold(getGold() + gold);
	}
	public void subGold(float gold)
	{
		setGold(getGold() - gold);
	}

	public float getExperience()
	{
		return experience;
	}

	public void setExperience(float experience)
	{
		this.experience = experience;
	}

	public void addExperience(float experience)
	{
		setExperience(getExperience() + experience);
	}

	public float getExperienceRequis()
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
	

	public void information()
	{
		System.out.println("Nom : " + this.getNom());
		System.out.println("Level : " + this.getLevel());
		System.out.println("Atk : " + this.getAtk());
	}
}
