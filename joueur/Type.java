package joueur;


public enum Type {
    AUCUN("Aucun"),
    PHYSIQUE("Physique"),// 1
    LUMIERE("Lumiere"),// 1
    TENEBRE("Tenebre"),// 1

    EAU("Eau"), // 1
    FEU( "Feu" ), // 1
    PLANTE( "Plante" ), // 2

    QUANTIC("Quantique"), // 1
    ROCHE("Roche"); // 3
    
    private int id;
    private String type;
    

    Type(String type){
        this.type = type;
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

   /* static{
        LUMIERE.faiblesse.addAll(Arrays.asList(Type.TENEBRE));

        TENEBRE.faiblesse.addAll(Arrays.asList(Type.LUMIERE));

        PHYSIQUE.faiblesse.addAll(Arrays.asList(Type.FEU, Type.ROCHE));

        FEU.faiblesse.addAll(Arrays.asList(Type.EAU ,Type.ROCHE));

        PLANTE.faiblesse.addAll(Arrays.asList(Type.FEU, Type.PHYSIQUE));

        EAU.faiblesse.addAll(Arrays.asList(Type.PLANTE));
    }*/

    

    

}

