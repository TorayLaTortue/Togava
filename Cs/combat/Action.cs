using System;
using System.Collections.Generic;

using joueur;
using monstre;

namespace combat
{
    public class Action
    {
        public static List<Entite> Execute(List<Monstre> monstres, List<Joueur> joueurs)
        {
            List<Entite> entites = new List<Entite>();

            foreach (Joueur joueur in joueurs)
            {
                if (!joueur.IsMort())
                {
                    entites.Add(joueur);
                }
            }

            foreach (Monstre monstre in monstres)
            {
                if (!monstre.IsMort())
                {
                    entites.Add(monstre);
                }
            }

            entites.Sort((entite1, entite2) =>
            {
                float action1 = entite1.GetAction();
                float action2 = entite2.GetAction();
                return action1.CompareTo(action2);
            });

            return entites;
        }
    }
}
