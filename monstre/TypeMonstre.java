package monstre;

import joueur.Type;

public enum TypeMonstre
{
	BLOB("Blob", Type.AUCUN, ArmesMonstre.AUCUNE, 8, 0, 2, 2, 3 , 250, 1), BLOBFEU("blob",Type.FEU , ArmesMonstre.AUCUNE, 10, 0, 4, 2, 6 , 25, 1),
	SQUELETTE("squelette", Type.TENEBRE, ArmesMonstre.ARCBOIS, 12, 1, 4, 3, 6 , 30, 1),
	CHEVALIERCOROMPUE("chevalier corompue", Type.PHYSIQUE, ArmesMonstre.EPEEBOIS, 5, 4, 9, 5, 999, 200, 5),
	DRAGON("dragon", Type.PHYSIQUE, ArmesMonstre.AUCUNE, 5, 10, 9, 5, 999, 200, 5);
	
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
	
	private TypeMonstre(String nom, Type type, ArmesMonstre armes, int vie, int defense, int atk, int vitesse, int gold, int experience, int difficulte)
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
	
	
	public int getAtk()
	{
		atk = atk + armesMonstre.getDégats();
		return atk;
	}
	public void setAtk(int atk)
	{
		this.atk = atk;
	}
	public ArmesMonstre getArmesMonstre() {
		return armesMonstre;
	}
	public void setArmesMonstre(ArmesMonstre armesMonstre) {
		this.armesMonstre = armesMonstre;
	}
	
	public int getVitesse()
	{
		return vitesse;
	}
	public void setVitesse(int vitesse)
	{
		this.vitesse = vitesse;
	}
	
	
	
	public int getGold()
	{
		return gold;
	}
	public void setGold(int gold)
	{
		this.gold = gold;
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
	
}
