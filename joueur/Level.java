package joueur;

public class Level {
	static int expRequis = 100;

	public static void levelUpdate() {
		Joueur joueur = Joueur.get();
		int level = joueur.getLevel();
		while (joueur.getExperience() == expRequis) {
			expRequis = expRequis * (joueur.getLevel() / 3);

			if (joueur.getExperience() >= expRequis) {
				joueur.setLevel(level + 1);
				joueur.setExperience(joueur.getExperience() - expRequis);
				System.out.println("Bravo vous etes passez lv " + joueur.getLevel() + " ,prochain level dans " + expRequis + "exp.");
			}
		}

	}

}
