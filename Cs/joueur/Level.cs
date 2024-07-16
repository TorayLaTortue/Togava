using System;

namespace joueur
{
    public class Level
    {
        public static void LevelUpdate(Joueur joueur)
        {
            while (joueur.GetExperience() >= joueur.GetExperienceRequis())
            {
                joueur.SetLevel(joueur.GetLevel() + 1);
                joueur.SetExperience(joueur.GetExperience() - joueur.GetExperienceRequis());
                joueur.SetExperienceRequis(joueur.GetLevel());
            }
            Console.WriteLine($"Bravo vous êtes passé lv {joueur.GetLevel()}, prochain level dans {joueur.GetExperienceRequis()} exp.");
        }
    }
}
