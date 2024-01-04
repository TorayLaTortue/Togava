package deplacement;

import java.util.Scanner;

import tableau.Tableau;

public class Deplacement
{
	public static void deplacement(Tableau tableau)
	{
		boolean end = false;
		
		System.out.println("\nOu voulez vous allez : ");
		
		while(end == false)
		{
			if(!tableau.hasGauche())
			{
				System.out.println("1 - Gauche ");
			}
			if(!tableau.hasBas())
			{
				System.out.println("2 - Bas ");
			}
			if(!tableau.hasDroite())
			{
				System.out.println("3 - Droite ");
			}
			
			System.out.println("4 - Dormir ");
		
			if(!tableau.hasHaut())
			{
				System.out.println("5 - Haut \n");
			}

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
		
			if(numero == 1 )
			{
				if(!tableau.hasGauche())
				{
					end = true;
					tableau.toGauche().evenement();
				}
				else
				{
					System.out.println("Vous ne pouvez pas aller a gauche. \n");
					System.out.println("Ou voulez vous allez : ");
					
				}
			}
			else if(numero == 2)
			{
				if(!tableau.hasBas())
				{
					end = true;
					tableau.toBas().evenement();
				}
				else
				{
					System.out.println("Vous ne pouvez pas aller en bas. \n");
					System.out.println("Ou voulez vous allez : ");
					
				}
			}
			else if(numero == 3)
			{
				if(!tableau.hasDroite())
				{
					end = true;
					tableau.toDroite().evenement();
				}
				else
				{
					System.out.println("Vous ne pouvez pas aller a droite. \n");
					System.out.println("Ou voulez vous allez : ");
					
				}
			}
			else if(numero == 4)
			{
				System.out.println(" Zzzzzz, vous avez bien dormis ! \n");
				System.out.println("Ou voulez vous allez : ");
			}
			else if(numero == 5)
			{
				if(!tableau.hasHaut())
				{
					end = true;
					tableau.toHaut().evenement();
					
				}
				else
				{
					System.out.println("Vous ne pouvez pas aller en haut. \n");
					System.out.println("Ou voulez vous allez : ");
					
				}
			}
			
		
		}
		
	}
	
	
}
