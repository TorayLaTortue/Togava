namespace equipement
{
    public enum Collier
    {
        AUCUN = 0
    }

    public class CollierDetails
    {
        public string Nom { get; private set; }
        public float VieMax { get; private set; }
        public float VoleVie { get; private set; }
        public float RegenVie { get; private set; }
        public float Vitality { get; private set; }

        private CollierDetails(string nom, float vieMax, float voleVie, float regenVie, float vitality)
        {
            Nom = nom;
            VieMax = vieMax;
            VoleVie = voleVie;
            RegenVie = regenVie;
            Vitality = vitality;
        }

        public static CollierDetails AUCUN = new CollierDetails("Aucun", 0, 0, 0, 0);
    }
}
