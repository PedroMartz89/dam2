using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace AppCompraInteractiva
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void radioButton2_CheckedChanged(object sender, EventArgs e)
        {

        }

        private void label2_Click(object sender, EventArgs e)
        {

        }

        private void panel2_Paint(object sender, PaintEventArgs e)
        {

        }

        private void rbPC_CheckedChanged(object sender, EventArgs e)
        {
            if (rbPC.Checked)
            {
                pbEquipo.Image = Properties.Resources.pc;
            }
            else
            {
                pbEquipo.Image = null;
            }
        }

        private void rbMac_CheckedChanged(object sender, EventArgs e)
        {
            if (rbMac.Checked)
            {
                pbEquipo.Image = Properties.Resources.macintosh;
            }
            else
            {
                pbEquipo.Image = null;
            }
        }

        private void rbPort_CheckedChanged(object sender, EventArgs e)
        {
            if (rbPort.Checked)
            {
                pbEquipo.Image = Properties.Resources.portatil;
            }
            else
            {
                pbEquipo.Image = null;
            }
        }

        private void cbContestador_CheckedChanged(object sender, EventArgs e)
        {
            if (cbContestador.Checked)
            {
                pbOfi1.Image = Properties.Resources.contestador;
            }
            else
            {
                pbOfi1.Image = null;
            }
        }

        private void checkBox2_CheckedChanged(object sender, EventArgs e)
        {
            if (cbCalc.Checked)
            {
                pbOfi2.Image = Properties.Resources.calculadora;
            }
            else
            {
                pbOfi2.Image = null;
            }
        }

        private void cbFoto_CheckedChanged(object sender, EventArgs e)
        {
            if (cbFoto.Checked)
            {
                pbOfi3.Image = Properties.Resources.impresoraPNG;
            }
            else
            {
                pbOfi3.Image = null;
            }
        }

        private void listBox1_SelectedIndexChanged(object sender, EventArgs e)
        {
            if (listBox1.SelectedIndex == 0)
            {
                pbPerifericos.Image = Properties.Resources.discoDuro;

            }
            else if (listBox1.SelectedIndex == 1)
            {

                pbPerifericos.Image = Properties.Resources.impresoraPNG;
            }
            else if (listBox1.SelectedIndex == 2)
            {
                pbPerifericos.Image = Properties.Resources.antena;
            }
        }

        private void cbPago_SelectedIndexChanged(object sender, EventArgs e)
        {
            if (cbPago.SelectedIndex == 0)
            {
                pbPago.Image = Properties.Resources.tarjeta;

            } else if (cbPago.SelectedIndex == 1)

            {
                pbPago.Image = Properties.Resources.paypal;

            } else if (cbPago.SelectedIndex == 2)

            {
                pbPago.Image = Properties.Resources.bizum;
            }
        }

        private void btnPresupuesto_Click(object sender, EventArgs e)
        {
            int presupuesto = 0;

            if (rbPC.Checked){presupuesto += 700; }
            if (rbMac.Checked) { presupuesto += 1000; }
            if (rbPort.Checked) { presupuesto += 500; }
            if (cbContestador.Checked) { presupuesto += 50; }
            if (cbCalc.Checked) { presupuesto += 20; }
            if (cbFoto.Checked) { presupuesto += 100; }
            if (listBox1.SelectedIndex == 0) { presupuesto+= 75; }
            if (listBox1.SelectedIndex == 1) { presupuesto += 90; }
            if (listBox1.SelectedIndex == 2) { presupuesto += 50; }

            MessageBox.Show("Presupuesto total = " + presupuesto + ".", "Presupuesto");
        }

        private void btnSalir_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }
    }
}
