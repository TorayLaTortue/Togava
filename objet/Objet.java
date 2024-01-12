package objet; 

import joueur.Joueur;

public enum Objet
{
   RIEN("vide", 0, 0, 0, 0, 0),
	POTIONVIE("potion de vie", 0, 5, 0, 0, 0),
   POTIONMANA("potion de mana", 0, 0, 0, 10, 0);
	
	private String nom;
	private int dégats;
   private int vie;
	private int vitesse;
	private int mana;
	private int couts;
   private Joueur joueur;
	
	
	private Objet(String nom, int dégats, int vie, int vitesse, int mana, int couts)
	{
		this.nom = nom;
		this.dégats = dégats;
      this.vie = vie;
		this.vitesse = vitesse;
		this.mana = mana;
		this.setCouts(couts);
	}

	
	public int getDégats()
	{
		return dégats;
	}

	public void setDégats(int dégats)
	{
		this.dégats = dégats;
	}

   public int getVie()
	{
		return vie;
	}

	public void setVie(int vie)
	{
		this.vie = vie;
	}

	public int getVitesse()
	{
		return vitesse;
	}

	public void setVitesse(int vitesse)
	{
		this.vitesse  = vitesse;
	}
	
	
	public String getNom()
	{
		return nom;
	}

	public void setNom(String nom)
	{
		this.nom = nom;
	}

	public int getMana()
	{
      System.out.println("Vous avez gagnez " + mana +" mana, vous avez donc " + joueur.getMana() + " sur " + joueur.getMana() + " total");
		return mana;
	}

	public void setMana(int mana)
	{
		this.mana = mana;
	}

	public int getCouts()
	{
		return couts;
	}


	public void setCouts(int couts)
	{
		this.couts = couts;
	}

	
	
}

