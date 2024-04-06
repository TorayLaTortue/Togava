package marchand;

import java.util.ArrayList;
import java.util.HashMap;
import deplacement.Deplacement;
import joueur.Joueur;
import objet.Armes;
import objet.Objet;
import pet.TypePets;
import scan.Scan;
import tableau.Tableau;
import tableau.TableauMarchand;

public class Marchand {

	private ArrayList<Armes> armes = new ArrayList<>();
	private ArrayList<Objet> objets = new ArrayList<>();
	private ArrayList<TypePets> pets = new ArrayList<>();

	public Marchand() {

	}

	public static void trade(TableauMarchand tableau) {
		Joueur joueur = Joueur.get();
		ArrayList<Armes> armesMarchand = tableau.getMarchand().getArmes();
		ArrayList<TypePets> petsMarchand = tableau.getMarchand().getPets();
		ArrayList<Objet> objetsMarchand = tableau.getMarchand().getObjets();
		HashMap<Integer, Object> hListObjet = new HashMap<>();

		boolean end = false;
		while (end == false) {

			if (armesMarchand.isEmpty() && petsMarchand.isEmpty() && objetsMarchand.isEmpty()) {
				System.out.println("Il n'y a plus de marchand.\n");
				Deplacement.deplacement(tableau);
				return;
			}

			int i = 1;
			System.out.println("Un marchand apparait devant vous !\n");
			System.out.println("\nQue voulez vous faire ?\n ");
			for (Armes armes : armesMarchand) {
				System.out.println(i + " - Acheter : " + armes.getNom());
				hListObjet.put(i, armes);
				i++;
			}
			for (TypePets pets : petsMarchand) {
				System.out.println(i + " - Acheter : " + pets.getNom());
				hListObjet.put(i, pets);
				i++;
			}
			for (Objet objets : objetsMarchand) {
				System.out.println(i + " - Acheter : " + objets.getNom());
				hListObjet.put(i, objets);
				i++;
			}
			System.out.println(i++ + " - Partir d'ici. ");

			if (armesMarchand.isEmpty()) {
				System.out.println("Il n'y a plus de marchand. \n");
				Deplacement.deplacement(tableau);
				return;
			}

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
					System.out.println("Vous devez mettre entre 1 et " + hListObjet.size() + " ! >:c");
				} else {

					if (numero <= hListObjet.size())// Achat
					{
						if (hListObjet.get(numero) instanceof Armes) // Armes
						{
							Armes arme = (Armes) hListObjet.get(numero);
							if (arme.getCouts() <= joueur.getGold()) {
								isCorrectNumero = true;
								joueur.setArme(arme);
								joueur.subGold(arme.getCouts());
								System.out.println("Vous equipez l'arme. \n");
								armesMarchand.remove(arme);
							} else {
								System.out.println("Vous n'avez pas assez d'argent ! ");
							}
						} else if (hListObjet.get(numero) instanceof Objet) // Objet
						{
							Objet objet = (Objet) hListObjet.get(numero);
							if (objet.getCouts() <= joueur.getGold()) {
								isCorrectNumero = true;
								objet.useAll(joueur);
								joueur.subGold(objet.getCouts());
								System.out.println("Vous utilisez l'objet. \n");
								objetsMarchand.remove(objet);
							} else {
								System.out.println("Vous n'avez pas assez d'argent ! ");
							}
						} else if (hListObjet.get(numero) instanceof TypePets) // Pets
						{
							TypePets pets = (TypePets) hListObjet.get(numero);
							if (pets.getCouts() <= joueur.getGold()) {
								isCorrectNumero = true;
								joueur.setTypePets(pets);
								joueur.subGold(pets.getCouts());
								System.out.println("Vous utilisez l'objet. \n");
								petsMarchand.remove(pets);
							} else {
								System.out.println("Vous n'avez pas assez d'argent ! ");
							}
						}

					} else if (numero == hListObjet.size() + 1) // Fuite
					{
						isCorrectNumero = true;
						System.out.println("Vous partez.\n");
						Tableau.getTableau(joueur.getAncienTableauX(), joueur.getAncienTableauY()).evenement();
					} else {
						System.out.println("Veuillez choisir un bon numéro. ");
					}
				}
			} while (!isCorrectNumero);
		}
	}




	public Marchand addArme(Armes arme) {
		armes.add(arme);
		return this;
	}

	public Marchand addObjet(Objet objet) {
		objets.add(objet);
		return this;
	}

	public Marchand addPets(TypePets pet) {
		pets.add(pet);
		return this;
	}

	public ArrayList<Armes> getArmes() {
		return armes;
	}

	public ArrayList<TypePets> getPets() {
		return pets;
	}

	public ArrayList<Objet> getObjets() {
		return objets;
	}
}
