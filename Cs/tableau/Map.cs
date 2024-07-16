using System;
using Coffre;  // Assurez-vous que ces espaces de noms sont corrects
using Marchand;
using Monstre;
using Objet;
using Pet;
using Tableau;

namespace YourNamespace
{
    public class Map
    {
        public static Tableau[] CreateMap()
        {
            // Créez un tableau de tableaux en initialisant les objets
            Tableau[] tableaux = {
                new Tableau(0, 0).AddBas().AddPorteDroite(),
                new TableauMonstre(1, 0, new Monstre(TypeMonstre.SQUELETTE), new Monstre(TypeMonstre.BLOB), new Monstre(TypeMonstre.BLOBFEU)),
                new TableauMonstre(2, 0, new Monstre(TypeMonstre.CHEVALIERCOROMPUE)),
                new TableauCoffre(3, 0, new Coffre().AddArme(Armes.DAGUE).AddObjet(Consommable.POTIONPOLY)),
                new TableauMarchand(4, 0, new Marchand().AddArme(Armes.CLAYMORE).AddPets(TypePets.TORTUE)).AddHaut().AddGauche(),
                new TableauCoffre(5, 0, new Coffre().AddArme(Armes.EPEEPIERRE).AddObjet(Consommable.RIEN)).AddHaut().AddDroite(),
                new Tableau(6, 0).AddBas(),
                new Tableau(7, 0).AddBas(),
                new Tableau(8, 0).AddBas(),

                new Tableau(0, 1).SetLevier(new Levier.Builder(0, 0).SetDroite(true).Build()).AddGauche(),
                new TableauMarchand(1, 1, new Marchand().AddArme(Armes.CLAYMORE).AddPets(TypePets.TORTUE)).AddHaut().AddGauche(),
                new Tableau(2, 1),
                new TableauMonstre(3, 1, new Monstre(TypeMonstre.DRAGON)).AddDroite(),
                new TableauMarchand(4, 1, new Marchand().AddArme(Armes.CLAYMORE)).AddHaut().AddGauche(),
                new TableauCoffre(5, 1, new Coffre().AddArme(Armes.SCEPTRELUMIERE, Armes.CLAYMORE).AddObjet(Consommable.POTIONVITESSE)).AddHaut().AddDroite(),
                new Tableau(6, 1),
                new TableauMarchand(7, 1, new Marchand().AddArme(Armes.CLAYMORE)),
                new Tableau(8, 1),

                new TableauCoffre(0, 2, new Coffre().AddArme(Armes.SCEPTRELUMIERE, Armes.CLAYMORE).AddObjet(Consommable.POTIONVITESSE)),
                new Tableau(1, 2),
                new Tableau(2, 2),
                new Tableau(3, 2),
                new Tableau(4, 2),
                new Tableau(5, 2),
                new Tableau(6, 2),
                new Tableau(7, 2),
                new Tableau(8, 2),

                new TableauMonstre(0, 3, TableauMonstre.MonstresAleatoire(1, 3)),
                new Tableau(1, 3),
                new Tableau(2, 3),
                new Tableau(3, 3),
                new Tableau(4, 3),
                new Tableau(5, 3),
                new Tableau(6, 3),
                new Tableau(7, 3),
                new Tableau(8, 3),

                new Tableau(0, 4),
                new Tableau(1, 4),
                new Tableau(2, 4),
                new Tableau(3, 4),
                new Tableau(4, 4),
                new Tableau(5, 4),
                new Tableau(6, 4),
                new Tableau(7, 4),
                new Tableau(8, 4),

                new Tableau(6, 6),
                new Tableau(7, 7),
                new Tableau(8, 8),
            };

            // Retourne le tableau de tableaux
            return tableaux;
        }
    }
}
