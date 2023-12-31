package tableau;

import deplacement.Deplacement;
import marchand.Marchand;

public class TableauMarchand extends Tableau
{
private Marchand marchand;
	
	public TableauMarchand(int id, Marchand marchand)
	{
		super(id);
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
