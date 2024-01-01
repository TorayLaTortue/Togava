package joueur;

import monstre.Monstre;

public class Joueur
{
	private String nom;
	private int vie;
	private int vitesse;
	private Armes arme;
	private int ancienTableau;
	private int gold;
	private boolean mort;
	
	private static Joueur joueur;  
	
	public Joueur(TypeJoueur TypeJoueur)
	{
		this.nom = TypeJoueur.getNom();
		this.vie = TypeJoueur.getVie();
		this.vitesse = TypeJoueur.getVitesse();
		this.setArme(arme);
		this.ancienTableau = tableauStart;
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
	public void attaque(Monstre victime)
	{
		victime.setVie(victime.getVie() - getArme().getDégats());
		System.out.println("Vous avez infligez " + getArme().getDégats() + " dégats au " + victime.getNom() + ".\n");
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
	public void addGold(int gold)
	{
		setGold(getGold() + gold);
	}
	public void subGold(int gold)
	{
		setGold(getGold() - gold);
	}
	
}
