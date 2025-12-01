using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ejRepaso1eva
{
    
    public class CuentaBancaria
    {
        int numsCuentas = 0;
        private int numCuenta;
        private string titular;
        private string dni;
        private double saldo;
        

        public CuentaBancaria()
        {
            numsCuentas++;
            this.NumCuenta = numsCuentas;

            this.Titular = null;
            this.Dni = null;
            this.Saldo = 0;
        }

        public CuentaBancaria(string titular, string dni, double saldo)
        {
            this.NumCuenta = numCuenta;
            this.Titular = titular;
            this.Dni = dni;
            this.Saldo = saldo;
        }

        public int NumCuenta { get => numCuenta; set => numCuenta = value; }
        public string Titular { get => titular; set => titular = value; }
        public string Dni { get => dni; set => dni = value; }
        public double Saldo { get => saldo; set => saldo = value; }

        public override string ToString()

        {

            return "Numero de cuenta: " + numCuenta +
                "\n Titular: " + titular +
                "\n DNI: " + dni +
                "\n Saldo: " + saldo;
        }

        public Boolean Reintegro(double dinero)
        {
            if (saldo > dinero)
            {
                saldo -= dinero;
                return true;
            }
            return false;

        }



        public Boolean Ingreso(double dinero)
        {

            if (dinero > 0)
            {
                saldo += dinero;
                return true;
            }
            return false;
        }

        public Boolean Transferencia(double dinero, CuentaBancaria c) {

            if (saldo < dinero)
            {
                return false;
            }

            c.Ingreso(dinero);
            Reintegro(dinero);
            return true;
        }
    }
}
