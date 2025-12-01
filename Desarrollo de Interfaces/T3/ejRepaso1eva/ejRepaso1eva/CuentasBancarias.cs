using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ejRepaso1eva
{
   public static class CuentasBancarias
    {
        public static List<CuentaBancaria> cuentasList = new List<CuentaBancaria>();

        static CuentasBancarias()
        {
            cuentasList = new List<CuentaBancaria>();
        }

        public static CuentaBancaria buscarCuenta(int numCuenta)
        {
            foreach (var c in cuentasList) {
                if (c.NumCuenta == numCuenta)
                {
                    return c;
                }
            }

            return null;
        }

        public static CuentaBancaria buscarCuentaDNI(String dni)
        {
            foreach (var c in cuentasList)
            {
                if (c.Dni == dni)
                {
                    return c;
                }
            }

            return null;
        }
    }


}
