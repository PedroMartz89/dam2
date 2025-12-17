using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ExamenPedroMartinezSanchez
{
    public partial class FormOperacionesCajeroMartinez : Form
    {
        public static Cliente cli = null;
        public FormOperacionesCajeroMartinez(Cliente c)
        {
            InitializeComponent();
            Text = "Cuenta de " + c.NombreCli;
            gbIngreso.Visible = false;
            gbRetiro.Visible = false;
            txtClaveAntigua.UseSystemPasswordChar = true;
            txtClaveNueva.UseSystemPasswordChar = true;
            txtRepetirClave.UseSystemPasswordChar = true;
            cli = c;
        }

        private void FormOperacionesCajeroMartinez_Load(object sender, EventArgs e)
        {

        }

        private void toolStripButton1_Click(object sender, EventArgs e)
        {
            gbRetiro.Visible = false;
            gbIngreso.Visible = true;

        }

        private void btIngresar_Click(object sender, EventArgs e)
        {
            if (double.TryParse(txtCantidad.Text, out double cantidad))
            {
                bool realizado = cli.Ingreso(cantidad);
                if (realizado) {

                    MessageBox.Show("Se ha realizado el ingreso, la nueva cantidad es: " + cli.SaldoCli + "€");

                    actualizarSaldo(cli);

                }
                else if (realizado == false)
                {
                    MessageBox.Show("No se ha podido realizar el ingreso.");
                }
            }
        }

        private void btnCancelar_Click(object sender, EventArgs e)
        {
            txtCantidad.Clear();
        }

        private void toolStripButton2_Click(object sender, EventArgs e)
        {
            gbIngreso.Visible = false;
            gbRetiro.Visible= true;

        }

        public void actualizarSaldo(Cliente cli)
        {
            foreach (Cliente c in FormPrincipalMartinez.clientes)
            {
                if (c.NombreCli.Equals(cli.NombreCli))
                {
                    c.SaldoCli = cli.SaldoCli;
                    return;
                }
            }

        }

        private void btnRetirar_Click(object sender, EventArgs e)
        {
            if (txtCantidadRetirar.Text.Equals(""))
            {
                MessageBox.Show("La cantidad no puede estar vacía,");
                txtCantidadRetirar.Focus();
                return;
            }

            if (double.TryParse(txtCantidadRetirar.Text, out double cantidad))
            {
                bool realizado = cli.Retiro(cantidad);

                if (realizado == true)
                {
                    MessageBox.Show("Se ha realizado el retiro, la nueva cantidad es: " + cli.SaldoCli + "€");
                    actualizarSaldo(cli);
                }
                else if (realizado == false)
                {
                    MessageBox.Show("No hay dinero suficiente para realizar el reintegro.");
                }
            }
            else
            {
                MessageBox.Show("La cantidad indicada no tiene un formato válido.");
            }

        }

        private void toolStripButton4_Click(object sender, EventArgs e)
        {
            FormPrincipalMartinez form = new FormPrincipalMartinez();
            form.Show();
            this.Close();
            
        }

        private void btnValidar_Click(object sender, EventArgs e)
        {
            if (int.TryParse(txtClaveAntigua.Text, out int clave))
            {
                if (clave == cli.ClaveCli)
                {
                    txtClaveNueva.ReadOnly = false;
                    txtRepetirClave.ReadOnly = false;
                }
            }

            
        }

        private void btnCambiar_Click(object sender, EventArgs e)
        {
            if (int.TryParse(txtClaveNueva.Text, out int claveNueva) && int.TryParse(txtRepetirClave.Text, out int claveRepetir))
            {
                if (claveNueva == claveRepetir)
                {
                    cli.ClaveCli = claveNueva;
                }
                else
                {
                    MessageBox.Show("Las claves no coinciden, vuelve a intentarlo.");
                    txtClaveNueva.Clear();
                    txtRepetirClave.Clear();
                    txtClaveNueva.Focus();
                }
            }
            else
            {
                MessageBox.Show("El formato de claves es incorrecto");
                txtClaveNueva.Clear();
                txtRepetirClave.Clear();
                txtClaveNueva.Focus();
            }
        }

        private void checkBoxMostrar_CheckedChanged(object sender, EventArgs e)
        {
            if (checkBoxMostrar.Checked) {
                txtClaveAntigua.UseSystemPasswordChar = false;
                txtClaveNueva.UseSystemPasswordChar = false;
                txtRepetirClave.UseSystemPasswordChar = false;
            }
            else 
            {
                txtClaveAntigua.UseSystemPasswordChar = true;
                txtClaveNueva.UseSystemPasswordChar = true;
                txtRepetirClave.UseSystemPasswordChar = true;
            }
        }
    }
}
