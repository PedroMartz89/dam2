using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using Microsoft.VisualBasic;

namespace Ejercicios3
{
    public partial class formMenu : Form
    {
        ALUMNO[] arrayAlumnos = new ALUMNO[3];
        int contador = 0;
        public formMenu()
        {
            InitializeComponent();
            
        }

        private void dataGridView1_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {

        }

        private void button2_Click(object sender, EventArgs e)
        {
            listBoxAlumnos.Items.Clear();
            foreach (ALUMNO a in arrayAlumnos)
            {
                if (a.nomAlum != null)
                    listBoxAlumnos.Items.Add(a.ToString());
            }
        }

        private void bttnAltas_Click(object sender, EventArgs e)
        {
            if (contador <= 3)
            {
                ALUMNO a = new ALUMNO();
                a.codAlum = contador+1;
                a.nomAlum = Interaction.InputBox("Introduce el nombre del alumno", "Alta");
                a.apellAlum = Interaction.InputBox("Introduce el apellido del alumno", "Alta");
                a.telfAlum = long.Parse(Interaction.InputBox("Introduce el teléfono del alumno", "Alta"));
                a.emailAlum = Interaction.InputBox("Introduce el email del alumno", "Alta");
                a.cursoAlum = Interaction.InputBox("Introduce el curso del alumno", "Alta");

                contador++;
                arrayAlumnos[contador] = a;
                MessageBox.Show("Alumno agregado correctamente");
                RefrescarLista();
                return;
            }

            MessageBox.Show("No hay espacio para más alumnos");
        }

        private void RefrescarLista()
        {
            listBoxAlumnos.Items.Clear();

            foreach (var alumno in arrayAlumnos.Where(a => a.nomAlum != null))
            {
                string info = $"Código: {alumno.codAlum}, Nombre: {alumno.nomAlum}, Apellido: {alumno.apellAlum}, Tel: {alumno.telfAlum}, Email: {alumno.emailAlum}, Curso: {alumno.cursoAlum}";
                listBoxAlumnos.Items.Add(info);
            }

        }

        private void bttnConsultas_Click(object sender, EventArgs e)
        {
            String buscar = Interaction.InputBox("Introduce el nombre del usuario a buscar", "Consultas");
            foreach (ALUMNO alumno in arrayAlumnos) {

                if (alumno.nomAlum == buscar)
                {
                    MessageBox.Show($"Código: {alumno.codAlum}, Nombre: {alumno.nomAlum}, Apellido: {alumno.apellAlum}, Tel: {alumno.telfAlum}, Email: {alumno.emailAlum}, Curso: {alumno.cursoAlum}");
                }
            }
        }

        private void bttnOrdenar_Click(object sender, EventArgs e)
        {
            Array.Sort(arrayAlumnos, (a, b) =>
            {
                if (a.nomAlum == null && b.nomAlum == null) return 0;
                if (a.nomAlum == null) return 1;
                if (b.nomAlum == null) return -1;
                return string.Compare(a.apellAlum, b.apellAlum, StringComparison.OrdinalIgnoreCase);
            });

            MessageBox.Show("Array ordenado por apellidos");
        }

        private void bttnSalir_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }
    }
}
