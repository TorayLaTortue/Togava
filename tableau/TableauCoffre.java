package tableau;

import coffre.Coffre;
import deplacement.Deplacement;
import joueur.Armes;

public class TableauCoffre extends Tableau
{
private Armes coffre;
	
	public TableauCoffre(int id, int id2, Armes coffre)
	{
		super(id, id2);
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
