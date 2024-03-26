package combat;

import java.util.ArrayList;
import java.util.Random;


import joueur.Joueur;
import monstre.Monstre;
import scan.Scan;
import tableau.Tableau;
import tableau.TableauMonstre;
import joueur.Level;

public class Combat
{

	public static void combat(TableauMonstre tableau)
	{
		int idMonstre = 0;
		
		boolean cycle = false;
		Joueur joueur = Joueur.get();
		boolean fin = false;
		

		

		float gold = tableau.getMonstre(idMonstre).getGold();
		float exp = tableau.getMonstre(idMonstre).getExperience();
		
	
		ArrayList<Monstre> monstres = tableau.getAllMonstre();

		if(fin == false)
		{
			System.out.println("Vous avez " + joueur.getVie() + " PV.");
			System.out.println(tableau.getAllNomVieMonstre() + ".");
			Action.action(tableau);
			System.out.println("");
			
			while(cycle == false)
			{
				System.out.println("Qui voulez-vous attaquer ?");
				idMonstre = 0;
				for(Monstre monstre  : monstres)
				{
					System.out.println(idMonstre + 1 + " - Attaquer " + monstre.getNom());
					idMonstre ++;
				}
				
				System.out.println(idMonstre + 1 + " - Fuir \n");
				
				boolean isNumero = true;
				boolean isCorrectNumero = false;
				int numero = 0;
				
				do  
				{
					String reponse = Scan.scanner();
					isNumero = true;
					numero = 0;
					
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
						System.out.println("Vous devez mettre entre 0 et " + (monstres.size()+1) + " ! ");
					}
					else
					{
						if(numero >= 0 && numero <= monstres.size() +1)
						{
							isCorrectNumero = true;
						}
					}
				} while(!isCorrectNumero);
				
				/*
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
								joueur.addGold(gold);
								joueur.addExperience(exp);
								System.out.println("Vous avez gagnez le combat et gagné " + gold + " gold et " + exp + " experience !");
								Level.levelUpdate(joueur);
								cycle = true;
							}
							else
							{
								monstre.attaque(joueur);
								if(joueur.getVie() <= 0)
								{
									joueur.setMort(true);
									cycle = true;
									System.out.println("La partie est terminée, tu es un noob ! ");
									System.exit(0);
								}
							}
						}
						else if (joueur.getMana() <= joueur.getArme().getCoutMana())
						{
							System.out.println("Vous n'avez pas assez de mana et donc en regeneré 1 de mana.");
							joueur.setMana(joueur.getMana() + 1);
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
									joueur.addGold(gold);
									joueur.addExperience(exp);
									Level.levelUpdate(joueur);
									System.out.println("Vous avez gagnez le combat et gagné " + gold + " gold et " + exp + " experience !");
									
									cycle = true;
								}
								else
								{
									monstre.attaque(joueur);
									System.out.println("Le monstre a été plus rapide et vous a infligez " + monstre.getAtk() + " dégats.");
									if(joueur.getVie() <= 0)
									{
										joueur.setMort(true);
										cycle = true;
										System.out.println("La partie est terminée, tu es un noob ! ");
										System.exit(0);
									}
								}
							}
							else if (joueur.getMana() <= joueur.getArme().getCoutMana())
							{
								System.out.println("Vous n'avez pas assez de mana et donc en regeneré 1 de mana.");
								joueur.setMana(joueur.getMana() + 1);
							}
						}
						else
						{
							monstre.attaque(joueur);
							if(joueur.getVie() <= 0)
							{
								joueur.setMort(true);
								cycle = true;
								System.out.println("La partie est terminée, tu es un noob ! ");
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
										joueur.addGold(gold);
										joueur.addExperience(exp);
										Level.levelUpdate(joueur);
										System.out.println("Vous avez gagnez le combat et gagné " + gold + " gold et " + exp + " experience !");
										cycle = true;
									}
								}
								else if (joueur.getMana() <= joueur.getArme().getCoutMana())
								{
									System.out.println("Vous n'avez pas assez de mana et donc en regeneré 1 de mana.");
									joueur.setMana(joueur.getMana() + 1);
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
							cycle = true;
							System.out.println("La partie est terminée, tu es un noob ! ");
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
									joueur.addGold(gold);
									joueur.addExperience(exp);
									Level.levelUpdate(joueur);
									System.out.println("Vous avez gagnez le combat et gagné " + gold + " gold et " + exp + " experience !");
									cycle = true;
								}
							}
							else if (joueur.getMana() <= joueur.getArme().getCoutMana())
							{
								System.out.println("Vous n'avez pas assez de mana et donc en regeneré 1 de mana.");
								joueur.setMana(joueur.getMana() + 1);
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
						System.out.println("Vous avez réussi à fuir comme un noob, bravo !\n");
						cycle = true;
						Tableau.getTableau(joueur.getAncienTableauX(), joueur.getAncienTableauY()).evenement();
					}
					else
					{
						System.out.println("Vous n'avez pas réussi a fuir, la honte !\n ");
						monstre.attaque(joueur);
						if(joueur.getVie() <= 0)
						{
							joueur.setMort(true);
							cycle = true;
							System.out.println("La partie est terminé, t'es trop nul ! ");
							System.exit(0);
						}
						
					}
					
				}	
					
			}*/

		fin = tableau.isAllMort();
		}
		
		
	}
		
	}
	
	
}
