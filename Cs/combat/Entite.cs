namespace combat
{
    public class Entite
    {
        private float action;
        private string nom;

        public Entite()
        {
        }

        public float GetAction()
        {
            // action = (float)Math.Round(action * 10.0f) / 10.0f;
            return action;
        }

        public void SetAction(float action)
        {
            if (action < 0)
            {
                action = 0;
            }
            // action = (float)Math.Round(action * 10.0f) / 10.0f;
            this.action = action;
        }

        public void ResetAction(float vitesse)
        {
            this.action = 10000 / vitesse;
        }

        public string GetNom()
        {
            return nom;
        }

        public void SetNom(string nom)
        {
            this.nom = nom;
        }
    }
}
