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
	private int X;
	private int Y;
	
	
	private static ArrayList<Tableau> tableaux = new ArrayList<>();
	
	
	public Tableau(int X,  int Y)
	{
		this.setDroite(false);
		this.setGauche(false);
		this.setHaut(false);
		this.setBas(false);
		this.setX(X);
		this.setY(Y);
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
		Joueur.get().setAncienTableauY(getX());
		return getTableau((getX() + 1), (getY()));
		
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
		Joueur.get().setAncienTableauY(getX());
		return getTableau((getX() - 1), (getY()));
		
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
		Joueur.get().setAncienTableauY(getY());
		return getTableau(getX(), (getY() + 1));
		
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
		Joueur.get().setAncienTableauY(getY());
		return getTableau(getX(), (getY() - 1));
		
	}
	
	public int getX()
	{
		return X;
	}

	public void setX(int X)
	{
		this.X = X;
	}
	
	public int getY()
	{
		return Y;
	}

	public void setY(int Y)
	{
		this.Y = Y;
	}

	
	public static ArrayList<Tableau> getTableaux()
	{
		return tableaux;
	}
	
	public static Tableau getTableau(int X, int Y)
	{	
		return getTableaux().stream().filter(t -> t.getX() == X && t.getY() == Y).findFirst().get();
	}

	public void evenement()
	{
		
		if(getX() == 3 && getY() == 0)
		{
			System.out.println("Bravo vous avez gagné ! ");
			System.exit(0);
			
		}
		else if(getX() == 0 && getY() == 0)
		{
			System.out.println("Vous vous trouvez au spawn.");
		}
		else
		{
			System.out.println("Vous êtes dans le neant.");
		}
		Deplacement.deplacement(this);
		
	}
}
