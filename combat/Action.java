package combat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


import joueur.Joueur;
import monstre.Monstre;


public class Action {
    
    public static ArrayList<Entite> action(ArrayList<Monstre> monstres, ArrayList<Joueur> joueurs) {
        
        ArrayList<Entite> entites =  new  ArrayList<>();

        for(Joueur joueur : joueurs)
        {
            if(!joueur.isMort()){
                entites.add(joueur);
            }
        }

        for(Monstre monstre : monstres)
        {
            if (!monstre.isMort()) {
                entites.add(monstre);
            }
        }
             
        Comparator<Entite> comparator = new Comparator<Entite>() {
            @Override
            public int compare(Entite entite1, Entite entite2) {
                float action1 = entite1.getAction();
                float action2 = entite2.getAction();
                // Compare les stats d'action
                return Float.compare(action1, action2);
            }
        };

        Collections.sort(entites, comparator);

        for(Entite entite : entites){
            System.out.println(entite.getNom() + " a " + entite.getAction() + " actions.");
        }
        
        return entites;
    }
}
