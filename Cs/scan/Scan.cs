using System;

namespace ScanUtility
{
    public static class Scan
    {
        // Méthode pour lire une chaîne de caractères
        public static string Scanner()
        {
            return Console.ReadLine();
        }

        // Méthode pour lire un entier avec validation
        public static int ScannerInt(int nombreChoix)
        {
            int numero = 0;
            bool isCorrectNumero = false;

            do
            {
                string reponse = Scanner();
                isCorrectNumero = int.TryParse(reponse, out numero);

                if (!isCorrectNumero)
                {
                    Console.WriteLine($"Vous devez mettre entre 1 et {nombreChoix} ! >:c");
                }
                else
                {
                    if (numero >= 1 && numero <= nombreChoix)
                    {
                        isCorrectNumero = true;
                    }
                    else
                    {
                        Console.WriteLine($"Vous devez mettre entre 1 et {nombreChoix} ! >:c");
                        isCorrectNumero = false;
                    }
                }
            } while (!isCorrectNumero);

            return numero;
        }

        // Méthode pour lire un booléen avec validation
        public static bool ScannerBoolean()
        {
            int numero = 0;
            bool isCorrectNumero = false;
            bool boolValue = false;

            do
            {
                string reponse = Scanner();
                isCorrectNumero = int.TryParse(reponse, out numero);

                if (!isCorrectNumero)
                {
                    Console.WriteLine("Vous devez mettre entre 0 et 1 ! >:c");
                }
                else
                {
                    if (numero == 0)
                    {
                        isCorrectNumero = true;
                        boolValue = false;
                    }
                    else if (numero == 1)
                    {
                        isCorrectNumero = true;
                        boolValue = true;
                    }
                    else
                    {
                        Console.WriteLine("Vous devez mettre entre 0 et 1 ! >:c");
                        isCorrectNumero = false;
                    }
                }
            } while (!isCorrectNumero);

            return boolValue;
        }
    }
}
