package tableau;

public class Levier {
    private Boolean droite;
    private Boolean gauche;
    private Boolean haut;
    private Boolean bas;
    private int X;
    private int Y;
    private Boolean used;

    private Levier(Builder builder) {
        this.X = builder.X;
        this.Y = builder.Y;
        this.droite = builder.droite;
        this.gauche = builder.gauche;
        this.haut = builder.haut;
        this.bas = builder.bas;
        this.used = builder.used;
    }

    public static class Builder {
        private Boolean droite = false;
        private Boolean gauche = false;
        private Boolean haut = false;
        private Boolean bas = false;
        private Boolean used  = false;
        private int X = 0;
        private int Y = 0;

        public Builder(int X, int Y) {
            this.X = X;
            this.Y = Y;
        }

        public Builder droite(Boolean value) {
            this.droite = value;
            return this;
        }

        public Builder gauche(Boolean value) {
            this.gauche = value;
            return this;
        }

        public Builder haut(Boolean value) {
            this.haut = value;
            return this;
        }

        public Builder bas(Boolean value) {
            this.bas = value;
            return this;
        }

        public Levier build() {
            return new Levier(this);
        }
    }

    public int getX() {
        return X;
    }

    public void setX(int X) {
        this.X = X;
    }

    public int getY() {
        return Y;
    }

    public void setY(int Y) {
        this.Y = Y;
    }

    public Boolean getDroite() {
        return droite;
    }

    public void setDroite(Boolean droite) {
        this.droite = droite;
    }

    public Boolean getGauche() {
        return gauche;
    }

    public void setGauche(Boolean gauche) {
        this.gauche = gauche;
    }

    public Boolean getHaut() {
        return haut;
    }

    public void setHaut(Boolean haut) {
        this.haut = haut;
    }

    public Boolean getBas() {
        return bas;
    }

    public void setBas(Boolean bas) {
        this.bas = bas;
    }
    public Boolean isUsed() {
        return used;
    }
    public void setUsed(Boolean used) {
        this.used = used;
    }
}
