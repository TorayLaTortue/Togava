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

	public String getAllNomVieMonstre(){
		ArrayList<Monstre> monstres = getAllMonstre();
		StringBuilder sb = new StringBuilder();
	
		for(Monstre monstre : monstres) {
			sb.append("Le " + monstre.getNom() + " a " + monstre.getVie() + " PV").append(", ");
		}
	
		
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
		
		System.out.println("Vous arrivez dans une case de combat.");
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


	public boolean isAllMort(ArrayList<Monstre> monstres)
	{
		boolean fin = false;
		int i = 0;
		int j = 0;
		for(Monstre monstre :  monstres)
		{
			
			i++;
			if(monstre.isMort())
			{
				j++;
			}
		}
		
		if(j == i)
		{
			fin = true;
		}
		
		return fin;
	}

}
