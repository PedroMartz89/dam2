namespace AppCompraInteractiva
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
            this.lblTitulo = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.panel1 = new System.Windows.Forms.Panel();
            this.panel2 = new System.Windows.Forms.Panel();
            this.lblProductos = new System.Windows.Forms.Label();
            this.lblPerifericos = new System.Windows.Forms.Label();
            this.listBox1 = new System.Windows.Forms.ListBox();
            this.cbPago = new System.Windows.Forms.ComboBox();
            this.btnPresupuesto = new System.Windows.Forms.Button();
            this.btnSalir = new System.Windows.Forms.Button();
            this.label3 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.rbPC = new System.Windows.Forms.RadioButton();
            this.rbMac = new System.Windows.Forms.RadioButton();
            this.rbPort = new System.Windows.Forms.RadioButton();
            this.cbContestador = new System.Windows.Forms.CheckBox();
            this.cbCalc = new System.Windows.Forms.CheckBox();
            this.cbFoto = new System.Windows.Forms.CheckBox();
            this.pbPago = new System.Windows.Forms.PictureBox();
            this.pbPerifericos = new System.Windows.Forms.PictureBox();
            this.pbOfi3 = new System.Windows.Forms.PictureBox();
            this.pbOfi2 = new System.Windows.Forms.PictureBox();
            this.pbOfi1 = new System.Windows.Forms.PictureBox();
            this.pbEquipo = new System.Windows.Forms.PictureBox();
            this.panel1.SuspendLayout();
            this.panel2.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.pbPago)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pbPerifericos)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pbOfi3)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pbOfi2)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pbOfi1)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pbEquipo)).BeginInit();
            this.SuspendLayout();
            // 
            // lblTitulo
            // 
            this.lblTitulo.AutoSize = true;
            this.lblTitulo.Font = new System.Drawing.Font("Microsoft Sans Serif", 18F);
            this.lblTitulo.Location = new System.Drawing.Point(41, 50);
            this.lblTitulo.Name = "lblTitulo";
            this.lblTitulo.Size = new System.Drawing.Size(213, 29);
            this.lblTitulo.TabIndex = 0;
            this.lblTitulo.Text = "Compra Interactiva";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(12, 111);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(460, 40);
            this.label1.TabIndex = 1;
            this.label1.Text = "Actualice su oficina comprando los productos que necesite \r\ncon casilas de verifi" +
    "cación. botones de opción y cuadros de lista.";
            // 
            // panel1
            // 
            this.panel1.Controls.Add(this.rbPort);
            this.panel1.Controls.Add(this.rbMac);
            this.panel1.Controls.Add(this.rbPC);
            this.panel1.Location = new System.Drawing.Point(60, 191);
            this.panel1.Name = "panel1";
            this.panel1.Size = new System.Drawing.Size(243, 161);
            this.panel1.TabIndex = 2;
            // 
            // panel2
            // 
            this.panel2.Controls.Add(this.cbFoto);
            this.panel2.Controls.Add(this.cbCalc);
            this.panel2.Controls.Add(this.cbContestador);
            this.panel2.Location = new System.Drawing.Point(60, 392);
            this.panel2.Name = "panel2";
            this.panel2.Size = new System.Drawing.Size(243, 161);
            this.panel2.TabIndex = 3;
            this.panel2.Paint += new System.Windows.Forms.PaintEventHandler(this.panel2_Paint);
            // 
            // lblProductos
            // 
            this.lblProductos.AutoSize = true;
            this.lblProductos.Font = new System.Drawing.Font("Microsoft Sans Serif", 18F);
            this.lblProductos.Location = new System.Drawing.Point(612, 50);
            this.lblProductos.Name = "lblProductos";
            this.lblProductos.Size = new System.Drawing.Size(216, 29);
            this.lblProductos.TabIndex = 4;
            this.lblProductos.Text = "Productos pedidos";
            // 
            // lblPerifericos
            // 
            this.lblPerifericos.AutoSize = true;
            this.lblPerifericos.Location = new System.Drawing.Point(378, 191);
            this.lblPerifericos.Name = "lblPerifericos";
            this.lblPerifericos.Size = new System.Drawing.Size(157, 20);
            this.lblPerifericos.TabIndex = 11;
            this.lblPerifericos.Text = "Periféricos (solo uno)";
            // 
            // listBox1
            // 
            this.listBox1.FormattingEnabled = true;
            this.listBox1.ItemHeight = 20;
            this.listBox1.Items.AddRange(new object[] {
            "Disco duro adicional (75€)",
            "Impresora (90€)",
            "Antena (50€)"});
            this.listBox1.Location = new System.Drawing.Point(364, 233);
            this.listBox1.Name = "listBox1";
            this.listBox1.Size = new System.Drawing.Size(192, 104);
            this.listBox1.TabIndex = 12;
            this.listBox1.SelectedIndexChanged += new System.EventHandler(this.listBox1_SelectedIndexChanged);
            // 
            // cbPago
            // 
            this.cbPago.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.cbPago.FormattingEnabled = true;
            this.cbPago.Items.AddRange(new object[] {
            "Tarjeta",
            "Paypal",
            "Bizum"});
            this.cbPago.Location = new System.Drawing.Point(382, 403);
            this.cbPago.Name = "cbPago";
            this.cbPago.Size = new System.Drawing.Size(153, 28);
            this.cbPago.TabIndex = 13;
            this.cbPago.SelectedIndexChanged += new System.EventHandler(this.cbPago_SelectedIndexChanged);
            // 
            // btnPresupuesto
            // 
            this.btnPresupuesto.Location = new System.Drawing.Point(396, 465);
            this.btnPresupuesto.Name = "btnPresupuesto";
            this.btnPresupuesto.Size = new System.Drawing.Size(113, 43);
            this.btnPresupuesto.TabIndex = 14;
            this.btnPresupuesto.Text = "Presupuesto";
            this.btnPresupuesto.UseVisualStyleBackColor = true;
            this.btnPresupuesto.Click += new System.EventHandler(this.btnPresupuesto_Click);
            // 
            // btnSalir
            // 
            this.btnSalir.Location = new System.Drawing.Point(396, 527);
            this.btnSalir.Name = "btnSalir";
            this.btnSalir.Size = new System.Drawing.Size(113, 43);
            this.btnSalir.TabIndex = 15;
            this.btnSalir.Text = "Salir";
            this.btnSalir.UseVisualStyleBackColor = true;
            this.btnSalir.Click += new System.EventHandler(this.btnSalir_Click);
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(72, 378);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(168, 20);
            this.label3.TabIndex = 16;
            this.label3.Text = "Equipo de oficina (0-3)";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(72, 179);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(144, 20);
            this.label2.TabIndex = 17;
            this.label2.Text = "Equipo (Necesario)";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(378, 368);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(125, 20);
            this.label4.TabIndex = 18;
            this.label4.Text = "Método de pago";
            // 
            // rbPC
            // 
            this.rbPC.AutoSize = true;
            this.rbPC.Location = new System.Drawing.Point(16, 32);
            this.rbPC.Name = "rbPC";
            this.rbPC.Size = new System.Drawing.Size(98, 24);
            this.rbPC.TabIndex = 0;
            this.rbPC.TabStop = true;
            this.rbPC.Text = "PC (700€)";
            this.rbPC.UseVisualStyleBackColor = true;
            this.rbPC.CheckedChanged += new System.EventHandler(this.rbPC_CheckedChanged);
            // 
            // rbMac
            // 
            this.rbMac.AutoSize = true;
            this.rbMac.Location = new System.Drawing.Point(16, 74);
            this.rbMac.Name = "rbMac";
            this.rbMac.Size = new System.Drawing.Size(159, 24);
            this.rbMac.TabIndex = 1;
            this.rbMac.TabStop = true;
            this.rbMac.Text = "Macintosh (1000€)";
            this.rbMac.UseVisualStyleBackColor = true;
            this.rbMac.CheckedChanged += new System.EventHandler(this.rbMac_CheckedChanged);
            // 
            // rbPort
            // 
            this.rbPort.AutoSize = true;
            this.rbPort.Location = new System.Drawing.Point(16, 112);
            this.rbPort.Name = "rbPort";
            this.rbPort.Size = new System.Drawing.Size(126, 24);
            this.rbPort.TabIndex = 2;
            this.rbPort.TabStop = true;
            this.rbPort.Text = "Portátil (500€)";
            this.rbPort.UseVisualStyleBackColor = true;
            this.rbPort.CheckedChanged += new System.EventHandler(this.rbPort_CheckedChanged);
            // 
            // cbContestador
            // 
            this.cbContestador.AutoSize = true;
            this.cbContestador.Location = new System.Drawing.Point(16, 38);
            this.cbContestador.Name = "cbContestador";
            this.cbContestador.Size = new System.Drawing.Size(157, 24);
            this.cbContestador.TabIndex = 0;
            this.cbContestador.Text = "Contestador (50€)";
            this.cbContestador.UseVisualStyleBackColor = true;
            this.cbContestador.CheckedChanged += new System.EventHandler(this.cbContestador_CheckedChanged);
            // 
            // cbCalc
            // 
            this.cbCalc.AutoSize = true;
            this.cbCalc.Location = new System.Drawing.Point(16, 83);
            this.cbCalc.Name = "cbCalc";
            this.cbCalc.Size = new System.Drawing.Size(153, 24);
            this.cbCalc.TabIndex = 1;
            this.cbCalc.Text = "Calculadora (20€)";
            this.cbCalc.UseVisualStyleBackColor = true;
            this.cbCalc.CheckedChanged += new System.EventHandler(this.checkBox2_CheckedChanged);
            // 
            // cbFoto
            // 
            this.cbFoto.AutoSize = true;
            this.cbFoto.Location = new System.Drawing.Point(16, 122);
            this.cbFoto.Name = "cbFoto";
            this.cbFoto.Size = new System.Drawing.Size(181, 24);
            this.cbFoto.TabIndex = 2;
            this.cbFoto.Text = "Fotocopiadora (100€)";
            this.cbFoto.UseVisualStyleBackColor = true;
            this.cbFoto.CheckedChanged += new System.EventHandler(this.cbFoto_CheckedChanged);
            // 
            // pbPago
            // 
            this.pbPago.Location = new System.Drawing.Point(780, 430);
            this.pbPago.Name = "pbPago";
            this.pbPago.Size = new System.Drawing.Size(120, 108);
            this.pbPago.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.pbPago.TabIndex = 10;
            this.pbPago.TabStop = false;
            // 
            // pbPerifericos
            // 
            this.pbPerifericos.Location = new System.Drawing.Point(636, 430);
            this.pbPerifericos.Name = "pbPerifericos";
            this.pbPerifericos.Size = new System.Drawing.Size(120, 108);
            this.pbPerifericos.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.pbPerifericos.TabIndex = 9;
            this.pbPerifericos.TabStop = false;
            // 
            // pbOfi3
            // 
            this.pbOfi3.Location = new System.Drawing.Point(780, 277);
            this.pbOfi3.Name = "pbOfi3";
            this.pbOfi3.Size = new System.Drawing.Size(120, 108);
            this.pbOfi3.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.pbOfi3.TabIndex = 8;
            this.pbOfi3.TabStop = false;
            // 
            // pbOfi2
            // 
            this.pbOfi2.Location = new System.Drawing.Point(636, 277);
            this.pbOfi2.Name = "pbOfi2";
            this.pbOfi2.Size = new System.Drawing.Size(120, 108);
            this.pbOfi2.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.pbOfi2.TabIndex = 7;
            this.pbOfi2.TabStop = false;
            // 
            // pbOfi1
            // 
            this.pbOfi1.Location = new System.Drawing.Point(780, 139);
            this.pbOfi1.Name = "pbOfi1";
            this.pbOfi1.Size = new System.Drawing.Size(120, 108);
            this.pbOfi1.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.pbOfi1.TabIndex = 6;
            this.pbOfi1.TabStop = false;
            // 
            // pbEquipo
            // 
            this.pbEquipo.Location = new System.Drawing.Point(636, 139);
            this.pbEquipo.Name = "pbEquipo";
            this.pbEquipo.Size = new System.Drawing.Size(120, 108);
            this.pbEquipo.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.pbEquipo.TabIndex = 5;
            this.pbEquipo.TabStop = false;
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(9F, 20F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(994, 621);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.btnSalir);
            this.Controls.Add(this.btnPresupuesto);
            this.Controls.Add(this.cbPago);
            this.Controls.Add(this.listBox1);
            this.Controls.Add(this.lblPerifericos);
            this.Controls.Add(this.pbPago);
            this.Controls.Add(this.pbPerifericos);
            this.Controls.Add(this.pbOfi3);
            this.Controls.Add(this.pbOfi2);
            this.Controls.Add(this.pbOfi1);
            this.Controls.Add(this.pbEquipo);
            this.Controls.Add(this.lblProductos);
            this.Controls.Add(this.panel2);
            this.Controls.Add(this.panel1);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.lblTitulo);
            this.Name = "Form1";
            this.Text = "Compra interactiva";
            this.panel1.ResumeLayout(false);
            this.panel1.PerformLayout();
            this.panel2.ResumeLayout(false);
            this.panel2.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.pbPago)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pbPerifericos)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pbOfi3)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pbOfi2)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pbOfi1)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pbEquipo)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label lblTitulo;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Panel panel1;
        private System.Windows.Forms.Panel panel2;
        private System.Windows.Forms.Label lblProductos;
        private System.Windows.Forms.PictureBox pbEquipo;
        private System.Windows.Forms.PictureBox pbOfi1;
        private System.Windows.Forms.PictureBox pbOfi2;
        private System.Windows.Forms.PictureBox pbOfi3;
        private System.Windows.Forms.PictureBox pbPerifericos;
        private System.Windows.Forms.PictureBox pbPago;
        private System.Windows.Forms.Label lblPerifericos;
        private System.Windows.Forms.ListBox listBox1;
        private System.Windows.Forms.ComboBox cbPago;
        private System.Windows.Forms.Button btnPresupuesto;
        private System.Windows.Forms.Button btnSalir;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.RadioButton rbPort;
        private System.Windows.Forms.RadioButton rbMac;
        private System.Windows.Forms.RadioButton rbPC;
        private System.Windows.Forms.CheckBox cbFoto;
        private System.Windows.Forms.CheckBox cbCalc;
        private System.Windows.Forms.CheckBox cbContestador;
    }
}

