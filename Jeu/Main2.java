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
import java.util.Random;

import javax.imageio.ImageIO;
import joueur.Armes;
import joueur.ChoixPersonnage;
import joueur.Joueur;
import joueur.TypeJoueur;
import marchand.Marchand;
import monstre.Monstre;
import monstre.TypeMonstre;
import tableau.ImageMap;
import tableau.Map;
import tableau.Tableau;
import tableau.TableauCoffre;
import tableau.TableauMarchand;
import tableau.TableauMonstre;

public class Main2 {
    public static void main(String[] args) {
        
        ChoixPersonnage choixPersonnage = new ChoixPersonnage();
        Joueur joueur = choixPersonnage.choixPersonnage();
        Tableau[] tableaux = Map.map();
        ImageMap.imageMap(tableaux);
        getc0.evenement();
    }

    
    

}
