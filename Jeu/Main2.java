package jeu;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import joueur.Armes;
import joueur.ChoixPersonnage;
import joueur.Joueur;
import joueur.TypeJoueur;
import marchand.Marchand;
import monstre.Monstre;
import monstre.TypeMonstre;
import tableau.Tableau;
import tableau.TableauCoffre;
import tableau.TableauMarchand;
import tableau.TableauMonstre;


public class Main2 {
    public static void main(String[] args) {

        Tableau c0 = new Tableau(0, 0).addBas().addGauche().addDroite(); //spawn

        Tableau[] tableaux = {
            new Tableau(1, 0).addHaut(),
            new TableauMonstre(2, 0, new Monstre(TypeMonstre.BLOB)).addGauche().addHaut(),
            new TableauMonstre(3, 0, new Monstre(TypeMonstre.DRAGON)).addDroite().addHaut(),
            new TableauMarchand(4, 0, new Marchand().addArme(Armes.CLAYMORE)).addHaut().addGauche(),
            new TableauCoffre(5, 0, Armes.EPEEPIERRE).addHaut().addDroite(),
            new Tableau(6, 0).addHaut(),
            new Tableau(7, 0).addHaut(),
            new Tableau(8, 0).addHaut(),
            new Tableau(9, 0).addHaut(),

            new TableauMonstre(0, 1, new Monstre(TypeMonstre.BLOB)).addGauche(),
            new Tableau(1, 1),
            new Tableau(2, 1),
            new TableauMonstre(3, 1, new Monstre(TypeMonstre.DRAGON)).addDroite(),
            new TableauMarchand(4, 1, new Marchand().addArme(Armes.CLAYMORE)).addHaut().addGauche(),
            new TableauCoffre(5, 1, Armes.EPEEPIERRE).addHaut().addDroite(),
            new Tableau(6, 1),
            new TableauMarchand(7, 1, new Marchand().addArme(Armes.CLAYMORE)),
            new Tableau(8, 1),
            new TableauCoffre(9, 1, Armes.EPEEPIERRE).addHaut().addDroite()

            
        };
        
        
        
        int width = 800;
        int height = 800;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        // Obtenez un objet Graphics à partir de l'image
        Graphics g = image.getGraphics();

        for (Tableau tableau : tableaux) {
            drawTableau(g, tableau);
        }
        drawTableau(g, c0);

        g.dispose();// Libérez les ressources graphiques
        showImage(image);// Affichez l'image dans une fenêtre

        ChoixPersonnage choixPersonnage = new ChoixPersonnage();
        Joueur chevalier = choixPersonnage.choixPersonnage();
		
		c0.evenement();
    }

    private static void drawTableau(Graphics g, Tableau tableau) {

        int x = tableau.getX() * 60;
        int y = 600 + (-60 * tableau.getY());
     
        // Dessinez le tableau sur l'image en fonction de son type
        if (tableau instanceof TableauMonstre) {
            drawImage(g, "image/Monstre.png", x, y);
        } else if (tableau instanceof TableauMarchand) {
            drawImage(g, "image/Marchand.png", x, y);
        } else if (tableau instanceof TableauCoffre) {
            drawImage(g, "image/Coffre.png", x, y);
        } else if (tableau instanceof Tableau) {
            drawImage(g, "image/PlaineVide.png", x, y);
        } else {
            // Dessinez une représentation par défaut pour les autres types de tableaux
            g.setColor(Color.BLACK);
            g.drawRect(x, y, 60, 60);
        }
    
        // Dessinez les indications de direction (haut, bas, gauche, droite)
        if (tableau.hasHaut()) {
            drawImage(g, "image/MurHaut.png", x, y);
        }
        if (tableau.hasBas()) {
            drawImage(g, "image/MurBas.png", x, y-60);
        }
        if (tableau.hasGauche()) {
            drawImage(g, "image/MurGauche.png", x, y);
        }
        if (tableau.hasDroite()) {
            drawImage(g, "image/MurDroite.png", x+60, y);
        }}

    private static void drawImage(Graphics g, String imageName, int x, int y) {
        // Chargez une image depuis un fichier
        try {
            Image image = new ImageIcon(ImageIO.read(new File(imageName))).getImage();
            g.drawImage(image, x, y, null);
            System.out.println("Image chargée : " + imageName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void showImage(BufferedImage image) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(image.getWidth(), image.getHeight());

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image, 0, 0, this);
            }
        };

        frame.add(panel);
        frame.setVisible(true);
    }


    
    
}


