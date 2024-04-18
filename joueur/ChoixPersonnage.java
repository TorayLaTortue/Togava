package joueur;


import scan.Scan;

public class ChoixPersonnage
{
	public Joueur choixPersonnage()
	{
		boolean end = false;
		
		System.out.println("\nQuel personnage voulez vous  : ");
		
		while(end == false)
		{
			int i = 0;
			System.out.println("1 - Chevalier ");
			i++;
		
			System.out.println("2 - Chevalier du neant ");
			i++;
		
			System.out.println("3 - Bandit ");
			i++;
		
			System.out.println("4 - Mage ");
			i++;

			System.out.println("5 - Adepte ");
			i++;
			
			int numero = Scan.scannerInt(i);
			
			if(numero == 1 )
			{
				
				end = true;
				return new Joueur(TypeJoueur.CHEVALIER);

				
			}
			else if(numero == 2)
			{
				
				end = true;
				return new Joueur(TypeJoueur.CHEVALIERDUNEANT);
			}
			
			
			else if(numero == 3)
			{
				end = true;
				return new Joueur(TypeJoueur.BANDIT);
			}
			
			else if(numero == 4)
			{
				end = true;
				return new Joueur(TypeJoueur.MAGE);
			}
			else if(numero == 5)
			{
				end = true;
				return new Joueur(TypeJoueur.ADEPTE);
			}
			
		
		}
		return null;
	}
	
}
