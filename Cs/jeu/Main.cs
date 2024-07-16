using joueur;
using objet;
using tableau;

namespace jeu
{
    public class Program
    {
        public static void Main(string[] args)
        {
            // Create an instance of ChoixPersonnage and select a character
            ChoixPersonnage choixPersonnage = new ChoixPersonnage();
            Joueur joueur = choixPersonnage.ChoixPersonnage();

            // Get the map
            Tableau[] tableaux = Map.Map();

            // Add an object to the inventory
            Inventaire.AddObjet(Armes.CLAYMORE);

            // Retrieve an object from the inventory
            Armes armes = (Armes)Inventaire.GetObjet(1);
            System.Console.WriteLine(armes.Nom);

            // Trigger an event in the first tableau
            Tableau.GetTableau(0, 0).Evenement();
        }
    }
}
