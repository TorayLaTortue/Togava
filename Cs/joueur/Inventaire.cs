using System.Collections.Generic;

namespace joueur
{
    public class Inventaire
    {
        private static Dictionary<int, object> inventaire = new Dictionary<int, object>();

        public static void AddObjet(object obj)
        {
            int nextKey = inventaire.Count + 1;
            inventaire[nextKey] = obj;
        }

        public static Dictionary<int, object> GetInventaire()
        {
            return inventaire;
        }

        public static object GetObjet(int i)
        {
            inventaire.TryGetValue(i, out var obj);
            return obj;
        }
    }
}
