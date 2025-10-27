using System;
using System.Collections;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ejercicio1Clases
{
    public partial class Form3 : Form
    {
        public ArrayList listaArticulos;
        public Form3()
        {
            InitializeComponent();
            comboBoxCategoría.DataSource = Enum.GetValues(typeof(categoriaArticulo));
        }

        public Form3(ArrayList articulos)
        {
            InitializeComponent();
            comboBoxCategoría.DataSource = Enum.GetValues(typeof(categoriaArticulo));
            listaArticulos = articulos;

           

        }

        private void comboBox1_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private void bttnAceptar_Click(object sender, EventArgs e)
        {
            lvArticulos.Items.Clear();
            foreach (Articulo a in listaArticulos)
            {
                if (a.categoriaArticulo.ToString() == comboBoxCategoría.SelectedItem.ToString())
                {
                    lvArticulos.Items.Add(a.ToString());
                }
            }
        }
    }
}
