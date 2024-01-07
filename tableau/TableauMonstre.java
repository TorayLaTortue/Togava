package tableau;

import combat.Combat;
import deplacement.Deplacement;
import monstre.Monstre;

public class TableauMonstre extends Tableau
{
	private Monstre monstre;
	
	public TableauMonstre(int X, int Y, Monstre monstre)
	{
		super(X, Y);
		this.monstre = monstre;
		
	}

	public Monstre getMonstre()
	{
		return monstre;
	}

	@SuppressWarnings("unused")
	private void setMonstre(Monstre monstre)
	{
		this.monstre = monstre;
	}
	
	
	public void evenement()
	{
		System.out.println("Wow un "+ getMonstre().getNom() +" terrifiant apparait.");
		Combat.combat(this);
		Deplacement.deplacement(this);
	}
	
	
}
