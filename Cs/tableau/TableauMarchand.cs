using Deplacement;
using Marchand; 

namespace TableauNamespace
{
    public class TableauMarchand : Tableau
    {
        private Marchand marchand;

        public TableauMarchand(int x, int y, Marchand marchand) : base(x, y)
        {
            this.marchand = marchand;
        }

        public Marchand GetMarchand()
        {
            return marchand;
        }

        private void SetMarchand(Marchand marchand)
        {
            this.marchand = marchand;
        }

        public override void Evenement()
        {
            Marchand.Trade(this);
            Deplacement.Deplacement(this);
        }
    }
}
