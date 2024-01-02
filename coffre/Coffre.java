package coffre;

import java.util.Scanner;

import joueur.Armes;
import joueur.Joueur;
import tableau.TableauCoffre;

public class Coffre
{
	public static void coffre(TableauCoffre tableau)
	{
		Joueur joueur = Joueur.get();
		Armes coffre = tableau.getCoffre();
		boolean end = false;
		
		System.out.println("Oh un coffre sauvage apparait !");
		
		
		if(coffre != Armes.AUCUNE)
		{
			System.out.println("Vous ouvrez le coffre et decouvrez : " + coffre.getNom());
			
			if(joueur.getArme() == Armes.AUCUNE)
			{
				System.out.println("Vous n'avez pas d'arme ,deux choix s'offre a vous : ");
			}
			else
			{
				System.out.println("Vous avez " + joueur.getArme().getNom() + ", deux choix s'offre a vous :");
			}
			
			while(end == false)
			{
				
				System.out.println("1 - Prendre ");
				System.out.println("2 - Partir \n");
				
				boolean isNumero = true;
				boolean isCorrectNumero = false;
				int numero = 0;
				
				do  
				{
					Scanner in = new Scanner(System.in);
					isNumero = true;
					numero = 0;
					
	
					String reponse = in.nextLine();
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
						System.out.println("Vous devez mettre 1 ou 2 ! >:c");
					}
					else
					{
						if(numero == 1 || numero == 2)
						{
							isCorrectNumero = true;
						}
					}
				} while(!isCorrectNumero);
			
				if(numero == 1)
				{
					
					joueur.setArme(coffre);
					System.out.println("Vous equipez l'arme.\n" );
					tableau.setCoffre(Armes.AUCUNE);
					end = true;
				}
				
				if(numero == 2)
				{
					System.out.println("Vous etes partie sans prendre l'arme.");
					end = true;
				}
				
			
			
			}
		}
		else
		{
			System.out.println("Malheureusement le coffre à déja été ouvert.");
		}
	}
}
