using System;

namespace Monstre
{
    public enum Type
    {
        AUCUN,
        PHYSIQUE
    }

    public class ArmesMonstre
    {
        public string Nom { get; set; }
        public Type Type { get; set; }
        public int Degats { get; set; }
        public int Vitesse { get; set; }
        public int CoutMana { get; set; }
        public int Couts { get; set; }
        public int Durabilite { get; set; }

        public static readonly ArmesMonstre AUCUNE = new ArmesMonstre("aucune", Type.AUCUN, 0, 0, 0, 0, 0);
        public static readonly ArmesMonstre EPEEBOIS = new ArmesMonstre("une épée en bois", Type.PHYSIQUE, 2, 1, 0, 0, 25);
        public static readonly ArmesMonstre ARCBOIS = new ArmesMonstre("un arc en bois", Type.PHYSIQUE, 3, 0, 0, 0, 25);

        private ArmesMonstre(string nom, Type type, int degats, int vitesse, int coutMana, int couts, int durabilite)
        {
            Nom = nom;
            Type = type;
            Degats = degats;
            Vitesse = vitesse;
            CoutMana = coutMana;
            Couts = couts;
            Durabilite = durabilite;
        }
    }
}
