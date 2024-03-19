package monstre;


import java.util.ArrayList;
import java.util.Random;

import joueur.Joueur;
import joueur.Type;

public class Monstre
{
	private String nom;
	private Type type;
	private ArmesMonstre armesMonstre;
	private int vie;
	private int defense;
	private int atk;
	private int vitesse;
	private int gold;
	private int experience;
	private int difficulte;
	private boolean mort;
	private ArrayList<Type> faiblesse = new ArrayList<>();
	
	public Monstre(TypeMonstre typeMonstre)
	{
		this.nom = typeMonstre.getNom();
		this.type = typeMonstre.getType();
		this.armesMonstre = typeMonstre.getArmes();
		this.vie = typeMonstre.getVie();
		this.defense = typeMonstre.getDefense();
		this.atk = typeMonstre.getAtk();
		this.vitesse = typeMonstre.getVitesse();
		this.gold = typeMonstre.getGold();
		this.experience = typeMonstre.getExperience();
		this.difficulte = typeMonstre.getDifficulte();
		this.setMort(false);
		this.faiblesse = typeMonstre.getFaiblesse();
	}
	
	public String getNom()
	{
		return nom;
	}

	public void setNom(String nom)
	{
		this.nom = nom;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	
	

	public int getVie()
	{
		return vie;
	}

	public void setVie(int vie)
	{
		this.vie = vie;
	}
	public int getDefense() {
		return defense;
	}
	public void setDefense(int defense) {
		this.defense = defense;
	}
	public void attaque(Joueur victime)
	{
		int degatTotal = victime.getDefense() - getAtk();
		if(degatTotal < 1)
		{
			degatTotal = 1;
		}

		victime.setVie(victime.getVie() - degatTotal);
		System.out.println("Le monstre vous a infligez " + degatTotal + " dégats.\n");
	}
	
	
	public int getAtk()
	{
		return atk;
	}

	public void setAtk(int atk)
	{
		this.atk = atk;
	}

	
	
	
	public int getVitesse()
	{
		vitesse = vitesse + armesMonstre.getVitesse();
		return vitesse;
	}

	public void setVitesse(int vitesse)
	{
		this.vitesse = vitesse;
	}
	
	
	

	public int getGold()
	{
		int aleatoireGold = (new Random().nextInt(4) + 10) /10;
		return gold * aleatoireGold;
	}

	public void setGold(int gold)
	{
		this.gold = gold;
	}

	
	
	
	public boolean isMort()
	{
		return mort;
	}

	public void setMort(boolean mort)
	{
		this.mort = mort;
	}

	public int getExperience()
	{
		return experience;
	}
	public void setExperience(int experience)
	{
		this.experience = experience;
	}
	
	public int getDifficulte()
	{
		return difficulte;
	}
	public void setDifficulte(int difficulte)
	{
		this.difficulte = difficulte;
	}

	public ArrayList<Type> getFaiblesse() {
		return faiblesse;
	}
	public void setFaiblesse(ArrayList<Type> faiblesse) {
		this.faiblesse = faiblesse;
	}
	
	public boolean estFaible(Type perso, Type arme){
        if(faiblesse.contains(perso) || faiblesse.contains(arme))
        {       
            return true;
        }
        return false;
    }
	
}
