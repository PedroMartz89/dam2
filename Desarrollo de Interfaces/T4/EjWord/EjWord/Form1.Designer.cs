namespace EjWord
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
            this.rtbTexto = new System.Windows.Forms.RichTextBox();
            this.btnCrearRichText = new System.Windows.Forms.Button();
            this.btnCrearConPlantilla = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // rtbTexto
            // 
            this.rtbTexto.Location = new System.Drawing.Point(75, 55);
            this.rtbTexto.Name = "rtbTexto";
            this.rtbTexto.Size = new System.Drawing.Size(313, 210);
            this.rtbTexto.TabIndex = 0;
            this.rtbTexto.Text = "";
            // 
            // btnCrearRichText
            // 
            this.btnCrearRichText.Location = new System.Drawing.Point(186, 302);
            this.btnCrearRichText.Name = "btnCrearRichText";
            this.btnCrearRichText.Size = new System.Drawing.Size(99, 32);
            this.btnCrearRichText.TabIndex = 1;
            this.btnCrearRichText.Text = "Crear con texto";
            this.btnCrearRichText.UseVisualStyleBackColor = true;
            this.btnCrearRichText.Click += new System.EventHandler(this.btnCrearRichText_Click);
            // 
            // btnCrearConPlantilla
            // 
            this.btnCrearConPlantilla.Location = new System.Drawing.Point(509, 179);
            this.btnCrearConPlantilla.Name = "btnCrearConPlantilla";
            this.btnCrearConPlantilla.Size = new System.Drawing.Size(118, 37);
            this.btnCrearConPlantilla.TabIndex = 2;
            this.btnCrearConPlantilla.Text = "Crear con plantilla";
            this.btnCrearConPlantilla.UseVisualStyleBackColor = true;
            this.btnCrearConPlantilla.Click += new System.EventHandler(this.btnCrearConPlantilla_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.btnCrearConPlantilla);
            this.Controls.Add(this.btnCrearRichText);
            this.Controls.Add(this.rtbTexto);
            this.Name = "Form1";
            this.Text = "Form1";
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.RichTextBox rtbTexto;
        private System.Windows.Forms.Button btnCrearRichText;
        private System.Windows.Forms.Button btnCrearConPlantilla;
    }
}

