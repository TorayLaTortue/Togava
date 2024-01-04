package joueur;

import java.util.Scanner;

public class ChoixPersonnage
{
	public Joueur choixPersonnage()
	{
		boolean end = false;
		
		System.out.println("\nQuel personnage voulez vous  : ");
		
		while(end == false)
		{
			
				System.out.println("1 - Chevalier ");
			
			
				System.out.println("2 - Chevalier du neant ");
			
			
				System.out.println("3 - Bandit ");
			
			
				System.out.println("4 - Mage ");
		
				System.out.println("5 - Adepte ");

			boolean isNumero = true;
			boolean isCorrectNumero = false;
			int numero = 0;
			
			do  
			{
				Scanner in = new Scanner(System.in);
				isNumero = true;
				numero = 0;
				

				String reponse = in.nextLine();
				in.close();
				try 
				{
					numero = Integer.parseInt(reponse);
				} 
				catch (NumberFormatException e)
				{
					isNumero = false;
				}
				
				if(!isNumero)
				{
					System.out.println("Vous devez mettre entre 1 et 5 ! >:c");
				}
				else
				{
					if(numero >= 1 && numero <= 5 )
					{
						isCorrectNumero = true;
					}
				}
			} while(!isCorrectNumero);
			{
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
		
		}
		return null;
	}
	
}
