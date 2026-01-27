using System;

namespace EjerBDSql
{
    partial class Form1
    {
        /// <summary>
        /// Variable del diseñador necesaria.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Limpiar los recursos que se estén usando.
        /// </summary>
        /// <param name="disposing">true si los recursos administrados se deben desechar; false en caso contrario.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Código generado por el Diseñador de Windows Forms

        /// <summary>
        /// Método necesario para admitir el Diseñador. No se puede modificar
        /// el contenido de este método con el editor de código.
        /// </summary>
        private void InitializeComponent()
        {
            this.lvlistapalabras = new System.Windows.Forms.ListView();
            this.colEsp = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.colIng = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.btnCargar = new System.Windows.Forms.Button();
            this.txtEspanol = new System.Windows.Forms.TextBox();
            this.txtIngles = new System.Windows.Forms.TextBox();
            this.btnAnadir = new System.Windows.Forms.Button();
            this.btnModificar = new System.Windows.Forms.Button();
            this.btnBorrar = new System.Windows.Forms.Button();
            this.txtBuscar = new System.Windows.Forms.TextBox();
            this.cbIdioma = new System.Windows.Forms.ComboBox();
            this.btnBuscar = new System.Windows.Forms.Button();
            this.btnCerrar = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // lvlistapalabras
            // 
            this.lvlistapalabras.Columns.AddRange(new System.Windows.Forms.ColumnHeader[] {
            this.colEsp,
            this.colIng});
            this.lvlistapalabras.FullRowSelect = true;
            this.lvlistapalabras.HideSelection = false;
            this.lvlistapalabras.Location = new System.Drawing.Point(147, 56);
            this.lvlistapalabras.Name = "lvlistapalabras";
            this.lvlistapalabras.Size = new System.Drawing.Size(300, 250);
            this.lvlistapalabras.TabIndex = 0;
            this.lvlistapalabras.UseCompatibleStateImageBehavior = false;
            this.lvlistapalabras.View = System.Windows.Forms.View.Details;
            // 
            // colEsp
            // 
            this.colEsp.Text = "Español";
            this.colEsp.Width = 140;
            // 
            // colIng
            // 
            this.colIng.Text = "Inglés";
            this.colIng.Width = 140;
            // 
            // btnCargar
            // 
            this.btnCargar.Location = new System.Drawing.Point(465, 124);
            this.btnCargar.Name = "btnCargar";
            this.btnCargar.Size = new System.Drawing.Size(100, 150);
            this.btnCargar.TabIndex = 1;
            this.btnCargar.Text = "Cargar Tabla";
            this.btnCargar.Click += new System.EventHandler(this.btnCargar_Click);
            // 
            // txtEspanol
            // 
            this.txtEspanol.Location = new System.Drawing.Point(147, 324);
            this.txtEspanol.Name = "txtEspanol";
            this.txtEspanol.Size = new System.Drawing.Size(100, 26);
            this.txtEspanol.TabIndex = 2;
            // 
            // txtIngles
            // 
            this.txtIngles.Location = new System.Drawing.Point(285, 324);
            this.txtIngles.Name = "txtIngles";
            this.txtIngles.Size = new System.Drawing.Size(100, 26);
            this.txtIngles.TabIndex = 3;
            // 
            // btnAnadir
            // 
            this.btnAnadir.Location = new System.Drawing.Point(465, 300);
            this.btnAnadir.Name = "btnAnadir";
            this.btnAnadir.Size = new System.Drawing.Size(100, 37);
            this.btnAnadir.TabIndex = 4;
            this.btnAnadir.Text = "Añadir";
            this.btnAnadir.Click += new System.EventHandler(this.btnAnadir_Click);
            // 
            // btnModificar
            // 
            this.btnModificar.Location = new System.Drawing.Point(465, 354);
            this.btnModificar.Name = "btnModificar";
            this.btnModificar.Size = new System.Drawing.Size(100, 35);
            this.btnModificar.TabIndex = 5;
            this.btnModificar.Text = "Modificar";
            this.btnModificar.Click += new System.EventHandler(this.btnModificar_Click);
            // 
            // btnBorrar
            // 
            this.btnBorrar.Location = new System.Drawing.Point(465, 395);
            this.btnBorrar.Name = "btnBorrar";
            this.btnBorrar.Size = new System.Drawing.Size(100, 32);
            this.btnBorrar.TabIndex = 6;
            this.btnBorrar.Text = "Borrar";
            this.btnBorrar.Click += new System.EventHandler(this.btnBorrar_Click);
            // 
            // txtBuscar
            // 
            this.txtBuscar.Location = new System.Drawing.Point(147, 374);
            this.txtBuscar.Name = "txtBuscar";
            this.txtBuscar.Size = new System.Drawing.Size(100, 26);
            this.txtBuscar.TabIndex = 7;
            // 
            // cbIdioma
            // 
            this.cbIdioma.Items.AddRange(new object[] {
            "Español",
            "Inglés"});
            this.cbIdioma.Location = new System.Drawing.Point(147, 404);
            this.cbIdioma.Name = "cbIdioma";
            this.cbIdioma.Size = new System.Drawing.Size(121, 28);
            this.cbIdioma.TabIndex = 8;
            // 
            // btnBuscar
            // 
            this.btnBuscar.Location = new System.Drawing.Point(285, 404);
            this.btnBuscar.Name = "btnBuscar";
            this.btnBuscar.Size = new System.Drawing.Size(83, 28);
            this.btnBuscar.TabIndex = 9;
            this.btnBuscar.Text = "Buscar";
            this.btnBuscar.Click += new System.EventHandler(this.btnBuscar_Click);
            // 
            // btnCerrar
            // 
            this.btnCerrar.Location = new System.Drawing.Point(465, 64);
            this.btnCerrar.Name = "btnCerrar";
            this.btnCerrar.Size = new System.Drawing.Size(100, 34);
            this.btnCerrar.TabIndex = 10;
            this.btnCerrar.Text = "Cerrar";
            this.btnCerrar.Click += new System.EventHandler(this.btnCerrar_Click);
            // 
            // Form1
            // 
            this.ClientSize = new System.Drawing.Size(779, 551);
            this.Controls.Add(this.lvlistapalabras);
            this.Controls.Add(this.btnCargar);
            this.Controls.Add(this.txtEspanol);
            this.Controls.Add(this.txtIngles);
            this.Controls.Add(this.btnAnadir);
            this.Controls.Add(this.btnModificar);
            this.Controls.Add(this.btnBorrar);
            this.Controls.Add(this.txtBuscar);
            this.Controls.Add(this.cbIdioma);
            this.Controls.Add(this.btnBuscar);
            this.Controls.Add(this.btnCerrar);
            this.Name = "Form1";
            this.Text = "Diccionario";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

       

        private System.Windows.Forms.ListView lvlistapalabras;
        private System.Windows.Forms.ColumnHeader colEsp;
        private System.Windows.Forms.ColumnHeader colIng;
        private System.Windows.Forms.Button btnCargar;
        private System.Windows.Forms.TextBox txtEspanol;
        private System.Windows.Forms.TextBox txtIngles;
        private System.Windows.Forms.Button btnAnadir;
        private System.Windows.Forms.Button btnModificar;
        private System.Windows.Forms.Button btnBorrar;
        private System.Windows.Forms.TextBox txtBuscar;
        private System.Windows.Forms.ComboBox cbIdioma;
        private System.Windows.Forms.Button btnBuscar;
        private System.Windows.Forms.Button btnCerrar;
    }

        #endregion
}


