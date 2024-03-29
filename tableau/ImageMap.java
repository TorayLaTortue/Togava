package tableau;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.geom.AffineTransform;
import java.awt.Graphics2D;

public class ImageMap {

    public static void imageMap(Tableau[] tableaux) {
        System.out.println("Début de la génération de l'image");
        int width = 900;
        int height = 900;
        int numRows = 9;
        int numCols = 9;
        double scaleFactor = 1;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        

        // Obtenez un objet Graphics à partir de l'image
        Graphics2D g = (Graphics2D) image.getGraphics();

        for (Tableau tableau : tableaux) {
            drawTableau(g, tableau, width, height, numRows, numCols);
        }
        
        AffineTransform at = AffineTransform.getScaleInstance(scaleFactor, scaleFactor);
        g.transform(at);

        g.dispose();// Libérez les ressources graphiques
        showImage(image, scaleFactor);// Affichez l'image dans une fenêtre
    }

    public static void drawTableau(Graphics g, Tableau tableau, int width, int height, int numRows, int numCols) {

        int x = (width / numCols) * (tableau.getX());
        int y = (height - ((height / numRows) * (tableau.getY() + 1)));

        // Dessinez le tableau sur l'image en fonction de son type
        if (tableau instanceof TableauMonstre) {
            TableauMonstre tableauMonstre = (TableauMonstre) tableau;
            int difficulteMax = tableauMonstre.getMaxDifficulte();
            if (tableauMonstre.getMonstre(difficulteMax).getDifficulte() == 1) {
                drawImage(g, "image/Monstre.png", x, y);
            } else if (tableauMonstre.getMonstre(difficulteMax).getDifficulte() == 5) {
                drawImage(g, "image/MonstreElite.png", x, y);
            } else {
                g.setColor(Color.BLACK);
                g.drawRect(x, y, 60, 60);
            }
        } else if (tableau instanceof TableauMarchand) {
            drawImage(g, "image/Marchand.png", x, y);
        } else if (tableau instanceof TableauCoffre) {
            drawImage(g, "image/Coffre.png", x, y);
        } else if (tableau instanceof Tableau) {
            drawImage(g, "image/PlaineVide.png", x, y);
        } else {
            // Est jamais senser ce produire
            g.setColor(Color.BLACK);
            g.drawRect(x, y, 60, 60);
        }

        // Dessinez les murs
        if (tableau.hasHaut()) {
            drawImage(g, "image/MurHaut.png", x, y);
        }
        if (tableau.hasBas()) {
            drawImage(g, "image/MurBas.png", x, y + (height / numRows));
        }
        if (tableau.hasGauche()) {
            drawImage(g, "image/MurGauche.png", x, y);
        }
        if (tableau.hasDroite()) {
            drawImage(g, "image/MurDroite.png", x + (width / numCols), y);
        }
    }

    public static void drawImage(Graphics g, String imageName, int x, int y) {
        // Chargez une image depuis un fichier
        try {
            Image image = new ImageIcon(ImageIO.read(new File(imageName))).getImage();
            g.drawImage(image, x, y, null);
        } catch (IOException e) {
            System.out.println("Image qui n'a pas chargée : " + imageName);
            e.printStackTrace();
        }
    }

    public static void showImage(BufferedImage image, double scaleFactor) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
        // Calculate the new size based on the scaling factor
        int newWidth = (int) (image.getWidth() * scaleFactor);
        int newHeight = (int) (image.getHeight() * scaleFactor);
    
        frame.setSize(newWidth, newHeight);
    
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
    
                // Apply scaling transformation
                Graphics2D g2d = (Graphics2D) g;
                AffineTransform transform = AffineTransform.getScaleInstance(scaleFactor, scaleFactor);
                g2d.setTransform(transform);
    
                g.drawImage(image, 0, 0, this);
            }
        };
    
        frame.add(panel);
        frame.setVisible(true);
    }
}
