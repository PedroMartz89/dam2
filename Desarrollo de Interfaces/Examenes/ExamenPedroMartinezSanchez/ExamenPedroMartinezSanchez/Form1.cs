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
    public partial class FormPrincipalMartinez : Form
    {
        public static List<Cliente> clientes = new List<Cliente>();
        int intentos = 3;
        public FormPrincipalMartinez()
        {
            InitializeComponent();
            gbAltas.Visible = false;
            gbConsulta.Visible = false;
            gbInicioCajero.Visible = false;
        }

        private void autorToolStripMenuItem_Click(object sender, EventArgs e)
        {

        }

        private void altaToolStripMenuItem_Click(object sender, EventArgs e)
        {
            gbConsulta.Visible = false;
            gbInicioCajero.Visible = false;
            gbAltas.Visible = true;
        }

        private void consultaToolStripMenuItem_Click(object sender, EventArgs e)
        {
            gbAltas.Visible = false;
            gbInicioCajero.Visible = false;
            gbConsulta.Visible = true;
        }

        public void limpiarList()
        {
            listConsultar.Items.Clear();
        }

        private void btnAlta_Click(object sender, EventArgs e)
        {
            if (txtDniAlta.Text == "")
            {
                MessageBox.Show("El campo DNI no puede estar vacío.");
                txtDniAlta.Focus();
                return;
            }

            if (txtNombreAlta.Text == "")
            {
                MessageBox.Show("El campo Nombre no puede estar vacío.");
                txtNombreAlta.Focus();
                return;
            }

            if (txtClaveAlta.Text == "")
            {
                MessageBox.Show("El campo Clave no puede estar vacío.");
                txtClaveAlta.Focus();
                return;
            }

            if (txtSaldo.Text == "")
            {
                MessageBox.Show("El campo Saldo no puede estar vacío.");
                txtSaldo.Focus();
                return;
            }

            if (double.TryParse(txtSaldo.Text, out double saldo) && (int.TryParse(txtClaveAlta.Text, out int clave)))
            {
                string dni = txtDniAlta.Text;
                string nombre = txtNombreAlta.Text;

                clientes.Add(new Cliente(dni, clave, nombre, saldo));
                MessageBox.Show("Se ha creado el nuevo cliente correctamente.");
                limpiarCampos();
            }
            else
            {
                MessageBox.Show("El campo saldo no tiene un formato correcto.");
                txtSaldo.Clear();
                txtSaldo.Focus();
            }


        }

        public void limpiarCampos()
        {

            txtClaveAlta.Clear();
            txtClaveIniciar.Clear();
            txtSaldo.Clear();
            txtDniAlta.Clear();
            txtDniIniciar.Clear();
            txtNombreAlta.Clear();
            txtNombreBuscar.Clear();

        }

        private void btnBuscar_Click(object sender, EventArgs e)
        {
            limpiarList();
            if (txtNombreBuscar.Text == "")
            {
                MessageBox.Show("El campo nombre debe contener datos.");
                txtNombreBuscar.Focus();
                return;
            }
            
            foreach (Cliente c in clientes)
            {
                if (c.NombreCli.Equals(txtNombreBuscar.Text))
                {
                    listConsultar.Items.Add(c);
                    if (c.BloqueoCli == true)
                    {
                        checkBloquear.Checked = true;
                    }
                    else
                    {
                        checkBloquear.Checked = false;
                    }
                    limpiarCampos();
                    return;
                }

            }

            listConsultar.Items.Add("No se ha encontrado el cliente " + txtNombreBuscar.Text.ToString() + ".");
            limpiarCampos();
        }

        private void label7_Click(object sender, EventArgs e)
        {

        }

        private void btnValidar_Click(object sender, EventArgs e)
        {
           
           foreach (Cliente cliente in clientes)
           {
                if (cliente.DniCli.Equals(txtDniIniciar.Text))
                {
                    MessageBox.Show("Se ha validado el DNI.");
                    txtClaveIniciar.Visible = true;
                    btnEntrar.Visible = true;
                    txtDniIniciar.Enabled = false;
                    return;
                }
                
           }

            MessageBox.Show("No se ha encontrado el cliente con ese DNI, vuelva a intentarlo.");
            limpiarCampos();
            return;
        }

        private void btnEntrar_Click(object sender, EventArgs e)
        {
            Cliente c = buscarClienteDNI(txtDniIniciar.Text);

            if (txtClaveIniciar.Text.Equals(""))
            {
                MessageBox.Show("El campo clave no puede estar vacío");
                txtClaveIniciar.Focus();
                return;
            }

            if (!int.TryParse(txtClaveIniciar.Text, out int clave))
            {
                MessageBox.Show("El formato de la clave es incorrecto");
                txtClaveIniciar.Clear();
                txtClaveIniciar.Focus();
                
            }

            if (intentos == 0)
            {
                c.BloqueoCli = true;
                MessageBox.Show("Se ha bloqueado la cuenta, demasiados intentos");
                limpiarCampos();
                txtDniIniciar.Enabled = true;
                return;
            }

            foreach (Cliente cli in clientes)
            {
                if (cli.ClaveCli == clave)
                {
                    MessageBox.Show("Bienvenido/a " + cli.NombreCli.ToString());
                    FormOperacionesCajeroMartinez form = new FormOperacionesCajeroMartinez(cli);
                    form.ShowDialog();
                    this.Hide();
                    limpiarCampos();
                    return;
                }
            }

            intentos--;
            MessageBox.Show("No se ha podido validar la clave, vuelva a intentarlo, le quedan " + intentos + " intentos.");
            
        }

        public Cliente buscarClienteDNI(string dni) {

            foreach (Cliente cliente in clientes) {

                if (cliente.DniCli.Equals(dni))
                {
                    return cliente;
                }
            }

            return null;
        }

        private void cajeroToolStripMenuItem_Click(object sender, EventArgs e)
        {
            intentos = 3;
            gbAltas.Visible = false;
            gbConsulta.Visible = false;
            gbInicioCajero.Visible = true;
        }

        private void btnCancelarAlta_Click(object sender, EventArgs e)
        {
            limpiarCampos();
        }

        private void btnCancelarBusca_Click(object sender, EventArgs e)
        {
            limpiarCampos();
        }
    }
}

