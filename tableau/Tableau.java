package tableau;

import java.util.ArrayList;

import deplacement.Deplacement;
import joueur.Joueur;

public class Tableau
{
	private Boolean droite;
	private Boolean gauche;
	private Boolean haut;
	private Boolean bas;
	private int id;
	
	
	private static ArrayList<Tableau> tableaux = new ArrayList<>();
	
	
	public Tableau(int id)
	
	{
		this.setDroite(false);
		this.setGauche(false);
		this.setHaut(false);
		this.setBas(false);
		this.setId(id);
		tableaux.add(this);
		
	}

	public Boolean hasDroite()
	{
		return droite;
	}

	
	public void setDroite(Boolean droite)
	{
		this.droite = droite;
	}

	public Tableau addDroite()
	{
		setDroite(true);
		return this;
	}
	public Tableau toDroite()
	{
		Joueur.get().setAncienTableau(getId());
		return getTableau(getId() +1);
		
	}
	
	public Boolean hasGauche()
	{
		return gauche;
	}

	public void setGauche(Boolean gauche)
	{
		this.gauche = gauche;
	}
	public Tableau addGauche()
	{
		setGauche(true);
		return this;
	}
	public Tableau toGauche()
	{
		Joueur.get().setAncienTableau(getId());
		return getTableau(getId() -1);
		
	}
	
	public Boolean hasHaut()
	{
		return haut;
	}

	public void setHaut(Boolean haut)
	{
		this.haut = haut;
	}
	public Tableau addHaut()
	{
		setHaut(true);
		return this;
	}
	public Tableau toHaut()
	{
		Joueur.get().setAncienTableau(getId());
		return getTableau(getId() +3);
		
	}
	
	public Boolean hasBas()
	{
		return bas;
	}

	public void setBas(Boolean bas)
	{
		this.bas = bas;
	}
	public Tableau addBas()
	{
		setBas(true);
		return this;
	}
	public Tableau toBas()
	{
		Joueur.get().setAncienTableau(getId());
		return getTableau(getId() -3);
		
	}
	
	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	
	public static ArrayList<Tableau> getTableaux()
	{
		return tableaux;
	}
	
	public static Tableau getTableau(int id)
	{
		for(Tableau tableau : getTableaux())
		{
			if(tableau.getId() == id )
			{
				return tableau;
			}
		}
		return null;
	}

	public void evenement()
	{
		
		if(getId() == 6)
		{
			System.out.println("Bravo vous avez gagner ! ");
			System.exit(0);
			
		}
		else if(getId() == 2)
		{
			System.out.println("Vous vous trouvez au spawn.");
		}
		else
		{
			System.out.println("Vous êtes dans un lieu vide");
		}
			Deplacement.deplacement(this);
		
		
	}
	
	
}
