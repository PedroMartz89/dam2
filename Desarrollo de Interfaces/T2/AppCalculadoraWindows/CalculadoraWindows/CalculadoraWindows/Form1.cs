using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Globalization;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace CalculadoraWindows
{
    public partial class Form1 : Form
    {   
        private double acumulado = 0.0;
        private string opPendiente = null;
        private bool entradaNueva = true;
        private double ultimoOperando = 0.0;
        private string ultimaOperacion = null;
        private readonly string separador;
        private double acumuladoAnterior = 0.0;

        public Form1()
        {
            InitializeComponent();
            this.KeyPreview = true;
            this.KeyDown += new KeyEventHandler(Form1_KeyDown);
            txtDisplay.Text = "0";
            separador = CultureInfo.CurrentCulture.NumberFormat.NumberDecimalSeparator;
            ButtonsEnable();
            
        }


        private void ButtonsEnable()
        {

            //Numeros
            foreach (var b in this.Controls.Find("tlpTeclado", true).FirstOrDefault()?.Controls.OfType<Button>() ?? this.Controls.OfType<Button>())
            {
                if (b.Name.StartsWith("btn") && b.Name.Length == 4 && char.IsDigit(b.Name.Last()))
                    b.Click += Digito_Click;
            }

            // Operadores
            btnSum.Click += (s, e) => Operador_Click("+");
            btnRest.Click += (s, e) => Operador_Click("-");
            btnMulti.Click += (s, e) => Operador_Click("*");
            btnDiv.Click += (s, e) => Operador_Click("/");

            // Especiales
            btnIgual.Click += (s, e) => Igual_Click();
            btnComa.Click += (s, e) => Coma_Click();
            btnMasMenos.Click += (s, e) => CambiarSigno();
            btnCE.Click += (s, e) => CE();
        }

        private void Operador_Click(string operador)
        {
            if (entradaNueva && opPendiente != null)
            {
                // Cambiar de operador si se pulsan operadores seguidos
                opPendiente = operador;
                return;
            }

            if (!double.TryParse(txtDisplay.Text, out double actual))
                return;

            if (opPendiente == null)
            {
                // Primera vez solo guardamos el acumulado
                acumulado = actual;
            }
            else
            {
                // Ya había operación pendiente calcula y anota
                acumuladoAnterior = acumulado;
                string op = opPendiente;
                double b = actual;

                acumulado = Aplicar(acumuladoAnterior, b, op);
                txtDisplay.Text = acumulado.ToString();

                // Historial
                AnotarHistorial(acumuladoAnterior, op, b, acumulado);
            }

            // Preparar siguiente estado
            opPendiente = operador;
            ultimaOperacion = null;
            ultimoOperando = actual;
            entradaNueva = true;
        }


        private void Coma_Click()
        {
            // Solo una coma: si empieza con coma => "0,"
            if (entradaNueva)
            {
                txtDisplay.Text = "0" + separador;
                entradaNueva = false;
                return;
            }

            if (!txtDisplay.Text.Contains(separador))
                txtDisplay.Text += separador;
        }
        private void CambiarSigno()
        {
            if (double.TryParse(txtDisplay.Text, out double v))
            {
                v = -v;
                txtDisplay.Text = v.ToString();
            }
        }
        private double Aplicar(double a, double b, string op)
        {
            switch (op)
            {
                case "+": return a + b;
                case "-": return a - b;
                case "*": return a * b;
                case "/":
                    if (b == 0)
                    {
                        MessageBox.Show("No se puede dividir entre cero.", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
                        CE();
                        return 0.0;
                    }
                    return a / b;
                default: return b;
            }
        }

        private void AnotarHistorial(double a, string op, double b, double resultado)
        {
            if (lbHistorial == null) return;
            if (string.IsNullOrEmpty(op)) return;

            string linea = $"{a} {op} {b} = {resultado}";
            lbHistorial.Items.Insert(0, linea);
        }


        private void CE()
        {
            acumulado = 0.0;
            opPendiente = null;
            ultimoOperando = 0.0;
            ultimaOperacion = null;
            entradaNueva = true;
            txtDisplay.Text = "0";
            lbHistorial.Items.Clear();
        }

        private void Digito_Click(object sender, EventArgs e)
        {
            var btn = ((Button)sender).Text;

            if (entradaNueva || txtDisplay.Text == "0")
            {
                txtDisplay.Text = btn;
                entradaNueva = false;
            }
            else
            {
                txtDisplay.Text += btn;
            }
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void Igual_Click()
        {
            if (!double.TryParse(txtDisplay.Text, out double actual))
                return;

            if (opPendiente != null)
            {
                // Cierra la operación pendiente
                acumuladoAnterior = acumulado;
                string op = opPendiente;
                double b = actual;

                acumulado = Aplicar(acumuladoAnterior, b, op);
                txtDisplay.Text = acumulado.ToString();

                // Guardar para repetir
                ultimaOperacion = opPendiente;
                ultimoOperando = b;

                opPendiente = null;
                entradaNueva = true;

                // Historial
                AnotarHistorial(acumuladoAnterior, op, b, acumulado);
            }
            else if (ultimaOperacion != null)
            {
                // Repetición de la última operación
                acumuladoAnterior = acumulado;
                string op = ultimaOperacion;
                double b = ultimoOperando;

                acumulado = Aplicar(acumuladoAnterior, b, op);
                txtDisplay.Text = acumulado.ToString();
                entradaNueva = true;

                // Historial correcto
                AnotarHistorial(acumuladoAnterior, op, b, acumulado);
            }
        }

        private void btnCE_Click(object sender, EventArgs e)
        {

        }

        private void Form1_KeyDown(object sender, KeyEventArgs e)
        {
            // Solo permitir agregar el número una vez por pulsación de tecla
            if (e.KeyCode >= Keys.D0 && e.KeyCode <= Keys.D9 || e.KeyCode >= Keys.NumPad0 && e.KeyCode <= Keys.NumPad9)
            {
                // Si no estamos ingresando un número repetido, lo agregamos
                if (!entradaNueva)
                {
                    // Evitar que se añadan números repetidos en una sola pulsación
                    var btn = this.Controls.Find($"btn{e.KeyCode - (e.KeyCode <= Keys.D9 ? Keys.D0 : Keys.NumPad0)}", true).FirstOrDefault() as Button;
                    btn?.PerformClick();  // Simula el clic en el botón correspondiente
                    entradaNueva = true;  // Indicamos que estamos agregando un número
                }
            }


            else if (e.KeyCode == Keys.Add || e.KeyCode == Keys.Oemplus) 
                btnSum.PerformClick();
            else if (e.KeyCode == Keys.Subtract || e.KeyCode == Keys.OemMinus)
                btnRest.PerformClick();
            else if ((e.KeyCode == Keys.Multiply || e.KeyCode == Keys.Oemplus) && e.Shift)
                btnMulti.PerformClick();
            else if (Control.ModifierKeys == Keys.Shift)
            {
                if (e.KeyCode == Keys.D7)
                {
                    btnDiv.PerformClick();
                }
            }                

            else if (e.KeyCode == Keys.Enter)
                btnIgual.PerformClick();

            else if (e.KeyCode == Keys.Oemcomma)
                btnComa.PerformClick();

            else if (e.KeyCode == Keys.Back)
                btnCE.PerformClick();

            else if (e.KeyCode == Keys.OemMinus)
                btnMasMenos.PerformClick();

        }

        private void Form1_KeyPress(object sender, KeyPressEventArgs e)
        {

        }

        private void Form1_KeyUp(object sender, KeyEventArgs e)
        {
            if (e.KeyCode >= Keys.D0 && e.KeyCode <= Keys.D9 || e.KeyCode >= Keys.NumPad0 && e.KeyCode <= Keys.NumPad9)
            {
                entradaNueva = false;  
            }
        }
    }
}
