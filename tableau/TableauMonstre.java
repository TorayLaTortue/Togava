package tableau;

import java.util.ArrayList;

import combat.Combat;
import deplacement.Deplacement;
import monstre.Monstre;

public class TableauMonstre extends Tableau
{
	private ArrayList<Monstre> monstre = new ArrayList<>();
	
	public TableauMonstre(int X, int Y, Monstre... monstre)
	{
		super(X, Y);
		this.monstre = new ArrayList<Monstre>();
		for (Monstre monstres : monstre) {
            this.monstre.add(monstres);
        }
		
	}

	public ArrayList<Monstre> getAllMonstre() {
		return monstre;
	}
	public String getAllNomMonstre(){
		ArrayList<Monstre> monstres = getAllMonstre();
		StringBuilder sb = new StringBuilder();
	
		for(Monstre monstre : monstres) {
			sb.append(monstre.getNom()).append(", ");
		}
	
		// Supprimer la virgule et l'espace en trop à la fin, s'ils existent
		if (sb.length() > 0) {
			sb.delete(sb.length() - 2, sb.length());
		}
	
		return sb.toString();
	}

	public void setMonstre(ArrayList<Monstre> monstre) {
		this.monstre = monstre;
	}
	
	public Monstre getMonstre(int index) {
        if (index >= 0 && index < monstre.size()) {
            return monstre.get(index);
        } else {
            return null; 
        }
    }
	
	public void evenement()
	{
		if(monstre.size() == 1)
		{
			System.out.println("Wow un "+ this.getMonstre(0).getNom() +" terrifiant apparait.");
		}
		else
		{
			System.out.println("Wow une horde de monstre apparait.");
		}
		Combat.combat(this);
		Deplacement.deplacement(this);
	}
	
	
	public int getMaxDifficulte()
	{
        if (monstre.isEmpty()) {
			System.out.println("GetMaxDifficulté, tableauMonstre impossible");
            return 0; 
        }

        int difficulteMax = monstre.get(0).getDifficulte(); // Initialise avec la difficulté du premier monstre

        // Parcourt la liste pour trouver la difficulté maximale
        for (int i = 1; i < monstre.size(); i++) {
            int difficulteCourante = monstre.get(i).getDifficulte();
            if (difficulteCourante > difficulteMax) {
                difficulteMax = difficulteCourante;
            }
        }

        return difficulteMax;
    }


	public boolean isAllMort()
	{
		ArrayList<Monstre> monstres = getAllMonstre();
		int monstreMort = 0;
		boolean fin = false;
		for (Monstre monstre : monstres) {
			if(monstre.isMort() == true)
			{
				monstreMort++;
			}
			if(monstreMort == monstres.size())
			{
				fin = true;
			}
			
		}
		return fin;
	}

}
