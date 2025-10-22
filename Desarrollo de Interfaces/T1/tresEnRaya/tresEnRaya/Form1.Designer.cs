namespace tresEnRaya
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
            this.jugador1 = new System.Windows.Forms.Label();
            this.jugador2 = new System.Windows.Forms.Label();
            this.nombre1 = new System.Windows.Forms.TextBox();
            this.nombre2 = new System.Windows.Forms.TextBox();
            this.play = new System.Windows.Forms.Button();
            this.layout = new System.Windows.Forms.TableLayoutPanel();
            this.button1 = new System.Windows.Forms.Button();
            this.button2 = new System.Windows.Forms.Button();
            this.button3 = new System.Windows.Forms.Button();
            this.button4 = new System.Windows.Forms.Button();
            this.button5 = new System.Windows.Forms.Button();
            this.button6 = new System.Windows.Forms.Button();
            this.button7 = new System.Windows.Forms.Button();
            this.button8 = new System.Windows.Forms.Button();
            this.button9 = new System.Windows.Forms.Button();
            this.jugadorActual = new System.Windows.Forms.Label();
            this.labelGanador = new System.Windows.Forms.Label();
            this.layout.SuspendLayout();
            this.SuspendLayout();
            // 
            // jugador1
            // 
            this.jugador1.AutoSize = true;
            this.jugador1.Location = new System.Drawing.Point(75, 33);
            this.jugador1.Name = "jugador1";
            this.jugador1.Size = new System.Drawing.Size(80, 20);
            this.jugador1.TabIndex = 0;
            this.jugador1.Text = "Jugador 1";
            this.jugador1.Click += new System.EventHandler(this.label1_Click);
            // 
            // jugador2
            // 
            this.jugador2.AutoSize = true;
            this.jugador2.Location = new System.Drawing.Point(75, 72);
            this.jugador2.Name = "jugador2";
            this.jugador2.Size = new System.Drawing.Size(80, 20);
            this.jugador2.TabIndex = 1;
            this.jugador2.Text = "Jugador 2";
            // 
            // nombre1
            // 
            this.nombre1.Location = new System.Drawing.Point(184, 26);
            this.nombre1.Name = "nombre1";
            this.nombre1.Size = new System.Drawing.Size(100, 26);
            this.nombre1.TabIndex = 2;
            // 
            // nombre2
            // 
            this.nombre2.Location = new System.Drawing.Point(184, 72);
            this.nombre2.Name = "nombre2";
            this.nombre2.Size = new System.Drawing.Size(100, 26);
            this.nombre2.TabIndex = 3;
            // 
            // play
            // 
            this.play.Location = new System.Drawing.Point(373, 44);
            this.play.Name = "play";
            this.play.Size = new System.Drawing.Size(83, 37);
            this.play.TabIndex = 4;
            this.play.Text = "Jugar";
            this.play.UseVisualStyleBackColor = true;
            this.play.Click += new System.EventHandler(this.play_Click);
            // 
            // layout
            // 
            this.layout.BackColor = System.Drawing.SystemColors.ButtonHighlight;
            this.layout.CellBorderStyle = System.Windows.Forms.TableLayoutPanelCellBorderStyle.Single;
            this.layout.ColumnCount = 3;
            this.layout.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 33.33333F));
            this.layout.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 33.33334F));
            this.layout.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 33.33334F));
            this.layout.Controls.Add(this.button9, 2, 2);
            this.layout.Controls.Add(this.button8, 1, 2);
            this.layout.Controls.Add(this.button7, 0, 2);
            this.layout.Controls.Add(this.button4, 0, 1);
            this.layout.Controls.Add(this.button3, 2, 0);
            this.layout.Controls.Add(this.button2, 1, 0);
            this.layout.Controls.Add(this.button1, 0, 0);
            this.layout.Controls.Add(this.button6, 2, 1);
            this.layout.Controls.Add(this.button5, 1, 1);
            this.layout.Location = new System.Drawing.Point(89, 126);
            this.layout.Name = "layout";
            this.layout.RowCount = 3;
            this.layout.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Percent, 33.33333F));
            this.layout.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Percent, 33.33333F));
            this.layout.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Percent, 33.33333F));
            this.layout.Size = new System.Drawing.Size(344, 266);
            this.layout.TabIndex = 5;
            this.layout.Paint += new System.Windows.Forms.PaintEventHandler(this.tableLayoutPanel1_Paint);
            // 
            // button1
            // 
            this.button1.Location = new System.Drawing.Point(4, 4);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(107, 81);
            this.button1.TabIndex = 0;
            this.button1.Tag = "0";
            this.button1.UseVisualStyleBackColor = true;
            this.button1.Click += new System.EventHandler(this.btnCasilla_Click);
            // 
            // button2
            // 
            this.button2.Location = new System.Drawing.Point(118, 4);
            this.button2.Name = "button2";
            this.button2.Size = new System.Drawing.Size(107, 81);
            this.button2.TabIndex = 1;
            this.button2.Tag = "1";
            this.button2.UseVisualStyleBackColor = true;
            this.button2.Click += new System.EventHandler(this.btnCasilla_Click);
            // 
            // button3
            // 
            this.button3.Location = new System.Drawing.Point(232, 4);
            this.button3.Name = "button3";
            this.button3.Size = new System.Drawing.Size(108, 81);
            this.button3.TabIndex = 2;
            this.button3.Tag = "2";
            this.button3.UseVisualStyleBackColor = true;
            this.button3.Click += new System.EventHandler(this.btnCasilla_Click);
            // 
            // button4
            // 
            this.button4.Location = new System.Drawing.Point(4, 92);
            this.button4.Name = "button4";
            this.button4.Size = new System.Drawing.Size(107, 81);
            this.button4.TabIndex = 3;
            this.button4.Tag = "3";
            this.button4.UseVisualStyleBackColor = true;
            this.button4.Click += new System.EventHandler(this.btnCasilla_Click);
            // 
            // button5
            // 
            this.button5.Location = new System.Drawing.Point(118, 92);
            this.button5.Name = "button5";
            this.button5.Size = new System.Drawing.Size(107, 81);
            this.button5.TabIndex = 4;
            this.button5.Tag = "4";
            this.button5.UseVisualStyleBackColor = true;
            this.button5.Click += new System.EventHandler(this.btnCasilla_Click);
            // 
            // button6
            // 
            this.button6.Location = new System.Drawing.Point(232, 92);
            this.button6.Name = "button6";
            this.button6.Size = new System.Drawing.Size(108, 81);
            this.button6.TabIndex = 5;
            this.button6.Tag = "5";
            this.button6.UseVisualStyleBackColor = true;
            this.button6.Click += new System.EventHandler(this.btnCasilla_Click);
            // 
            // button7
            // 
            this.button7.Location = new System.Drawing.Point(4, 180);
            this.button7.Name = "button7";
            this.button7.Size = new System.Drawing.Size(107, 82);
            this.button7.TabIndex = 6;
            this.button7.Tag = "6";
            this.button7.UseVisualStyleBackColor = true;
            this.button7.Click += new System.EventHandler(this.btnCasilla_Click);
            // 
            // button8
            // 
            this.button8.Location = new System.Drawing.Point(118, 180);
            this.button8.Name = "button8";
            this.button8.Size = new System.Drawing.Size(107, 82);
            this.button8.TabIndex = 7;
            this.button8.Tag = "7";
            this.button8.UseVisualStyleBackColor = true;
            this.button8.Click += new System.EventHandler(this.btnCasilla_Click);
            // 
            // button9
            // 
            this.button9.Location = new System.Drawing.Point(232, 180);
            this.button9.Name = "button9";
            this.button9.Size = new System.Drawing.Size(108, 82);
            this.button9.TabIndex = 8;
            this.button9.Tag = "8";
            this.button9.UseVisualStyleBackColor = true;
            this.button9.Click += new System.EventHandler(this.btnCasilla_Click);
            // 
            // jugadorActual
            // 
            this.jugadorActual.AutoSize = true;
            this.jugadorActual.Location = new System.Drawing.Point(458, 160);
            this.jugadorActual.Name = "jugadorActual";
            this.jugadorActual.Size = new System.Drawing.Size(124, 20);
            this.jugadorActual.TabIndex = 6;
            this.jugadorActual.Text = "Jugador Actual: ";
            this.jugadorActual.Click += new System.EventHandler(this.label1_Click_1);
            // 
            // labelGanador
            // 
            this.labelGanador.AutoSize = true;
            this.labelGanador.BackColor = System.Drawing.SystemColors.ButtonFace;
            this.labelGanador.Location = new System.Drawing.Point(458, 268);
            this.labelGanador.Name = "labelGanador";
            this.labelGanador.Size = new System.Drawing.Size(80, 20);
            this.labelGanador.TabIndex = 7;
            this.labelGanador.Text = "Ganador: ";
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(9F, 20F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.labelGanador);
            this.Controls.Add(this.jugadorActual);
            this.Controls.Add(this.layout);
            this.Controls.Add(this.play);
            this.Controls.Add(this.nombre2);
            this.Controls.Add(this.nombre1);
            this.Controls.Add(this.jugador2);
            this.Controls.Add(this.jugador1);
            this.Name = "Form1";
            this.Text = "Form1";
            this.layout.ResumeLayout(false);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label jugador1;
        private System.Windows.Forms.Label jugador2;
        private System.Windows.Forms.TextBox nombre1;
        private System.Windows.Forms.TextBox nombre2;
        private System.Windows.Forms.Button play;
        private System.Windows.Forms.TableLayoutPanel layout;
        private System.Windows.Forms.Button button9;
        private System.Windows.Forms.Button button8;
        private System.Windows.Forms.Button button7;
        private System.Windows.Forms.Button button6;
        private System.Windows.Forms.Button button5;
        private System.Windows.Forms.Button button4;
        private System.Windows.Forms.Button button3;
        private System.Windows.Forms.Button button2;
        private System.Windows.Forms.Button button1;
        private System.Windows.Forms.Label jugadorActual;
        private System.Windows.Forms.Label labelGanador;
    }
}

