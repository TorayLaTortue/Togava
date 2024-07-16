using System;
using System.Collections.Generic;
using Deplacement;
using Joueur;
using Scan;

namespace TableauNamespace
{
    public class Tableau
    {
        private bool droite;
        private bool gauche;
        private bool haut;
        private bool bas;

        private bool porteDroite;
        private bool porteGauche;
        private bool porteHaut;
        private bool porteBas;
        private Levier levier;

        private int x;
        private int y;

        private static List<Tableau> tableaux = new List<Tableau>();

        public Tableau(int x, int y)
        {
            this.droite = false;
            this.gauche = false;
            this.haut = false;
            this.bas = false;
            this.porteDroite = false;
            this.porteGauche = false;
            this.porteHaut = false;
            this.porteBas = false;
            this.levier = null;
            this.x = x;
            this.y = y;
            tableaux.Add(this);
        }

        public bool HasDroite()
        {
            try
            {
                GetTableau(x + 1, y);
            }
            catch (Exception)
            {
                droite = true;
            }
            return droite;
        }

        public void SetDroite(bool droite)
        {
            this.droite = droite;
        }

        public Tableau AddDroite()
        {
            SetDroite(true);
            return this;
        }

        public Tableau ToDroite()
        {
            Joueur.Get().SetAncienTableauY(x);
            return GetTableau(x + 1, y);
        }

        public void SetPorteDroite(bool porteDroite)
        {
            this.porteDroite = porteDroite;
            this.droite = porteDroite;
        }

        public Tableau AddPorteDroite()
        {
            SetDroite(true);
            SetPorteDroite(true);
            return this;
        }

        public bool HasPorteDroite()
        {
            return porteDroite;
        }

        public bool HasGauche()
        {
            try
            {
                GetTableau(x - 1, y);
            }
            catch (Exception)
            {
                gauche = true;
            }
            return gauche;
        }

        public void SetGauche(bool gauche)
        {
            this.gauche = gauche;
        }

        public Tableau AddGauche()
        {
            SetGauche(true);
            return this;
        }

        public Tableau ToGauche()
        {
            Joueur.Get().SetAncienTableauY(x);
            return GetTableau(x - 1, y);
        }

        public void SetPorteGauche(bool porteGauche)
        {
            this.porteGauche = porteGauche;
            this.gauche = porteGauche;
        }

        public Tableau AddPorteGauche()
        {
            SetGauche(true);
            SetPorteGauche(true);
            return this;
        }

        public bool HasPorteGauche()
        {
            return porteGauche;
        }

        public bool HasHaut()
        {
            try
            {
                GetTableau(x, y + 1);
            }
            catch (Exception)
            {
                haut = true;
            }
            return haut;
        }

        public void SetHaut(bool haut)
        {
            this.haut = haut;
        }

        public Tableau AddHaut()
        {
            SetHaut(true);
            return this;
        }

        public Tableau ToHaut()
        {
            Joueur.Get().SetAncienTableauY(y);
            return GetTableau(x, y + 1);
        }

        public void SetPorteHaut(bool porteHaut)
        {
            this.porteHaut = porteHaut;
        }

        public Tableau AddPorteHaut()
        {
            SetHaut(true);
            SetPorteHaut(true);
            return this;
        }

        public bool HasPorteHaut()
        {
            return porteHaut;
        }

        public bool HasBas()
        {
            try
            {
                GetTableau(x, y - 1);
            }
            catch (Exception)
            {
                bas = true;
            }
            return bas;
        }

        public void SetBas(bool bas)
        {
            this.bas = bas;
        }

        public Tableau AddBas()
        {
            SetBas(true);
            return this;
        }

        public Tableau ToBas()
        {
            Joueur.Get().SetAncienTableauY(y);
            return GetTableau(x, y - 1);
        }

        public void SetPorteBas(bool porteBas)
        {
            this.porteBas = porteBas;
            this.bas = porteBas;
        }

        public Tableau AddPorteBas()
        {
            SetBas(true);
            SetPorteBas(true);
            return this;
        }

        public bool HasPorteBas()
        {
            return porteBas;
        }

        public int GetX()
        {
            return x;
        }

        public void SetX(int x)
        {
            this.x = x;
        }

        public int GetY()
        {
            return y;
        }

        public void SetY(int y)
        {
            this.y = y;
        }

        public static List<Tableau> GetTableaux()
        {
            return tableaux;
        }

        public static Tableau GetTableau(int x, int y)
        {
            return GetTableaux().Find(t => t.GetX() == x && t.GetY() == y) 
                   ?? throw new Exception("Tableau not found");
        }

        public void Evenement()
        {
            if (x == 3 && y == 0)
            {
                Console.WriteLine("Bravo vous avez gagné !");
                Environment.Exit(0);
            }
            else if (x == 0 && y == 0)
            {
                Console.WriteLine("Vous vous trouvez au spawn.");
            }
            else if (this is Tableau)
            {
                Console.WriteLine("Vous êtes dans une plaine vide.");
            }
            else
            {
                Console.WriteLine("Vous êtes dans le néant."); // Cas impossible
            }

            if (levier != null)
            {
                UseLevier();
            }

            Deplacement.Deplacement(this);
        }

        public Tableau SetLevier(Levier levier)
        {
            this.levier = levier;
            return this;
        }

        public void UseLevier()
        {
            Tableau tableau = GetTableau(levier.GetX(), levier.GetY());
            Console.WriteLine("Vous trouvez un levier.\nVoulez-vous l'utiliser ?");
            Console.WriteLine("0 - Non");
            Console.WriteLine("1 - Oui");

            bool reponse = Scan.ScannerBoolean();

            if (reponse)
            {
                if (!levier.IsUsed()) // on/off levier 
                {
                    Console.WriteLine("Le levier est maintenant activé.");
                    if (levier.GetDroite())
                    {
                        tableau.SetPorteDroite(false);
                    }
                    if (levier.GetGauche())
                    {
                        tableau.SetPorteGauche(false);
                    }
                    if (levier.GetHaut())
                    {
                        tableau.SetPorteHaut(false);
                    }
                    if (levier.GetBas())
                    {
                        tableau.SetPorteBas(false);
                    }
                    levier.SetUsed(true);
                }
                else
                {
                    Console.WriteLine("Le levier est maintenant désactivé.");
                    if (levier.GetDroite())
                    {
                        tableau.SetPorteDroite(true);
                    }
                    if (levier.GetGauche())
                    {
                        tableau.SetPorteGauche(true);
                    }
                    if (levier.GetHaut())
                    {
                        tableau.SetPorteHaut(true);
                    }
                    if (levier.GetBas())
                    {
                        tableau.SetPorteBas(true);
                    }
                    levier.SetUsed(false);
                }
            }
        }
    }
}
