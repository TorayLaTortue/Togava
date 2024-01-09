package scan;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Touche {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Key Press Event Example");
        JTextField textField = new JTextField();

        textField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                // Cette méthode est appelée lorsque la touche est pressée et relâchée
                System.out.println("Key Typed: " + e.getKeyChar());
            }

            @Override
            public void keyPressed(KeyEvent e) {
                // Cette méthode est appelée lorsque la touche est pressée
                System.out.println("Key Pressed: " + e.getKeyChar());
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // Cette méthode est appelée lorsque la touche est relâchée
                System.out.println("Key Released: " + e.getKeyChar());
            }
        });

        frame.add(textField);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
