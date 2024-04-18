package scan;

import java.util.Scanner;

public class Scan 
{
    final static Scanner in = new Scanner(System.in);
    
    public static String scanner()
    {
        return in.nextLine();
        
    }

    public static int scannerInt(int nombreChoix)
    {
        boolean isNumero = true;
        boolean isCorrectNumero = false;
        int numero = 0;

        do{
            String reponse = Scan.scanner();
            isNumero = true;
            numero = 0;
            
            try 
            {
                numero = Integer.parseInt(reponse);
            } 
            catch (NumberFormatException e)
            {
                isNumero = false;
            }
            
            if(!isNumero)
            {
                System.out.println("Vous devez mettre entre 1 et " + nombreChoix + " ! >:c");
            }
            else
            {
                if(numero >= 1 && numero <= nombreChoix )
                {
                    isCorrectNumero = true;
                }
                else{
                    System.out.println("Vous devez mettre entre 1 et " + nombreChoix + " ! >:c");
                }
            }
        } while(!isCorrectNumero);

        return numero;
    }

    public static Boolean scannerBoolean()
    {
        boolean isNumero = true;
        boolean isCorrectNumero = false;
        int numero = 0;
        boolean bool = false;

        do{
            String reponse = Scan.scanner();
            isNumero = true;
            numero = 0;
            
            try 
            {
                numero = Integer.parseInt(reponse);
            } 
            catch (NumberFormatException e)
            {
                isNumero = false;
            }
            
            if(!isNumero)
            {
                System.out.println("Vous devez mettre entre 0 et 1 ! >:c");
            }
            else
            {
                if(numero == 0)
                {
                    isCorrectNumero = true;
                    bool = false;
                }
                else if(numero == 1)
                {
                    isCorrectNumero = true;
                    bool = true;
                }
                else{
                    System.out.println("Vous devez mettre entre 0 et 1 ! >:c");
                }
            }
        } while(!isCorrectNumero);
        
        return bool;
    }


    
}