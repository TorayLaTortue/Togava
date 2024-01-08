package tableau;

import java.util.Random;
import joueur.Armes;
import marchand.Marchand;
import monstre.Monstre;
import monstre.TypeMonstre;
import tableau.Map;



public class Map {
    private static Tableau c0;
    public static Tableau[] map() {
        int seed = new Random().nextInt(101);
        Tableau c0 = new Tableau(0, 0).addBas().addGauche().addDroite(); //spawn
        
        Tableau[] tableaux = {
            new Tableau(1, 0).addBas().addDroite().addHaut(),
            new TableauMonstre(2, 0, new Monstre(TypeMonstre.BLOB)).addGauche().addHaut(),
            new TableauMonstre(3, 0, new Monstre(TypeMonstre.DRAGON)).addDroite().addHaut(),
            new TableauMarchand(4, 0, new Marchand().addArme(Armes.CLAYMORE)).addHaut().addGauche(),
            new TableauCoffre(5, 0, Armes.EPEEPIERRE).addHaut().addDroite(),
            new Tableau(6, 0).addBas(),
            new Tableau(7, 0).addBas(),
            new Tableau(8, 0).addBas(),
            new Tableau(9, 0).addBas(),

            new TableauMonstre(0, 1, new Monstre(TypeMonstre.BLOB)).addGauche(),
            new Tableau(1, 1),
            new Tableau(2, 1),
            new TableauMonstre(3, 1, new Monstre(TypeMonstre.DRAGON)).addDroite(),
            new TableauMarchand(4, 1, new Marchand().addArme(Armes.CLAYMORE)).addHaut().addGauche(),
            new TableauCoffre(5, 1, Armes.EPEEPIERRE).addHaut().addDroite(),
            new Tableau(6, 1),
            new TableauMarchand(7, 1, new Marchand().addArme(Armes.CLAYMORE)),
            new Tableau(8, 1),
            new TableauCoffre(9, 1, Armes.EPEEPIERRE).addHaut().addDroite(),

            new Tableau(0, 3),
            new Tableau(1, 3),
            new Tableau(2, 3),
            new Tableau(3, 3),
            new Tableau(4, 3),
            new Tableau(5, 3),
            new Tableau(6, 3),
            new Tableau(7, 3),
            new Tableau(8, 3),
            new Tableau(9, 3),

            new Tableau(0, 2),
            new Tableau(1, 2),
            new Tableau(2, 2),
            new Tableau(3, 2),
            new Tableau(4, 2),
            new Tableau(5, 2),
            new Tableau(6, 2),
            new Tableau(7, 2),
            new Tableau(8, 2),
            new Tableau(9, 2),

            
        };
        //c0.evenement();
        return tableaux;

    }
    public Tableau getc0() {
            return c0;
        }
}