namespace practicaFicheros
{
    partial class Agenda
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
            this.contextMenuStrip1 = new System.Windows.Forms.ContextMenuStrip(this.components);
            this.menuStrip1 = new System.Windows.Forms.MenuStrip();
            this.altasToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.altasToolStripMenuItem1 = new System.Windows.Forms.ToolStripMenuItem();
            this.consultarTelefonoToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.eliminarContactosToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.ficherosToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.guardarToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.guardarAgendaPorInicialToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.leerAgendaToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.leerAgendaPorInicialToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.salirToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.menuStrip1.SuspendLayout();
            this.SuspendLayout();
            // 
            // contextMenuStrip1
            // 
            this.contextMenuStrip1.Name = "contextMenuStrip1";
            this.contextMenuStrip1.Size = new System.Drawing.Size(61, 4);
            // 
            // menuStrip1
            // 
            this.menuStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.altasToolStripMenuItem,
            this.ficherosToolStripMenuItem,
            this.salirToolStripMenuItem});
            this.menuStrip1.Location = new System.Drawing.Point(0, 0);
            this.menuStrip1.Name = "menuStrip1";
            this.menuStrip1.Size = new System.Drawing.Size(800, 24);
            this.menuStrip1.TabIndex = 1;
            this.menuStrip1.Text = "menuStrip1";
            // 
            // altasToolStripMenuItem
            // 
            this.altasToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.altasToolStripMenuItem1,
            this.consultarTelefonoToolStripMenuItem,
            this.eliminarContactosToolStripMenuItem});
            this.altasToolStripMenuItem.Name = "altasToolStripMenuItem";
            this.altasToolStripMenuItem.Size = new System.Drawing.Size(73, 20);
            this.altasToolStripMenuItem.Text = "Contactos";
            this.altasToolStripMenuItem.Click += new System.EventHandler(this.altasToolStripMenuItem_Click);
            // 
            // altasToolStripMenuItem1
            // 
            this.altasToolStripMenuItem1.Name = "altasToolStripMenuItem1";
            this.altasToolStripMenuItem1.Size = new System.Drawing.Size(180, 22);
            this.altasToolStripMenuItem1.Text = "Altas";
            this.altasToolStripMenuItem1.Click += new System.EventHandler(this.altasToolStripMenuItem1_Click);
            // 
            // consultarTelefonoToolStripMenuItem
            // 
            this.consultarTelefonoToolStripMenuItem.Name = "consultarTelefonoToolStripMenuItem";
            this.consultarTelefonoToolStripMenuItem.Size = new System.Drawing.Size(180, 22);
            this.consultarTelefonoToolStripMenuItem.Text = "Consultar telefono";
            this.consultarTelefonoToolStripMenuItem.Click += new System.EventHandler(this.consultarTelefonoToolStripMenuItem_Click);
            // 
            // eliminarContactosToolStripMenuItem
            // 
            this.eliminarContactosToolStripMenuItem.Name = "eliminarContactosToolStripMenuItem";
            this.eliminarContactosToolStripMenuItem.Size = new System.Drawing.Size(180, 22);
            this.eliminarContactosToolStripMenuItem.Text = "Eliminar contactos";
            this.eliminarContactosToolStripMenuItem.Click += new System.EventHandler(this.eliminarContactosToolStripMenuItem_Click);
            // 
            // ficherosToolStripMenuItem
            // 
            this.ficherosToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.guardarToolStripMenuItem,
            this.guardarAgendaPorInicialToolStripMenuItem,
            this.leerAgendaToolStripMenuItem,
            this.leerAgendaPorInicialToolStripMenuItem});
            this.ficherosToolStripMenuItem.Name = "ficherosToolStripMenuItem";
            this.ficherosToolStripMenuItem.Size = new System.Drawing.Size(63, 20);
            this.ficherosToolStripMenuItem.Text = "Ficheros";
            // 
            // guardarToolStripMenuItem
            // 
            this.guardarToolStripMenuItem.Name = "guardarToolStripMenuItem";
            this.guardarToolStripMenuItem.Size = new System.Drawing.Size(213, 22);
            this.guardarToolStripMenuItem.Text = "Guardar agenda";
            this.guardarToolStripMenuItem.Click += new System.EventHandler(this.guardarToolStripMenuItem_Click);
            // 
            // guardarAgendaPorInicialToolStripMenuItem
            // 
            this.guardarAgendaPorInicialToolStripMenuItem.Name = "guardarAgendaPorInicialToolStripMenuItem";
            this.guardarAgendaPorInicialToolStripMenuItem.Size = new System.Drawing.Size(213, 22);
            this.guardarAgendaPorInicialToolStripMenuItem.Text = "Guardar agenda por inicial";
            this.guardarAgendaPorInicialToolStripMenuItem.Click += new System.EventHandler(this.guardarAgendaPorInicialToolStripMenuItem_Click);
            // 
            // leerAgendaToolStripMenuItem
            // 
            this.leerAgendaToolStripMenuItem.Name = "leerAgendaToolStripMenuItem";
            this.leerAgendaToolStripMenuItem.Size = new System.Drawing.Size(213, 22);
            this.leerAgendaToolStripMenuItem.Text = "Leer agenda";
            this.leerAgendaToolStripMenuItem.Click += new System.EventHandler(this.leerAgendaToolStripMenuItem_Click);
            // 
            // leerAgendaPorInicialToolStripMenuItem
            // 
            this.leerAgendaPorInicialToolStripMenuItem.Name = "leerAgendaPorInicialToolStripMenuItem";
            this.leerAgendaPorInicialToolStripMenuItem.Size = new System.Drawing.Size(213, 22);
            this.leerAgendaPorInicialToolStripMenuItem.Text = "Leer agenda por inicial";
            // 
            // salirToolStripMenuItem
            // 
            this.salirToolStripMenuItem.Name = "salirToolStripMenuItem";
            this.salirToolStripMenuItem.Size = new System.Drawing.Size(41, 20);
            this.salirToolStripMenuItem.Text = "Salir";
            // 
            // Agenda
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.menuStrip1);
            this.Name = "Agenda";
            this.Text = "Form1";
            this.menuStrip1.ResumeLayout(false);
            this.menuStrip1.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.ContextMenuStrip contextMenuStrip1;
        private System.Windows.Forms.MenuStrip menuStrip1;
        private System.Windows.Forms.ToolStripMenuItem altasToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem altasToolStripMenuItem1;
        private System.Windows.Forms.ToolStripMenuItem consultarTelefonoToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem eliminarContactosToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem ficherosToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem guardarToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem guardarAgendaPorInicialToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem leerAgendaToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem leerAgendaPorInicialToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem salirToolStripMenuItem;
    }
}

