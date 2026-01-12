using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Xml.Linq;

namespace EjercicioXMLDocument
{
    public partial class Form1 : Form
    {
        private string path = "personas.xml";
        private XDocument doc;

        public Form1()
        {
            InitializeComponent();
            this.Size = new Size(800, 500);
            this.StartPosition = FormStartPosition.CenterScreen;

            CargarDatos();
            ConfigurarInterfaz();
        }
        private void ConfigurarInterfaz()
        {

            // Eventos
            lstPersonas.SelectedIndexChanged += lstPersonas_SelectedIndexChanged;
            btnModificar.Click += btnModificar_Click;
            btnNueva.Click += btnNueva_Click;
            btnEliminar.Click += btnEliminar_Click;
        }

        // 1. Leer personas
        // 2. Mostrar nombres en ListBox
        private void CargarDatos()
        {
            try
            {
                doc = XDocument.Load(path);
                var lista = doc.Descendants("persona")
                    .Select(x => new {
                        Id = x.Attribute("id").Value,
                        Nombre = x.Element("nombre").Value
                    }).ToList();

                lstPersonas.DataSource = lista;
                lstPersonas.DisplayMember = "Nombre";
                lstPersonas.ValueMember = "Id";
            }
            catch (Exception ex)
            {
                MessageBox.Show("Error al cargar el archivo: " + ex.Message);
            }
        }

        // 3. Selección en ListBox y mostrar en TextBox
        private void lstPersonas_SelectedIndexChanged(object sender, EventArgs e)
        {
            if (lstPersonas.SelectedValue != null)
            {
                string id = lstPersonas.SelectedValue.ToString();
                var p = doc.Descendants("persona").FirstOrDefault(x => x.Attribute("id").Value == id);
                if (p != null)
                {
                    txtNombre.Text = p.Element("nombre").Value;
                    txtEdad.Text = p.Element("edad").Value;
                }
            }
        }

        // 4. Botón modificar
        private void btnModificar_Click(object sender, EventArgs e)
        {
            if (lstPersonas.SelectedValue == null) return;

            string id = lstPersonas.SelectedValue.ToString();
            var p = doc.Descendants("persona").FirstOrDefault(x => x.Attribute("id").Value == id);
            if (p != null)
            {
                p.Element("nombre").Value = txtNombre.Text;
                p.Element("edad").Value = txtEdad.Text;
                doc.Save(path);
                CargarDatos();
                MessageBox.Show("Datos modificados correctamente.");
            }
        }

        // 5. Botón nueva persona
        private void btnNueva_Click(object sender, EventArgs e)
        {
            if (string.IsNullOrEmpty(txtNombre.Text)) return;

            XElement nueva = new XElement("persona",
                new XAttribute("id", Guid.NewGuid().ToString().Substring(0, 5)),
                new XElement("nombre", txtNombre.Text),
                new XElement("edad", txtEdad.Text));

            doc.Root.Add(nueva);
            doc.Save(path);
            CargarDatos();
            txtNombre.Clear();
            txtEdad.Clear();
        }

        // 6. Botón eliminar con confirmación
        private void btnEliminar_Click(object sender, EventArgs e)
        {
            if (lstPersonas.SelectedValue == null) return;

            var confirm = MessageBox.Show("¿Seguro que deseas eliminar esta persona?", "Confirmar", MessageBoxButtons.YesNo);
            if (confirm == DialogResult.Yes)
            {
                string id = lstPersonas.SelectedValue.ToString();
                doc.Descendants("persona").Where(x => x.Attribute("id").Value == id).Remove();
                doc.Save(path);
                CargarDatos();
            }
        }
    }
}
