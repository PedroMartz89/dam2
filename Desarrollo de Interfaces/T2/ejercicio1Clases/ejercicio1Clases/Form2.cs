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
    public partial class Form2 : Form
    {
        public ArrayList articulos;
        public Form2()
        {
            InitializeComponent();
        }

        // Solución CS0051: Hacer Articulo público
        public Form2(ArrayList articulosF1)
        {
            InitializeComponent();
            articulos = articulosF1;
            foreach (Articulo a in articulosF1)
            {
                listView1.Items.Add(a.ToString());
            }

        }
        private void lblListadoTodos_Click(object sender, EventArgs e)
        {

        }
    }
}
