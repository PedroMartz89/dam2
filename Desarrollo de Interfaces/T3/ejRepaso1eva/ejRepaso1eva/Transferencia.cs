using System;
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
    public partial class Transferencia : Form
    {
        public Transferencia()
        {
            InitializeComponent();
        }

        private void btnAceptar_Click(object sender, EventArgs e)
        {
            if (tbCantidad != null && tbNcuenta != null)
            {
                CuentaBancaria c = CuentasBancarias.buscarCuenta(int.Parse(tbNcuenta.Text));
                CuentaBancaria c2 = CuentasBancarias.buscarCuenta(int.Parse(tbCuentaDestino.Text));
                c.Transferencia(double.Parse(tbCantidad.Text), c2);
                
            }
            else
            {
                MessageBox.Show("No se ha podido realizar la tansferencia");
            }
        }

        
    }
}
