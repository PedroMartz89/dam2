using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace holaMundo
{
    internal class Program
    {
        static void Main(string[] args) {
            Console.Write("Introduce tu nombre: ");
            var name = Console.ReadLine();
            Console.WriteLine($"Hola {name}");
        }
    }
}
