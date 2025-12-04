using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace repaso1Ev
{
    public class Cuenta
    {
        private string titular;
        private string dni;
        private double saldo;

        public Cuenta() {}
        public Cuenta(string titular, string dni, double saldo)
        {
            this.titular = titular;
            this.dni = dni;
            this.saldo = saldo;
        }

        public string Titular
        {
            get { return titular; }
            set { titular = value; }
        }

        public string Dni
        {
            get { return dni; }
            set { dni = value; }
        }
        public double Saldo
        {
            get { return saldo; }
            set { saldo = value; }
        }

        public bool Ingresar(double cantidad)
        {
            if (cantidad > 0)
            {
                saldo += cantidad;
                return true;
            }

            return false;
        }

        public bool Retirar(double cantidad)
        {
           if (cantidad > saldo)
           {
                MessageBox.Show("No hay suficiente saldo");
                return false;
           }

           saldo -= cantidad;
           return true;
        }

        public bool Transferencia(Cuenta cuentaDestino, double cantidad) { 
        
           if (saldo < cantidad)
           {
                MessageBox.Show("No hay suficiente saldo para la transferencia");
                return false;
           }
            saldo -= cantidad;
            cuentaDestino.saldo += cantidad;

            return true;
        }


        public override string ToString()
        {
            return "Titular: " + titular + ", DNI: " + dni + ", Saldo: " + saldo + "€";
        }

       
    }
}
