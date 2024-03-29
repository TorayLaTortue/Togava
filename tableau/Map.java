package tableau;

import java.util.Random;

import marchand.Marchand;
import monstre.Monstre;
import monstre.TypeMonstre;
import objet.Armes;
import objet.Objet;
import tableau.Map;



public class Map {
 
    public static Tableau[] map() {
        // int seed = new Random().nextInt(101);
       
        
        Tableau[] tableaux = {
            new Tableau(0, 0).addBas(),
            new TableauMonstre(1, 0, new Monstre(TypeMonstre.SQUELETTE), new Monstre(TypeMonstre.BLOB)),
            new TableauMonstre(2, 0, new Monstre(TypeMonstre.SQUELETTE)),
            new TableauCoffre(3, 0, Armes.AUCUNE, Objet.POTIONPOLY),
            new TableauMarchand(4, 0, new Marchand().addArme(Armes.CLAYMORE)).addHaut().addGauche(),
            new TableauCoffre(5, 0, Armes.EPEEPIERRE , Objet.RIEN).addHaut().addDroite(),
            new Tableau(6, 0).addBas(),
            new Tableau(7, 0).addBas(),
            new Tableau(8, 0).addBas(),
           

            new TableauMonstre(0, 1, new Monstre(TypeMonstre.BLOB)).addGauche(),
            new Tableau(1, 1),
            new Tableau(2, 1),
            new TableauMonstre(3, 1, new Monstre(TypeMonstre.DRAGON)).addDroite(),
            new TableauMarchand(4, 1, new Marchand().addArme(Armes.CLAYMORE)).addHaut().addGauche(),
            new TableauCoffre(5, 1, Armes.EPEEPIERRE , Objet.RIEN).addHaut().addDroite(),
            new Tableau(6, 1),
            new TableauMarchand(7, 1, new Marchand().addArme(Armes.CLAYMORE)),
            new Tableau(8, 1),
            

            new Tableau(0, 2),
            new Tableau(1, 2),
            new Tableau(2, 2),
            new Tableau(3, 2),
            new Tableau(4, 2),
            new Tableau(5, 2),
            new Tableau(6, 2),
            new Tableau(7, 2),
            new Tableau(8, 2),
            

            new Tableau(0, 3),
            new Tableau(1, 3),
            new Tableau(2, 3),
            new Tableau(3, 3),
            new Tableau(4, 3),
            new Tableau(5, 3),
            new Tableau(6, 3),
            new Tableau(7, 3),
            new Tableau(8, 3),
            

            new Tableau(0, 4),
            new Tableau(1, 4),
            new Tableau(2, 4),
            new Tableau(3, 4),
            new Tableau(4, 4),
            new Tableau(5, 4),
            new Tableau(6, 4),
            new Tableau(7, 4),
            new Tableau(8, 4),

            new Tableau(6, 6),
            new Tableau(7, 7),
            new Tableau(8, 8),
            

            
        };
        //c0.evenement();
        return tableaux;

    }
    
}