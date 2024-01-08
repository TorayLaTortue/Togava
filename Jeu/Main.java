package jeu;
import joueur.ChoixPersonnage;
import joueur.Joueur;
import tableau.ImageMap;
import tableau.Map;
import tableau.Tableau;

public class Main {
    public static void main(String[] args) {
        
        ChoixPersonnage choixPersonnage = new ChoixPersonnage();
        Joueur joueur = choixPersonnage.choixPersonnage();
        Tableau[] tableaux = Map.map();
        ImageMap.imageMap(tableaux);
        Tableau.getTableau(0, 0).evenement();
    }

    
    

}
