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
    public partial class Altas : Form
    {
        public Altas()
        {
            InitializeComponent();
        }

        private void btnAceptar_Click(object sender, EventArgs e)
        {
            int id;
            int telf;

            if (!int.TryParse(tbId.Text, out id)) {
                MessageBox.Show("ID no válido");
                return;
            }

            if (!int.TryParse(tbTelf.Text, out telf))
            {
                MessageBox.Show("Teléfono no válido");
                return;
            }

            string nombre = tbNombre.Text.ToString();
           
            Agenda.Listin.Add(new Contacto(id, nombre, telf));
            MessageBox.Show("Contacto añadido");

            tbId.Clear();
            tbTelf.Clear();
            tbNombre.Clear();
            tbId.Focus();
        }

        private void btnCancelar_Click(object sender, EventArgs e)
        {
            tbId.Clear();
            tbTelf.Clear();
            tbNombre.Clear();
            tbId.Focus();
        }
    }
}
