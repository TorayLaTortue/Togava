package joueur;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class Objet {
    
    private static HashMap<Integer, Object> hInventaire = new LinkedHashMap<>();
    private String nom;
    private String description;

    public Objet()
    {

    }

    public static void addObjet(Object obj)
    {
        hInventaire.put(hInventaire.size() + 1, obj);
    }



    public static HashMap<Integer, Object> gethInventaire() {
        return hInventaire;
    }

    public static Object getObjet(int i)
    {
        return hInventaire.get(i);
    }
}
