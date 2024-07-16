namespace equipement
{
    public enum Cape
    {
        AUCUN = 0
    }

    public class CapeDetails
    {
        public string Nom { get; private set; }
        public float Vitesse { get; private set; }
        public float ManaMax { get; private set; }
        public float BonusGold { get; private set; }
        public float BonusExp { get; private set; }

        private CapeDetails(string nom, float vitesse, float manaMax, float bonusGold, float bonusExp)
        {
            Nom = nom;
            Vitesse = vitesse;
            ManaMax = manaMax;
            BonusGold = bonusGold;
            BonusExp = bonusExp;
        }

        public static CapeDetails AUCUN = new CapeDetails("Aucun", 0, 0, 0, 0);
    }
}
