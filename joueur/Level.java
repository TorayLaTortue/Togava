package joueur;

public class Level {

	public static void levelUpdate(Joueur joueur) {
		while (joueur.getExperience() >= joueur.getExperienceRequis()) {
			joueur.setLevel(joueur.getLevel() + 1);
			joueur.setExperience(joueur.getExperience() - joueur.getExperienceRequis());
			joueur.setExperienceRequis(joueur.getLevel());
			System.out.println("Bravo vous etes passez lv " + joueur.getLevel() + " ,prochain level dans " +joueur.getExperienceRequis() + "exp.");
			}
		}

	}


