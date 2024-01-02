package combat;

import java.util.Random;
import java.util.Scanner;

import joueur.Joueur;
import monstre.Monstre;
import tableau.Tableau;
import tableau.TableauMonstre;

public class Combat
{

	public static void combat(TableauMonstre tableau)
	{
		boolean end = false;
		Joueur joueur = Joueur.get();
		Monstre monstre = tableau.getMonstre();
		
		if(monstre.isMort() == false)
		{
			while(end == false)
			{
				System.out.println("Vous avez " + joueur.getVie() + " pv et le " + monstre.getNom() + " a " + monstre.getVie() + " pv");
				System.out.println("Voulez vous attaquer ou fuir ?");
				
				System.out.println("1 - Attaquer ");
				System.out.println("2 - Fuir \n");
				
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
				
				
				if(numero == 1) //Attaque 
				{
					
					if(joueur.getVitesse() > monstre.getVitesse())
					{
						if(joueur.getMana() >= joueur.getArme().getCoutMana())
						{
							joueur.attaque(monstre);
							if(monstre.getVie() <= 0)
							{
								monstre.setMort(true);
								joueur.addGold(monstre.getGold());
								System.out.println("Vous avez gagnez le combat wow et gagnez " + monstre.getGold() + " gold !");
								end = true;
							}
							else
							{
								monstre.attaque(joueur);
								if(joueur.getVie() <= 0)
								{
									joueur.setMort(true);
									end = true;
									System.out.println("La partie est terminer, t'es un noob ! ");
									System.exit(0);
								}
							}
						}
						else
						{
							System.out.println("Vous n'avez pas assez de mana et donc en regenerez");
						}
						
					}
					else if(joueur.getVitesse() == monstre.getVitesse()) 
					{
						boolean chanceAttaque = new Random().nextBoolean();
						if(chanceAttaque)
						{
							if(joueur.getMana() >= joueur.getArme().getCoutMana())
							{
								joueur.attaque(monstre);
								if(monstre.getVie() <= 0)
								{
									monstre.setMort(true);
									joueur.addGold(monstre.getGold());
									System.out.println("Vous avez gagnez le combat wow et gagnez " + monstre.getGold() + " gold !");
									end = true;
								}
								else
								{
									monstre.attaque(joueur);
									if(joueur.getVie() <= 0)
									{
										joueur.setMort(true);
										end = true;
										System.out.println("La partie est terminer, t'es un noob ! ");
										System.exit(0);
									}
								}
							}
							else
							{
								System.out.println("Vous n'avez pas assez de mana et donc en regenerez");
							}
						}
						else
						{
							monstre.attaque(joueur);
							if(joueur.getVie() <= 0)
							{
								joueur.setMort(true);
								end = true;
								System.out.println("La partie est terminer, t'es un noob ! ");
								System.exit(0);
							}
							else
							{
								if(joueur.getMana() >= joueur.getArme().getCoutMana())
								{
									joueur.attaque(monstre);
									if(monstre.getVie() <= 0)
									{
										monstre.setMort(true);
										joueur.addGold(monstre.getGold());
										System.out.println("Vous avez gagnez le combat wow et gagnez " + monstre.getGold() + " gold !");
										end = true;
									}
								}
								else
								{
									System.out.println("Vous n'avez pas assez de mana et donc en regenerez");
								}
							}
						}
					}
					
					
					else
					{
						monstre.attaque(joueur);
						if(joueur.getVie() <= 0)
						{
							joueur.setMort(true);
							end = true;
							System.out.println("La partie est terminer, t'es un noob ! ");
							System.exit(0);
						}
						else
						{
							if(joueur.getMana() >= joueur.getArme().getCoutMana())
							{
								joueur.attaque(monstre);
								if(monstre.getVie() <= 0)
								{
									monstre.setMort(true);
									joueur.addGold(monstre.getGold());
									System.out.println("Vous avez gagnez le combat wow et gagnez " + monstre.getGold() + " gold !");
									end = true;
								}
							}
							else
							{
								System.out.println("Vous n'avez pas assez de mana et donc en regenerez");
							}
						}
					}	
					
				}
				else // fuite
				{
					float fuite = (joueur.getVitesse() / monstre.getVitesse())*50;
					int probafuite = Math.round(fuite);
					
					int chanceDeFuite = new Random().nextInt(101);
					if(chanceDeFuite <= probafuite)
					{
						System.out.println("Vous avez réussi a fuir comme un noob, bravo !\n");
						end = true;
						Tableau.getTableau(joueur.getAncienTableau()).evenement();
					}
					else
					{
						System.out.println("Vous n'avez pas réussi a fuir, la honte !\n ");
						monstre.attaque(joueur);
						if(joueur.getVie() <= 0)
						{
							joueur.setMort(true);
							end = true;
							System.out.println("La partie est terminer, t'es trop nul ! ");
							System.exit(0);
						}
						
					}
					
				}	
					
			}
		}
		else
		{
			System.out.println("Il y a un cadavre d'un " + monstre.getNom());
		}
		
		
		
	}
	
	
}
