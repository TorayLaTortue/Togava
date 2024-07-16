package jeu;
import joueur.ChoixPersonnage;
import joueur.Inventaire;
import joueur.Joueur;
import objet.Armes;
import tableau.Map;
import tableau.Tableau;


public class Main {
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        
        ChoixPersonnage choixPersonnage = new ChoixPersonnage();
        Joueur joueur = choixPersonnage.choixPersonnage();
        Tableau[] tableaux = Map.map();



        Inventaire.addObjet(Armes.CLAYMORE);
        Armes armes = (Armes) Inventaire.getObjet(1);
        System.out.println(armes.getNom());


        //ImageMap.imageMap(tableaux);
        Tableau.getTableau(0, 0).evenement();
    }


    /*Tableau tableau = Tableau.getTableau(1, 0);
        TableauMonstre tableauMonstre = (TableauMonstre) tableau;
        System.out.println("X: " + tableauMonstre.getX());
        System.out.println("Y: " + tableauMonstre.getY());
        System.out.println("Monstre: " + tableauMonstre.getMonstre(1).getNom()); */
}
