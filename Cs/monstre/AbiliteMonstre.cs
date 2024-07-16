using System;

namespace Monstre
{
    public interface IAbiliteMonstre
    {
        void PerformAbilite();
    }

    public class Rien : IAbiliteMonstre
    {
        public void PerformAbilite()
        {
            Console.WriteLine("Le monstre n'a pas d'abilite!");
        }
    }

    public class PoisonAbility : IAbiliteMonstre
    {
        public void PerformAbilite()
        {
            Console.WriteLine("The monster poisons its opponent!");
        }
    }
}
