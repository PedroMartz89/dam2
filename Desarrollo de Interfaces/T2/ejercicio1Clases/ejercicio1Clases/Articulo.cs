using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ejercicio1Clases
{
 
    public enum categoriaArticulo
    {
        Informática,
        Imagen,
        Telefonía,
        Sonido

    }
    internal class Articulo
    {
        public int codArticulo;
        public String nombreArticulo;
        public categoriaArticulo categoriaArticulo;
        public decimal precioArticulo;
        public int existenciasArticulo;

        public Articulo()
        {
        }

        public Articulo(int codArticulo, string nombreArticulo, categoriaArticulo categoriaArticulo, decimal precioArticulo, int existenciasArticulo)
        {
            this.codArticulo = codArticulo;
            this.nombreArticulo = nombreArticulo;
            this.categoriaArticulo = categoriaArticulo;
            this.precioArticulo = precioArticulo;
            this.existenciasArticulo = existenciasArticulo;
        }

        public int CodArticulo { get; set; }
        public string NombreArticulo { get; set; }
        public categoriaArticulo CategoriaArticulo { get; set; }
        public decimal PrecioArticulo { get; set; }
        public int ExistenciasArticulo { get; set; }

        public override string ToString()
        {
            return $"Código: {codArticulo} | " +
                   $"Nombre: {nombreArticulo} | " +
                   $"Categoría: {categoriaArticulo} | " +
                   $"Precio: {precioArticulo:€} | " +
                   $"Existencias: {existenciasArticulo}";
        }
        public void actualizarExistencias(int cantidadPedido)
        {
            if (cantidadPedido < existenciasArticulo)
            {
                existenciasArticulo = existenciasArticulo - cantidadPedido;
                decimal total = precioArticulo * cantidadPedido;
                MessageBox.Show("Pedido realizado, quedan " + existenciasArticulo + ",importe total: " + total);
            }
            else
            {
                MessageBox.Show("No hay suficientes existencias, quedan: " + existenciasArticulo, "Error");
            }


        }
    }
}
