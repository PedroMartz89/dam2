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
    public partial class Consulta : Form
    {
        public Consulta()
        {
            InitializeComponent();
        }

        private void btnConsultar_Click(object sender, EventArgs e)
        {
            if (tbDNI.Text != null) {

                CuentaBancaria c = CuentasBancarias.buscarCuentaDNI(tbDNI.Text);
                lblResultado.Text = c.ToString();
                lblResultado.Visible = true;
            }
        }
    }
}
