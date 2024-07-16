using scan;

namespace joueur
{
    public class ChoixPersonnage
    {
        public Joueur ChoixPersonnage()
        {
            bool end = false;
            
            System.Console.WriteLine("\nQuel personnage voulez-vous : ");
            
            while (!end)
            {
                int i = 0;
                System.Console.WriteLine("1 - Chevalier ");
                i++;
        
                System.Console.WriteLine("2 - Chevalier du néant ");
                i++;
        
                System.Console.WriteLine("3 - Bandit ");
                i++;
        
                System.Console.WriteLine("4 - Mage ");
                i++;

                System.Console.WriteLine("5 - Adepte ");
                i++;
            
                int numero = Scan.ScannerInt(i);
            
                switch (numero)
                {
                    case 1:
                        end = true;
                        return new Joueur(TypeJoueur.CHEVALIER);
                
                    case 2:
                        end = true;
                        return new Joueur(TypeJoueur.CHEVALIERDUNEANT);
                
                    case 3:
                        end = true;
                        return new Joueur(TypeJoueur.BANDIT);
                
                    case 4:
                        end = true;
                        return new Joueur(TypeJoueur.MAGE);
                
                    case 5:
                        end = true;
                        return new Joueur(TypeJoueur.ADEPTE);
                
                    default:
                        System.Console.WriteLine("Choix invalide. Veuillez essayer à nouveau.");
                        break;
                }
            }
            return null;
        }
    }
}
