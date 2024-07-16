using System;
using Equipement;
using Objet;
using Pet;
using Type;

namespace Joueur
{
    public enum TypeJoueur
    {
        CHEVALIER("Chevalier", Type.PHYSIQUE, TypePets.AUCUN, Anneau.AUCUN, Collier.AUCUN, Cape.AUCUN, 10, 2, 10, 2, 0, 50, 0, 120, Armes.EPEEBOIS, 3, 3, 2, 0, 0, 0, 100, 1),
        CHEVALIERDUNEANT("Chevalier du neant", Type.PHYSIQUE, TypePets.AUCUN, Anneau.AUCUN, Collier.AUCUN, Cape.AUCUN, 6, 2, 6, 4, 0, 50, 0, 120, Armes.EPEEBOIS, 8, 8, 2, 0, 0, 0, 100, 1),
        BANDIT("Bandit", Type.TENEBRE, TypePets.AUCUN, Anneau.AUCUN, Collier.AUCUN, Cape.AUCUN, 8, 2, 8, 4, 0, 50, 0, 120, Armes.DAGUEROUILLE, 5, 5, 2, 5, 0, 0, 100, 1),
        VAMPIRE("Vampire", Type.TENEBRE, TypePets.BAT, Anneau.AUCUN, Collier.AUCUN, Cape.AUCUN, 7, 2, 7, 3, 0, 50, 0, 120, Armes.DAGUEROUILLE, 5, 5, 2, 0, 0, 0, 100, 1),
        MAGE("Mage", Type.LUMIERE, TypePets.AUCUN, Anneau.AUCUN, Collier.AUCUN, Cape.AUCUN, 50, 2, 50, 70, 50, 50, 0, 120, Armes.SCEPTRET1, 20, 20, 2, 0, 0, 0, 100, 1),
        ADEPTE("Adepte", Type.LUMIERE, TypePets.AUCUN, Anneau.AUCUN, Collier.AUCUN, Cape.AUCUN, 500, 2, 500, 50, 150, 50, 0, 115, Armes.SCEPTRET1, 10, 10, 2, 300, 0, 0, 100, 1);

        private readonly string nom;
        private readonly Type type;
        private readonly TypePets typePets;
        private readonly Collier collier;
        private readonly Cape cape;
        private readonly Anneau anneau;
        private readonly float vie;
        private readonly float defense;
        private readonly float vieMax;
        private readonly float atk;
        private readonly float tauxCrit;
        private readonly float degatCrit;
        private readonly float atkSuivie;
        private readonly float vitesse;
        private readonly Armes arme;
        private readonly float mana;
        private readonly float manaMax;
        private readonly int ancienTableau;
        private readonly float gold;
        private readonly float bonusGold;
        private readonly float experience;
        private readonly float experienceRequis;
        private readonly int level;

        private TypeJoueur(string nom, Type type, TypePets typePets, Anneau anneau, Collier collier, Cape cape, float vie, float defense, float vieMax, float atk, float tauxCrit, float degatCrit, float atkSuivie, float vitesse, Armes arme, float mana, float manaMax, int tableauStart, float gold, float bonusGold, float experience, float experienceRequis, int level)
        {
            this.nom = nom;
            this.type = type;
            this.typePets = typePets;
            this.collier = collier;
            this.anneau = anneau;
            this.cape = cape;
            this.vie = vie;
            this.defense = defense;
            this.vieMax = vieMax;
            this.atk = atk;
            this.tauxCrit = tauxCrit;
            this.degatCrit = degatCrit;
            this.atkSuivie = atkSuivie;
            this.vitesse = vitesse;
            this.arme = arme;
            this.mana = mana;
            this.manaMax = manaMax;
            this.ancienTableau = tableauStart;
            this.gold = gold;
            this.bonusGold = bonusGold;
            this.experience = experience;
            this.experienceRequis = experienceRequis;
            this.level = level;
        }

        public string GetNom()
        {
            return nom;
        }

        public Type GetType()
        {
            return type;
        }

        public TypePets GetTypePets()
        {
            return typePets;
        }

        public Collier GetCollier()
        {
            return collier;
        }

        public Cape GetCape()
        {
            return cape;
        }

        public Anneau GetAnneau()
        {
            return anneau;
        }

        public float GetVie()
        {
            if (vie > vieMax)
            {
                SetVie(vieMax);
            }
            return vie;
        }

        public void SetVie(float vie)
        {
            this.vie = vie;
        }

        public float GetDefense()
        {
            return defense;
        }

        public void SetDefense(float defense)
        {
            this.defense = defense;
        }

        public float GetVieMax()
        {
            return vieMax;
        }

        public void SetVieMax(float vieMax)
        {
            this.vieMax = vieMax;
        }

        public float GetAtk()
        {
            return atk;
        }

        public void SetAtk(float atk)
        {
            this.atk = atk;
        }

        public float GetTauxCrit()
        {
            return tauxCrit;
        }

        public void SetTauxCrit(float tauxCrit)
        {
            this.tauxCrit = tauxCrit;
        }

        public float GetDegatCrit()
        {
            return degatCrit;
        }

        public void SetDegatCrit(float degatCrit)
        {
            this.degatCrit = degatCrit;
        }

        public float GetAtkSuivie()
        {
            return atkSuivie;
        }

        public void SetAtkSuivie(float atkSuivie)
        {
            this.atkSuivie = atkSuivie;
        }

        public float GetVitesse()
        {
            return vitesse;
        }

        public void SetVitesse(float vitesse)
        {
            this.vitesse = vitesse;
        }

        public Armes GetArme()
        {
            return arme;
        }

        public void SetArme(Armes arme)
        {
            this.arme = arme;
        }

        public float GetMana()
        {
            if (mana > manaMax)
            {
                SetMana(manaMax);
            }
            return mana;
        }

        public void SetMana(float mana)
        {
            this.mana = mana;
        }

        public float GetManaMax()
        {
            return manaMax;
        }

        public void SetManaMax(float manaMax)
        {
            this.manaMax = manaMax;
        }

        public int GetAncienTableau()
        {
            return ancienTableau;
        }

        public void SetAncienTableau(int ancienTableau)
        {
            this.ancienTableau = ancienTableau;
        }

        public float GetGold()
        {
            return gold;
        }

        public void SetGold(float gold)
        {
            this.gold = gold;
        }

        public float GetBonusGold()
        {
            return bonusGold;
        }

        public void SetBonusGold(float bonusGold)
        {
            this.bonusGold = bonusGold;
        }

        public float GetExperience()
        {
            return experience;
        }

        public void SetExperience(float experience)
        {
            this.experience = experience;
        }

        public float GetExperienceRequis()
        {
            return experienceRequis;
        }

        public void SetExperienceRequis(float experienceRequis)
        {
            this.experienceRequis = experienceRequis;
        }

        public int GetLevel()
        {
            return level;
        }

        public void SetLevel(int level)
        {
            this.level = level;
        }
    }
}
