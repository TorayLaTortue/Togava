package combat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import joueur.Joueur;
import monstre.Monstre;
import tableau.TableauMonstre;

public class Action {
    
    public static void action(TableauMonstre tableau) {
        // Déclaration et initialisation des listes
        Joueur joueur = Joueur.get();
        List<Monstre> monstres = tableau.getAllMonstre();
        List<Entite> entites = new ArrayList<>();

        for (Monstre monstre : monstres) {
            entites.add(monstre);
        }
        
        entites.add(joueur);

        // Définir le comparateur personnalisé pour trier par la stat action
        Comparator<Entite> comparator = new Comparator<Entite>() {
            @Override
            public int compare(Entite entite1, Entite entite2) {
                float action1 = entite1.getAction();
                float action2 = entite2.getAction();
                // Compare les stats d'action
                return Float.compare(action1, action2);
            }
        };

        // Trier la liste d'entités en utilisant le comparateur
        Collections.sort(entites, comparator);

        // La liste d'entités est maintenant triée par la stat action

        for(Entite entite : entites){
            System.out.println(entite.getNom() + " a " +entite.getAction() + " actions.");
        }
    }
}
