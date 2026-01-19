using EjExcel.Services;
using EjWord.Modelos;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace EjExcel
{
    public partial class Form1 : Form
    {
        ExcelService excelService = new ExcelService();
        Agenda[] listaContactos = new Agenda[]
        {
            new Agenda { Nombre = "Jorge Hernández", Telefono = "600111222", Email = "jorge@ejemplo.com" },
            new Agenda { Nombre = "Roberto Company", Telefono = "600333444", Email = "roberto@ejemplo.com" },
            new Agenda { Nombre = "Claudia Murcia", Telefono = "600555666", Email = "claudia@ejemplo.com" }
        };
        public Form1()
        {
            InitializeComponent();
            
        }

        private void button2_Click(object sender, EventArgs e)
        {
            excelService.CrearExcel("plantilla.xlsx");
        }

        private void btnCrearConPlantilla_Click(object sender, EventArgs e)
        {
            excelService.GenerarDesdePlantillaExcel(@"plantilla.xlsx", 
                "ExceldesdePlantilla.xlsx", listaContactos);
        }
    }
}
