using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace repaso1Ev
{
    public partial class Form1 : Form
    {
        public static List<Cuenta> listaCuentas = new List<Cuenta>();
        public Form1()
        {
            InitializeComponent();

            pnlAltas.Visible = false;
            pnlConsultar.Visible = false;

        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void altaToolStripMenuItem_Click(object sender, EventArgs e)
        {
            pnlAltas.Visible = true;
        }

        private void btnAceptarAlta_Click(object sender, EventArgs e)
        {
            if (txtTitular.Text.Equals(""))
            {
                MessageBox.Show("El titular no puede estar vacío"); return;
            }

            if (txtDNI.Text.Equals(""))
            {
                MessageBox.Show("El DNI no puede estar vacío"); return;
            }
            
            listaCuentas.Add(new Cuenta(txtTitular.Text, txtDNI.Text, 0));
            MessageBox.Show("Cuenta dada de alta correctamente");
            txtTitular.Text = "";
            txtDNI.Text = "";
            txtTitular.Focus();

        }

        private void btnCancelarAlta_Click(object sender, EventArgs e)
        {
            txtTitular.Text = "";
            txtDNI.Text = "";
            txtTitular.Focus();
        }

        private void btnAceptarConsultar_Click(object sender, EventArgs e)
        {
            if (txtDNIConultar.Text.Equals(""))
            {
                MessageBox.Show("El DNI no puede estar vacío"); return;
            }

            foreach (Cuenta c in listaCuentas)
            {
                if (c.Dni.Equals(txtDNIConultar.Text))
                {
                    MessageBox.Show(c.ToString());
                    return;
                }
            }

            MessageBox.Show("No existe ninguna cuenta con ese DNI");
        }

        private void btnCancelarConsultar_Click(object sender, EventArgs e)
        {
            txtDNIConultar.Text = "";
        }

        private void consultaToolStripMenuItem_Click(object sender, EventArgs e)
        {
            pnlAltas.Visible = false;
            pnlConsultar.Visible = true;
        }

        private void operacionesToolStripMenuItem_Click(object sender, EventArgs e)
        {
            FormOperaciones formOp = new FormOperaciones();
            formOp.Show();
            this.Hide();
        }

        private void salirToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }
    }
}
