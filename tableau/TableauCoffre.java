package tableau;

import coffre.Coffre;
import deplacement.Deplacement;

public class TableauCoffre extends Tableau
{
private Coffre coffre;
	
	public TableauCoffre(int X, int Y, Coffre coffre)
	{
		super(X, Y);
		this.coffre = coffre;
	}

	public Coffre getCoffre() {
		return coffre;
	}
	public void setCoffre(Coffre coffre) {
		this.coffre = coffre;
	}
	
	public void evenement()
	{
		Coffre.ouverture(this);
		Deplacement.deplacement(this);
	}
}
