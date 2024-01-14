package coffre;

import joueur.Joueur;
import objet.Armes;
import objet.Objet;
import scan.Scan;
import tableau.TableauCoffre;

public class Coffre {
	public static void coffre(TableauCoffre tableau) {
		Joueur joueur = Joueur.get();
		Armes coffreArmes = tableau.getCoffreArmes();
		Objet coffreObjet = tableau.getCoffreObjet();
		boolean end = false;

		System.out.println("Oh un coffre sauvage apparait !");

		if (coffreArmes != Armes.AUCUNE) {
			System.out.println("Vous ouvrez le coffre et decouvrez : " + coffreArmes.getNom());

			if (joueur.getArme() == Armes.AUCUNE) {
				System.out.println("Vous n'avez pas d'arme ,deux choix s'offre a vous : ");
			} else {
				System.out.println("Vous avez " + joueur.getArme().getNom() + ", deux choix s'offre a vous :");
			}

			while (end == false) {

				System.out.println("1 - Prendre ");
				System.out.println("2 - Partir \n");

				boolean isNumero = true;
				boolean isCorrectNumero = false;
				int numero = 0;

				do {
					String reponse = Scan.scanner();
					isNumero = true;
					numero = 0;

					try {
						numero = Integer.parseInt(reponse);
					} catch (NumberFormatException e) {
						isNumero = false;
					}

					if (!isNumero) {
						System.out.println("Vous devez mettre 1 ou 2 ! >:c");
					} else {
						if (numero == 1 || numero == 2) {
							isCorrectNumero = true;
						}
					}
				} while (!isCorrectNumero);

				if (numero == 1) {

					joueur.setArme(coffreArmes);
					System.out.println("Vous equipez l'arme.\n");
					tableau.setCoffreArmes(Armes.AUCUNE);
					end = true;
				}

				if (numero == 2) {
					System.out.println("Vous etes partie sans prendre l'arme.");
					end = true;
				}

			}
		} else if (coffreObjet != Objet.RIEN) {
			System.out.println("Vous ouvrez le coffre et decouvrez : " + coffreObjet.getNom());

			while (end == false) {

				System.out.println("1 - Prendre ");
				System.out.println("2 - Partir \n");

				boolean isNumero = true;
				boolean isCorrectNumero = false;
				int numero = 0;

				do {
					String reponse = Scan.scanner();
					isNumero = true;
					numero = 0;

					try {
						numero = Integer.parseInt(reponse);
					} catch (NumberFormatException e) {
						isNumero = false;
					}

					if (!isNumero) {
						System.out.println("Vous devez mettre 1 ou 2 ! >:c");
					} else {
						if (numero == 1 || numero == 2) {
							isCorrectNumero = true;
						}
					}
				} while (!isCorrectNumero);

				if (numero == 1) {
				
					if(coffreObjet.getVie() > 0)
					{coffreObjet.useVie(joueur);}
					if(coffreObjet.getVieMax() > 0)
					{joueur.setVieMax(coffreObjet.useVieMax(joueur) + joueur.getVieMax());}
					if(coffreObjet.getMana() > 0)
					{joueur.setMana(coffreObjet.useMana(joueur) + joueur.getMana());}
					if(coffreObjet.getManaMax() > 0)
					{joueur.setManaMax(coffreObjet.useManaMax(joueur) + joueur.getManaMax());}
					if(coffreObjet.getVitesse() > 0)
					{joueur.setVitesse(coffreObjet.useVitesse(joueur) + joueur.getVitesse());}
					
					tableau.setCoffreObjet(Objet.RIEN);
					end = true;
				}

				if (numero == 2) {
					System.out.println("Vous etes partie sans prendre l'objet.");
					end = true;
				}
			}

		} else {
			System.out.println("Malheureusement le coffre à déja été ouvert.");
		}
	}
}