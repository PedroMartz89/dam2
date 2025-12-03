using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace practicaFicheros
{
    public partial class Agenda : Form
    {
        public static List<Contacto> Listin = new List<Contacto>();

        public Agenda()
        {
            InitializeComponent();
        }

        private void tableLayoutPanel1_Paint(object sender, PaintEventArgs e)
        {

        }

        private void altasToolStripMenuItem_Click(object sender, EventArgs e)
        {

        }

        private void altasToolStripMenuItem1_Click(object sender, EventArgs e)
        {
            Altas altas = new Altas();
            altas.Show();
        }

        private void consultarTelefonoToolStripMenuItem_Click(object sender, EventArgs e)
        {
            FormBuscarTelfNombrecs buscarTelfNombre = new FormBuscarTelfNombrecs();
            buscarTelfNombre.Show();
        }

        private void guardarToolStripMenuItem_Click(object sender, EventArgs e)
        {
            List<String> lineas = new List<String>();

            foreach (Contacto contacto in Listin)
            {
                lineas.Add(contacto.Id + "," + contacto.Nombre + "," + contacto.Telefono);
            }

            File.WriteAllLines("listin.txt", lineas.ToArray());
            MessageBox.Show("Lista guardada correctamente");

        }

        private void leerAgendaToolStripMenuItem_Click(object sender, EventArgs e)
        {
            string texto = File.ReadAllText("listin.txt");
            MessageBox.Show(texto);
        }

        private void guardarAgendaPorInicialToolStripMenuItem_Click(object sender, EventArgs e)
        {
            FormBuscarInicial formBuscarInicial = new FormBuscarInicial();
            formBuscarInicial.Show();
        }

        private void eliminarContactosToolStripMenuItem_Click(object sender, EventArgs e)
        {
            FormEliminar formEliminar = new FormEliminar();
            formEliminar.Show();
        }
    }
}
