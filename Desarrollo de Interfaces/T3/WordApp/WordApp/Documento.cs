using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WordApp
{
    public partial class Documento : Form
    {
        private string rutaArchivo;
        private bool modificado;

        public Documento()
        {
            InitializeComponent();
        }

        private void Documento_Load(object sender, EventArgs e)
        {

        }

        private void richTextBox1_TextChanged(object sender, EventArgs e)
        {
            modificado = true;
        }

        public void CargarArchivo(string ruta)
        {
            string contenido = File.ReadAllText(ruta);
            richTextBox1.Text = contenido;
            rutaArchivo = ruta;
            modificado = false;
            this.Text = Path.GetFileName(ruta);
        }

        public void GuardarEnArchivo(string ruta)
        {
            if (ruta == null)
            {
                return;
            }

            File.WriteAllText(ruta, richTextBox1.Text);

            rutaArchivo = ruta;
            modificado = false;

            this.Text = Path.GetFileName(ruta);
        }

        public string RutaArchivo
        {
            get
            {
                return rutaArchivo;
            }
            set
            {
                rutaArchivo = value;
            }
        }

        public RichTextBox cajaTexto
        {
            get
            {
                return this.Controls["richTextBox1"] as RichTextBox;
            }
        }

        protected override void OnFormClosing(FormClosingEventArgs e)
        {
            if (!modificado)
            {
                base.OnFormClosing(e);
                return;
            }

            DialogResult resultado = MessageBox.Show(
                "El documento tiene cambios sin guardar. ¿Desea guardarlos?",
                "Guardar cambios",
                MessageBoxButtons.YesNoCancel,
                MessageBoxIcon.Question
            );

            if (resultado == DialogResult.Yes)
            {
                if (string.IsNullOrEmpty(rutaArchivo))
                {
                    e.Cancel = true;
                }
                else
                {
                    GuardarEnArchivo(rutaArchivo);
                }

                base.OnFormClosing(e);
            }

            
        }
        
    }
}
