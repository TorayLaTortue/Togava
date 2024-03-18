package pet;


import java.util.Random;

import joueur.Joueur;
import joueur.Type;

public class Pets
{
	private String nom;
	private int atk;
	private int vitesse;
    private int defense;

	
	public Pets(TypePets typePets)
	{
		this.nom = typePets.getNom();
        this.atk = typePets.getAtk();
        this.vitesse = typePets.getVitesse();
        this.defense = typePets.getDefense();
	
	}
	
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public int getAtk() {
        return atk;
    }
    public void setAtk(int atk) {
        this.atk = atk;
    }
    public int getVitesse() {
        return vitesse;
    }
    public void setVitesse(int vitesse) {
        this.vitesse = vitesse;
    }
    public int getDefense() {
        return defense;
    }
    public void setDefense(int defense) {
        this.defense = defense;
    }
}
