using System;
using System.Collections.Generic;
using Combat; 
using Deplacement; 
using Monstre; 
using MonstreType;

namespace TableauNamespace
{
    public class TableauMonstre : Tableau
    {
        private List<Monstre> monstre;

        public TableauMonstre(int x, int y, params Monstre[] monstres) : base(x, y)
        {
            this.monstre = new List<Monstre>(monstres);
        }

        public List<Monstre> GetAllMonstre()
        {
            return monstre;
        }

        public string GetAllNomMonstre()
        {
            var sb = new System.Text.StringBuilder();

            foreach (var monstre in monstre)
            {
                sb.Append(monstre.GetNom()).Append(", ");
            }

            // Supprimer la virgule et l'espace en trop à la fin, s'ils existent
            if (sb.Length > 0)
            {
                sb.Length -= 2; // Efface les deux derniers caractères (", ")
            }

            return sb.ToString();
        }

        public string GetAllNomVieMonstre()
        {
            var sb = new System.Text.StringBuilder();

            foreach (var monstre in monstre)
            {
                sb.Append($"Le {monstre.GetNom()} a {monstre.GetVie()} PV").Append(", ");
            }

            if (sb.Length > 0)
            {
                sb.Length -= 2; // Efface les deux derniers caractères (", ")
            }

            return sb.ToString();
        }

        public void SetMonstre(List<Monstre> monstres)
        {
            this.monstre = monstres;
        }

        public Monstre GetMonstre(int index)
        {
            if (index >= 0 && index < monstre.Count)
            {
                return monstre[index];
            }
            else
            {
                return null;
            }
        }

        public override void Evenement()
        {
            Console.WriteLine("Vous arrivez dans une case de combat.");
            Combat.Combat(this);
            Deplacement.Deplacement(this);
        }

        public int GetMaxDifficulte()
        {
            if (monstre.Count == 0)
            {
                Console.WriteLine("GetMaxDifficulté, tableauMonstre impossible");
                return 0;
            }

            int difficulteMax = monstre[0].GetDifficulte(); // Initialise avec la difficulté du premier monstre

            // Parcourt la liste pour trouver la difficulté maximale
            for (int i = 1; i < monstre.Count; i++)
            {
                int difficulteCourante = monstre[i].GetDifficulte();
                if (difficulteCourante > difficulteMax)
                {
                    difficulteMax = difficulteCourante;
                }
            }

            return difficulteMax;
        }

        public bool IsAllMort(List<Monstre> monstres)
        {
            int total = monstres.Count;
            int morts = 0;

            foreach (var monstre in monstres)
            {
                if (monstre.IsMort())
                {
                    morts++;
                }
            }

            return morts == total;
        }

        public static Monstre[] MonstresAleatoire(int difficulte, int nombreMob)
        {
            var monstresEnum = Enum.GetValues(typeof(TypeMonstre)) as TypeMonstre[];
            var monstresChoisis = new List<Monstre>();
            var rand = new Random();

            for (int i = 0; i < nombreMob; i++)
            {
                TypeMonstre monstreChoisi;
                do
                {
                    monstreChoisi = monstresEnum[rand.Next(monstresEnum.Length)];
                } while (monstreChoisi.GetDifficulte() != difficulte);

                var monstre = new Monstre(monstreChoisi);
                monstresChoisis.Add(monstre);
            }

            // Convertir la liste des monstres choisis en tableau et le retourner
            return monstresChoisis.ToArray();
        }
    }
}
