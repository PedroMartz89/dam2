namespace Ejercicios3
{
    partial class formMenu
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.label1 = new System.Windows.Forms.Label();
            this.bttnAltas = new System.Windows.Forms.Button();
            this.bttnListar = new System.Windows.Forms.Button();
            this.bttnConsultas = new System.Windows.Forms.Button();
            this.bttnOrdenar = new System.Windows.Forms.Button();
            this.bttnSalir = new System.Windows.Forms.Button();
            this.listBoxAlumnos = new System.Windows.Forms.ListBox();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(291, 63);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(151, 20);
            this.label1.TabIndex = 1;
            this.label1.Text = "Gestión de alumnos";
            // 
            // bttnAltas
            // 
            this.bttnAltas.Location = new System.Drawing.Point(256, 114);
            this.bttnAltas.Name = "bttnAltas";
            this.bttnAltas.Size = new System.Drawing.Size(99, 32);
            this.bttnAltas.TabIndex = 2;
            this.bttnAltas.Text = "Altas";
            this.bttnAltas.UseVisualStyleBackColor = true;
            this.bttnAltas.Click += new System.EventHandler(this.bttnAltas_Click);
            // 
            // bttnListar
            // 
            this.bttnListar.Location = new System.Drawing.Point(256, 164);
            this.bttnListar.Name = "bttnListar";
            this.bttnListar.Size = new System.Drawing.Size(99, 33);
            this.bttnListar.TabIndex = 3;
            this.bttnListar.Text = "Listar";
            this.bttnListar.UseVisualStyleBackColor = true;
            this.bttnListar.Click += new System.EventHandler(this.button2_Click);
            // 
            // bttnConsultas
            // 
            this.bttnConsultas.Location = new System.Drawing.Point(387, 114);
            this.bttnConsultas.Name = "bttnConsultas";
            this.bttnConsultas.Size = new System.Drawing.Size(99, 32);
            this.bttnConsultas.TabIndex = 4;
            this.bttnConsultas.Text = "Consultas";
            this.bttnConsultas.UseVisualStyleBackColor = true;
            this.bttnConsultas.Click += new System.EventHandler(this.bttnConsultas_Click);
            // 
            // bttnOrdenar
            // 
            this.bttnOrdenar.Location = new System.Drawing.Point(387, 164);
            this.bttnOrdenar.Name = "bttnOrdenar";
            this.bttnOrdenar.Size = new System.Drawing.Size(99, 33);
            this.bttnOrdenar.TabIndex = 5;
            this.bttnOrdenar.Text = "Ordenar";
            this.bttnOrdenar.UseVisualStyleBackColor = true;
            // 
            // bttnSalir
            // 
            this.bttnSalir.Location = new System.Drawing.Point(331, 203);
            this.bttnSalir.Name = "bttnSalir";
            this.bttnSalir.Size = new System.Drawing.Size(75, 41);
            this.bttnSalir.TabIndex = 6;
            this.bttnSalir.Text = "Salir";
            this.bttnSalir.UseVisualStyleBackColor = true;
            // 
            // listBoxAlumnos
            // 
            this.listBoxAlumnos.FormattingEnabled = true;
            this.listBoxAlumnos.ItemHeight = 20;
            this.listBoxAlumnos.Location = new System.Drawing.Point(74, 277);
            this.listBoxAlumnos.Name = "listBoxAlumnos";
            this.listBoxAlumnos.Size = new System.Drawing.Size(657, 84);
            this.listBoxAlumnos.TabIndex = 7;
            // 
            // formMenu
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(9F, 20F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.SystemColors.Info;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.listBoxAlumnos);
            this.Controls.Add(this.bttnSalir);
            this.Controls.Add(this.bttnOrdenar);
            this.Controls.Add(this.bttnConsultas);
            this.Controls.Add(this.bttnListar);
            this.Controls.Add(this.bttnAltas);
            this.Controls.Add(this.label1);
            this.Name = "formMenu";
            this.Text = "Menu";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Button bttnAltas;
        private System.Windows.Forms.Button bttnListar;
        private System.Windows.Forms.Button bttnConsultas;
        private System.Windows.Forms.Button bttnOrdenar;
        private System.Windows.Forms.Button bttnSalir;
        private System.Windows.Forms.ListBox listBoxAlumnos;
    }
}