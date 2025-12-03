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
    public partial class FormEliminar : Form
    {
        public FormEliminar()
        {
            InitializeComponent();
        }

        private void btnAceptar_Click(object sender, EventArgs e)
        {
            string caracteres = tbCaracter.Text;
            lstResultados.Items.Clear();
            lstResultados.SelectionMode = SelectionMode.MultiExtended;

            foreach (Contacto contact in Agenda.Listin)
            {

                if (contact.Nombre.IndexOf(caracteres) >= 0)
                {
                    lstResultados.Items.Add(contact);
                }
            }


        }

        private void btnEliminar_Click(object sender, EventArgs e)
        {
            if (lstResultados.SelectedItems.Count == 0)
            {
                MessageBox.Show("Selecciona un contacto para eliminar");
                return;
            }

            List<Contacto> contactosAEliminar = new List<Contacto>();

            foreach (object item in lstResultados.SelectedItems) { 
            
                Contacto contacto = item as Contacto;
                if (contacto != null) { 
                    contactosAEliminar.Add(contacto);
                }
            }

            foreach (Contacto contacto in contactosAEliminar)
            {
                Agenda.Listin.Remove(contacto);
            }

            MessageBox.Show("Contactos eliminados correctamente.");

            lstResultados.Items.Clear();

            foreach (Contacto contact in Agenda.Listin)
            {
                lstResultados.Items.Add(contact.ToString());
            }

        }
    }
}
