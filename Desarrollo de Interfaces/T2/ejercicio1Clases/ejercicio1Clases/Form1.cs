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

namespace ejercicio1Clases
{
    public partial class Form1 : Form
    {
        public static ArrayList articulos = new ArrayList();
        Boolean articuloEncontrado = false;
        public Form1()
        {
            InitializeComponent();
            comboBoxCategoría.DataSource = Enum.GetValues(typeof(categoriaArticulo));
            pnlAltas.Visible = false;
            altasLabel.Visible = false;
            pnlpPedidos.Visible = false;
            lblPedidos.Visible = false;
        }

        private void toolStripMenuItem1_Click(object sender, EventArgs e)
        {

        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void label4_Click(object sender, EventArgs e)
        {

        }

        private void radioButton1_CheckedChanged(object sender, EventArgs e)
        {

        }

        private void altasToolStripMenuItem_Click(object sender, EventArgs e)
        {
            pnlAltas.Visible = true;
            altasLabel.Visible = true;
            lblPedidos.Visible = false;
            pnlpPedidos.Visible = false;
            
        }

        private void buttonAceptar_Click(object sender, EventArgs e)
        {
            if (string.IsNullOrWhiteSpace(textBoxCodigo.Text) ||
                string.IsNullOrWhiteSpace(textBoxNombre.Text) ||
                string.IsNullOrWhiteSpace(textBoxPrecio.Text) ||
                string.IsNullOrWhiteSpace(textBoxExistencias.Text) ||
                comboBoxCategoría.SelectedItem == null)
            {
                MessageBox.Show("Por favor, rellene todos los campos.");
                return;
            }
            articulos.Add(new Articulo(
                int.Parse(textBoxCodigo.Text),
                textBoxNombre.Text,
                (categoriaArticulo)comboBoxCategoría.SelectedItem,
                decimal.Parse(textBoxPrecio.Text),
                int.Parse(textBoxExistencias.Text)
            ));
            MessageBox.Show("Artículo añadido correctamente.");
            textBoxCodigo.Clear();
            textBoxNombre.Clear();
            textBoxPrecio.Clear();
            textBoxExistencias.Clear();
        }

        private void pedidosToolStripMenuItem_Click(object sender, EventArgs e)
        {
            pnlAltas.Visible = false;
            altasLabel.Visible = false;
            lblPedidos.Visible = true;
            pnlpPedidos.Visible = true;
            
        }

        private void panel1_Paint(object sender, PaintEventArgs e)
        {

        }

        private void label5_Click(object sender, EventArgs e)
        {

        }

        private void buttonCancelarAltas_Click(object sender, EventArgs e)
        {
            textBoxCodigo.Clear();
            textBoxNombre.Clear();
            textBoxPrecio.Clear();
            textBoxExistencias.Clear();

        }

        private void porNombreToolStripMenuItem_Click(object sender, EventArgs e)
        {
            String nombre = Microsoft.VisualBasic.Interaction.InputBox("Introduzca el nombre del artículo:", "Búsqueda por nombre");
            foreach (Articulo articulo in articulos)
            {
                if (articulo.nombreArticulo.Equals(nombre, StringComparison.OrdinalIgnoreCase))
                {
                    MessageBox.Show(articulo.ToString(), "Artículo encontrado");
                    return;
                }
                else
                {
                    MessageBox.Show("Artículo no encontrado", "Búsqueda por nombre");
                }
            }

        }

        private void porCódigoToolStripMenuItem_Click(object sender, EventArgs e)
        {
            String codigo = Microsoft.VisualBasic.Interaction.InputBox("Introduzca el código del artículo:", "Búsqueda por código");
            foreach (Articulo articulo in articulos)
            {
                if (int.TryParse(codigo, out int codigoInt) && articulo.codArticulo == codigoInt)
                {
                    
                    MessageBox.Show(articulo.ToString(), "Artículo encontrado");
                    articuloEncontrado = true;
                    return;
                } else
                {
                    articuloEncontrado = false;
                }

                if (!articuloEncontrado)
                {
                    MessageBox.Show("Artículo no encontrado", "Error");
                }
            }
        }

        private void todosToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Form2 form = new Form2(articulos);
            form.Show();

        }

        private void mínimosToolStripMenuItem_Click(object sender, EventArgs e)
        {
            ArrayList articuloisMinimos = new ArrayList();

            foreach (Articulo articulo in articulos)
            {
                if (articulo.existenciasArticulo < 10)
                {
                    articuloisMinimos.Add(articulo);
                }
            }
            Form2 form = new Form2(articuloisMinimos);
            form.Show();
        }

        private void porCategoríaToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Form3 form3 = new Form3(articulos);
            form3.Show();
        }

        private void comboBoxCategoría_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private void bttnAceptarPedido_Click(object sender, EventArgs e)
        {
            Articulo articulo;

            foreach (Articulo a in articulos)
            {
                if (a.codArticulo.ToString() == tbCodigoPedido.Text)
                {
                    articulo = a;
                    articulo.actualizarExistencias(int.Parse(tbCantidadPedido.Text));
                    MessageBox.Show("Pedido realizado correctamente.");
                    return;
                }
            }
        }

        private void altasLabel_Click(object sender, EventArgs e)
        {

        }

        private void autorToolStripMenuItem_Click(object sender, EventArgs e)
        {
            MessageBox.Show("Desarrollado por Pedro Martínez Sánchez.", "Autor");
        }

        private void salirToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }
    }
}
