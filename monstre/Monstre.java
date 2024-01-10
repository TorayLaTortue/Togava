package monstre;

import java.util.Random;

import joueur.Joueur;

public class Monstre
{
	private String nom;
	private int vie;
	private int atk;
	private int vitesse;
	private int gold;
	private int experience;
	private int difficulte;
	private boolean mort;
	
	public Monstre(TypeMonstre typeMonstre)
	{
		this.nom = typeMonstre.getNom();
		this.vie = typeMonstre.getVie();
		this.atk = typeMonstre.getAtk();
		this.vitesse = typeMonstre.getVitesse();
		this.gold = typeMonstre.getGold();
		this.experience = typeMonstre.getExperience();
		this.difficulte = typeMonstre.getDifficulte();
		this.setMort(false);
	
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
	public void attaque(Joueur victime)
	{
		victime.setVie(victime.getVie() - getAtk());
		System.out.println("Le monstre vous a infligez " + getAtk() + " dégats.\n");
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

	
	
	
	public boolean isMort()
	{
		return mort;
	}

	public void setMort(boolean mort)
	{
		this.mort = mort;
	}

	public int getExperience()
	{
		return experience;
	}
	public void setExperience(int experience)
	{
		this.experience = experience;
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
