using System;
using System.Collections.Generic;
using joueur;
using deplacement;
using objet;
using scan;
using tableau;

namespace coffre
{
    public class Coffre
    {
        private List<Armes> armes = new List<Armes>();
        private List<Consommable> objets = new List<Consommable>();

        public Coffre() { }

        public static void Ouverture(TableauCoffre tableau)
        {
            Joueur joueur = Joueur.Get();
            List<Armes> armesCoffre = tableau.GetCoffre().GetArmes();
            List<Consommable> objetsCoffre = tableau.GetCoffre().GetObjets();
            bool end = false;

            while (!end)
            {
                Dictionary<int, object> hListObjet = new Dictionary<int, object>();

                if (armesCoffre.Count == 0 && objetsCoffre.Count == 0)
                {
                    Console.WriteLine("Le coffre est vide.\n");
                    end = true;
                    Deplacement.DeplacementMethod(tableau);
                    return;
                }
                else
                {
                    Console.WriteLine("Oh un coffre sauvage apparait !");
                }

                int i = 1;
                Console.WriteLine("\nQue voulez vous faire ?\n ");
                foreach (Armes armes in armesCoffre)
                {
                    Console.WriteLine(i + " - Prendre : " + armes.GetNom());
                    hListObjet.Add(i, armes);
                    i++;
                }
                foreach (Consommable objets in objetsCoffre)
                {
                    Console.WriteLine(i + " - Prendre : " + objets.GetNom());
                    hListObjet.Add(i, objets);
                    i++;
                }
                Console.WriteLine(i++ + " - Partir d'ici. ");

                int numero = Scan.ScannerInt(i);

                if (numero <= hListObjet.Count)
                {
                    if (hListObjet[numero] is Armes)
                    {
                        Armes arme = (Armes)hListObjet[numero];

                        joueur.SetArme(arme);
                        Console.WriteLine("Vous equipez : " + arme.GetNom() + ". \n");
                        armesCoffre.Remove(arme);

                    }
                    else if (hListObjet[numero] is Consommable)
                    {
                        Consommable objet = (Consommable)hListObjet[numero];

                        objet.UseAll(joueur);
                        Console.WriteLine("Vous utilisez : " + objet.GetNom() + ". \n");
                        objetsCoffre.Remove(objet);
                    }
                }
                else if (numero == hListObjet.Count + 1)
                {
                    Console.WriteLine("Vous partez.\n");
                    Deplacement.DeplacementMethod(tableau);
                    return;
                }
                else
                {
                    Console.WriteLine("Veuillez choisir un bon numéro. ");
                }
            }
        }

        public Coffre AddArme(params Armes[] arme)
        {
            armes.AddRange(arme);
            return this;
        }

        public Coffre AddObjet(params Consommable[] objet)
        {
            objets.AddRange(objet);
            return this;
        }

        public List<Armes> GetArmes()
        {
            return armes;
        }

        public List<Consommable> GetObjets()
        {
            return objets;
        }
    }
}
