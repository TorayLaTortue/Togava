package objet;

import joueur.Joueur;

public enum Objet {
	RIEN("vide", 0, 0, 0, 0, 0, 0 ,0),
	POTIONVIE("potion de vie", 0, 5, 0, 0, 0, 0 ,0), POTIONVIEMAX("potion d'augmentation de vie", 0, 0, 5, 0, 0, 0 ,0),
	POTIONMANA("potion de  régénaration de mana", 0, 0, 0, 0, 10, 0, 0), POTIONMANMAX("potion d'augmentation du mana", 0, 0, 0, 0, 0, 5, 0),
	POTIONVITESSE("potion de  régénaration de mana", 0, 0, 0, 2, 0, 0, 0);

	private String nom;
	private int dégats;
	private int vie;
	private int vieMax;
	private int vitesse;
	private int mana;
	private int manaMax;
	private int couts;
	private Joueur joueur;

	private Objet(String nom, int dégats, int vie, int vieMax, int vitesse, int mana, int manaMax, int couts) {
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

	public void setDégats(int dégats) {
		this.dégats = dégats;
	}

	public int getVie() {
		System.out.println("Vous avez gagnez " + vie + " pv, vous avez donc " + joueur.getVie() + " sur " + joueur.getVieMax() + " total");
		return vie;
	}

	public void setVie(int vie) {
		this.vie = vie;
	}

	public int getVieMax() {
		System.out.println("Vous avez augmentez votre vie max de " + vieMax + " pv, votre maximum de pv est passer a  " + joueur.getVieMax() + " pv au total.");
		return vieMax;
	}

	public void setVieMax(int vieMax) {
		this.vieMax = vieMax;
	}

	public int getVitesse() {
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
		System.out.println("Vous avez gagnez " + mana + " mana, vous avez donc " + joueur.getMana() + " mana sur " + joueur.getManaMax() + " mana total.");
		return mana;
	}

	public void setMana(int mana) {
		this.mana = mana;
	}

	public int getManaMax() {
		System.out.println("Vous avez augmentez votre mana max de " + manaMax + " mana, votre maximum de mana est passer a " + joueur.getManaMax() + " mana au total." );

		return manaMax;
	}

	public void setManaMax(int mana) {
		this.mana = mana;
	}

	public int getCouts() {
		return couts;
	}

	public void setCouts(int couts) {
		this.couts = couts;
	}

}
