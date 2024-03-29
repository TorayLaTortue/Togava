package monstre;

import java.util.ArrayList;
import java.util.Arrays;

import joueur.Type;

public enum TypeMonstre
{
	BLOB("Blob", Type.AUCUN, ArmesMonstre.AUCUNE, 8, 0, 2, 100, 3 , 250, 5, 1), BLOBFEU("Blob de feu",Type.FEU , ArmesMonstre.AUCUNE, 10, 0, 4, 105, 6 , 25, 5, 1),
	SQUELETTE("Squelette", Type.TENEBRE, ArmesMonstre.ARCBOIS, 12, 1, 4, 110, 6 , 30, 4, 1),
	CHEVALIERCOROMPUE("Chevalier corompue", Type.PHYSIQUE, ArmesMonstre.EPEEBOIS, 5, 4, 9, 120, 999, 200, 4, 5),
	DRAGON("Dragon", Type.PHYSIQUE, ArmesMonstre.AUCUNE, 5, 10, 9, 130, 999, 200, 2, 5);
	
	private String nom;
	private Type type;
	private ArmesMonstre armesMonstre;
	private float vie;
	private float defense;
	private float atk;
	private float vitesse;
	private float gold;
	private float experience;
	private int multiplicateur;
	private int difficulte;
	private ArrayList<Type> faiblesse = new ArrayList<>();
	
	private TypeMonstre(String nom, Type type, ArmesMonstre armes, float vie, float defense, float atk, float vitesse, float gold, float experience, int multiplicateur, int difficulte)
	{
	this.nom = nom;
	this.type = type;
	this.armesMonstre = armes;
	this.vie = vie;
	this.defense = defense;
	this.atk = atk;
	this.vitesse = vitesse;
	this.gold = gold;
	this.experience = experience;
	this.difficulte = difficulte;
	for (Type faiblesses : faiblesse) {
		this.faiblesse.add(faiblesses);
	}
	
	}

	static{
        BLOBFEU.faiblesse.addAll(Arrays.asList(Type.EAU));
		SQUELETTE.faiblesse.addAll(Arrays.asList(Type.LUMIERE));
		CHEVALIERCOROMPUE.faiblesse.addAll(Arrays.asList(Type.LUMIERE));
		DRAGON.faiblesse.addAll(Arrays.asList(Type.PHYSIQUE, Type.TENEBRE));
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
	public ArmesMonstre getArmes() {
		return armesMonstre;
	}
	public void setArmes(ArmesMonstre armes) {
		this.armesMonstre = armes;
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
	
	
	public float getAtk()
	{
		atk = atk + armesMonstre.getDégats();
		return atk;
	}
	public void setAtk(float atk)
	{
		this.atk = atk;
	}
	public ArmesMonstre getArmesMonstre() {
		return armesMonstre;
	}
	public void setArmesMonstre(ArmesMonstre armesMonstre) {
		this.armesMonstre = armesMonstre;
	}
	
	public float getVitesse()
	{
		return vitesse;
	}
	public void setVitesse(float vitesse)
	{
		this.vitesse = vitesse;
	}
	
	
	
	public float getGold()
	{
		return gold;
	}
	public void setGold(float gold)
	{
		this.gold = gold;
	}

	public float getExperience()
	{
		return experience;
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

	public int getMultiplicateur() {
		return multiplicateur;
	}
	public void setMultiplicateur(int multiplicateur) {
		this.multiplicateur = multiplicateur;
	}
	
}
