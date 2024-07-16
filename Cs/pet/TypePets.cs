using System;

namespace Pet
{
    public class TypePets
    {
        public static readonly TypePets Aucun = new TypePets("", 0, 0, 0, 0);
        public static readonly TypePets Tortue = new TypePets("Tortue", 2, 1, 5, 25);
        public static readonly TypePets Bat = new TypePets("chauve-souris", 4, 3, 7, 20);

        public string Nom { get; private set; }
        public int Atk { get; private set; }
        public int Vitesse { get; private set; }
        public int Defense { get; private set; }
        public float Couts { get; private set; }

        private TypePets(string nom, int atk, int vitesse, int defense, float couts)
        {
            Nom = nom;
            Atk = atk;
            Vitesse = vitesse;
            Defense = defense;
            Couts = couts;
        }
    }
}
