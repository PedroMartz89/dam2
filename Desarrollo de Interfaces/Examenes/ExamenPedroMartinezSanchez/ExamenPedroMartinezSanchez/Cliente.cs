using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExamenPedroMartinezSanchez
{
    public class Cliente
    {
        private string dniCli;
        private int claveCli;
        private string nombreCli;
        private double saldoCli;
        private bool bloqueoCli;

        public string DniCli { get => dniCli; set => dniCli = value; }
        public int ClaveCli { get => claveCli; set => claveCli = value; }
        public string NombreCli { get => nombreCli; set => nombreCli = value; }
        public double SaldoCli { get => saldoCli; set => saldoCli = value; }
        public bool BloqueoCli { get => bloqueoCli; set => bloqueoCli = value; }

        public Cliente(string dniCli, int claveCli, string nombreCli, double saldoCli)
        {
            this.dniCli = dniCli;
            this.claveCli = claveCli;
            this.nombreCli = nombreCli;
            this.saldoCli = saldoCli;
            this.bloqueoCli = false;
        }

        public Cliente()
        {

        }

        public override string ToString()
        {
            return "Nombre: " + nombreCli + " - DNI: " + dniCli + " - Saldo: " + saldoCli;
        }

        public bool Ingreso(double cantidad)
        {
            saldoCli += cantidad;
            return true;
        }

        public bool Retiro(double cantidad)
        {
            if (cantidad > saldoCli)
            {
                return false;
            }
            else
            {
                saldoCli -= cantidad;
                return true;
            }
        }
    }
}
