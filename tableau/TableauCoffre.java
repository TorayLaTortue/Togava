package tableau;

import coffre.Coffre;
import deplacement.Deplacement;
import joueur.Armes;

public class TableauCoffre extends Tableau
{
private Armes coffre;
	
	public TableauCoffre(int X, int Y, Armes coffre)
	{
		super(X, Y);
		this.setCoffre(coffre);
		
	}

	public Armes getCoffre()
	{
		return coffre;
	}

	public void setCoffre(Armes coffre)
	{
		this.coffre = coffre;
	}
	
	public void evenement()
	{
		Coffre.coffre(this);
		Deplacement.deplacement(this);
	}
}
