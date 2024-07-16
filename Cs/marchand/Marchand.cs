using System;
using System.Collections.Generic;
using Deplacement;
using Joueur;
using Objet;
using Pet;
using Scan;
using Tableau;

namespace Marchand
{
    public class Marchand
    {
        private List<Armes> armes = new List<Armes>();
        private List<Consommable> objets = new List<Consommable>();
        private List<TypePets> pets = new List<TypePets>();

        public Marchand()
        {
        }

        public static void Trade(TableauMarchand tableau)
        {
            Joueur joueur = Joueur.Get();
            List<Armes> armesMarchand = tableau.GetMarchand().GetArmes();
            List<TypePets> petsMarchand = tableau.GetMarchand().GetPets();
            List<Consommable> objetsMarchand = tableau.GetMarchand().GetObjets();

            bool end = false;
            while (!end)
            {
                Dictionary<int, object> hListObjet = new Dictionary<int, object>();

                if (armesMarchand.Count == 0 && petsMarchand.Count == 0 && objetsMarchand.Count == 0)
                {
                    Console.WriteLine("Il n'y a plus de marchand.\n");
                    end = true;
                    Deplacement.Deplacement(tableau);
                    return;
                }
                else
                {
                    Console.WriteLine("Un marchand apparait devant vous !\n");
                }

                int i = 0;
                Console.WriteLine("\nQue voulez-vous faire ?\n ");
                foreach (Armes arme in armesMarchand)
                {
                    i++;
                    Console.WriteLine($"{i} - Acheter : {arme.GetNom()}");
                    hListObjet[i] = arme;
                }
                foreach (TypePets pet in petsMarchand)
                {
                    i++;
                    Console.WriteLine($"{i} - Acheter : {pet.GetNom()}");
                    hListObjet[i] = pet;
                }
                foreach (Consommable objet in objetsMarchand)
                {
                    i++;
                    Console.WriteLine($"{i} - Acheter : {objet.GetNom()}");
                    hListObjet[i] = objet;
                }
                Console.WriteLine($"{i + 1} - Partir d'ici.");

                int numero = Scan.ScannerInt(i + 1);

                if (numero <= hListObjet.Count) // Achat
                {
                    if (hListObjet[numero] is Armes arme)
                    {
                        if (arme.GetCouts() <= joueur.GetGold())
                        {
                            joueur.SetArme(arme);
                            joueur.SubGold(arme.GetCouts());
                            Console.WriteLine($"Vous équipez : {arme.GetNom()}. \n");
                            armesMarchand.Remove(arme);
                        }
                        else
                        {
                            Console.WriteLine("Vous n'avez pas assez d'argent !");
                        }
                    }
                    else if (hListObjet[numero] is Consommable objet)
                    {
                        if (objet.GetCouts() <= joueur.GetGold())
                        {
                            objet.UseAll(joueur);
                            joueur.SubGold(objet.GetCouts());
                            Console.WriteLine($"Vous utilisez : {objet.GetNom()}. \n");
                            objetsMarchand.Remove(objet);
                        }
                        else
                        {
                            Console.WriteLine("Vous n'avez pas assez d'argent !");
                        }
                    }
                    else if (hListObjet[numero] is TypePets pet)
                    {
                        if (pet.GetCouts() <= joueur.GetGold())
                        {
                            joueur.SetTypePets(pet);
                            joueur.SubGold(pet.GetCouts());
                            Console.WriteLine($"Vous équipez : {pet.GetNom()}. \n");
                            petsMarchand.Remove(pet);
                        }
                        else
                        {
                            Console.WriteLine("Vous n'avez pas assez d'argent !");
                        }
                    }
                }
                else if (numero == hListObjet.Count + 1) // Partir
                {
                    Console.WriteLine("Vous partez.\n");
                    Deplacement.Deplacement(tableau);
                    return;
                }
                else
                {
                    Console.WriteLine("Veuillez choisir un bon numéro.");
                }
            }
        }

        public Marchand AddArme(Armes arme)
        {
            armes.Add(arme);
            return this;
        }

        public Marchand AddObjet(Consommable objet)
        {
            objets.Add(objet);
            return this;
        }

        public Marchand AddPets(TypePets pet)
        {
            pets.Add(pet);
            return this;
        }

        public List<Armes> GetArmes()
        {
            return armes;
        }

        public List<TypePets> GetPets()
        {
            return pets;
        }

        public List<Consommable> GetObjets()
        {
            return objets;
        }
    }
}
