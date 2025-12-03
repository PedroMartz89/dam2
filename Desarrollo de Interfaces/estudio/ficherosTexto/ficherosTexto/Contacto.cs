using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ficherosTexto
{
    internal class Contacto
    {
        private int id;
        private string nombre;
        private int telefono;

        public Contacto(int id, string nombre, int telefono)
        {
            this.id = id;
            this.nombre = nombre;
            this.telefono = telefono;
        }

        public int Id { get => id; set => id = value; }
        public string Nombre { get => nombre; set => nombre = value; }
        public int Telefono { get => telefono; set => telefono = value; }

        public void mostrarTelefono(string nombre)
        {

        }

        public void MostrarPorInicial(string inicial)
        {

        }

        public override string ToString()
        {
            return "Id: " + id + " - Nombre: " + nombre + " - Telefono: " + telefono;
        }
    }
}
