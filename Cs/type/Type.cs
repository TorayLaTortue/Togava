package type;

import java.util.HashSet;
import java.util.Set;

public enum Type {
    AUCUN("Aucun", 0),
    PHYSIQUE("Physique", 1),
    LUMIERE("Lumiere", 1),
    TENEBRE("Tenebre", 1),
    EAU("Eau", 1),
    FEU("Feu", 1),
    PLANTE("Plante", 2),
    QUANTIC("Quantique", 1),
    ROCHE("Roche", 3);

    private int id;
    private String type;
    private Set<Type> faiblesses;

    // Constructeur
    Type(String type, int id) {
        this.type = type;
        this.id = id;
        this.faiblesses = new HashSet<>();
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public Set<Type> getFaiblesses() {
        return faiblesses;
    }

    public void addFaiblesse(Type faiblesse) {
        this.faiblesses.add(faiblesse);
    }

    // Initialisation des faiblesses
    static {
        LUMIERE.addFaiblesse(TENEBRE);
        TENEBRE.addFaiblesse(LUMIERE);

        PHYSIQUE.addFaiblesse(FEU);
        PHYSIQUE.addFaiblesse(ROCHE);

        FEU.addFaiblesse(EAU);
        FEU.addFaiblesse(ROCHE);

        PLANTE.addFaiblesse(FEU);
        PLANTE.addFaiblesse(PHYSIQUE);

        EAU.addFaiblesse(PLANTE);
    }
}
