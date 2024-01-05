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
		Tableau c1 = new TableauMonstre(1, new Monstre(TypeMonstre.BLOB)).addBas().addGauche();
		Tableau c2 = new Tableau(2).addBas();
		Tableau c3 = new TableauMonstre(3, new Monstre(TypeMonstre.DRAGON)).addBas().addDroite();
		Tableau c4 = new TableauMarchand(11, new Marchand().addArme(Armes.CLAYMORE)).addHaut().addGauche();
		Tableau c5 = new TableauCoffre(12, Armes.EPEEPIERRE).addHaut().addDroite();
		Tableau c6 = new Tableau(13).addHaut().addDroite().addGauche(); // fin
		

		
		ChoixPersonnage choixPersonnage = new ChoixPersonnage();
        Joueur chevalier = choixPersonnage.choixPersonnage();
		
		c2.evenement();
		

	}
	
	
}
