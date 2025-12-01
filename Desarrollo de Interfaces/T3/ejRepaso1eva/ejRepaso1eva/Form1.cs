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

namespace ejRepaso1eva
{
    public partial class Altas : Form

    {
        public Altas()
        {
            InitializeComponent();
           
        }

        private void altaToolStripMenuItem_Click(object sender, EventArgs e)
        {

        }



        private void label3_Click(object sender, EventArgs e)
        {

        }

        private void consultasToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Consulta consulta = new Consulta();
            consulta.Show();
        }

        private void operacionesToolStripMenuItem_Click(object sender, EventArgs e)
        {

        }

        private void reintegrosToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Reintegro reintegro = new Reintegro();
            reintegro.Show();
        }

        private void transferenciaToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Transferencia transferencia = new Transferencia();
            transferencia.Show();
        }

        private void ingresoToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Ingreso ingreso = new Ingreso();
            ingreso.Show();
        }

        private void salirToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void btnGuardar_Click(object sender, EventArgs e)
        {
            string titular;
            string dni;
            double saldoInicial;
            bool okSaldo;

            titular = tbTitular.Text;
            dni = tbDNI.Text;

            if (titular.Length == 0)
            {
                MessageBox.Show("Debes introducir el nombre del titular.");
                tbTitular.Focus();
                return;
            }

            if (dni.Length == 0)
            {
                MessageBox.Show("Debes introducir el DNI.");
                tbDNI.Focus();
                return;
            }

            /* Validar saldo inicial numérico */
            okSaldo = double.TryParse(tbSaldo.Text.Trim(), out saldoInicial);

            if (!okSaldo || saldoInicial < 0)
            {
                MessageBox.Show("El saldo inicial debe ser un número mayor o igual que 0.");
                tbSaldo.Focus();
                return;
            }

            /* Crear la nueva cuenta */
            CuentaBancaria nuevaCuenta;
            nuevaCuenta = new CuentaBancaria(titular, dni, saldoInicial);

            /* Añadir a la lista global */
            CuentasBancarias.cuentasList.Add(nuevaCuenta);

            MessageBox.Show("Cuenta creada correctamente.\n\nNúmero: " + nuevaCuenta.NumCuenta +
                            "\nTitular: " + nuevaCuenta.Titular +
                            "\nDNI: " + nuevaCuenta.Dni +
                            "\nSaldo: " + nuevaCuenta.Saldo + " €");

            /* Limpiar campos para poder crear otra si se quiere */
            tbTitular.Clear();
            tbDNI.Clear();
            tbSaldo.Clear();
            tbTitular.Focus();
        }

        private void btnSalir_Click(object sender, EventArgs e)
        {
            this.Close();
        }
    }
}
