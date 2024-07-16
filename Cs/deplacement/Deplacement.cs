using System;
using scan;
using tableau;

namespace deplacement
{
    public class Deplacement
    {
        public static void DeplacementMethod(Tableau tableau)
        {
            bool end = false;

            Console.WriteLine("\nOu voulez vous allez : ");

            while (!end)
            {
                if (!tableau.HasGauche())
                {
                    Console.WriteLine("1 - Gauche ");
                }
                if (!tableau.HasBas())
                {
                    Console.WriteLine("2 - Bas ");
                }
                if (!tableau.HasDroite())
                {
                    Console.WriteLine("3 - Droite ");
                }

                Console.WriteLine("4 - Dormir ");

                if (!tableau.HasHaut())
                {
                    Console.WriteLine("5 - Haut \n");
                }

                int numero = Scan.ScannerInt(5);

                switch (numero)
                {
                    case 1:
                        if (!tableau.HasGauche())
                        {
                            end = true;
                            tableau.ToGauche().Evenement();
                        }
                        else
                        {
                            Console.WriteLine("Vous ne pouvez pas aller a gauche. \n");
                            Console.WriteLine("Ou voulez vous allez : ");
                        }
                        break;

                    case 2:
                        if (!tableau.HasBas())
                        {
                            end = true;
                            tableau.ToBas().Evenement();
                        }
                        else
                        {
                            Console.WriteLine("Vous ne pouvez pas aller en bas. \n");
                            Console.WriteLine("Ou voulez vous allez : ");
                        }
                        break;

                    case 3:
                        if (!tableau.HasDroite())
                        {
                            end = true;
                            tableau.ToDroite().Evenement();
                        }
                        else
                        {
                            Console.WriteLine("Vous ne pouvez pas aller a droite. \n");
                            Console.WriteLine("Ou voulez vous allez : ");
                        }
                        break;

                    case 4:
                        Console.WriteLine(" Zzzzzz, vous avez bien dormis ! \n");
                        Console.WriteLine("Ou voulez vous allez : ");
                        break;

                    case 5:
                        if (!tableau.HasHaut())
                        {
                            end = true;
                            tableau.ToHaut().Evenement();
                        }
                        else
                        {
                            Console.WriteLine("Vous ne pouvez pas aller en haut. \n");
                            Console.WriteLine("Ou voulez vous allez : ");
                        }
                        break;

                    default:
                        Console.WriteLine("Veuillez choisir un bon numéro.");
                        break;
                }
            }
        }
    }
}
