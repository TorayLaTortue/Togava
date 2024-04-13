package tableau;

import java.util.ArrayList;

import deplacement.Deplacement;
import joueur.Joueur;
import tableau.Levier;

public class Tableau
{
	private Boolean droite;
	private Boolean gauche;
	private Boolean haut;
	private Boolean bas;

	private Boolean porteDroite;
	private Boolean porteGauche;
	private Boolean porteHaut;
	private Boolean porteBas;
	private Levier levier;

	private int X;
	private int Y;
	
	
	private static ArrayList<Tableau> tableaux = new ArrayList<>();
	
	
	public Tableau(int X,  int Y)
	{
		this.setDroite(false);
		this.setGauche(false);
		this.setHaut(false);
		this.setBas(false);
		this.setPorteDroite(porteDroite);
		this.setPorteGauche(porteGauche);
		this.setPorteHaut(porteHaut);
		this.setPorteBas(porteBas);
		this.setLevier(levier);
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
	public void setPorteDroite(Boolean porteDroite) {
		this.porteDroite = porteDroite;
		this.droite = porteDroite;
	}
	public Boolean hasPorteDroite() {
		return porteDroite;
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
	public void setPorteGauche(Boolean porteGauche) {
		this.porteGauche = porteGauche;
		this.gauche = porteGauche;
	}
	public Boolean hasPorteGauche() {
		return porteGauche;
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
	public void setPorteHaut(Boolean porteHaut) {
		this.porteHaut = porteHaut;
	}
	public Boolean hasPorteHaut() {
		return porteHaut;
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
	public void setPorteBas(Boolean porteBas) {
		this.porteBas = porteBas;
		this.bas = porteBas;
	}
	public Boolean hasPorteBas() {
		return porteBas;
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

	public Tableau setLevier(Levier levier)
	{
		this.levier = levier;
		return this;
	}

	public void useLevier(Levier levier)
	{
		if(!levier.isUsed()) // faire que le levier ouvre la porte
		{

			if (levier.getDroite()) {
				Tableau.getTableau(levier.getX(), levier.getY()).setPorteDroite(false);
			}
			if (levier.getGauche()) {
				Tableau.getTableau(levier.getX(), levier.getY()).setPorteGauche(false);
			}
			levier.setUsed(true);
			
			
			Tableau.getTableau(levier.getX(), levier.getY()).setPorteHaut(false);
			Tableau.getTableau(levier.getX(), levier.getY()).setPorteBas(false);
		}
		else
		{
			levier.setUsed(false);
			Tableau.getTableau(levier.getX(), levier.getY()).setPorteDroite(true);
			Tableau.getTableau(levier.getX(), levier.getY()).setPorteGauche(true);
			Tableau.getTableau(levier.getX(), levier.getY()).setPorteHaut(true);
			Tableau.getTableau(levier.getX(), levier.getY()).setPorteBas(true);
		}
		
	}


}
