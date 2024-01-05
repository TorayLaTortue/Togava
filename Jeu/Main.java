package jeu;

import joueur.Armes;
import joueur.Joueur;
import joueur.TypeJoueur;
import joueur.ChoixPersonnage;
import marchand.Marchand;
import monstre.Monstre;
import monstre.TypeMonstre;
import tableau.Tableau;
import tableau.TableauCoffre;
import tableau.TableauMarchand;
import tableau.TableauMonstre;


public class Main
{
	public static void main(String[] args)
	{
		Tableau c0 = new Tableau(0, 0).addBas();
		Tableau c1 = new TableauMonstre(2, 0, new Monstre(TypeMonstre.BLOB)).addBas().addGauche();
		Tableau c2 = new Tableau(2, 1).addBas();
		Tableau c3 = new TableauMonstre(0, 1, new Monstre(TypeMonstre.DRAGON)).addBas().addDroite();
		Tableau c4 = new TableauMarchand(1, 1, new Marchand().addArme(Armes.CLAYMORE)).addHaut().addGauche();
		Tableau c5 = new TableauCoffre(2, 1, Armes.EPEEPIERRE).addHaut().addDroite();
		Tableau c6 = new Tableau(3 ,1).addHaut().addDroite().addGauche(); // fin
		

		
		ChoixPersonnage choixPersonnage = new ChoixPersonnage();
        Joueur chevalier = choixPersonnage.choixPersonnage();
		
		c2.evenement();
		

	}
	
	
}
