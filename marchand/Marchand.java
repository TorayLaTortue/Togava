package marchand;

import java.util.ArrayList;
import java.util.HashMap;
import deplacement.Deplacement;
import joueur.Joueur;
import objet.Armes;
import objet.Objet;
import pet.TypePets;
import scan.Scan;
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

		boolean end = false;
		while (end == false) {
			HashMap<Integer, Object> hListObjet = new HashMap<>();

			if (armesMarchand.isEmpty() && petsMarchand.isEmpty() && objetsMarchand.isEmpty()) {
				System.out.println("Il n'y a plus de marchand.\n");
				end = true;
				Deplacement.deplacement(tableau);
				return;
			} else {
				System.out.println("Un marchand apparait devant vous !\n");
			}

			int i = 0;
			System.out.println("\nQue voulez vous faire ?\n ");
			for (Armes armes : armesMarchand) {
				i++;
				System.out.println(i + " - Acheter : " + armes.getNom());
				hListObjet.put(i, armes);

			}
			for (TypePets pets : petsMarchand) {
				i++;
				System.out.println(i + " - Acheter : " + pets.getNom());
				hListObjet.put(i, pets);

			}
			for (Objet objets : objetsMarchand) {
				i++;
				System.out.println(i + " - Acheter : " + objets.getNom());
				hListObjet.put(i, objets);

			}
			System.out.println(i++ + " - Partir d'ici. ");

			int numero = Scan.scannerInt(i);

			if (numero <= hListObjet.size())// Achat
			{
				if (hListObjet.get(numero) instanceof Armes) // Armes
				{
					Armes arme = (Armes) hListObjet.get(numero);
					if (arme.getCouts() <= joueur.getGold()) {

						joueur.setArme(arme);
						joueur.subGold(arme.getCouts());
						System.out.println("Vous equipez : " + arme.getNom() + ". \n");
						armesMarchand.remove(arme);
					} else {
						System.out.println("Vous n'avez pas assez d'argent ! ");
					}
				} else if (hListObjet.get(numero) instanceof Objet) // Objet
				{
					Objet objet = (Objet) hListObjet.get(numero);
					if (objet.getCouts() <= joueur.getGold()) {

						objet.useAll(joueur);
						joueur.subGold(objet.getCouts());
						System.out.println("Vous utilisez : " + objet.getNom() + ". \n");
						objetsMarchand.remove(objet);
					} else {
						System.out.println("Vous n'avez pas assez d'argent ! ");
					}
				} else if (hListObjet.get(numero) instanceof TypePets) // Pets
				{
					TypePets pets = (TypePets) hListObjet.get(numero);
					if (pets.getCouts() <= joueur.getGold()) {

						joueur.setTypePets(pets);
						joueur.subGold(pets.getCouts());
						System.out.println("Vous equipez : " + pets.getNom() + ". \n");
						petsMarchand.remove(pets);
					} else {
						System.out.println("Vous n'avez pas assez d'argent ! ");
					}
				}

			} else if (numero == hListObjet.size() + 1) // Partir
			{

				System.out.println("Vous partez.\n");
				Deplacement.deplacement(tableau);
				return;
			} else {
				System.out.println("Veuillez choisir un bon numéro. ");
			}
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
