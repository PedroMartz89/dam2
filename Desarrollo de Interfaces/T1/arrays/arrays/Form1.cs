using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace arrays
{
    public partial class Form1 : Form

    {
        int[] Numeros = new int[10];
        int contador = 0;
        public Form1()
        {
            InitializeComponent();
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            if (contador < 10)
            {
                if (int.TryParse(num.Text, out int numero)) { 
                    Numeros[contador] = numero;
                    contador++;

                    listBox1.Items.Add($"{numero} → {(EsPrimo(numero) ? "PRIMO" : "NO PRIMO")}");

                    num.Clear();
                    num.Focus();
                }
                
            }
        }

        private bool EsPrimo(int numero)
        {
            if (numero < 2)

            return false;

            for (int i = 2; i <= Math.Sqrt(numero); i++)

            if (numero % i == 0) {
                return false;
            }
                return true;
            }

        private void button2_Click(object sender, EventArgs e)
        {
            if (int.TryParse(textoBuscar.Text, out int numBuscar)) 
            {
                int repeticiones = Numeros.Count(x => x == numBuscar);
                MessageBox.Show($"El número {numBuscar} se repite {repeticiones} veces.");
            }
            else
            {
                MessageBox.Show("Introduce un número válido para buscar.");
            }
        }

        private void button3_Click(object sender, EventArgs e)
        {
            int[] copia = (int[])Numeros.Clone();

            // Ordenar manualmente (burbuja)
            for (int i = 0; i < copia.Length - 1; i++)
            {
                for (int j = i + 1; j < copia.Length; j++)
                {
                    if (copia[i] > copia[j])
                    {
                        int temp = copia[i];
                        copia[i] = copia[j];
                        copia[j] = temp;
                    }
                }
            }

            listBox2.Items.Clear();
            for (int i = 0; i < copia.Length; i++)
            {
                listBox2.Items.Add($"{copia[i]}");
            }

            double media = copia.Average();
            int mayor = copia.Max();
            int menor = copia.Min();

            lblResultados.Text = $"Media: {media:F2} | Mayor: {mayor} | Menor: {menor}";
        }

        private void lblResultados_Click(object sender, EventArgs e)
        {

        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }
    }
 }
