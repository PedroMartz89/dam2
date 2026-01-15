using EjWord.Modelos;
using EjWord.Servicios;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace EjWord
{
    public partial class Form1 : Form
    {
        Agenda[] listaContactos = new Agenda[]
        {
            new Agenda { Nombre = "Jorge Hernández", Telefono = "600111222", Email = "jorge@ejemplo.com" },
            new Agenda { Nombre = "Roberto Company", Telefono = "600333444", Email = "roberto@ejemplo.com" },
            new Agenda { Nombre = "Claudia Murcia", Telefono = "600555666", Email = "claudia@ejemplo.com" }
        };

        WordService word = new WordService();

        public Form1()
        {
            InitializeComponent();
            
        }

        private void btnCrearRichText_Click(object sender, EventArgs e)
        {
            word.CrearDocumentoDesdeTexto("AgendaDesdeTexto.docx", rtbTexto.Text);
            MessageBox.Show("Documento creado con el contenido del TextBox");
        }

        private void btnCrearConPlantilla_Click(object sender, EventArgs e)
        {
            word.GenerarDesdePlantilla(@"Plantillas\plantilla.docx", "AgendaFinal.docx", listaContactos);
            MessageBox.Show("Documento de Agenda generado con éxito");
        }
    }
}
