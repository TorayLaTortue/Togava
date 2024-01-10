package scan;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Touche implements KeyListener {

    private boolean keyPressed = false;

    @Override
    public void keyTyped(KeyEvent e) {
        // Cette méthode est appelée lorsque la touche est pressée et relâchée
        System.out.println("Key Typed: " + e.getKeyChar());
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Cette méthode est appelée lorsque la touche est pressée
        if (!keyPressed) {
            System.out.println("Key Pressed: " + e.getKeyChar());
            if (e.getKeyChar() == 'Z' || e.getKeyChar() == 'z') {
                System.out.println("La touche Z a été pressée!");
                // Ajoutez ici le code que vous souhaitez exécuter lorsque la touche Z est pressée
            }
            keyPressed = true;

            // Utilisez un délai si nécessaire
            
            try {
                Thread.sleep(100); // Délai en millisecondes
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
        // Cette méthode est appelée lorsque la touche est relâchée
        System.out.println("Key Released: " + e.getKeyChar());
        keyPressed = false;
    }
}