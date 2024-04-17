package monstre;

public interface AbiliteMonstre {
    void performAbilite();
}

class Rien implements AbiliteMonstre {
    @Override
    public void performAbilite() {
        System.out.println("Le monstre n'a pas d'abilite!");
    }
}

class PoisonAbility implements AbiliteMonstre {
    @Override
    public void performAbilite() {
        System.out.println("The monster poisons its opponent!");
    }
}
