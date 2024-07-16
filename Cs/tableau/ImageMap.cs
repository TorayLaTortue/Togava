using System;
using System.Drawing;
using System.Drawing.Imaging;
using System.IO;
using System.Windows.Forms;

namespace ImageMapGenerator
{
    public class ImageMap
    {
        public static void GenerateImageMap(Tableau[] tableaux)
        {
            Console.WriteLine("Début de la génération de l'image");
            int width = 900;
            int height = 900;
            int numRows = 9;
            int numCols = 9;
            float scaleFactor = 1.0f;
            Bitmap image = new Bitmap(width, height);

            using (Graphics g = Graphics.FromImage(image))
            {
                for (int i = 0; i < tableaux.Length; i++)
                {
                    DrawTableau(g, tableaux[i], width, height, numRows, numCols);
                }

                ShowImage(image, scaleFactor);
            }
        }

        private static void DrawTableau(Graphics g, Tableau tableau, int width, int height, int numRows, int numCols)
        {
            int x = (width / numCols) * tableau.GetX();
            int y = (height - ((height / numRows) * (tableau.GetY() + 1)));

            // Dessinez le tableau sur l'image en fonction de son type
            if (tableau is TableauMonstre tableauMonstre)
            {
                int difficulteMax = tableauMonstre.GetMaxDifficulte();
                if (tableauMonstre.GetMonstre(difficulteMax).GetDifficulte() == 1)
                {
                    DrawImage(g, "image/Monstre.png", x, y);
                }
                else if (tableauMonstre.GetMonstre(difficulteMax).GetDifficulte() == 5)
                {
                    DrawImage(g, "image/MonstreElite.png", x, y);
                }
                else
                {
                    g.DrawRectangle(Pens.Black, x, y, 60, 60);
                }
            }
            else if (tableau is TableauMarchand)
            {
                DrawImage(g, "image/Marchand.png", x, y);
            }
            else if (tableau is TableauCoffre)
            {
                DrawImage(g, "image/Coffre.png", x, y);
            }
            else
            {
                DrawImage(g, "image/PlaineVide.png", x, y);
            }

            // Dessinez les murs
            if (tableau.HasHaut())
            {
                DrawImage(g, "image/MurHaut.png", x, y);
            }
            if (tableau.HasBas())
            {
                DrawImage(g, "image/MurBas.png", x, y + (height / numRows));
            }
            if (tableau.HasGauche())
            {
                DrawImage(g, "image/MurGauche.png", x, y);
            }
            if (tableau.HasDroite())
            {
                DrawImage(g, "image/MurDroite.png", x + (width / numCols), y);
            }
        }

        private static void DrawImage(Graphics g, string imageName, int x, int y)
        {
            try
            {
                using (Image image = Image.FromFile(imageName))
                {
                    g.DrawImage(image, x, y);
                }
            }
            catch (IOException e)
            {
                Console.WriteLine("Image qui n'a pas chargée : " + imageName);
                Console.WriteLine(e.Message);
            }
        }

        private static void ShowImage(Bitmap image, float scaleFactor)
        {
            Form form = new Form
            {
                Text = "Image Map",
                AutoScaleMode = AutoScaleMode.Font,
                ClientSize = new Size((int)(image.Width * scaleFactor), (int)(image.Height * scaleFactor)),
                StartPosition = FormStartPosition.CenterScreen
            };

            PictureBox pictureBox = new PictureBox
            {
                Dock = DockStyle.Fill,
                Image = image
            };

            form.Controls.Add(pictureBox);
            form.ShowDialog();
        }
    }
}
