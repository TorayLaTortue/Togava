package marchand;

import java.util.ArrayList;
import java.util.Scanner;

import deplacement.Deplacement;
import joueur.Joueur;
import objet.Armes;
import tableau.Tableau;
import tableau.TableauMarchand;

public class Marchand
{
	
	private ArrayList<Armes> armes = new ArrayList<>();
	
	public Marchand()
	{
		
	}

	public static void trade(TableauMarchand tableau)
	{
		Joueur joueur = Joueur.get();
		ArrayList<Armes> armesMarchand = tableau.getMarchand().getArmes();
		
		if(armesMarchand.isEmpty())
		{
			System.out.println("Il n'y a plus de marchand. \n");
			Deplacement.deplacement(tableau);
			return;
		}
		String marchandise = "";
		for(Armes armes : armesMarchand)
		{
			marchandise += armes.getNom() + " et ";
		}
		String nomMarchandise = marchandise.substring(0, marchandise.length() - 4);
		System.out.println("Un marchand qui vend "+ nomMarchandise + " apparait devant vous !");
		
		boolean end = false;
		
		while(end == false)
		{
			if(armesMarchand.isEmpty())
			{
				System.out.println("Il n'y a plus de marchand. \n");
				Deplacement.deplacement(tableau);
				return;
			}
			
			System.out.println("Que voulez vous achetez ?\n ");
			
			if(armesMarchand.size() >= 1)
			{
				System.out.println("1 - " + armesMarchand.get(0).getNom());
			}
			if(armesMarchand.size() >= 2)
			{
				System.out.println("2 - " + armesMarchand.get(1).getNom());
			}
			if(armesMarchand.size() >= 3)
			{
				System.out.println("3 - " + armesMarchand.get(2).getNom());
			}
			
			System.out.println("4 - Partir. ");

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
					System.out.println("Vous devez mettre entre 1 et 4 ! >:c");
				}
				else
				{
					if(armesMarchand.size() >= 1 && numero == 1)
					{
						if(armesMarchand.get(0).getCouts() <= joueur.getGold())
						{
							isCorrectNumero = true;
							joueur.setArme(armesMarchand.get(0));
							joueur.subGold(armesMarchand.get(0).getCouts());
							System.out.println("Vous equipez l'objet. \n");
							armesMarchand.remove(0);					
						}
						else
						{
							System.out.println("Vous n'avez pas assez d'argent ! ");
						}
					}
					
					
					else if(armesMarchand.size() >= 2 && numero == 2)
					{
						if(armesMarchand.get(1).getCouts() <= joueur.getGold())
						{
							isCorrectNumero = true;
							joueur.setArme(armesMarchand.get(1));
							joueur.subGold(armesMarchand.get(1).getCouts());
							System.out.println("Vous equipez l'objet. \n");
							armesMarchand.remove(1);
						}
						else
						{
							System.out.println("Vous n'avez pas assez d'argent ! ");
						}
					}
					
					
					else if (armesMarchand.size() >= 3 && numero == 3)
					{
						if(armesMarchand.get(1).getCouts() <= joueur.getGold())
						{
							isCorrectNumero = true;
							joueur.setArme(armesMarchand.get(2));
							joueur.subGold(armesMarchand.get(2).getCouts());
							System.out.println("Vous equipez l'objet. \n");
							armesMarchand.remove(2);
						}
						else
						{
							System.out.println("Vous n'avez pas assez d'argent ! ");
						}
					}
					
					
					else if (numero == 4)
					{
						isCorrectNumero = true;
						System.out.println("Vous partez. \n");
						Tableau.getTableau(joueur.getAncienTableauX(), joueur.getAncienTableauY()).evenement();
					}
					else
					{
						System.out.println("Veuillez choisir un bon numéro. ");
					}
				}
			} while(!isCorrectNumero);
			
		}
	}
	
	public Marchand addArme(Armes arme)
	{
		armes.add(arme);
		return this;
	}

	public Marchand addPotion(Armes arme)
	{
		armes.add(arme);
		return this;
	}


	
	
	public ArrayList<Armes> getArmes()
	{
		return armes;
	}

	
}
