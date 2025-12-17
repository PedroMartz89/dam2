namespace ExamenPedroMartinezSanchez
{
    partial class FormOperacionesCajeroMartinez
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(FormOperacionesCajeroMartinez));
            this.toolStrip1 = new System.Windows.Forms.ToolStrip();
            this.toolStripButton1 = new System.Windows.Forms.ToolStripButton();
            this.toolStripButton2 = new System.Windows.Forms.ToolStripButton();
            this.toolStripButton3 = new System.Windows.Forms.ToolStripButton();
            this.toolStripButton4 = new System.Windows.Forms.ToolStripButton();
            this.gbIngreso = new System.Windows.Forms.GroupBox();
            this.label1 = new System.Windows.Forms.Label();
            this.txtCantidad = new System.Windows.Forms.TextBox();
            this.btIngresar = new System.Windows.Forms.Button();
            this.btnCancelar = new System.Windows.Forms.Button();
            this.gbRetiro = new System.Windows.Forms.GroupBox();
            this.btnCancelarRetiro = new System.Windows.Forms.Button();
            this.btnRetirar = new System.Windows.Forms.Button();
            this.txtCantidadRetirar = new System.Windows.Forms.TextBox();
            this.label2 = new System.Windows.Forms.Label();
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.txtClaveAntigua = new System.Windows.Forms.TextBox();
            this.label3 = new System.Windows.Forms.Label();
            this.txtClaveNueva = new System.Windows.Forms.TextBox();
            this.label4 = new System.Windows.Forms.Label();
            this.txtRepetirClave = new System.Windows.Forms.TextBox();
            this.label5 = new System.Windows.Forms.Label();
            this.btnValidar = new System.Windows.Forms.Button();
            this.btnCambiar = new System.Windows.Forms.Button();
            this.btnCancelarCambio = new System.Windows.Forms.Button();
            this.checkBoxMostrar = new System.Windows.Forms.CheckBox();
            this.toolStrip1.SuspendLayout();
            this.gbIngreso.SuspendLayout();
            this.gbRetiro.SuspendLayout();
            this.groupBox1.SuspendLayout();
            this.SuspendLayout();
            // 
            // toolStrip1
            // 
            this.toolStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.toolStripButton1,
            this.toolStripButton2,
            this.toolStripButton3,
            this.toolStripButton4});
            this.toolStrip1.Location = new System.Drawing.Point(0, 0);
            this.toolStrip1.Name = "toolStrip1";
            this.toolStrip1.Size = new System.Drawing.Size(800, 25);
            this.toolStrip1.TabIndex = 0;
            this.toolStrip1.Text = "toolStrip1";
            // 
            // toolStripButton1
            // 
            this.toolStripButton1.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.toolStripButton1.Image = ((System.Drawing.Image)(resources.GetObject("toolStripButton1.Image")));
            this.toolStripButton1.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.toolStripButton1.Name = "toolStripButton1";
            this.toolStripButton1.Size = new System.Drawing.Size(23, 22);
            this.toolStripButton1.Text = "Ingreso";
            this.toolStripButton1.Click += new System.EventHandler(this.toolStripButton1_Click);
            // 
            // toolStripButton2
            // 
            this.toolStripButton2.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.toolStripButton2.Image = ((System.Drawing.Image)(resources.GetObject("toolStripButton2.Image")));
            this.toolStripButton2.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.toolStripButton2.Name = "toolStripButton2";
            this.toolStripButton2.Size = new System.Drawing.Size(23, 22);
            this.toolStripButton2.Text = "Reintegro";
            this.toolStripButton2.Click += new System.EventHandler(this.toolStripButton2_Click);
            // 
            // toolStripButton3
            // 
            this.toolStripButton3.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.toolStripButton3.Image = ((System.Drawing.Image)(resources.GetObject("toolStripButton3.Image")));
            this.toolStripButton3.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.toolStripButton3.Name = "toolStripButton3";
            this.toolStripButton3.Size = new System.Drawing.Size(23, 22);
            this.toolStripButton3.Text = "Cambiar clave";
            // 
            // toolStripButton4
            // 
            this.toolStripButton4.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.toolStripButton4.Image = ((System.Drawing.Image)(resources.GetObject("toolStripButton4.Image")));
            this.toolStripButton4.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.toolStripButton4.Name = "toolStripButton4";
            this.toolStripButton4.Size = new System.Drawing.Size(23, 22);
            this.toolStripButton4.Text = "Salir";
            this.toolStripButton4.Click += new System.EventHandler(this.toolStripButton4_Click);
            // 
            // gbIngreso
            // 
            this.gbIngreso.Controls.Add(this.btnCancelar);
            this.gbIngreso.Controls.Add(this.btIngresar);
            this.gbIngreso.Controls.Add(this.txtCantidad);
            this.gbIngreso.Controls.Add(this.label1);
            this.gbIngreso.Location = new System.Drawing.Point(67, 64);
            this.gbIngreso.Name = "gbIngreso";
            this.gbIngreso.Size = new System.Drawing.Size(248, 126);
            this.gbIngreso.TabIndex = 1;
            this.gbIngreso.TabStop = false;
            this.gbIngreso.Text = "Ingreso";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(27, 41);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(49, 13);
            this.label1.TabIndex = 0;
            this.label1.Text = "Cantidad";
            // 
            // txtCantidad
            // 
            this.txtCantidad.Location = new System.Drawing.Point(82, 38);
            this.txtCantidad.Name = "txtCantidad";
            this.txtCantidad.Size = new System.Drawing.Size(100, 20);
            this.txtCantidad.TabIndex = 1;
            // 
            // btIngresar
            // 
            this.btIngresar.Location = new System.Drawing.Point(30, 80);
            this.btIngresar.Name = "btIngresar";
            this.btIngresar.Size = new System.Drawing.Size(75, 23);
            this.btIngresar.TabIndex = 2;
            this.btIngresar.Text = "Ingresar";
            this.btIngresar.UseVisualStyleBackColor = true;
            this.btIngresar.Click += new System.EventHandler(this.btIngresar_Click);
            // 
            // btnCancelar
            // 
            this.btnCancelar.Location = new System.Drawing.Point(130, 80);
            this.btnCancelar.Name = "btnCancelar";
            this.btnCancelar.Size = new System.Drawing.Size(75, 23);
            this.btnCancelar.TabIndex = 3;
            this.btnCancelar.Text = "Cancelar";
            this.btnCancelar.UseVisualStyleBackColor = true;
            this.btnCancelar.Click += new System.EventHandler(this.btnCancelar_Click);
            // 
            // gbRetiro
            // 
            this.gbRetiro.Controls.Add(this.btnCancelarRetiro);
            this.gbRetiro.Controls.Add(this.btnRetirar);
            this.gbRetiro.Controls.Add(this.txtCantidadRetirar);
            this.gbRetiro.Controls.Add(this.label2);
            this.gbRetiro.Location = new System.Drawing.Point(337, 64);
            this.gbRetiro.Name = "gbRetiro";
            this.gbRetiro.Size = new System.Drawing.Size(248, 126);
            this.gbRetiro.TabIndex = 2;
            this.gbRetiro.TabStop = false;
            this.gbRetiro.Text = "Reintegro";
            // 
            // btnCancelarRetiro
            // 
            this.btnCancelarRetiro.Location = new System.Drawing.Point(130, 80);
            this.btnCancelarRetiro.Name = "btnCancelarRetiro";
            this.btnCancelarRetiro.Size = new System.Drawing.Size(75, 23);
            this.btnCancelarRetiro.TabIndex = 3;
            this.btnCancelarRetiro.Text = "Cancelar";
            this.btnCancelarRetiro.UseVisualStyleBackColor = true;
            // 
            // btnRetirar
            // 
            this.btnRetirar.Location = new System.Drawing.Point(30, 80);
            this.btnRetirar.Name = "btnRetirar";
            this.btnRetirar.Size = new System.Drawing.Size(75, 23);
            this.btnRetirar.TabIndex = 2;
            this.btnRetirar.Text = "Retirar";
            this.btnRetirar.UseVisualStyleBackColor = true;
            this.btnRetirar.Click += new System.EventHandler(this.btnRetirar_Click);
            // 
            // txtCantidadRetirar
            // 
            this.txtCantidadRetirar.Location = new System.Drawing.Point(82, 38);
            this.txtCantidadRetirar.Name = "txtCantidadRetirar";
            this.txtCantidadRetirar.Size = new System.Drawing.Size(100, 20);
            this.txtCantidadRetirar.TabIndex = 1;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(27, 41);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(49, 13);
            this.label2.TabIndex = 0;
            this.label2.Text = "Cantidad";
            // 
            // groupBox1
            // 
            this.groupBox1.Controls.Add(this.checkBoxMostrar);
            this.groupBox1.Controls.Add(this.btnCancelarCambio);
            this.groupBox1.Controls.Add(this.btnCambiar);
            this.groupBox1.Controls.Add(this.btnValidar);
            this.groupBox1.Controls.Add(this.txtRepetirClave);
            this.groupBox1.Controls.Add(this.label5);
            this.groupBox1.Controls.Add(this.txtClaveNueva);
            this.groupBox1.Controls.Add(this.label4);
            this.groupBox1.Controls.Add(this.txtClaveAntigua);
            this.groupBox1.Controls.Add(this.label3);
            this.groupBox1.Location = new System.Drawing.Point(67, 225);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(316, 165);
            this.groupBox1.TabIndex = 3;
            this.groupBox1.TabStop = false;
            this.groupBox1.Text = "Cambiar clave";
            // 
            // txtClaveAntigua
            // 
            this.txtClaveAntigua.Location = new System.Drawing.Point(103, 40);
            this.txtClaveAntigua.Name = "txtClaveAntigua";
            this.txtClaveAntigua.Size = new System.Drawing.Size(100, 20);
            this.txtClaveAntigua.TabIndex = 3;
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(27, 43);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(72, 13);
            this.label3.TabIndex = 2;
            this.label3.Text = "Clave antigua";
            // 
            // txtClaveNueva
            // 
            this.txtClaveNueva.Location = new System.Drawing.Point(105, 69);
            this.txtClaveNueva.Name = "txtClaveNueva";
            this.txtClaveNueva.ReadOnly = true;
            this.txtClaveNueva.Size = new System.Drawing.Size(100, 20);
            this.txtClaveNueva.TabIndex = 5;
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(27, 76);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(67, 13);
            this.label4.TabIndex = 4;
            this.label4.Text = "Clave nueva";
            // 
            // txtRepetirClave
            // 
            this.txtRepetirClave.Location = new System.Drawing.Point(105, 95);
            this.txtRepetirClave.Name = "txtRepetirClave";
            this.txtRepetirClave.ReadOnly = true;
            this.txtRepetirClave.Size = new System.Drawing.Size(100, 20);
            this.txtRepetirClave.TabIndex = 7;
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(27, 102);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(67, 13);
            this.label5.TabIndex = 6;
            this.label5.Text = "Repite clave";
            // 
            // btnValidar
            // 
            this.btnValidar.Location = new System.Drawing.Point(223, 33);
            this.btnValidar.Name = "btnValidar";
            this.btnValidar.Size = new System.Drawing.Size(75, 23);
            this.btnValidar.TabIndex = 8;
            this.btnValidar.Text = "Validar";
            this.btnValidar.UseVisualStyleBackColor = true;
            this.btnValidar.Click += new System.EventHandler(this.btnValidar_Click);
            // 
            // btnCambiar
            // 
            this.btnCambiar.Location = new System.Drawing.Point(223, 64);
            this.btnCambiar.Name = "btnCambiar";
            this.btnCambiar.Size = new System.Drawing.Size(75, 23);
            this.btnCambiar.TabIndex = 9;
            this.btnCambiar.Text = "Cambiar";
            this.btnCambiar.UseVisualStyleBackColor = true;
            this.btnCambiar.Click += new System.EventHandler(this.btnCambiar_Click);
            // 
            // btnCancelarCambio
            // 
            this.btnCancelarCambio.Location = new System.Drawing.Point(223, 121);
            this.btnCancelarCambio.Name = "btnCancelarCambio";
            this.btnCancelarCambio.Size = new System.Drawing.Size(75, 23);
            this.btnCancelarCambio.TabIndex = 10;
            this.btnCancelarCambio.Text = "Cancelar";
            this.btnCancelarCambio.UseVisualStyleBackColor = true;
            // 
            // checkBoxMostrar
            // 
            this.checkBoxMostrar.AutoSize = true;
            this.checkBoxMostrar.Location = new System.Drawing.Point(30, 127);
            this.checkBoxMostrar.Name = "checkBoxMostrar";
            this.checkBoxMostrar.Size = new System.Drawing.Size(122, 17);
            this.checkBoxMostrar.TabIndex = 11;
            this.checkBoxMostrar.Text = "Mostrar contraseñas";
            this.checkBoxMostrar.UseVisualStyleBackColor = true;
            this.checkBoxMostrar.CheckedChanged += new System.EventHandler(this.checkBoxMostrar_CheckedChanged);
            // 
            // FormOperacionesCajeroMartinez
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.groupBox1);
            this.Controls.Add(this.gbRetiro);
            this.Controls.Add(this.gbIngreso);
            this.Controls.Add(this.toolStrip1);
            this.Name = "FormOperacionesCajeroMartinez";
            this.Text = "FormOperacionesCajeroMartinez";
            this.Load += new System.EventHandler(this.FormOperacionesCajeroMartinez_Load);
            this.toolStrip1.ResumeLayout(false);
            this.toolStrip1.PerformLayout();
            this.gbIngreso.ResumeLayout(false);
            this.gbIngreso.PerformLayout();
            this.gbRetiro.ResumeLayout(false);
            this.gbRetiro.PerformLayout();
            this.groupBox1.ResumeLayout(false);
            this.groupBox1.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.ToolStrip toolStrip1;
        private System.Windows.Forms.ToolStripButton toolStripButton1;
        private System.Windows.Forms.ToolStripButton toolStripButton2;
        private System.Windows.Forms.ToolStripButton toolStripButton3;
        private System.Windows.Forms.ToolStripButton toolStripButton4;
        private System.Windows.Forms.GroupBox gbIngreso;
        private System.Windows.Forms.Button btnCancelar;
        private System.Windows.Forms.Button btIngresar;
        private System.Windows.Forms.TextBox txtCantidad;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.GroupBox gbRetiro;
        private System.Windows.Forms.Button btnCancelarRetiro;
        private System.Windows.Forms.Button btnRetirar;
        private System.Windows.Forms.TextBox txtCantidadRetirar;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.CheckBox checkBoxMostrar;
        private System.Windows.Forms.Button btnCancelarCambio;
        private System.Windows.Forms.Button btnCambiar;
        private System.Windows.Forms.Button btnValidar;
        private System.Windows.Forms.TextBox txtRepetirClave;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.TextBox txtClaveNueva;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.TextBox txtClaveAntigua;
        private System.Windows.Forms.Label label3;
    }
}