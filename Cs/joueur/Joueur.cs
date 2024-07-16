using System;
using System.Collections.Generic;
using combat;
using equipement;
using monstre;
using obje
//using pet;
using type;


public class Joueur : Entite
{
    private string nom;
    private Type type;
    private float vie;
    private Collier collier;
    private Cape cape;
    private Anneau anneau;
    private float voleVie;
    private float regenVie;
    private float vitality;
    private float defense;
    private float vieMax;
    private float atk;
    private float tauxCrit;
    private float degatCrit;
    private float atkSuivie;
    private float ferocity;
    private float vitesse;
    private Armes arme;
    private TypePets typePets;
    private float mana;
    private float manaMax;
    private int ancienTableauX;
    private int ancienTableauY;
    private float gold;
    private float bonusGold;
    private float experience;
    private float bonusExp;
    private float experienceRequis;
    private int level;
    private bool mort;
    private static Joueur joueur;

    public Joueur(TypeJoueur typeJoueur)
    {
        base.SetAction(10000 / typeJoueur.GetVitesse());
        nom = typeJoueur.GetNom();
        type = typeJoueur.GetType();
        collier = typeJoueur.GetCollier();
        anneau = typeJoueur.GetAnneau();
        cape = typeJoueur.GetCape();
        vie = typeJoueur.GetVie();
        defense = typeJoueur.GetDefense();
        vieMax = typeJoueur.GetVieMax();
        atk = typeJoueur.GetAtk();
        tauxCrit = typeJoueur.GetTauxCrit();
        degatCrit = typeJoueur.GetDegatCrit();
        atkSuivie = typeJoueur.GetAtkSuivie();
        vitesse = typeJoueur.GetVitesse();
        arme = typeJoueur.GetArme();
        typePets = typeJoueur.GetTypePets();
        mana = typeJoueur.GetMana();
        manaMax = typeJoueur.GetManaMax();
        gold = typeJoueur.GetGold();
        bonusGold = typeJoueur.GetBonusGold();
        mort = false;
        experience = typeJoueur.GetExperience();
        experienceRequis = typeJoueur.GetExperienceRequis();
        level = typeJoueur.GetLevel();
        joueur = this;
    }

    public string GetNom()
    {
        return nom;
    }

    public void SetNom(string nom)
    {
        this.nom = nom;
    }

    public Type GetType()
    {
        return type;
    }

    public void SetType(Type type)
    {
        this.type = type;
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
        if (vie > vieMax)
        {
            vie = vieMax;
        }
        this.vie = vie;
    }

    public Collier GetCollier()
    {
        return collier;
    }

    public void SetCollier(Collier collier)
    {
        this.collier = collier;
    }

    public Cape GetCape()
    {
        return cape;
    }

    public void SetCape(Cape cape)
    {
        this.cape = cape;
    }

    public Anneau GetAnneau()
    {
        return anneau;
    }

    public void SetAnneau(Anneau anneau)
    {
        this.anneau = anneau;
    }

    public float GetRegenVie()
    {
        return regenVie;
    }

    public void SetRegenVie(float regenVie)
    {
        this.regenVie = regenVie;
    }

    public float GetVitality()
    {
        return vitality;
    }

    public void SetVitality(float vitality)
    {
        this.vitality = vitality;
    }

    public float GetVoleVie()
    {
        return voleVie;
    }

    public void SetVoleVie(float voleVie)
    {
        this.voleVie = voleVie;
    }

    public float GetDefense()
    {
        defense += typePets.GetDefense();
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
        return atk + arme.GetDégats() + typePets.GetAtk() + anneau.GetAtk();
    }

    public void SetAtk(float atk)
    {
        this.atk = atk;
    }

    public float GetTauxCrit()
    {
        return tauxCrit + anneau.GetTauxCrit();
    }

    public void SetTauxCrit(float tauxCrit)
    {
        this.tauxCrit = tauxCrit;
    }

    public float GetDegatCrit()
    {
        return degatCrit + anneau.GetDegatCrit();
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

    public float GetFerocity()
    {
        return ferocity + anneau.GetFerocity();
    }

    public void SetFerocity(float ferocity)
    {
        this.ferocity = ferocity;
    }

    public float CoupCritique(float tauxCritique, float degat)
    {
        Random rand = new Random();
        float chance = (float)rand.NextDouble() * 100;
        float bonusCritique = 1;

        for (int i = 100; i < tauxCritique; i += 100)
        {
            bonusCritique++;
            Console.WriteLine(" - Bonus dégats critique.");
        }

        if (chance <= tauxCritique)
        {
            Console.WriteLine(" - Dégats critique !");
            return degat * ((degatCrit / 100) + bonusCritique);
        }
        else
        {
            return degat;
        }
    }

    public void Attaque(Monstre victime)
    {
        float degatTotal = GetAtk();
        degatTotal = victime.DegatFaible(arme.GetType(), GetType(), degatTotal) - victime.GetDefense();

        degatTotal = CoupCritique(tauxCrit, degatTotal);

        if (degatTotal < 1)
        {
            degatTotal = 1;
        }

        victime.SetVie(victime.GetVie() - degatTotal);
        Console.WriteLine($"Vous avez infligé {degatTotal} dégâts au {victime.GetNom()}.\n");
        SetMana(GetMana() - arme.GetCoutMana());

        if (arme.GetCoutMana() >= 1)
        {
            Console.WriteLine($"Vous avez utilisé {arme.GetCoutMana()} mana, il vous reste {GetMana()} mana.");
        }
    }

    public float GetVitesse()
    {
        return vitesse + arme.GetVitesse() + typePets.GetVitesse() + cape.GetVitesse();
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

    public TypePets GetTypePets()
    {
        return typePets;
    }

    public void SetTypePets(TypePets typePets)
    {
        this.typePets = typePets;
    }

    public void SetMana(float mana)
    {
        if (mana > manaMax)
        {
            mana = manaMax;
        }
        this.mana = mana;
    }

    public float GetMana()
    {
        if (mana > manaMax)
        {
            SetMana(manaMax);
        }
        return mana;
    }

    public float GetManaMax()
    {
        return manaMax + cape.GetManaMax();
    }

    public void SetManaMax(float manaMax)
    {
        this.manaMax = manaMax;
    }

    public static Joueur Get()
    {
        return joueur;
    }

    public bool IsMort()
    {
        return mort;
    }

    public void SetMort(bool mort)
    {
        this.mort = mort;
    }

    public int GetAncienTableauX()
    {
        return ancienTableauX;
    }

    public void SetAncienTableauX(int ancienTableauX)
    {
        this.ancienTableauX = ancienTableauX;
    }

    public int GetAncienTableauY()
    {
        return ancienTableauY;
    }

    public void SetAncienTableauY(int ancienTableauY)
    {
        this.ancienTableauY = ancienTableauY;
    }

    public float GetGold()
    {
        return gold;
    }

    public void SetGold(float gold)
    {
        this.gold = gold;
    }

    public void AddGold(float gold)
    {
        SetGold(GetGold() + gold);
    }

    public void SubGold(float gold)
    {
        SetGold(GetGold() - gold);
    }

    public float GetBonusGold()
    {
        return bonusGold + cape.GetBonusGold();
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

    public void AddExperience(float experience)
    {
        SetExperience(GetExperience() + experience);
    }

    public float GetExperienceRequis()
    {
        return experienceRequis;
    }

    public void SetExperienceRequis(int level)
    {
        double result = experienceRequis * (1 + (level / 10.0));
        experienceRequis = (int)Math.Round(result);
    }

    public float GetBonusExp()
    {
        return bonusExp + cape.GetBonusExp();
    }

    public void SetBonusExp(float bonusExp)
    {
        this.bonusExp = bonusExp;
    }

    public int GetLevel()
    {
        return level;
    }

    public void SetLevel(int level)
    {
        this.level = level;
    }

    public void Information()
    {
        Console.WriteLine($"Nom : {GetNom()}");
        Console.WriteLine($"Level : {GetLevel()}");
        Console.WriteLine($"Atk : {GetAtk()}");
    }

}
