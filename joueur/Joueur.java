package joueur;

import monstre.Monstre;

public class Joueur
{
	private String nom;
	private int vie;
	private int atk;
	private int vitesse;
	private Armes arme;
	private int mana;
	private int ancienTableauX;
	private int ancienTableauY;
	private int gold;
	private boolean mort;
	
	private static Joueur joueur;  
	
	public Joueur(TypeJoueur TypeJoueur)
	{
		this.nom = TypeJoueur.getNom();
		this.vie = TypeJoueur.getVie();
		this.atk = TypeJoueur.getAtk();
		this.vitesse = TypeJoueur.getVitesse();
		this.arme = TypeJoueur.getArme();
		this.mana =  TypeJoueur.getMana();
		this.gold = TypeJoueur.getGold();
		this.mort = false;
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


	public void attaque(Monstre victime)
	{
		victime.setVie(victime.getVie() - (getArme().getDégats() + getAtk()));
		System.out.println("Vous avez infligez " + (getArme().getDégats() + getAtk()) + " dégats au " + victime.getNom() + ".\n");
		setMana(getMana() - getArme().getCoutMana());
		System.out.println("Vous avez utilisez " + getArme().getCoutMana() + " mana, il vous reste " + getMana() + " mana.");
	}
	
	
	public int getVitesse()
	{
		return vitesse +  arme.getVitesse();
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
	
}
