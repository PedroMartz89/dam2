namespace EjExcel
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
            this.btnCrearConPlantilla = new System.Windows.Forms.Button();
            this.button2 = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // btnCrearConPlantilla
            // 
            this.btnCrearConPlantilla.Location = new System.Drawing.Point(388, 193);
            this.btnCrearConPlantilla.Margin = new System.Windows.Forms.Padding(4, 5, 4, 5);
            this.btnCrearConPlantilla.Name = "btnCrearConPlantilla";
            this.btnCrearConPlantilla.Size = new System.Drawing.Size(177, 57);
            this.btnCrearConPlantilla.TabIndex = 5;
            this.btnCrearConPlantilla.Text = "Crear con plantilla";
            this.btnCrearConPlantilla.UseVisualStyleBackColor = true;
            this.btnCrearConPlantilla.Click += new System.EventHandler(this.btnCrearConPlantilla_Click);
            // 
            // button2
            // 
            this.button2.Location = new System.Drawing.Point(216, 193);
            this.button2.Name = "button2";
            this.button2.Size = new System.Drawing.Size(129, 57);
            this.button2.TabIndex = 7;
            this.button2.Text = "Crear desde 0";
            this.button2.UseVisualStyleBackColor = true;
            this.button2.Click += new System.EventHandler(this.button2_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(9F, 20F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.button2);
            this.Controls.Add(this.btnCrearConPlantilla);
            this.Name = "Form1";
            this.Text = "Form1";
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Button btnCrearConPlantilla;
        private System.Windows.Forms.Button button2;
    }
}

