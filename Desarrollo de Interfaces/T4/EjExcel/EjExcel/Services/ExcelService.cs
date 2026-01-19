using ClosedXML.Excel;
using DocumentFormat.OpenXml.Packaging;
using DocumentFormat.OpenXml.Spreadsheet;
using EjWord.Modelos;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EjExcel.Services
{

    internal class ExcelService
    {


        // EXCEL DESDE CERO
        public void CrearExcel(string ruta)
        {
            var wb = new XLWorkbook();
            var ws = wb.Worksheets.Add("Datos");
            ws.Cell(1, 1).Value = "Nombre";
            ws.Cell(1, 2).Value = "Telefono";
            ws.Cell(1, 3).Value = "Email";
            wb.SaveAs(ruta);
        }

        // EXCEL DESDE PLANTILLA
        public void GenerarDesdePlantillaExcel(string plantilla, string salida, Agenda[] agenda)
        {
            File.Copy(plantilla, salida, true);
            using (var wb = new XLWorkbook(salida))
            {
                var ws = wb.Worksheet(1);
                int fila = 2;
                foreach (var contacto in agenda)
                {
                    ws.Cell(fila, 1).Value = contacto.Nombre;
                    ws.Cell(fila, 2).Value = contacto.Telefono;
                    ws.Cell(fila, 3).Value = contacto.Email;
                    fila++;
                }
                wb.Save();
            }
        }

       
    }
}

