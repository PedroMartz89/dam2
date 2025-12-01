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
    public partial class Reintegro : Form
    {
        public Reintegro()
        {
            InitializeComponent();
        }

        private void btnConsultar_Click(object sender, EventArgs e)
        {
            if (double.Parse(tbCantidad.Text) < 0)
            {
                return;
            }

            CuentaBancaria c = CuentasBancarias.buscarCuenta(int.Parse(tbCuenta.Text));
            c.Reintegro(double.Parse(tbCantidad.Text));
        }
    }
}
