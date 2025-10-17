using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Ejercicios3
{
    public partial class loginForm : Form
    {
        string[,] arrayUsuarios = new string[4, 2];
        int intentos = 3;
        public loginForm()
        {
            InitializeComponent();
            IniciarUsuarios();
        }

        private void button1_Click(object sender, EventArgs e)
        {

        }

        private void bttnLoginClick(object sender, EventArgs e)
        {
            String user = txtUsuario.Text;
            String passwd = txtContraseña.Text;

            for (int i = 0; i < arrayUsuarios.GetLength(0); i++)
            {
                if (arrayUsuarios[i, 0] == user && arrayUsuarios[i, 1] == passwd)
                {
                    MessageBox.Show("Has iniciado sesión correctamente");
                    this.Hide();
                    new formMenu().Show();
                    return;
                }
            }

            intentos--;
            if (intentos == 0) {

                MessageBox.Show("Demasiados intentos. Cerrando programa.");
                Application.Exit();
            }
            else
            {
                MessageBox.Show("Usuario o contraseña incorrectos, vuelva a intentarlo.");
            }
        }


        private void IniciarUsuarios()
        {
            arrayUsuarios[0, 0] = "admin"; arrayUsuarios[0, 1] = "1234";
            arrayUsuarios[1, 0] = "jorge"; arrayUsuarios[1, 1] = "abcd";
            arrayUsuarios[2, 0] = "roberto"; arrayUsuarios[2, 1] = "roberto1234";
            arrayUsuarios[3, 0] = "pedro"; arrayUsuarios[3, 1] = "pedro1234";
        }
    }
}
