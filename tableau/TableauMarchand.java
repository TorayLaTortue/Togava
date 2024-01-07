package tableau;

import deplacement.Deplacement;
import marchand.Marchand;

public class TableauMarchand extends Tableau
{
private Marchand marchand;
	
	public TableauMarchand(int X, int Y, Marchand marchand)
	{
		super(X, Y);
		this.setMarchand(marchand);
		
	}

	public Marchand getMarchand()
	{
		return marchand;
	}

	private void setMarchand(Marchand marchand)
	{
		this.marchand = marchand;
	}
	
	public void evenement()
	{
		Marchand.trade(this);
		Deplacement.deplacement(this);
	}
	
}
