using Coffre;  
using Deplacement;

namespace TableauNamespace
{
    public class TableauCoffre : Tableau
    {
        private Coffre coffre;

        public TableauCoffre(int x, int y, Coffre coffre) : base(x, y)
        {
            this.coffre = coffre;
        }

        public Coffre GetCoffre()
        {
            return coffre;
        }

        public void SetCoffre(Coffre coffre)
        {
            this.coffre = coffre;
        }

        public override void Evenement()
        {
            Coffre.Ouverture(this);
            Deplacement.Deplacement(this);
        }
    }
}
