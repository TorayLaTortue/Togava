using System;
using System.Collections.Generic;

namespace Monstre
{
    public class Monstre : Entite
    {
        public string Nom { get; set; }
        public Type Type { get; set; }
        public ArmesMonstre ArmesMonstre { get; set; }
        public float Vie { get; set; }
        public float Defense { get; set; }
        public float Atk { get; set; }
        public float Vitesse { get; set; }
        public float Gold { get; set; }
        public float Experience { get; set; }
        public int Multiplicateur { get; set; }
        public int Difficulte { get; set; }
        public bool Mort { get; set; }
        public List<Type> Faiblesse { get; set; }
        public AbiliteMonstre Abilite { get; set; }

        public Monstre(TypeMonstre typeMonstre)
        {
            // Set action for base entity
            base.SetAction(10000 / typeMonstre.Vitesse);

            Nom = typeMonstre.Nom;
            Type = typeMonstre.Type;
            ArmesMonstre = typeMonstre.Armes;
            Vie = typeMonstre.Vie;
            Defense = typeMonstre.Defense;
            Atk = typeMonstre.Atk;
            Vitesse = typeMonstre.Vitesse;
            Gold = typeMonstre.Gold;
            Experience = typeMonstre.Experience;
            Multiplicateur = typeMonstre.Multiplicateur;
            Difficulte = typeMonstre.Difficulte;
            Mort = false;
            Faiblesse = new List<Type>(typeMonstre.Faiblesse);
            Abilite = typeMonstre.Abilite;
        }

        public void Attaque(Joueur victime)
        {
            float degatTotal = Atk - victime.Defense;
            if (degatTotal < 1)
            {
                degatTotal = 1;
            }

            victime.Vie -= degatTotal;
            Console.WriteLine($"Le {Nom} vous a infligé {degatTotal} dégâts.\nIl vous reste {victime.Vie} PV.");
        }

        public float GetVitesse()
        {
            return Vitesse + ArmesMonstre.Vitesse;
        }

        public float GetGold()
        {
            Random random = new Random();
            int randomNumber = random.Next(Multiplicateur + 1) + 10;
            float randomFloatGold = Math.Round(randomNumber) / 10.0f;
            return Gold * randomFloatGold;
        }

        public float GetExperience()
        {
            Random random = new Random();
            int randomNumber = random.Next(Multiplicateur + 1) + 10;
            float randomFloatExp = Math.Round(randomNumber) / 10.0f;
            return Experience * randomFloatExp;
        }

        public float DegatFaible(Type perso, Type arme, float degat)
        {
            bool crit = false;
            if (Faiblesse.Contains(perso))
            {
                degat *= 1.5f;
                crit = true;
            }
            if (Faiblesse.Contains(arme))
            {
                degat *= 1.5f;
                crit = true;
            }
            if (crit)
            {
                Console.WriteLine("Votre attaque est super efficace");
            }

            return degat;
        }

        public void UseAbilite()
        {
            Abilite?.PerformAbilite();
        }
    }
}
