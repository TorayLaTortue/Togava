package coffre;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import deplacement.Deplacement;
import joueur.Joueur;
import objet.Armes;
import objet.Objet;
import scan.Scan;
import tableau.TableauCoffre;

public class Coffre {

	private ArrayList<Armes> armes = new ArrayList<>();
	private ArrayList<Objet> objets = new ArrayList<>();

	public Coffre() {

	}

	public static void ouverture(TableauCoffre tableau) {
		Joueur joueur = Joueur.get();
		ArrayList<Armes> armesCoffre = tableau.getCoffre().getArmes();
		ArrayList<Objet> objetsCoffre = tableau.getCoffre().getObjets();
		boolean end = false;

		while (end == false) {
			HashMap<Integer, Object> hListObjet = new HashMap<>();

			if (armesCoffre.isEmpty() && objetsCoffre.isEmpty()) {
				System.out.println("Le coffre est vide.\n");
				end = true;
				Deplacement.deplacement(tableau);
				return;
			} else {
				System.out.println("Oh un coffre sauvage apparait !");
			}

			int i = 1;
			System.out.println("\nQue voulez vous faire ?\n ");
			for (Armes armes : armesCoffre) {
				System.out.println(i + " - Prendre : " + armes.getNom());
				hListObjet.put(i, armes);
				i++;
			}
			for (Objet objets : objetsCoffre) {
				System.out.println(i + " - Prendre : " + objets.getNom());
				hListObjet.put(i, objets);
				i++;
			}
			System.out.println(i++ + " - Partir d'ici. ");

			int numero = Scan.scannerInt(i);

			if (numero <= hListObjet.size())// Prendre
			{
				if (hListObjet.get(numero) instanceof Armes) // Armes
				{
					Armes arme = (Armes) hListObjet.get(numero);

					joueur.setArme(arme);
					System.out.println("Vous equipez : " + arme.getNom() + ". \n");
					armesCoffre.remove(arme);

				} else if (hListObjet.get(numero) instanceof Objet) // Objet
				{
					Objet objet = (Objet) hListObjet.get(numero);

					objet.useAll(joueur);
					System.out.println("Vous utilisez : " + objet.getNom() + ". \n");
					objetsCoffre.remove(objet);

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

	public Coffre addArme(Armes... arme) {
		Collections.addAll(this.armes, arme);
		return this;
	}

	public Coffre addObjet(Objet... objet) {
		Collections.addAll(this.objets, objet);
		return this;
	}

	public ArrayList<Armes> getArmes() {
		return armes;
	}

	public ArrayList<Objet> getObjets() {
		return objets;
	}

}