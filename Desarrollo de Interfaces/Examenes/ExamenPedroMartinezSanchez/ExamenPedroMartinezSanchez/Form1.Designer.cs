namespace ExamenPedroMartinezSanchez
{
    partial class FormPrincipalMartinez
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
            this.menuStrip1 = new System.Windows.Forms.MenuStrip();
            this.clienteToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.cajeroToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.tarjetaToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.autorToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.cerrarToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.pedroMartínezSánchezToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.altaToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.consultaToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.bloquearDesbloquearToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.label2 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.label5 = new System.Windows.Forms.Label();
            this.label6 = new System.Windows.Forms.Label();
            this.txtDniAlta = new System.Windows.Forms.TextBox();
            this.txtNombreAlta = new System.Windows.Forms.TextBox();
            this.txtClaveAlta = new System.Windows.Forms.TextBox();
            this.txtSaldo = new System.Windows.Forms.TextBox();
            this.btnAlta = new System.Windows.Forms.Button();
            this.btnCancelarAlta = new System.Windows.Forms.Button();
            this.label8 = new System.Windows.Forms.Label();
            this.listConsultar = new System.Windows.Forms.ListBox();
            this.label9 = new System.Windows.Forms.Label();
            this.txtNombreBuscar = new System.Windows.Forms.TextBox();
            this.gbAltas = new System.Windows.Forms.GroupBox();
            this.gbConsulta = new System.Windows.Forms.GroupBox();
            this.btnBuscar = new System.Windows.Forms.Button();
            this.btnCancelarBusca = new System.Windows.Forms.Button();
            this.checkBloquear = new System.Windows.Forms.CheckBox();
            this.gbInicioCajero = new System.Windows.Forms.GroupBox();
            this.label7 = new System.Windows.Forms.Label();
            this.btnValidar = new System.Windows.Forms.Button();
            this.txtDniIniciar = new System.Windows.Forms.TextBox();
            this.label10 = new System.Windows.Forms.Label();
            this.txtClaveIniciar = new System.Windows.Forms.TextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.btnEntrar = new System.Windows.Forms.Button();
            this.btnCancelarSesión = new System.Windows.Forms.Button();
            this.menuStrip1.SuspendLayout();
            this.gbAltas.SuspendLayout();
            this.gbConsulta.SuspendLayout();
            this.gbInicioCajero.SuspendLayout();
            this.SuspendLayout();
            // 
            // menuStrip1
            // 
            this.menuStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.clienteToolStripMenuItem,
            this.cajeroToolStripMenuItem,
            this.tarjetaToolStripMenuItem,
            this.autorToolStripMenuItem,
            this.cerrarToolStripMenuItem});
            this.menuStrip1.Location = new System.Drawing.Point(0, 0);
            this.menuStrip1.Name = "menuStrip1";
            this.menuStrip1.Size = new System.Drawing.Size(851, 24);
            this.menuStrip1.TabIndex = 0;
            this.menuStrip1.Text = "menuStrip1";
            // 
            // clienteToolStripMenuItem
            // 
            this.clienteToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.altaToolStripMenuItem,
            this.consultaToolStripMenuItem});
            this.clienteToolStripMenuItem.Name = "clienteToolStripMenuItem";
            this.clienteToolStripMenuItem.Size = new System.Drawing.Size(56, 20);
            this.clienteToolStripMenuItem.Text = "Cliente";
            // 
            // cajeroToolStripMenuItem
            // 
            this.cajeroToolStripMenuItem.Name = "cajeroToolStripMenuItem";
            this.cajeroToolStripMenuItem.Size = new System.Drawing.Size(53, 20);
            this.cajeroToolStripMenuItem.Text = "Cajero";
            this.cajeroToolStripMenuItem.Click += new System.EventHandler(this.cajeroToolStripMenuItem_Click);
            // 
            // tarjetaToolStripMenuItem
            // 
            this.tarjetaToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.bloquearDesbloquearToolStripMenuItem});
            this.tarjetaToolStripMenuItem.Name = "tarjetaToolStripMenuItem";
            this.tarjetaToolStripMenuItem.Size = new System.Drawing.Size(53, 20);
            this.tarjetaToolStripMenuItem.Text = "Tarjeta";
            // 
            // autorToolStripMenuItem
            // 
            this.autorToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.pedroMartínezSánchezToolStripMenuItem});
            this.autorToolStripMenuItem.Name = "autorToolStripMenuItem";
            this.autorToolStripMenuItem.Size = new System.Drawing.Size(49, 20);
            this.autorToolStripMenuItem.Text = "Autor";
            this.autorToolStripMenuItem.Click += new System.EventHandler(this.autorToolStripMenuItem_Click);
            // 
            // cerrarToolStripMenuItem
            // 
            this.cerrarToolStripMenuItem.Name = "cerrarToolStripMenuItem";
            this.cerrarToolStripMenuItem.Size = new System.Drawing.Size(51, 20);
            this.cerrarToolStripMenuItem.Text = "Cerrar";
            // 
            // pedroMartínezSánchezToolStripMenuItem
            // 
            this.pedroMartínezSánchezToolStripMenuItem.Name = "pedroMartínezSánchezToolStripMenuItem";
            this.pedroMartínezSánchezToolStripMenuItem.Size = new System.Drawing.Size(200, 22);
            this.pedroMartínezSánchezToolStripMenuItem.Text = "Pedro Martínez Sánchez";
            // 
            // altaToolStripMenuItem
            // 
            this.altaToolStripMenuItem.Name = "altaToolStripMenuItem";
            this.altaToolStripMenuItem.Size = new System.Drawing.Size(180, 22);
            this.altaToolStripMenuItem.Text = "Alta";
            this.altaToolStripMenuItem.Click += new System.EventHandler(this.altaToolStripMenuItem_Click);
            // 
            // consultaToolStripMenuItem
            // 
            this.consultaToolStripMenuItem.Name = "consultaToolStripMenuItem";
            this.consultaToolStripMenuItem.Size = new System.Drawing.Size(180, 22);
            this.consultaToolStripMenuItem.Text = "Consulta";
            this.consultaToolStripMenuItem.Click += new System.EventHandler(this.consultaToolStripMenuItem_Click);
            // 
            // bloquearDesbloquearToolStripMenuItem
            // 
            this.bloquearDesbloquearToolStripMenuItem.Name = "bloquearDesbloquearToolStripMenuItem";
            this.bloquearDesbloquearToolStripMenuItem.Size = new System.Drawing.Size(192, 22);
            this.bloquearDesbloquearToolStripMenuItem.Text = "Bloquear/Desbloquear";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(30, 38);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(184, 13);
            this.label2.TabIndex = 1;
            this.label2.Text = "Introduce tus datos para darte de alta";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(48, 71);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(49, 13);
            this.label3.TabIndex = 2;
            this.label3.Text = "DNI/NIE";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(50, 99);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(47, 13);
            this.label4.TabIndex = 3;
            this.label4.Text = "Nombre:";
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(21, 135);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(87, 13);
            this.label5.TabIndex = 4;
            this.label5.Text = "Clave (4 dígitos):";
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Location = new System.Drawing.Point(48, 164);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(37, 13);
            this.label6.TabIndex = 5;
            this.label6.Text = "Saldo:";
            // 
            // txtDniAlta
            // 
            this.txtDniAlta.Location = new System.Drawing.Point(114, 68);
            this.txtDniAlta.Name = "txtDniAlta";
            this.txtDniAlta.Size = new System.Drawing.Size(100, 20);
            this.txtDniAlta.TabIndex = 6;
            // 
            // txtNombreAlta
            // 
            this.txtNombreAlta.Location = new System.Drawing.Point(114, 96);
            this.txtNombreAlta.Name = "txtNombreAlta";
            this.txtNombreAlta.Size = new System.Drawing.Size(100, 20);
            this.txtNombreAlta.TabIndex = 7;
            // 
            // txtClaveAlta
            // 
            this.txtClaveAlta.Location = new System.Drawing.Point(114, 128);
            this.txtClaveAlta.MaxLength = 4;
            this.txtClaveAlta.Name = "txtClaveAlta";
            this.txtClaveAlta.Size = new System.Drawing.Size(100, 20);
            this.txtClaveAlta.TabIndex = 8;
            // 
            // txtSaldo
            // 
            this.txtSaldo.Location = new System.Drawing.Point(114, 157);
            this.txtSaldo.Name = "txtSaldo";
            this.txtSaldo.Size = new System.Drawing.Size(100, 20);
            this.txtSaldo.TabIndex = 9;
            // 
            // btnAlta
            // 
            this.btnAlta.Location = new System.Drawing.Point(33, 201);
            this.btnAlta.Name = "btnAlta";
            this.btnAlta.Size = new System.Drawing.Size(75, 23);
            this.btnAlta.TabIndex = 10;
            this.btnAlta.Text = "Aceptar";
            this.btnAlta.UseVisualStyleBackColor = true;
            this.btnAlta.Click += new System.EventHandler(this.btnAlta_Click);
            // 
            // btnCancelarAlta
            // 
            this.btnCancelarAlta.Location = new System.Drawing.Point(139, 201);
            this.btnCancelarAlta.Name = "btnCancelarAlta";
            this.btnCancelarAlta.Size = new System.Drawing.Size(75, 23);
            this.btnCancelarAlta.TabIndex = 11;
            this.btnCancelarAlta.Text = "Cancelar";
            this.btnCancelarAlta.UseVisualStyleBackColor = true;
            this.btnCancelarAlta.Click += new System.EventHandler(this.btnCancelarAlta_Click);
            // 
            // label8
            // 
            this.label8.AutoSize = true;
            this.label8.Location = new System.Drawing.Point(54, 28);
            this.label8.Name = "label8";
            this.label8.Size = new System.Drawing.Size(156, 13);
            this.label8.TabIndex = 2;
            this.label8.Text = "Introduce el nombre a consultar\r\n";
            // 
            // listConsultar
            // 
            this.listConsultar.FormattingEnabled = true;
            this.listConsultar.Location = new System.Drawing.Point(10, 99);
            this.listConsultar.Name = "listConsultar";
            this.listConsultar.Size = new System.Drawing.Size(256, 56);
            this.listConsultar.TabIndex = 3;
            // 
            // label9
            // 
            this.label9.AutoSize = true;
            this.label9.Location = new System.Drawing.Point(28, 66);
            this.label9.Name = "label9";
            this.label9.Size = new System.Drawing.Size(44, 13);
            this.label9.TabIndex = 4;
            this.label9.Text = "Nombre";
            // 
            // txtNombreBuscar
            // 
            this.txtNombreBuscar.Location = new System.Drawing.Point(81, 63);
            this.txtNombreBuscar.Name = "txtNombreBuscar";
            this.txtNombreBuscar.Size = new System.Drawing.Size(100, 20);
            this.txtNombreBuscar.TabIndex = 5;
            // 
            // gbAltas
            // 
            this.gbAltas.Controls.Add(this.btnCancelarAlta);
            this.gbAltas.Controls.Add(this.label2);
            this.gbAltas.Controls.Add(this.btnAlta);
            this.gbAltas.Controls.Add(this.txtSaldo);
            this.gbAltas.Controls.Add(this.label3);
            this.gbAltas.Controls.Add(this.txtClaveAlta);
            this.gbAltas.Controls.Add(this.label4);
            this.gbAltas.Controls.Add(this.txtNombreAlta);
            this.gbAltas.Controls.Add(this.label5);
            this.gbAltas.Controls.Add(this.txtDniAlta);
            this.gbAltas.Controls.Add(this.label6);
            this.gbAltas.Location = new System.Drawing.Point(32, 47);
            this.gbAltas.Name = "gbAltas";
            this.gbAltas.Size = new System.Drawing.Size(236, 230);
            this.gbAltas.TabIndex = 3;
            this.gbAltas.TabStop = false;
            this.gbAltas.Text = "Altas";
            // 
            // gbConsulta
            // 
            this.gbConsulta.Controls.Add(this.checkBloquear);
            this.gbConsulta.Controls.Add(this.btnCancelarBusca);
            this.gbConsulta.Controls.Add(this.btnBuscar);
            this.gbConsulta.Controls.Add(this.txtNombreBuscar);
            this.gbConsulta.Controls.Add(this.label9);
            this.gbConsulta.Controls.Add(this.label8);
            this.gbConsulta.Controls.Add(this.listConsultar);
            this.gbConsulta.Location = new System.Drawing.Point(287, 47);
            this.gbConsulta.Name = "gbConsulta";
            this.gbConsulta.Size = new System.Drawing.Size(272, 224);
            this.gbConsulta.TabIndex = 4;
            this.gbConsulta.TabStop = false;
            this.gbConsulta.Text = "Consultar";
            // 
            // btnBuscar
            // 
            this.btnBuscar.Location = new System.Drawing.Point(187, 61);
            this.btnBuscar.Name = "btnBuscar";
            this.btnBuscar.Size = new System.Drawing.Size(75, 23);
            this.btnBuscar.TabIndex = 6;
            this.btnBuscar.Text = "Buscar";
            this.btnBuscar.UseVisualStyleBackColor = true;
            this.btnBuscar.Click += new System.EventHandler(this.btnBuscar_Click);
            // 
            // btnCancelarBusca
            // 
            this.btnCancelarBusca.Location = new System.Drawing.Point(31, 187);
            this.btnCancelarBusca.Name = "btnCancelarBusca";
            this.btnCancelarBusca.Size = new System.Drawing.Size(75, 23);
            this.btnCancelarBusca.TabIndex = 7;
            this.btnCancelarBusca.Text = "Cancelar";
            this.btnCancelarBusca.UseVisualStyleBackColor = true;
            this.btnCancelarBusca.Click += new System.EventHandler(this.btnCancelarBusca_Click);
            // 
            // checkBloquear
            // 
            this.checkBloquear.AutoSize = true;
            this.checkBloquear.Enabled = false;
            this.checkBloquear.Location = new System.Drawing.Point(133, 191);
            this.checkBloquear.Name = "checkBloquear";
            this.checkBloquear.Size = new System.Drawing.Size(112, 17);
            this.checkBloquear.TabIndex = 8;
            this.checkBloquear.Text = "Tarjeta bloqueada";
            this.checkBloquear.UseVisualStyleBackColor = true;
            // 
            // gbInicioCajero
            // 
            this.gbInicioCajero.Controls.Add(this.btnCancelarSesión);
            this.gbInicioCajero.Controls.Add(this.btnEntrar);
            this.gbInicioCajero.Controls.Add(this.txtClaveIniciar);
            this.gbInicioCajero.Controls.Add(this.label1);
            this.gbInicioCajero.Controls.Add(this.btnValidar);
            this.gbInicioCajero.Controls.Add(this.txtDniIniciar);
            this.gbInicioCajero.Controls.Add(this.label10);
            this.gbInicioCajero.Controls.Add(this.label7);
            this.gbInicioCajero.Location = new System.Drawing.Point(32, 283);
            this.gbInicioCajero.Name = "gbInicioCajero";
            this.gbInicioCajero.Size = new System.Drawing.Size(307, 180);
            this.gbInicioCajero.TabIndex = 5;
            this.gbInicioCajero.TabStop = false;
            this.gbInicioCajero.Text = "Cajero";
            // 
            // label7
            // 
            this.label7.AutoSize = true;
            this.label7.Location = new System.Drawing.Point(35, 38);
            this.label7.Name = "label7";
            this.label7.Size = new System.Drawing.Size(187, 13);
            this.label7.TabIndex = 3;
            this.label7.Text = "Introduce los datos para iniciar sesión.";
            this.label7.Click += new System.EventHandler(this.label7_Click);
            // 
            // btnValidar
            // 
            this.btnValidar.Location = new System.Drawing.Point(174, 65);
            this.btnValidar.Name = "btnValidar";
            this.btnValidar.Size = new System.Drawing.Size(75, 23);
            this.btnValidar.TabIndex = 9;
            this.btnValidar.Text = "Validar";
            this.btnValidar.UseVisualStyleBackColor = true;
            this.btnValidar.Click += new System.EventHandler(this.btnValidar_Click);
            // 
            // txtDniIniciar
            // 
            this.txtDniIniciar.Location = new System.Drawing.Point(68, 67);
            this.txtDniIniciar.Name = "txtDniIniciar";
            this.txtDniIniciar.Size = new System.Drawing.Size(100, 20);
            this.txtDniIniciar.TabIndex = 8;
            // 
            // label10
            // 
            this.label10.AutoSize = true;
            this.label10.Location = new System.Drawing.Point(30, 70);
            this.label10.Name = "label10";
            this.label10.Size = new System.Drawing.Size(26, 13);
            this.label10.TabIndex = 7;
            this.label10.Text = "DNI";
            // 
            // txtClaveIniciar
            // 
            this.txtClaveIniciar.Location = new System.Drawing.Point(102, 97);
            this.txtClaveIniciar.MaxLength = 4;
            this.txtClaveIniciar.Name = "txtClaveIniciar";
            this.txtClaveIniciar.PasswordChar = '*';
            this.txtClaveIniciar.Size = new System.Drawing.Size(100, 20);
            this.txtClaveIniciar.TabIndex = 11;
            this.txtClaveIniciar.Visible = false;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(9, 104);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(87, 13);
            this.label1.TabIndex = 10;
            this.label1.Text = "Clave (4 dígitos):";
            // 
            // btnEntrar
            // 
            this.btnEntrar.Location = new System.Drawing.Point(206, 95);
            this.btnEntrar.Name = "btnEntrar";
            this.btnEntrar.Size = new System.Drawing.Size(75, 23);
            this.btnEntrar.TabIndex = 12;
            this.btnEntrar.Text = "Entrar";
            this.btnEntrar.UseVisualStyleBackColor = true;
            this.btnEntrar.Visible = false;
            this.btnEntrar.Click += new System.EventHandler(this.btnEntrar_Click);
            // 
            // btnCancelarSesión
            // 
            this.btnCancelarSesión.Location = new System.Drawing.Point(12, 142);
            this.btnCancelarSesión.Name = "btnCancelarSesión";
            this.btnCancelarSesión.Size = new System.Drawing.Size(75, 23);
            this.btnCancelarSesión.TabIndex = 13;
            this.btnCancelarSesión.Text = "Cancelar";
            this.btnCancelarSesión.UseVisualStyleBackColor = true;
            // 
            // FormPrincipalMartinez
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(851, 497);
            this.Controls.Add(this.gbInicioCajero);
            this.Controls.Add(this.gbConsulta);
            this.Controls.Add(this.gbAltas);
            this.Controls.Add(this.menuStrip1);
            this.MainMenuStrip = this.menuStrip1;
            this.Name = "FormPrincipalMartinez";
            this.Text = "Examen de Pedro Martínez Sánchez";
            this.menuStrip1.ResumeLayout(false);
            this.menuStrip1.PerformLayout();
            this.gbAltas.ResumeLayout(false);
            this.gbAltas.PerformLayout();
            this.gbConsulta.ResumeLayout(false);
            this.gbConsulta.PerformLayout();
            this.gbInicioCajero.ResumeLayout(false);
            this.gbInicioCajero.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.MenuStrip menuStrip1;
        private System.Windows.Forms.ToolStripMenuItem clienteToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem cajeroToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem tarjetaToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem autorToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem cerrarToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem altaToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem consultaToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem bloquearDesbloquearToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem pedroMartínezSánchezToolStripMenuItem;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Button btnCancelarAlta;
        private System.Windows.Forms.Button btnAlta;
        private System.Windows.Forms.TextBox txtSaldo;
        private System.Windows.Forms.TextBox txtClaveAlta;
        private System.Windows.Forms.TextBox txtNombreAlta;
        private System.Windows.Forms.TextBox txtDniAlta;
        private System.Windows.Forms.TextBox txtNombreBuscar;
        private System.Windows.Forms.Label label9;
        private System.Windows.Forms.ListBox listConsultar;
        private System.Windows.Forms.Label label8;
        private System.Windows.Forms.GroupBox gbAltas;
        private System.Windows.Forms.GroupBox gbConsulta;
        private System.Windows.Forms.CheckBox checkBloquear;
        private System.Windows.Forms.Button btnCancelarBusca;
        private System.Windows.Forms.Button btnBuscar;
        private System.Windows.Forms.GroupBox gbInicioCajero;
        private System.Windows.Forms.Label label7;
        private System.Windows.Forms.Button btnCancelarSesión;
        private System.Windows.Forms.Button btnEntrar;
        private System.Windows.Forms.TextBox txtClaveIniciar;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Button btnValidar;
        private System.Windows.Forms.TextBox txtDniIniciar;
        private System.Windows.Forms.Label label10;
    }
}

