using System;

namespace Objet
{
    public class Armes
    {
        public static readonly Armes Aucune = new Armes("aucune", Type.Aucun, 0, 0, 0, 0);
        public static readonly Armes EpeeBois = new Armes("une épée en bois", Type.Physique, 2, 0, 0, 0);
        public static readonly Armes EpeePierre = new Armes("une épée en pierre", Type.Physique, 3, 1, 0, 1);
        public static readonly Armes DagueRouille = new Armes("une dague rouillé", Type.Tenebre, 1, 2, 0, 0);
        public static readonly Armes Dague = new Armes("une dague basique", Type.Tenebre, 2, 3, 0, 0);
        public static readonly Armes SceptreT1 = new Armes("un sceptre magique de débutant", Type.Lumiere, 3, 2, 1, 0);
        public static readonly Armes SceptreT2 = new Armes("un sceptre magique puissant", Type.Lumiere, 6, 2, 2, 0);
        public static readonly Armes Claymore = new Armes("une claymore sombre", Type.Physique, 25, -2, 0, 30);
        public static readonly Armes Karambit = new Armes("un karambit sombre", Type.Tenebre, 20, 10, 0, 30);
        public static readonly Armes SceptreLumiere = new Armes("un sceptre magique infusé de néant", Type.Lumiere, 30, 2, 5, 30);

        public string Nom { get; private set; }
        public Type Type { get; private set; }
        public int Degats { get; private set; }
        public int Vitesse { get; private set; }
        public int CoutMana { get; private set; }
        public float Couts { get; private set; }

        private Armes(string nom, Type type, int degats, int vitesse, int coutMana, float couts)
        {
            Nom = nom;
            Type = type;
            Degats = degats;
            Vitesse = vitesse;
            CoutMana = coutMana;
            Couts = couts;
        }
    }
}
