using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.IO;

namespace practicaFicheros
{
    public partial class FormBuscarInicial : Form
    {
        public FormBuscarInicial()
        {
            InitializeComponent();
        }

        private void btnAceptar_Click(object sender, EventArgs e)
        {
            List<String> resultados = new List<String>();

            foreach (Contacto c in Agenda.Listin)
            {
                if (c.Nombre.StartsWith(tbCaracter.Text))
                {
                    resultados.Add(c.ToString());
                }
            }

            File.WriteAllLines("AgendaPorInicial.txt", resultados.ToArray());
            MessageBox.Show("Fichero creado con exito");

        }
    }
}
