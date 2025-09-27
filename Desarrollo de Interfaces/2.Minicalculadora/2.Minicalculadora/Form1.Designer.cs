namespace _2.Minicalculadora
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
            this.label1 = new System.Windows.Forms.Label();
            this.operador1 = new System.Windows.Forms.TextBox();
            this.operador2 = new System.Windows.Forms.TextBox();
            this.resultado = new System.Windows.Forms.Label();
            this.sumar = new System.Windows.Forms.Button();
            this.restar = new System.Windows.Forms.Button();
            this.mult = new System.Windows.Forms.Button();
            this.div = new System.Windows.Forms.Button();
            this.label2 = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.Location = new System.Drawing.Point(481, 191);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(21, 24);
            this.label1.TabIndex = 1;
            this.label1.Text = "=";
            this.label1.Click += new System.EventHandler(this.label1_Click);
            // 
            // operador1
            // 
            this.operador1.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.operador1.Location = new System.Drawing.Point(208, 188);
            this.operador1.Name = "operador1";
            this.operador1.Size = new System.Drawing.Size(86, 29);
            this.operador1.TabIndex = 2;
            this.operador1.TextChanged += new System.EventHandler(this.textBox1_TextChanged);
            // 
            // operador2
            // 
            this.operador2.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.operador2.Location = new System.Drawing.Point(387, 188);
            this.operador2.Name = "operador2";
            this.operador2.Size = new System.Drawing.Size(88, 29);
            this.operador2.TabIndex = 3;
            // 
            // resultado
            // 
            this.resultado.AutoSize = true;
            this.resultado.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.resultado.Location = new System.Drawing.Point(505, 191);
            this.resultado.Name = "resultado";
            this.resultado.Size = new System.Drawing.Size(60, 24);
            this.resultado.TabIndex = 5;
            this.resultado.Text = "label2";
            this.resultado.Visible = false;
            // 
            // sumar
            // 
            this.sumar.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.sumar.Location = new System.Drawing.Point(320, 122);
            this.sumar.Name = "sumar";
            this.sumar.Size = new System.Drawing.Size(44, 43);
            this.sumar.TabIndex = 6;
            this.sumar.Text = "+";
            this.sumar.UseVisualStyleBackColor = true;
            this.sumar.Click += new System.EventHandler(this.sumar_Click);
            // 
            // restar
            // 
            this.restar.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.restar.Location = new System.Drawing.Point(320, 171);
            this.restar.Name = "restar";
            this.restar.Size = new System.Drawing.Size(44, 41);
            this.restar.TabIndex = 7;
            this.restar.Text = "-";
            this.restar.UseVisualStyleBackColor = true;
            this.restar.Click += new System.EventHandler(this.restar_Click);
            // 
            // mult
            // 
            this.mult.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.mult.Location = new System.Drawing.Point(320, 218);
            this.mult.Name = "mult";
            this.mult.Size = new System.Drawing.Size(44, 39);
            this.mult.TabIndex = 8;
            this.mult.Text = "x";
            this.mult.UseVisualStyleBackColor = true;
            this.mult.Click += new System.EventHandler(this.button3_Click);
            // 
            // div
            // 
            this.div.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.div.Location = new System.Drawing.Point(320, 263);
            this.div.Name = "div";
            this.div.Size = new System.Drawing.Size(44, 39);
            this.div.TabIndex = 9;
            this.div.Text = "/";
            this.div.UseVisualStyleBackColor = true;
            this.div.Click += new System.EventHandler(this.div_Click);
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("Microsoft Sans Serif", 24F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label2.Location = new System.Drawing.Point(176, 29);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(389, 37);
            this.label2.TabIndex = 10;
            this.label2.Text = "MACHINE CALCULATOR";
            this.label2.Click += new System.EventHandler(this.label2_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(9F, 20F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.div);
            this.Controls.Add(this.mult);
            this.Controls.Add(this.restar);
            this.Controls.Add(this.sumar);
            this.Controls.Add(this.resultado);
            this.Controls.Add(this.operador2);
            this.Controls.Add(this.operador1);
            this.Controls.Add(this.label1);
            this.Name = "Form1";
            this.Text = "Form1";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox operador1;
        private System.Windows.Forms.TextBox operador2;
        private System.Windows.Forms.Label resultado;
        private System.Windows.Forms.Button sumar;
        private System.Windows.Forms.Button restar;
        private System.Windows.Forms.Button mult;
        private System.Windows.Forms.Button div;
        private System.Windows.Forms.Label label2;
    }
}

