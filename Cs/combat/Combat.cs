using System;
using System.Collections.Generic;
using deplacement;
using joueur;
using monstre;
using scan;
using tableau;

namespace combat
{
    public class Combat
    {
        public static void StartCombat(TableauMonstre tableau)
        {
            bool cycle = false;
            Joueur joueur = Joueur.Get();
            List<Monstre> monstres = tableau.GetAllMonstre();
            Dictionary<int, Monstre> hMonstres = new Dictionary<int, Monstre>();
            List<Joueur> joueurs = new List<Joueur>();

            bool fin = tableau.IsAllMort(monstres);
            joueurs.Add(joueur);

            if (monstres.Count == 1)
            {
                if (!tableau.IsAllMort(monstres))
                {
                    Console.WriteLine("Wow un " + monstres[0].GetNom() + " terrifiant apparait.");
                }
                else
                {
                    Console.WriteLine("Il y a le cadavre d'un " + monstres[0].GetNom() + ".\n");
                    Deplacement.DeplacementMethod(tableau);
                    return;
                }
            }
            else
            {
                if (!tableau.IsAllMort(monstres))
                {
                    Console.WriteLine("Des monstres apparaissent : " + tableau.GetAllNomMonstre() + ".");
                }
                else
                {
                    Console.WriteLine("Il y a le cadavre de " + tableau.GetAllNomMonstre() + ".\n");
                    Deplacement.DeplacementMethod(tableau);
                    return;
                }
            }

            while (!fin)
            {
                Console.WriteLine("Vous avez " + joueur.GetVie() + " PV.");
                Console.WriteLine(tableau.GetAllNomVieMonstre() + ".\n");

                cycle = false;
                Console.WriteLine("\nNouveau cycle. \n");
                while (!cycle && !fin)
                {
                    List<Entite> entites = Action.Execute(monstres, joueurs);

                    float action = entites[0].GetAction();
                    Console.WriteLine("\nOrdre d'action :\n╔═══════");
                    foreach (Entite entite in entites)
                    {
                        entite.SetAction(entite.GetAction() - action);
                        Console.WriteLine("║" + entite.GetNom() + " a : " + entite.GetAction() + " point d'action."); // ordre d'action
                    }
                    Console.WriteLine("╚═══════");

                    if (entites[0] is Joueur)
                    {
                        joueur = (Joueur)entites[0];

                        Console.WriteLine("\nQui voulez-vous attaquer ?");
                        int i = 0;
                        float vitesseTotal = 0;
                        foreach (Entite entite in entites)
                        {
                            if (entite is Monstre)
                            {
                                Monstre monstre = (Monstre)entite;
                                i++;
                                Console.WriteLine(i + " - Attaquer " + monstre.GetNom());
                                hMonstres.Add(i, monstre);
                                vitesseTotal += monstre.GetVitesse();
                            }
                        }

                        Console.WriteLine(i + 1 + " - Fuir \n");

                        int choix = Scan.ScannerInt(i);

                        if (choix <= hMonstres.Count)
                        {
                            float gold = hMonstres[choix].GetGold();
                            float exp = hMonstres[choix].GetExperience();

                            joueur.ResetAction(joueur.GetVitesse());

                            if (joueur.GetMana() >= joueur.GetArme().GetCoutMana())
                            {
                                joueur.Attaque(hMonstres[choix]);
                                if (hMonstres[choix].GetVie() <= 0)
                                {
                                    hMonstres[choix].SetMort(true);
                                    joueur.AddGold(gold);
                                    joueur.AddExperience(exp);
                                    Console.WriteLine("Vous avez battu le " + hMonstres[choix].GetNom() + " et gagné " + gold + " gold et " + exp + " experience !\n");
                                    entites.RemoveAt(choix);
                                    Level.LevelUpdate(joueur);
                                }
                                else
                                {
                                    hMonstres[choix].Attaque(joueur);
                                    if (joueur.GetVie() <= 0)
                                    {
                                        joueur.SetMort(true);
                                        Console.WriteLine("La partie est terminée, tu es un noob ! ");
                                        Environment.Exit(0);
                                    }
                                }
                            }
                            else if (joueur.GetMana() <= joueur.GetArme().GetCoutMana())
                            {
                                Console.WriteLine("Vous n'avez pas assez de mana et donc en régénérez 1 de mana.");
                                joueur.SetMana(joueur.GetMana() + 1);
                            }
                        }
                        else if (choix == hMonstres.Count + 1)
                        {
                            float fuite = (joueur.GetVitesse() / (vitesseTotal / hMonstres.Count)) * 50;
                            int probafuite = (int)Math.Round(fuite);

                            int chanceDeFuite = new Random().Next(101);
                            if (chanceDeFuite <= probafuite)
                            {
                                Console.WriteLine("Vous avez réussi à fuir comme un noob, bravo !\n");
                                cycle = true;
                                Tableau.GetTableau(joueur.GetAncienTableauX(), joueur.GetAncienTableauY()).Evenement();
                            }
                            else
                            {
                                Console.WriteLine("Vous n'avez pas réussi à fuir, la honte !\n ");
                                hMonstres[1].Attaque(joueur);
                                if (joueur.GetVie() <= 0)
                                {
                                    joueur.SetMort(true);
                                    cycle = true;
                                    Console.WriteLine("La partie est terminée, t'es trop nul ! ");
                                    Environment.Exit(0);
                                }
                            }
                        }
                    }
                    else
                    {
                        Monstre monstre = (Monstre)entites[0];
                        monstre.ResetAction(monstre.GetVitesse());
                        monstre.Attaque(joueur);
                        monstre.UseAbilite();
                        if (joueur.GetVie() <= 0)
                        {
                            joueur.SetMort(true);
                            cycle = true;
                            Console.WriteLine("La partie est terminée, tu es un noob ! ");
                            Environment.Exit(0);
                        }
                    }

                    if (hMonstres.Count == 0)
                    {
                        cycle = true;
                    }
                    fin = tableau.IsAllMort(monstres);
                }
            }
        }
    }
}
