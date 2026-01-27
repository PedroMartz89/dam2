using System;
using System.Data.SqlClient;
using System.Windows.Forms;

namespace EjerBDSql
{
    public partial class Form1 : Form
    {
        SqlConnection conexion = new SqlConnection("Data Source=DESKTOP-N8LAFE9\\SQLEXPRESS;Initial Catalog=DiccionarioDB;Integrated Security=True;TrustServerCertificate=True");
        SqlCommand comandosql = new SqlCommand();
        SqlTransaction transaccion;
        public Form1()

        {
            InitializeComponent();
        }



        private void btnCerrar_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void btnCargar_Click(object sender, EventArgs e)
        {
            try
            {
                lvlistapalabras.Items.Clear();
                conexion.Open();
                comandosql.Connection = conexion;
                comandosql.CommandText = "SELECT esp, ing FROM traduccion";

                SqlDataReader midatareader = comandosql.ExecuteReader();

                while (midatareader.Read())
                {
                    string dato1 = midatareader["esp"].ToString();
                    string dato2 = midatareader["ing"].ToString();

                    ListViewItem milista = lvlistapalabras.Items.Add(dato1);
                    milista.SubItems.Add(dato2);
                }
                midatareader.Close();
            }
            catch (Exception ex) { MessageBox.Show("Error al cargar: " + ex.Message); }
            finally { conexion.Close(); }
        }

        private void btnAnadir_Click(object sender, EventArgs e)
        {
            try
            {
                conexion.Open();
                transaccion = conexion.BeginTransaction();
                comandosql.Connection = conexion;
                comandosql.Transaction = transaccion;

                comandosql.CommandText = "INSERT INTO traduccion (esp, ing) VALUES (@esp, @ing)";
                comandosql.Parameters.Clear();
                comandosql.Parameters.AddWithValue("@esp", txtEspanol.Text);
                comandosql.Parameters.AddWithValue("@ing", txtIngles.Text);

                comandosql.ExecuteNonQuery();
                transaccion.Commit();

                MessageBox.Show("Palabra añadida correctamente");
                conexion.Close();
                btnCargar_Click(null, null);
            }
            catch (Exception ex)
            {
                if (transaccion != null) transaccion.Rollback();
                MessageBox.Show("Error al insertar: " + ex.Message);
                conexion.Close();
            }
        }

        private void btnModificar_Click(object sender, EventArgs e)
        {
            if (lvlistapalabras.SelectedItems.Count > 0)
            {
                try
                {
                    conexion.Open();
                    transaccion = conexion.BeginTransaction();
                    comandosql.Connection = conexion;
                    comandosql.Transaction = transaccion;

                    comandosql.CommandText = "UPDATE traduccion SET esp = @esp, ing = @ing WHERE esp = @select";
                    comandosql.Parameters.Clear();
                    comandosql.Parameters.AddWithValue("@esp", txtEspanol.Text);
                    comandosql.Parameters.AddWithValue("@ing", txtIngles.Text);
                    comandosql.Parameters.AddWithValue("@select", lvlistapalabras.SelectedItems[0].Text);

                    comandosql.ExecuteNonQuery();
                    transaccion.Commit();
                    conexion.Close();
                    btnCargar_Click(null, null);
                }
                catch (Exception ex)
                {
                    if (transaccion != null) transaccion.Rollback();
                    MessageBox.Show("Error al modificar: " + ex.Message);
                    conexion.Close();
                }
            }
            else
            {
                MessageBox.Show("Seleccione un elemento de la lista para modificar");
            }
        }

        private void btnBorrar_Click(object sender, EventArgs e)
        {
            if (lvlistapalabras.SelectedItems.Count > 0)
            {
                try
                {
                    conexion.Open();
                    comandosql.Connection = conexion;
                    comandosql.CommandText = "DELETE FROM traduccion WHERE esp = @esp";
                    comandosql.Parameters.Clear();
                    comandosql.Parameters.AddWithValue("@esp", lvlistapalabras.SelectedItems[0].Text);

                    comandosql.ExecuteNonQuery();
                    conexion.Close();
                    btnCargar_Click(null, null);
                }
                catch (Exception ex) { MessageBox.Show(ex.Message); conexion.Close(); }
            }

        }

        private void btnBuscar_Click(object sender, EventArgs e)
        {
            if (cbIdioma.SelectedItem == null)
            {
                MessageBox.Show("Por favor, seleccione un idioma en el ComboBox");
                return;
            }

            try
            {
                lvlistapalabras.Items.Clear();
                conexion.Open();
                comandosql.Connection = conexion;
                comandosql.CommandText = "SELECT * FROM traduccion WHERE (@pais = 'Español' AND esp LIKE @palabra) OR (@pais = 'Inglés' AND ing LIKE @palabra)";

                comandosql.Parameters.Clear();
                comandosql.Parameters.AddWithValue("@pais", cbIdioma.SelectedItem.ToString());
                comandosql.Parameters.AddWithValue("@palabra", txtBuscar.Text + "%");

                SqlDataReader midatareader = comandosql.ExecuteReader();
                while (midatareader.Read())
                {
                    ListViewItem milista = lvlistapalabras.Items.Add(midatareader["esp"].ToString());
                    milista.SubItems.Add(midatareader["ing"].ToString());
                }
                midatareader.Close();
            }
            catch (Exception ex) { MessageBox.Show("Error en la búsqueda: " + ex.Message); }
            finally { conexion.Close(); }
        }
    }
}

