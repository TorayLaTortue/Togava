package coffre;

import java.util.ArrayList;
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

	public Coffre()
	{

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
			}
			else{
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
	
					if (numero <= hListObjet.size())// Prendre
					{
						if (hListObjet.get(numero) instanceof Armes) // Armes
						{
							Armes arme = (Armes) hListObjet.get(numero);
						
							isCorrectNumero = true;
							joueur.setArme(arme);
							System.out.println("Vous equipez : " + arme.getNom() + ". \n");
							armesCoffre.remove(arme);
							
						} else if (hListObjet.get(numero) instanceof Objet) // Objet
						{
							Objet objet = (Objet) hListObjet.get(numero);
						
							isCorrectNumero = true;
							objet.useAll(joueur);
							System.out.println("Vous utilisez : " + objet.getNom() + ". \n");
							objetsCoffre.remove(objet);
						
						}
					} else if (numero == hListObjet.size() + 1) // Partir
					{
						isCorrectNumero = true;
						System.out.println("Vous partez.\n");
						Deplacement.deplacement(tableau);
						return;
					} else {
						System.out.println("Veuillez choisir un bon numéro. ");
					}
				}
			} while (!isCorrectNumero);
		}
	}

	public Coffre addArme(Armes... arme) {
		
		armes.addAll(arme);
		
		return this;
	}

	public Coffre addObjet(Objet objet) {
		objets.add(objet);
		return this;
	}

	public ArrayList<Armes> getArmes() {
		return armes;
	}

	public ArrayList<Objet> getObjets() {
		return objets;
	}


}