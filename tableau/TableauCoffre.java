package tableau;

import coffre.Coffre;
import deplacement.Deplacement;
import objet.Armes;
import objet.Objet;

public class TableauCoffre extends Tableau
{
private Armes armes;
private Objet objet;
	
	public TableauCoffre(int X, int Y, Armes armes ,Objet objet)
	{
		super(X, Y);
		this.setCoffreArmes(armes);
		this.setCoffreObjet(objet);
	}

	public Armes getCoffreArmes()
	{
		return armes;
	}

	public void setCoffreArmes(Armes armes)
	{
		this.armes = armes;
	}


	public Objet getCoffreObjet()
	{
		return objet;
	}

	public void setCoffreObjet(Objet objet)
	{
		this.objet = objet;
	}
	
	public void evenement()
	{
		Coffre.coffre(this);
		Deplacement.deplacement(this);
	}
}
