package combat;

import java.util.ArrayList;
import java.util.HashMap;
import joueur.Joueur;
import monstre.Monstre;
import scan.Scan;
import tableau.TableauMonstre;
import joueur.Level;

public class Combat {

	public static void combat(TableauMonstre tableau) {
		int idMonstre = 0;

		boolean cycle = false;
		Joueur joueur = Joueur.get();
		boolean fin = false;

		ArrayList<Monstre> monstres = tableau.getAllMonstre();
		HashMap<Integer, Monstre> hMonstres = new HashMap<>();

	
		while (fin == false) // Debut combat
		{
			System.out.println("Vous avez " + joueur.getVie() + " PV.");
			System.out.println(tableau.getAllNomVieMonstre() + ".\n");
			

			idMonstre = 0;
			int id = 1;
			for (Monstre monstre : monstres)// Verifie que dans la case, il reste des monstres vivant
			{
				if (monstre.isMort() == false) {
					hMonstres.put(id, monstres.get(idMonstre));
					id++;
				}
				idMonstre++;
			}
			ArrayList<Entite> entites = Action.action(monstres);
			cycle = false;
			while (cycle == false) // Debut d'une partie de tour
			{
				System.out.println("\n");
				float action = entites.get(0).getAction();
				for (Entite entite : entites) {
					
					System.out.println(entite.getNom() + " " + entite.getAction()  + " - : " + action);
					entite.setAction(entite.getAction() - action);
					
				}

				if (entites.get(0) instanceof Joueur) {

					System.out.println("\nQui voulez-vous attaquer ?");
					int i = 0;
					for (Monstre hMonstre : monstres)// Verifie que dans la case, il reste des monstres vivant
					{
						i++;
						System.out.println(i + " - Attaquer " + hMonstre.getNom());
					}

					System.out.println(i + 1 + " - Fuir \n");

					boolean ischoix = true;
					boolean isCorrectNumero = false;
					int choix = 0;

					do {
						String reponse = Scan.scanner();
						ischoix = true;
						choix = 0;

						try {
							choix = Integer.parseInt(reponse);
						} catch (NumberFormatException e) {
							ischoix = false;
						}

						if (!ischoix) {
							System.out.println("Vous devez mettre entre 1 et " + (hMonstres.size() + 1) + " ! ");
						} else {
							if (choix >= 0 && choix <= hMonstres.size() + 1) {
								isCorrectNumero = true;
							} else {
								System.out.println("Vous devez mettre entre 1 et " + (hMonstres.size() + 1) + " ! ");
							}
						}
					} while (!isCorrectNumero);

					if (choix <= hMonstres.size()) // Attaque
					{

						float gold = hMonstres.get(choix).getGold();
						float exp = hMonstres.get(choix).getExperience();

						if (joueur.getMana() >= joueur.getArme().getCoutMana()) {
							joueur.attaque(hMonstres.get(choix));
							if (hMonstres.get(choix).getVie() <= 0) {

								hMonstres.get(choix).setMort(true);
								joueur.addGold(gold);
								joueur.addExperience(exp);
								System.out.println("Vous avez battue le " + hMonstres.get(choix).getNom() + " et gagné "
										+ gold + " gold et " + exp + " experience !");
								Level.levelUpdate(joueur);
							} else {
								hMonstres.get(choix).attaque(joueur);
								if (joueur.getVie() <= 0) {
									joueur.setMort(true);
									System.out.println("La partie est terminée, tu es un noob ! ");
									System.exit(0);
								}
							}
						} else if (joueur.getMana() <= joueur.getArme().getCoutMana()) {
							System.out.println("Vous n'avez pas assez de mana et donc en regeneré 1 de mana.");
							joueur.setMana(joueur.getMana() + 1);
						}

						
						cycle = true;
					}
					/*
					 * else // fuite
					 * {
					 * float fuite = (joueur.getVitesse() / monstre.getVitesse())*50;
					 * int probafuite = Math.round(fuite);
					 * 
					 * int chanceDeFuite = new Random().nextInt(101);
					 * if(chanceDeFuite <= probafuite)
					 * {
					 * System.out.println("Vous avez réussi à fuir comme un noob, bravo !\n");
					 * cycle = true;
					 * Tableau.getTableau(joueur.getAncienTableauX(),
					 * joueur.getAncienTableauY()).evenement();
					 * }
					 * else
					 * {
					 * System.out.println("Vous n'avez pas réussi a fuir, la honte !\n ");
					 * monstre.attaque(joueur);
					 * if(joueur.getVie() <= 0)
					 * {
					 * joueur.setMort(true);
					 * cycle = true;
					 * System.out.println("La partie est terminé, t'es trop nul ! ");
					 * System.exit(0);
					 * }
					 * 
					 * }
					 * 
					 * }
					 * 
					 * }
					 */

					

				}
				else {

					Monstre monstre = (Monstre) entites.get(0);
					monstre.attaque(joueur);
					if (joueur.getVie() <= 0) {
						joueur.setMort(true);
						cycle = true;
						System.out.println("La partie est terminée, tu es un noob ! ");
						System.exit(0);
					}

				}
				fin = tableau.isAllMort();
				System.out.println("remove : " + entites.get(0).getNom());
				entites.remove(0);

			}

		}

	}
}