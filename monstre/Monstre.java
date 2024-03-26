package monstre;


import java.util.ArrayList;
import java.util.Random;

import combat.Entite;
import joueur.Joueur;
import joueur.Type;
import tableau.Tableau;
import tableau.TableauMonstre;

public class Monstre extends Entite
{
	private String nom;
	private Type type;
	private ArmesMonstre armesMonstre;
	private float vie;
	private float defense;
	private float atk;
	private float vitesse;
	private float action;
	private float gold;
	private float experience;
	private int multiplicateur;
	private int difficulte;
	private boolean mort;
	private ArrayList<Type> faiblesse = new ArrayList<>();
	
	public Monstre(TypeMonstre typeMonstre)
	{
		super();
		this.nom = typeMonstre.getNom();
		this.type = typeMonstre.getType();
		this.armesMonstre = typeMonstre.getArmes();
		this.vie = typeMonstre.getVie();
		this.defense = typeMonstre.getDefense();
		this.atk = typeMonstre.getAtk();
		this.vitesse = typeMonstre.getVitesse();
		this.gold = typeMonstre.getGold();
		this.experience = typeMonstre.getExperience();
		this.multiplicateur = typeMonstre.getMultiplicateur();
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
	
	

	public float getVie()
	{
		return vie;
	}

	public void setVie(float vie)
	{
		this.vie = vie;
	}
	public float getDefense() {
		return defense;
	}
	public void setDefense(float defense) {
		this.defense = defense;
	}
	public void attaque(Joueur victime)
	{
		float degatTotal = victime.getDefense() - getAtk();
		if(degatTotal < 1)
		{
			degatTotal = 1;
		}

		victime.setVie(victime.getVie() - degatTotal);
		System.out.println("Le monstre vous a infligez " + degatTotal + " dégats.\n");
	}
	
	
	public float getAtk()
	{
		return atk;
	}

	public void setAtk(float atk)
	{
		this.atk = atk;
	}

	
	
	
	public float getVitesse()
	{
		vitesse = vitesse + armesMonstre.getVitesse();
		return vitesse;
	}

	public void setVitesse(float vitesse)
	{
		this.vitesse = vitesse;
	}
	public float getAction() {
		action = 10000 / vitesse;
		action = (float) Math.round(action * 10.0f) / 10.0f;
		return action;
	}
	public void setAction(float action) {
		this.action = action;
	}
	
	

	public float getGold()
	{
		Random random = new Random();
		int randomNumber = random.nextInt(multiplicateur + 1) + 10;
        float randomFloatGold = Math.round(randomNumber) / 10.0f;
		return gold * randomFloatGold;
	}

	public void setGold(float gold)
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

	public float getExperience()
	{
		Random random = new Random();
		int randomNumber = random.nextInt(multiplicateur + 1) + 10;
        float randomFloatExp = Math.round(randomNumber) / 10.0f;
		return experience * randomFloatExp;
	}
	public void setExperience(float experience)
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
	
	public float estFaible(Type perso, Type arme, float degat){
		boolean crit = false;
        if(faiblesse.contains(perso))
        {       
            degat = degat * 1.5f;
			crit = true;
        }
		if(faiblesse.contains(arme))
        {       
            degat = degat * 1.5f;
			crit = true;
        }
		if(crit)
		{
			System.out.println("Votre attaque est super efficace");
		}

        return degat;
    }
	
	

	
}
