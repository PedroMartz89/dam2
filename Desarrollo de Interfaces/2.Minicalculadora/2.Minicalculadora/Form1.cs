using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace _2.Minicalculadora
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void comboBox1_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {

        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void button_Click(object sender, EventArgs e)
        {
       
        }

        private void button3_Click(object sender, EventArgs e)
        {
            if (int.TryParse(operador1.Text, out int num1) && int.TryParse(operador2.Text, out int num2))
            {

                resultado.Visible = true;
                int result = num1 * num2;
                resultado.Text = result.ToString();

            }
            else
            {
                MessageBox.Show("Los valores introducidos no son correctos.");
            }
        }

        private void sumar_Click(object sender, EventArgs e)
        {

            if (int.TryParse(operador1.Text, out int num1) && int.TryParse(operador2.Text, out int num2)) {

                resultado.Visible = true;
                int result = num1 + num2;
                resultado.Text = result.ToString();
                
            }
            else
            {
                MessageBox.Show("Los valores introducidos no son correctos."); 
            }
        }

        private void restar_Click(object sender, EventArgs e)
        {
            if (int.TryParse(operador1.Text, out int num1) && int.TryParse(operador2.Text, out int num2))
            {

                resultado.Visible = true;
                int result = num1 - num2;
                resultado.Text = result.ToString();

            }
            else
            {
                MessageBox.Show("Los valores introducidos no son correctos.");
            }
        }

        private void div_Click(object sender, EventArgs e)
        {
            if (int.TryParse(operador1.Text, out int num1) && int.TryParse(operador2.Text, out int num2))
            {

                resultado.Visible = true;
                int result = num1 / num2;
                resultado.Text = result.ToString();

            }
            else
            {
                MessageBox.Show("Los valores introducidos no son correctos.");
            }
        }

        private void label2_Click(object sender, EventArgs e)
        {

        }
    }
}
