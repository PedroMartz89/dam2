namespace ejercicio1Clases
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
            this.components = new System.ComponentModel.Container();
            this.menuStrip1 = new System.Windows.Forms.MenuStrip();
            this.menu = new System.Windows.Forms.ToolStripMenuItem();
            this.altasToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.pedidosToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.toolStripSeparator1 = new System.Windows.Forms.ToolStripSeparator();
            this.salirToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.consultasToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.porNombreToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.porCódigoToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.listadosToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.mínimosToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.porCategoríaToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.todosToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.acercaDeToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.autorToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.altasLabel = new System.Windows.Forms.Label();
            this.pnlAltas = new System.Windows.Forms.Panel();
            this.buttonCancelarAltas = new System.Windows.Forms.Button();
            this.buttonAceptarAltas = new System.Windows.Forms.Button();
            this.comboBoxCategoría = new System.Windows.Forms.ComboBox();
            this.textBoxExistencias = new System.Windows.Forms.TextBox();
            this.textBoxPrecio = new System.Windows.Forms.TextBox();
            this.textBoxNombre = new System.Windows.Forms.TextBox();
            this.textBoxCodigo = new System.Windows.Forms.TextBox();
            this.label4 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.labelCodigo = new System.Windows.Forms.Label();
            this.contextMenuStrip1 = new System.Windows.Forms.ContextMenuStrip(this.components);
            this.lblPedidos = new System.Windows.Forms.Label();
            this.pnlpPedidos = new System.Windows.Forms.Panel();
            this.bttnCancelarPedido = new System.Windows.Forms.Button();
            this.bttnAceptarPedido = new System.Windows.Forms.Button();
            this.tbCantidadPedido = new System.Windows.Forms.TextBox();
            this.tbCodigoPedido = new System.Windows.Forms.TextBox();
            this.label6 = new System.Windows.Forms.Label();
            this.label10 = new System.Windows.Forms.Label();
            this.bindingSource1 = new System.Windows.Forms.BindingSource(this.components);
            this.menuStrip1.SuspendLayout();
            this.pnlAltas.SuspendLayout();
            this.pnlpPedidos.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.bindingSource1)).BeginInit();
            this.SuspendLayout();
            // 
            // menuStrip1
            // 
            this.menuStrip1.ImageScalingSize = new System.Drawing.Size(24, 24);
            this.menuStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.menu,
            this.consultasToolStripMenuItem,
            this.listadosToolStripMenuItem,
            this.acercaDeToolStripMenuItem});
            this.menuStrip1.Location = new System.Drawing.Point(0, 0);
            this.menuStrip1.Name = "menuStrip1";
            this.menuStrip1.Padding = new System.Windows.Forms.Padding(4, 1, 0, 1);
            this.menuStrip1.Size = new System.Drawing.Size(592, 24);
            this.menuStrip1.TabIndex = 0;
            this.menuStrip1.Text = "menuStrip1";
            // 
            // menu
            // 
            this.menu.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.altasToolStripMenuItem,
            this.pedidosToolStripMenuItem,
            this.toolStripSeparator1,
            this.salirToolStripMenuItem});
            this.menu.Name = "menu";
            this.menu.Size = new System.Drawing.Size(66, 22);
            this.menu.Text = "Artículos";
            this.menu.Click += new System.EventHandler(this.toolStripMenuItem1_Click);
            // 
            // altasToolStripMenuItem
            // 
            this.altasToolStripMenuItem.Name = "altasToolStripMenuItem";
            this.altasToolStripMenuItem.Size = new System.Drawing.Size(180, 22);
            this.altasToolStripMenuItem.Text = "Altas";
            this.altasToolStripMenuItem.Click += new System.EventHandler(this.altasToolStripMenuItem_Click);
            // 
            // pedidosToolStripMenuItem
            // 
            this.pedidosToolStripMenuItem.Name = "pedidosToolStripMenuItem";
            this.pedidosToolStripMenuItem.Size = new System.Drawing.Size(180, 22);
            this.pedidosToolStripMenuItem.Text = "Pedidos";
            this.pedidosToolStripMenuItem.Click += new System.EventHandler(this.pedidosToolStripMenuItem_Click);
            // 
            // toolStripSeparator1
            // 
            this.toolStripSeparator1.Name = "toolStripSeparator1";
            this.toolStripSeparator1.Size = new System.Drawing.Size(177, 6);
            // 
            // salirToolStripMenuItem
            // 
            this.salirToolStripMenuItem.Name = "salirToolStripMenuItem";
            this.salirToolStripMenuItem.Size = new System.Drawing.Size(180, 22);
            this.salirToolStripMenuItem.Text = "Salir";
            this.salirToolStripMenuItem.Click += new System.EventHandler(this.salirToolStripMenuItem_Click);
            // 
            // consultasToolStripMenuItem
            // 
            this.consultasToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.porNombreToolStripMenuItem,
            this.porCódigoToolStripMenuItem});
            this.consultasToolStripMenuItem.Name = "consultasToolStripMenuItem";
            this.consultasToolStripMenuItem.Size = new System.Drawing.Size(71, 22);
            this.consultasToolStripMenuItem.Text = "Consultas";
            // 
            // porNombreToolStripMenuItem
            // 
            this.porNombreToolStripMenuItem.Name = "porNombreToolStripMenuItem";
            this.porNombreToolStripMenuItem.Size = new System.Drawing.Size(180, 22);
            this.porNombreToolStripMenuItem.Text = "Por nombre";
            this.porNombreToolStripMenuItem.Click += new System.EventHandler(this.porNombreToolStripMenuItem_Click);
            // 
            // porCódigoToolStripMenuItem
            // 
            this.porCódigoToolStripMenuItem.Name = "porCódigoToolStripMenuItem";
            this.porCódigoToolStripMenuItem.Size = new System.Drawing.Size(180, 22);
            this.porCódigoToolStripMenuItem.Text = "Por código";
            this.porCódigoToolStripMenuItem.Click += new System.EventHandler(this.porCódigoToolStripMenuItem_Click);
            // 
            // listadosToolStripMenuItem
            // 
            this.listadosToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.mínimosToolStripMenuItem,
            this.porCategoríaToolStripMenuItem,
            this.todosToolStripMenuItem});
            this.listadosToolStripMenuItem.Name = "listadosToolStripMenuItem";
            this.listadosToolStripMenuItem.Size = new System.Drawing.Size(62, 22);
            this.listadosToolStripMenuItem.Text = "Listados";
            // 
            // mínimosToolStripMenuItem
            // 
            this.mínimosToolStripMenuItem.Name = "mínimosToolStripMenuItem";
            this.mínimosToolStripMenuItem.Size = new System.Drawing.Size(180, 22);
            this.mínimosToolStripMenuItem.Text = "Mínimos";
            this.mínimosToolStripMenuItem.Click += new System.EventHandler(this.mínimosToolStripMenuItem_Click);
            // 
            // porCategoríaToolStripMenuItem
            // 
            this.porCategoríaToolStripMenuItem.Name = "porCategoríaToolStripMenuItem";
            this.porCategoríaToolStripMenuItem.Size = new System.Drawing.Size(180, 22);
            this.porCategoríaToolStripMenuItem.Text = "Por Categoría";
            this.porCategoríaToolStripMenuItem.Click += new System.EventHandler(this.porCategoríaToolStripMenuItem_Click);
            // 
            // todosToolStripMenuItem
            // 
            this.todosToolStripMenuItem.Name = "todosToolStripMenuItem";
            this.todosToolStripMenuItem.Size = new System.Drawing.Size(180, 22);
            this.todosToolStripMenuItem.Text = "Todos";
            this.todosToolStripMenuItem.Click += new System.EventHandler(this.todosToolStripMenuItem_Click);
            // 
            // acercaDeToolStripMenuItem
            // 
            this.acercaDeToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.autorToolStripMenuItem});
            this.acercaDeToolStripMenuItem.Name = "acercaDeToolStripMenuItem";
            this.acercaDeToolStripMenuItem.Size = new System.Drawing.Size(71, 22);
            this.acercaDeToolStripMenuItem.Text = "Acerca de";
            // 
            // autorToolStripMenuItem
            // 
            this.autorToolStripMenuItem.Name = "autorToolStripMenuItem";
            this.autorToolStripMenuItem.Size = new System.Drawing.Size(180, 22);
            this.autorToolStripMenuItem.Text = "Autor";
            this.autorToolStripMenuItem.Click += new System.EventHandler(this.autorToolStripMenuItem_Click);
            // 
            // altasLabel
            // 
            this.altasLabel.AutoSize = true;
            this.altasLabel.Location = new System.Drawing.Point(25, 64);
            this.altasLabel.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.altasLabel.Name = "altasLabel";
            this.altasLabel.Size = new System.Drawing.Size(30, 13);
            this.altasLabel.TabIndex = 1;
            this.altasLabel.Text = "Altas";
            this.altasLabel.Click += new System.EventHandler(this.altasLabel_Click);
            // 
            // pnlAltas
            // 
            this.pnlAltas.AccessibleName = "";
            this.pnlAltas.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.pnlAltas.Controls.Add(this.buttonCancelarAltas);
            this.pnlAltas.Controls.Add(this.buttonAceptarAltas);
            this.pnlAltas.Controls.Add(this.comboBoxCategoría);
            this.pnlAltas.Controls.Add(this.textBoxExistencias);
            this.pnlAltas.Controls.Add(this.textBoxPrecio);
            this.pnlAltas.Controls.Add(this.textBoxNombre);
            this.pnlAltas.Controls.Add(this.textBoxCodigo);
            this.pnlAltas.Controls.Add(this.label4);
            this.pnlAltas.Controls.Add(this.label3);
            this.pnlAltas.Controls.Add(this.label2);
            this.pnlAltas.Controls.Add(this.label1);
            this.pnlAltas.Controls.Add(this.labelCodigo);
            this.pnlAltas.Location = new System.Drawing.Point(28, 79);
            this.pnlAltas.Margin = new System.Windows.Forms.Padding(2);
            this.pnlAltas.Name = "pnlAltas";
            this.pnlAltas.Size = new System.Drawing.Size(262, 163);
            this.pnlAltas.TabIndex = 2;
            // 
            // buttonCancelarAltas
            // 
            this.buttonCancelarAltas.Location = new System.Drawing.Point(192, 119);
            this.buttonCancelarAltas.Margin = new System.Windows.Forms.Padding(2);
            this.buttonCancelarAltas.Name = "buttonCancelarAltas";
            this.buttonCancelarAltas.Size = new System.Drawing.Size(59, 23);
            this.buttonCancelarAltas.TabIndex = 11;
            this.buttonCancelarAltas.Text = "Cancelar";
            this.buttonCancelarAltas.UseVisualStyleBackColor = true;
            this.buttonCancelarAltas.Click += new System.EventHandler(this.buttonCancelarAltas_Click);
            // 
            // buttonAceptarAltas
            // 
            this.buttonAceptarAltas.Location = new System.Drawing.Point(192, 79);
            this.buttonAceptarAltas.Margin = new System.Windows.Forms.Padding(2);
            this.buttonAceptarAltas.Name = "buttonAceptarAltas";
            this.buttonAceptarAltas.Size = new System.Drawing.Size(59, 22);
            this.buttonAceptarAltas.TabIndex = 10;
            this.buttonAceptarAltas.Text = "Aceptar";
            this.buttonAceptarAltas.UseVisualStyleBackColor = true;
            this.buttonAceptarAltas.Click += new System.EventHandler(this.buttonAceptar_Click);
            // 
            // comboBoxCategoría
            // 
            this.comboBoxCategoría.FormattingEnabled = true;
            this.comboBoxCategoría.Location = new System.Drawing.Point(90, 79);
            this.comboBoxCategoría.Margin = new System.Windows.Forms.Padding(2);
            this.comboBoxCategoría.Name = "comboBoxCategoría";
            this.comboBoxCategoría.Size = new System.Drawing.Size(93, 21);
            this.comboBoxCategoría.TabIndex = 9;
            this.comboBoxCategoría.SelectedIndexChanged += new System.EventHandler(this.comboBoxCategoría_SelectedIndexChanged);
            // 
            // textBoxExistencias
            // 
            this.textBoxExistencias.Location = new System.Drawing.Point(90, 125);
            this.textBoxExistencias.Margin = new System.Windows.Forms.Padding(2);
            this.textBoxExistencias.Name = "textBoxExistencias";
            this.textBoxExistencias.Size = new System.Drawing.Size(93, 20);
            this.textBoxExistencias.TabIndex = 8;
            // 
            // textBoxPrecio
            // 
            this.textBoxPrecio.Location = new System.Drawing.Point(90, 101);
            this.textBoxPrecio.Margin = new System.Windows.Forms.Padding(2);
            this.textBoxPrecio.Name = "textBoxPrecio";
            this.textBoxPrecio.Size = new System.Drawing.Size(93, 20);
            this.textBoxPrecio.TabIndex = 7;
            // 
            // textBoxNombre
            // 
            this.textBoxNombre.Location = new System.Drawing.Point(90, 53);
            this.textBoxNombre.Margin = new System.Windows.Forms.Padding(2);
            this.textBoxNombre.Name = "textBoxNombre";
            this.textBoxNombre.Size = new System.Drawing.Size(93, 20);
            this.textBoxNombre.TabIndex = 6;
            // 
            // textBoxCodigo
            // 
            this.textBoxCodigo.Location = new System.Drawing.Point(90, 32);
            this.textBoxCodigo.Margin = new System.Windows.Forms.Padding(2);
            this.textBoxCodigo.Name = "textBoxCodigo";
            this.textBoxCodigo.Size = new System.Drawing.Size(93, 20);
            this.textBoxCodigo.TabIndex = 5;
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(29, 130);
            this.label4.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(55, 13);
            this.label4.TabIndex = 4;
            this.label4.Text = "Exitencias";
            this.label4.Click += new System.EventHandler(this.label4_Click);
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(29, 105);
            this.label3.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(37, 13);
            this.label3.TabIndex = 3;
            this.label3.Text = "Precio";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(29, 79);
            this.label2.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(54, 13);
            this.label2.TabIndex = 2;
            this.label2.Text = "Categoría";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(29, 57);
            this.label1.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(44, 13);
            this.label1.TabIndex = 1;
            this.label1.Text = "Nombre";
            this.label1.Click += new System.EventHandler(this.label1_Click);
            // 
            // labelCodigo
            // 
            this.labelCodigo.AutoSize = true;
            this.labelCodigo.Location = new System.Drawing.Point(29, 32);
            this.labelCodigo.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.labelCodigo.Name = "labelCodigo";
            this.labelCodigo.Size = new System.Drawing.Size(40, 13);
            this.labelCodigo.TabIndex = 0;
            this.labelCodigo.Text = "Código";
            // 
            // contextMenuStrip1
            // 
            this.contextMenuStrip1.Name = "contextMenuStrip1";
            this.contextMenuStrip1.Size = new System.Drawing.Size(61, 4);
            // 
            // lblPedidos
            // 
            this.lblPedidos.AutoSize = true;
            this.lblPedidos.Location = new System.Drawing.Point(294, 64);
            this.lblPedidos.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.lblPedidos.Name = "lblPedidos";
            this.lblPedidos.Size = new System.Drawing.Size(45, 13);
            this.lblPedidos.TabIndex = 4;
            this.lblPedidos.Text = "Pedidos";
            this.lblPedidos.Click += new System.EventHandler(this.label5_Click);
            // 
            // pnlpPedidos
            // 
            this.pnlpPedidos.AccessibleName = "";
            this.pnlpPedidos.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.pnlpPedidos.Controls.Add(this.bttnCancelarPedido);
            this.pnlpPedidos.Controls.Add(this.bttnAceptarPedido);
            this.pnlpPedidos.Controls.Add(this.tbCantidadPedido);
            this.pnlpPedidos.Controls.Add(this.tbCodigoPedido);
            this.pnlpPedidos.Controls.Add(this.label6);
            this.pnlpPedidos.Controls.Add(this.label10);
            this.pnlpPedidos.Location = new System.Drawing.Point(294, 79);
            this.pnlpPedidos.Margin = new System.Windows.Forms.Padding(2);
            this.pnlpPedidos.Name = "pnlpPedidos";
            this.pnlpPedidos.Size = new System.Drawing.Size(262, 163);
            this.pnlpPedidos.TabIndex = 5;
            this.pnlpPedidos.Paint += new System.Windows.Forms.PaintEventHandler(this.panel1_Paint);
            // 
            // bttnCancelarPedido
            // 
            this.bttnCancelarPedido.Location = new System.Drawing.Point(143, 122);
            this.bttnCancelarPedido.Margin = new System.Windows.Forms.Padding(2);
            this.bttnCancelarPedido.Name = "bttnCancelarPedido";
            this.bttnCancelarPedido.Size = new System.Drawing.Size(59, 23);
            this.bttnCancelarPedido.TabIndex = 11;
            this.bttnCancelarPedido.Text = "Cancelar";
            this.bttnCancelarPedido.UseVisualStyleBackColor = true;
            // 
            // bttnAceptarPedido
            // 
            this.bttnAceptarPedido.Location = new System.Drawing.Point(59, 121);
            this.bttnAceptarPedido.Margin = new System.Windows.Forms.Padding(2);
            this.bttnAceptarPedido.Name = "bttnAceptarPedido";
            this.bttnAceptarPedido.Size = new System.Drawing.Size(59, 22);
            this.bttnAceptarPedido.TabIndex = 10;
            this.bttnAceptarPedido.Text = "Aceptar";
            this.bttnAceptarPedido.UseVisualStyleBackColor = true;
            this.bttnAceptarPedido.Click += new System.EventHandler(this.bttnAceptarPedido_Click);
            // 
            // tbCantidadPedido
            // 
            this.tbCantidadPedido.Location = new System.Drawing.Point(88, 85);
            this.tbCantidadPedido.Margin = new System.Windows.Forms.Padding(2);
            this.tbCantidadPedido.Name = "tbCantidadPedido";
            this.tbCantidadPedido.Size = new System.Drawing.Size(93, 20);
            this.tbCantidadPedido.TabIndex = 8;
            // 
            // tbCodigoPedido
            // 
            this.tbCodigoPedido.Location = new System.Drawing.Point(90, 53);
            this.tbCodigoPedido.Margin = new System.Windows.Forms.Padding(2);
            this.tbCodigoPedido.Name = "tbCodigoPedido";
            this.tbCodigoPedido.Size = new System.Drawing.Size(93, 20);
            this.tbCodigoPedido.TabIndex = 5;
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Location = new System.Drawing.Point(29, 88);
            this.label6.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(49, 13);
            this.label6.TabIndex = 4;
            this.label6.Text = "Cantidad";
            // 
            // label10
            // 
            this.label10.AutoSize = true;
            this.label10.Location = new System.Drawing.Point(29, 57);
            this.label10.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.label10.Name = "label10";
            this.label10.Size = new System.Drawing.Size(40, 13);
            this.label10.TabIndex = 0;
            this.label10.Text = "Código";
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(592, 344);
            this.Controls.Add(this.lblPedidos);
            this.Controls.Add(this.pnlpPedidos);
            this.Controls.Add(this.altasLabel);
            this.Controls.Add(this.pnlAltas);
            this.Controls.Add(this.menuStrip1);
            this.MainMenuStrip = this.menuStrip1;
            this.Margin = new System.Windows.Forms.Padding(2);
            this.Name = "Form1";
            this.Text = "Form1";
            this.menuStrip1.ResumeLayout(false);
            this.menuStrip1.PerformLayout();
            this.pnlAltas.ResumeLayout(false);
            this.pnlAltas.PerformLayout();
            this.pnlpPedidos.ResumeLayout(false);
            this.pnlpPedidos.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.bindingSource1)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.MenuStrip menuStrip1;
        private System.Windows.Forms.ToolStripMenuItem menu;
        private System.Windows.Forms.ToolStripMenuItem altasToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem pedidosToolStripMenuItem;
        private System.Windows.Forms.ToolStripSeparator toolStripSeparator1;
        private System.Windows.Forms.ToolStripMenuItem salirToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem consultasToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem porNombreToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem porCódigoToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem listadosToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem mínimosToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem porCategoríaToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem todosToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem acercaDeToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem autorToolStripMenuItem;
        private System.Windows.Forms.BindingSource bindingSource1;
        private System.Windows.Forms.Label altasLabel;
        private System.Windows.Forms.Panel pnlAltas;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label labelCodigo;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.TextBox textBoxExistencias;
        private System.Windows.Forms.TextBox textBoxPrecio;
        private System.Windows.Forms.TextBox textBoxNombre;
        private System.Windows.Forms.TextBox textBoxCodigo;
        private System.Windows.Forms.Button buttonCancelarAltas;
        private System.Windows.Forms.Button buttonAceptarAltas;
        private System.Windows.Forms.ComboBox comboBoxCategoría;
        private System.Windows.Forms.ContextMenuStrip contextMenuStrip1;
        private System.Windows.Forms.Label lblPedidos;
        private System.Windows.Forms.Panel pnlpPedidos;
        private System.Windows.Forms.Button bttnCancelarPedido;
        private System.Windows.Forms.Button bttnAceptarPedido;
        private System.Windows.Forms.TextBox tbCantidadPedido;
        private System.Windows.Forms.TextBox tbCodigoPedido;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.Label label10;
    }
}

