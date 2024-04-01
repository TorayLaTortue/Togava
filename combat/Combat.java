package combat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import joueur.Joueur;
import monstre.Monstre;
import scan.Scan;
import tableau.Tableau;
import tableau.TableauMonstre;
import joueur.Level;

public class Combat {

	public static void combat(TableauMonstre tableau) {
		int idMonstre = 0;

		boolean cycle = false;
		Joueur joueur = Joueur.get();

		ArrayList<Monstre> monstres = tableau.getAllMonstre();
		HashMap<Integer, Monstre> hMonstres = new HashMap<>();
		ArrayList<Joueur> joueurs = new ArrayList<>();

		boolean fin = tableau.isAllMort(monstres);

		joueurs.add(joueur);

		while (fin == false) // Debut combat
		{
			System.out.println("Vous avez " + joueur.getVie() + " PV.");
			System.out.println(tableau.getAllNomVieMonstre() + ".\n");
			
			cycle = false;
			System.out.println("\nNouveau cycle. \n");
			while (cycle == false && fin == false) // Debut d'une partie de tour
			{
				ArrayList<Entite> entites = Action.action(monstres, joueurs);

				System.out.println("\n");
				float action = entites.get(0).getAction();
				for (Entite entite : entites) {
					entite.setAction(entite.getAction() - action);
					System.out.println(entite.getNom() + " " + entite.getAction()  + " - : " + action);
				}

				if (entites.get(0) instanceof Joueur) {
					
					joueur = (Joueur) entites.get(0);

					System.out.println("\nQui voulez-vous attaquer ?");
					int i = 0;
					for (Entite entite : entites)// Verifie que dans la case, il reste des monstres vivant
					{
						if(entite instanceof Monstre)
						{
							Monstre monstre = (Monstre) entite;
							i++;
							System.out.println(i + " - Attaquer " + monstre.getNom());
							hMonstres.put(i, monstre);
						}

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
							if (choix >= 1 && choix <= hMonstres.size() +1) {
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

						joueur.resetAction(joueur.getVitesse());

						if (joueur.getMana() >= joueur.getArme().getCoutMana()) {
							joueur.attaque(hMonstres.get(choix));
							if (hMonstres.get(choix).getVie() <= 0) {

								hMonstres.get(choix).setMort(true);
								joueur.addGold(gold);
								joueur.addExperience(exp);
								System.out.println("Vous avez battue le " + hMonstres.get(choix).getNom() + " et gagné " + gold + " gold et " + exp + " experience !\n");
								entites.remove(choix);
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
					}
					else if(choix == hMonstres.size() + 1) // fuite
					{
						float fuite = (joueur.getVitesse() / hMonstres.get(1).getVitesse()) * 50;
						int probafuite = Math.round(fuite);

						int chanceDeFuite = new Random().nextInt(101);
						if (chanceDeFuite <= probafuite) {
							System.out.println("Vous avez réussi à fuir comme un noob, bravo !\n");
							cycle = true;
							Tableau.getTableau(joueur.getAncienTableauX(),
							joueur.getAncienTableauY()).evenement();
						} else {
							System.out.println("Vous n'avez pas réussi a fuir, la honte !\n ");
							hMonstres.get(1).attaque(joueur);
							if (joueur.getVie() <= 0) {
								joueur.setMort(true);
								cycle = true;
								System.out.println("La partie est terminé, t'es trop nul ! ");
								System.exit(0);
							}

						}
					}

				}
				else { //Monstre attaque joueur
					
					Monstre monstre = (Monstre) entites.get(0);
					monstre.resetAction(monstre.getVitesse());
					monstre.attaque(joueur);
					if (joueur.getVie() <= 0) {
						joueur.setMort(true);
						cycle = true;
						System.out.println("La partie est terminée, tu es un noob ! ");
						System.exit(0);
					}

				}
				
				if(hMonstres.isEmpty())
				{
					cycle = true;
				}
				fin = tableau.isAllMort(monstres);
			}

		}

}}