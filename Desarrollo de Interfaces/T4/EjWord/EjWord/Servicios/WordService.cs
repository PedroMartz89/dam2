using DocumentFormat.OpenXml;
using DocumentFormat.OpenXml.Packaging;
using DocumentFormat.OpenXml.Wordprocessing;
using EjWord.Modelos;
using System;
using System.CodeDom;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EjWord.Servicios
{
    internal class WordService
    {
        public void CrearDocumentoDesdeTexto(string ruta, string contenido)
        {

            using (WordprocessingDocument doc = WordprocessingDocument.Create(ruta, WordprocessingDocumentType.Document))
            {
                //Crear la parte principal del documento
                MainDocumentPart mainPart = doc.AddMainDocumentPart();
                //Inicializar la estructura del documento y agregar el cuerpo
                mainPart.Document = new Document(new Body());
                Body body = mainPart.Document.Body;

                //Crear un párrafo y una separacion de texto
                Paragraph para = new Paragraph();
                Run run = new Run();

                //Insertar
                run.Append(new Text(contenido));
                para.Append(run);
                body.Append(para);
            }

        }

        public void GenerarDesdePlantilla(string ruta, string salida, Agenda[] agenda)
        {
            // Copiamos la plantilla al archivo final de salida
            File.Copy(ruta, salida, true);

            using (WordprocessingDocument doc = WordprocessingDocument.Open(salida, true))
            {
                Body body = doc.MainDocumentPart.Document.Body;

                // Buscamos el párrafo que contiene la etiqueta
                var parrafoMolde = body.Descendants<Paragraph>()
                                       .FirstOrDefault(p => p.InnerText.Contains("{NOMBRE}"));

                if (parrafoMolde != null)
                {
                    foreach (var contacto in agenda)
                    {
                        // Creamos una copia del párrafo para cada contacto
                        Paragraph nuevaFila = (Paragraph)parrafoMolde.CloneNode(true);

                        // Reemplazamos los datos en la copia recién creada
                        foreach (var t in nuevaFila.Descendants<Text>())
                        {
                            if (t.Text.Contains("{NOMBRE}"))
                                t.Text = t.Text.Replace("{NOMBRE}", contacto.Nombre);

                            if (t.Text.Contains("{TELEFONO}"))
                                t.Text = t.Text.Replace("{TELEFONO}", contacto.Telefono.ToString());

                            if (t.Text.Contains("{EMAIL}"))
                                t.Text = t.Text.Replace("{EMAIL}", contacto.Email);
                        }

                        // Añadimos el párrafo con los datos al final del documento
                        body.AppendChild(nuevaFila);
                    }

                    // Eliminamos el párrafo original que tiene las llaves
                    body.RemoveChild(parrafoMolde);
                }

                // Guardamos los cambios
                doc.MainDocumentPart.Document.Save();
            }
        }
    }
}
