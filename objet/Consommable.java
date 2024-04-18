package objet;

import joueur.Joueur;

public enum Consommable {
	RIEN("vide", 0, 0, 0, 0, 0, 0 ,0),
	POTIONVIE("potion de vie", 0, 5, 0, 0, 0, 0 ,0), POTIONVIEMAX("potion d'augmentation de vie", 0, 0, 5, 0, 0, 0 ,0),
	POTIONMANA("potion de régénaration de mana", 0, 0, 0, 0, 10, 0, 0), POTIONMANMAX("potion d'augmentation du mana", 0, 0, 0, 0, 0, 5, 0),
	POTIONPOLY("potion de régénaration polyvalente", 0, 30, 0, 0, 5, 0, 0),
	POTIONVITESSE("potion de vitesse", 0, 0, 0, 2, 0, 0, 0);

	private String nom;
	private int dégats;
	private int vie;
	private int vieMax;
	private int vitesse;
	private int mana;
	private int manaMax;
	private float couts;

	private Consommable(String nom, int dégats, int vie, int vieMax, int vitesse, int mana, int manaMax, float couts) {
		this.nom = nom;
		this.dégats = dégats;
		this.vie = vie;
		this.vieMax = vieMax;
		this.vitesse = vitesse;
		this.mana = mana;
		this.manaMax = manaMax;
		this.setCouts(couts);
	}

	public int getDégats() {
		return dégats;
	}

	public int useDégats() {
		return dégats;
	}

	public void setDégats(int dégats) {
		this.dégats = dégats;
	}

	public void useVie(Joueur joueur) {		
		System.out.println("Vous aviez " + joueur.getVie() + "  vie.");
		joueur.setVie(joueur.getVie() + vie);
		
		System.out.println("Vous avez gagnez " + vie + " vous avez donc " + joueur.getVie() + " pv sur " + joueur.getVieMax() + " pv maximum.");
		
	}

	public int getVie() {
		return vie;
	}

	public void setVie(int vie) {
		this.vie = vie;
	}

	public int getVieMax() {
		return vieMax;
	}

	public int useVieMax(Joueur joueur) {
		System.out.println("Vous avez augmenté votre vie max de " + vieMax + " pv, votre maximum de pv est donc de " + joueur.getVieMax() + " pv au total.");
		return vieMax;
	}

	public void setVieMax(int vieMax) {
		this.vieMax = vieMax;
	}

	public int getVitesse() {
		return vitesse;
	}

	public int useVitesse(Joueur joueur) {
		System.out.println("Vous avez augmenté votre vitesse de " + vitesse + " de facon permanente, votre vitesse est donc de " + joueur.getVitesse());
		return vitesse;
	}

	public void setVitesse(int vitesse) {
		this.vitesse = vitesse;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getMana() {
		return mana;
	}

	public int useMana(Joueur joueur) {
		System.out.println("Vous aviez " + joueur.getMana() + "  mana.");
		joueur.setMana(joueur.getMana() + mana);
		
		System.out.println("Vous avez gagnez " + mana + " mana, vous avez donc " + joueur.getMana() + " mana sur " + joueur.getManaMax() + " mana total.");
		return mana;
	}

	public int getManaMax() {
		return manaMax;
	}

	
	public void setMana(int mana) {
		this.mana = mana;
	}

	public int useManaMax(Joueur joueur) {
		System.out.println("Vous avez augmenté votre mana max de " + manaMax + " mana, votre maximum de mana est passer a " + joueur.getManaMax() + " mana au total." );

		return manaMax;
	}

	public void setManaMax(int mana) {
		this.mana = mana;
	}

	public float getCouts() {
		return couts;
	}

	public void setCouts(float couts) {
		this.couts = couts;
	}

	public void useAll(Joueur joueur){
		if(this.getVie() > 0)
		{this.useVie(joueur);}
		if(this.getVieMax() > 0)
		{joueur.setVieMax(this.useVieMax(joueur) + joueur.getVieMax());}
		if(this.getMana() > 0)
		{joueur.setMana(this.useMana(joueur) + joueur.getMana());}
		if(this.getManaMax() > 0)
		{joueur.setManaMax(this.useManaMax(joueur) + joueur.getManaMax());}
		if(this.getVitesse() > 0)
		{joueur.setVitesse(this.useVitesse(joueur) + joueur.getVitesse());}
					
	}

}
