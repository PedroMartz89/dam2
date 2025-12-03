using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace practicaFicheros
{
    public partial class FormBuscarTelfNombrecs : Form
    {
        public FormBuscarTelfNombrecs()
        {
            InitializeComponent();
        }

        private void btnAceptar_Click(object sender, EventArgs e)
        {
            List<Contacto> listin = Agenda.Listin;
            bool encontrado = false;

            foreach (Contacto contacto in listin)
            {
                if (contacto.Nombre.Equals(tbNombre.Text))
                {
                    MessageBox.Show("El telefono de " + contacto.Nombre + " es: " + contacto.Telefono);
                    encontrado = true;
                    break;

                }

            }
            if (!encontrado) {
                MessageBox.Show("No se ha encontrado el contacto");
            }            
            
            tbNombre.Clear();
        }
    }
}
