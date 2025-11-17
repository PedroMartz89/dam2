using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Drawing.Printing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WordApp
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
            this.IsMdiContainer = true;
        }

        private void toolStripButton1_Click(object sender, EventArgs e)
        {
            nuevoToolStripMenuItem_Click(sender, e);
        }

        private void nuevoToolStripMenuItem_Click(object sender, EventArgs e)
        {
            int numDocumento = 0;

            Documento doc = new Documento();
            doc.MdiParent = this;
            numDocumento++;
            doc.Text = "Documento" + numDocumento;
            doc.Show();
        }

        private void toolStripButton3_Click(object sender, EventArgs e)
        {
            guardarToolStripMenuItem_Click(sender, e);
        }

        private void abrirToolStripMenuItem_Click(object sender, EventArgs e)
        {
            OpenFileDialog ofd = new OpenFileDialog();

            ofd.Filter = "Ficheros de texto (*.txt)|*.txt|Todos los archivos (*.*)|*.*";

            if (ofd.ShowDialog() == DialogResult.OK)
            {
                Documento doc = new Documento();
                doc.MdiParent = this;
                doc.CargarArchivo(ofd.FileName);
                doc.Show();
            }
           
        }

        private void guardarToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Documento doc = new Documento();

            if (doc == null)
            {
                return;
            }

            if (string.IsNullOrEmpty(doc.RutaArchivo)) {

                guardarComo();

            }
            else
            {
                doc.GuardarEnArchivo(doc.RutaArchivo);
            }
        }

        private void guardarComoToolStripMenuItem_Click(object sender, EventArgs e)
        {
            guardarComo();
        }

        private void guardarComo()
        {
            Documento doc = this.ActiveMdiChild as Documento;

      
            SaveFileDialog saveFileDialog = new SaveFileDialog();

            saveFileDialog.Filter = "Ficheros de texto (*.txt)|*.txt|Todos los archivos (*.*)|*.*";

            if (saveFileDialog.ShowDialog() == DialogResult.OK)
            {
                doc.GuardarEnArchivo(saveFileDialog.FileName);
            }
        }

        private void salirToolStripMenuItem_Click(object sender, EventArgs e)
        {
           this.Close();
        }

        private void copiarToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Documento doc = this.ActiveMdiChild as Documento;
            if (doc == null) { return; }

            doc.cajaTexto.Copy();
        }

        private void pegarToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Documento doc = this.ActiveMdiChild as Documento;
            if (doc == null) { return; }

            doc.cajaTexto.Paste();
        }

        private void cortarToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Documento doc = this.ActiveMdiChild as Documento;
            if (doc == null) { return; }

            doc.cajaTexto.Cut();
        }

        private void deshacerToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Documento doc = this.ActiveMdiChild as Documento;
            if (doc == null) { return; }

            doc.cajaTexto.Undo();
        }

        private void rehacerToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Documento doc = this.ActiveMdiChild as Documento;
            if (doc == null) { return; }

            doc.cajaTexto.Redo();
        }

        private void seleccionarTodoToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Documento doc = this.ActiveMdiChild as Documento;
            if (doc == null) { return; }

            doc.cajaTexto.SelectAll();
        }

        private void colorDelTextoToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Documento doc = this.ActiveMdiChild as Documento;

            if (doc == null) { return; }

            ColorDialog colorDialog = new ColorDialog();

            if (colorDialog.ShowDialog() == DialogResult.OK)
            {
                doc.cajaTexto.SelectionColor = colorDialog.Color;
            }
        }

        private void colorDelFondoToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Documento doc = this.ActiveMdiChild as Documento;
            if (doc == null) { return; }
            ColorDialog colorDialog = new ColorDialog();

            if (colorDialog.ShowDialog() == DialogResult.OK)
            {
                doc.cajaTexto.SelectionBackColor = colorDialog.Color;
            }
        }

        private void colorDelFondoDelFormToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Documento doc = this.ActiveMdiChild as Documento;
            if (doc == null) { return; }

            ColorDialog colorDialog = new ColorDialog();

            if (colorDialog.ShowDialog() == DialogResult.OK)
            {
                doc.BackColor = colorDialog.Color;
            }
        }

        private void formatoTextoToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Documento doc = this.ActiveMdiChild as Documento;
            if (doc == null) { return; }
            FontDialog fontDialog = new FontDialog();

            if (fontDialog.ShowDialog() == DialogResult.OK)
            {
                doc.cajaTexto.SelectionFont = fontDialog.Font;
            }
        }

        private void cascadaToolStripMenuItem_Click(object sender, EventArgs e)
        {
            this.LayoutMdi(System.Windows.Forms.MdiLayout.Cascade);
        }

        private void verticalToolStripMenuItem_Click(object sender, EventArgs e)
        {
            this.LayoutMdi(System.Windows.Forms.MdiLayout.TileVertical);
        }

        private void horizontalToolStripMenuItem_Click(object sender, EventArgs e)
        {
            this.LayoutMdi(System.Windows.Forms.MdiLayout.TileHorizontal);
        }

        private void listaDeDocumentosAbiertosToolStripMenuItem_Click(object sender, EventArgs e)
        {
                
        }

        private void toolStripButton2_Click(object sender, EventArgs e)
        {
            
            abrirToolStripMenuItem_Click(sender, e);
        }

        private void toolStripButton4_Click(object sender, EventArgs e)
        {
            Documento doc = this.ActiveMdiChild as Documento;
            if (doc == null) { return; }
            PrintDialog printDialog = new PrintDialog();
            PrintDocument docPrint = new PrintDocument();

            docPrint.PrintPage += (s, ev) =>
            {

                string texto = doc.cajaTexto.Text;


                Font fuente = doc.cajaTexto.Font;


                ev.Graphics.DrawString(texto, fuente, Brushes.Black, ev.MarginBounds.Left, ev.MarginBounds.Top);
            };

            printDialog.Document = docPrint;
            if (printDialog.ShowDialog() == DialogResult.OK)
            {
                docPrint.Print();
            }
        }

        private void toolStripButton5_Click(object sender, EventArgs e)
        {
            cortarToolStripMenuItem_Click(sender, e);
        }

        private void toolStripButton6_Click(object sender, EventArgs e)
        {
            copiarToolStripMenuItem_Click(sender, e);
        }

        private void toolStripButton7_Click(object sender, EventArgs e)
        {
            pegarToolStripMenuItem_Click(sender, e);
        }

        private void toolStripButton8_Click(object sender, EventArgs e)
        {
            MessageBox.Show("Hecho por Pedro Martínez Sánchez, 2ºDAM");
        }
    }
}
