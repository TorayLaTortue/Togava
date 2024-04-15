package tableau;

import java.util.ArrayList;

import deplacement.Deplacement;
import joueur.Joueur;
import scan.Scan;
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
		this.setPorteDroite(false);
		this.setPorteGauche(false);
		this.setPorteHaut(false);
		this.setPorteBas(false);
		this.setLevier(null);
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
	public Tableau addPorteDroite() {
		setDroite(true);
		setPorteDroite(true);
		return this;
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
	public Tableau addPorteGauche() {
		setGauche(true);
		setPorteGauche(true);
		return this;
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
	public Tableau addPorteHaut() {
		setHaut(true);
		setPorteHaut(true);
		return this;
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
	public Tableau addPorteBas() {
		setBas(true);
		setPorteBas(true);
		return this;
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
		else if(this instanceof Tableau)
		{
			System.out.println("Vous êtes dans une plaine vide.");
		}
		else
		{
			System.out.println("Vous êtes dans le neant."); //Cas impossible
		}

		if(this.levier != null)
		{
			this.useLevier();
		}
		Deplacement.deplacement(this);
		
	}

	public Tableau setLevier(Levier levier)
	{
		this.levier = levier;
		return this;
	}

	public void useLevier()
	{
		Tableau tableau = Tableau.getTableau(levier.getX(), levier.getY());
		System.out.println("Vous trouvez un levier.\nVoulez vous l'utilisez ?");
		System.out.println("0 - Non");
		System.out.println("1 - Oui");
		boolean isNumero = true;
		boolean isCorrectNumero = false;
		int numero = 0;
		
		do  
		{
			String reponse = Scan.scanner();
			isNumero = true;
			numero = 0;
			
			try 
			{
				numero = Integer.parseInt(reponse);
			} 
			catch (NumberFormatException e)
			{
				isNumero = false;
			}
			
			if(!isNumero)
			{
				System.out.println("Vous devez mettre entre 0 et 1 ! >:c");
			}
			else
			{
				if(numero >= 0 && numero <= 1 )
				{
					isCorrectNumero = true;
				}
			}
		} while(!isCorrectNumero);
	
		if(numero == 1 )
		{
			if(!levier.isUsed()) // on/off levier 
			{
				System.out.println("Levier activé.");
				if (levier.getDroite()) {
					tableau.setPorteDroite(false);
				}
				if (levier.getGauche()) {
					tableau.setPorteGauche(false);
				}
				if (levier.getHaut()) {
					tableau.setPorteHaut(false);
				}
				if (levier.getBas()) {
					tableau.setPorteBas(false);
				}
				levier.setUsed(true);
			}
			else
			{
				System.out.println("Levier désactivé.");
				if (levier.getDroite()) {
					tableau.setPorteDroite(true);
				}
				if (levier.getGauche()) {
					tableau.setPorteGauche(true);
				}
				if (levier.getHaut()) {
					tableau.setPorteHaut(true);
				}
				if (levier.getBas()) {
					tableau.setPorteBas(true);
				}
				levier.setUsed(false);
			}
		}
	}
}
