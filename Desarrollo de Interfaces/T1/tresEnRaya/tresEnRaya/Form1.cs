using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace tresEnRaya
{

    public partial class Form1 : Form
    {
        char[,] tablero = new char[3, 3];
        int turno = 1;
        String nombreJugador1 = "";
        String nombreJugador2 = "";
        bool ganador = false;

        public Form1()
        {
            InitializeComponent();


        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void tableLayoutPanel1_Paint(object sender, PaintEventArgs e)
        {

        }

        private void label1_Click_1(object sender, EventArgs e)
        {

        }

        private void play_Click(object sender, EventArgs e)
        {
            nombreJugador1 = jugador1.Text;
            nombreJugador2 = jugador2.Text;
            reiniciarTablero();
            turno = 1;
            jugadorActual.Text = "Turno de " + nombreJugador1;
            labelGanador.Text = "";
        }

        private void PonerXoO(int jugador)
        {

        }

        private void reiniciarTablero()
        {
            char valor = '1';
            for (int i = 0; i < 3; i++) // ← corregido: antes era i = 1
            {
                for (int j = 0; j < 3; j++)
                {
                    tablero[i, j] = valor++;
                }
            }

            // Limpia los botones del tablero
            foreach (Control c in this.Controls)
            {
                if (c is Button && c.Tag != null)
                {
                    c.Text = "";
                    c.Enabled = true;
                }
            }
        }

        private bool HayGanador()
        {
            for (int i = 0; i < 3; i++)
            {
                if (tablero[i, 0] == tablero[i, 1] && tablero[i, 1] == tablero[i, 2]) return true;
                if (tablero[0, i] == tablero[1, i] && tablero[1, i] == tablero[2, i]) return true;
            }
            if (tablero[0, 0] == tablero[1, 1] && tablero[1, 1] == tablero[2, 2]) return true;
            if (tablero[0, 2] == tablero[1, 1] && tablero[1, 1] == tablero[2, 0]) return true;

            return false;
        }

        private bool EsEmpate()
        {
            foreach (char c in tablero)
                if (c != 'X' && c != 'O') return false;
            return true;
        }


        private void btnCasilla_Click(object sender, EventArgs e)
        {
            Button btn = (Button)sender;
            int posicion = int.Parse(btn.Tag.ToString());
            int fila = posicion / 3;
            int columna = posicion % 3;

            if (tablero[fila, columna] == 'X' || tablero[fila, columna] == 'O') return;

            if (turno == 1)
            {
                tablero[fila, columna] = 'X';
            }
            else
            {
                tablero[fila, columna] = 'O';
            }
            btn.Text = tablero[fila, columna].ToString();
            btn.ForeColor = turno == 1 ? Color.Green : Color.Blue;

            if (HayGanador())
            {
                labelGanador.Text = $"Ganador: {(turno == 1 ? nombreJugador1 : nombreJugador2)}";

                // Desactiva el tablero
                foreach (Control c in this.Controls)
                {
                    if (c is Button && c.Tag != null)
                    {
                        c.Enabled = false;
                    }
                }
            }
            else if (EsEmpate())
            {
                labelGanador.Text = "Empate";

                // Desactiva el tablero
                foreach (Control c in this.Controls)
                {
                    if (c is Button && c.Tag != null)
                    {
                        c.Enabled = false;
                    }
                }
            }
            else
            {
                turno = turno == 1 ? 2 : 1;
                jugadorActual.Text = $"Turno de {(turno == 1 ? nombreJugador1 : nombreJugador2)}";
            }
        }

    }
    
   }
