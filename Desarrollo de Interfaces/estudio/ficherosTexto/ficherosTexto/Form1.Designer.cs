namespace ficherosTexto
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
            this.panel1 = new System.Windows.Forms.Panel();
            this.contextMenuStrip1 = new System.Windows.Forms.ContextMenuStrip(this.components);
            this.contextMenuStrip2 = new System.Windows.Forms.ContextMenuStrip(this.components);
            this.menuStrip1 = new System.Windows.Forms.MenuStrip();
            this.altasToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.consultasToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.guardarAgendaToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.guardarAgendaToolStripMenuItem1 = new System.Windows.Forms.ToolStripMenuItem();
            this.leerToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.leerAgendaPorInicialToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.eliminarContactoToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.performanceCounter1 = new System.Diagnostics.PerformanceCounter();
            this.panel1.SuspendLayout();
            this.menuStrip1.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.performanceCounter1)).BeginInit();
            this.SuspendLayout();
            // 
            // panel1
            // 
            this.panel1.Controls.Add(this.menuStrip1);
            this.panel1.Dock = System.Windows.Forms.DockStyle.Fill;
            this.panel1.Location = new System.Drawing.Point(0, 0);
            this.panel1.Name = "panel1";
            this.panel1.Size = new System.Drawing.Size(800, 450);
            this.panel1.TabIndex = 0;
            // 
            // contextMenuStrip1
            // 
            this.contextMenuStrip1.Name = "contextMenuStrip1";
            this.contextMenuStrip1.Size = new System.Drawing.Size(61, 4);
            // 
            // contextMenuStrip2
            // 
            this.contextMenuStrip2.Name = "contextMenuStrip2";
            this.contextMenuStrip2.Size = new System.Drawing.Size(61, 4);
            // 
            // menuStrip1
            // 
            this.menuStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.altasToolStripMenuItem,
            this.consultasToolStripMenuItem,
            this.guardarAgendaToolStripMenuItem,
            this.eliminarContactoToolStripMenuItem});
            this.menuStrip1.Location = new System.Drawing.Point(0, 0);
            this.menuStrip1.Name = "menuStrip1";
            this.menuStrip1.Size = new System.Drawing.Size(800, 24);
            this.menuStrip1.TabIndex = 4;
            this.menuStrip1.Text = "menuStrip1";
            // 
            // altasToolStripMenuItem
            // 
            this.altasToolStripMenuItem.Name = "altasToolStripMenuItem";
            this.altasToolStripMenuItem.Size = new System.Drawing.Size(45, 20);
            this.altasToolStripMenuItem.Text = "Altas";
            this.altasToolStripMenuItem.Click += new System.EventHandler(this.altasToolStripMenuItem_Click);
            // 
            // consultasToolStripMenuItem
            // 
            this.consultasToolStripMenuItem.Name = "consultasToolStripMenuItem";
            this.consultasToolStripMenuItem.Size = new System.Drawing.Size(71, 20);
            this.consultasToolStripMenuItem.Text = "Consultas";
            // 
            // guardarAgendaToolStripMenuItem
            // 
            this.guardarAgendaToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.guardarAgendaToolStripMenuItem1,
            this.leerToolStripMenuItem,
            this.leerAgendaPorInicialToolStripMenuItem});
            this.guardarAgendaToolStripMenuItem.Name = "guardarAgendaToolStripMenuItem";
            this.guardarAgendaToolStripMenuItem.Size = new System.Drawing.Size(60, 20);
            this.guardarAgendaToolStripMenuItem.Text = "Agenda";
            // 
            // guardarAgendaToolStripMenuItem1
            // 
            this.guardarAgendaToolStripMenuItem1.Name = "guardarAgendaToolStripMenuItem1";
            this.guardarAgendaToolStripMenuItem1.Size = new System.Drawing.Size(193, 22);
            this.guardarAgendaToolStripMenuItem1.Text = "Guardar Agenda";
            // 
            // leerToolStripMenuItem
            // 
            this.leerToolStripMenuItem.Name = "leerToolStripMenuItem";
            this.leerToolStripMenuItem.Size = new System.Drawing.Size(193, 22);
            this.leerToolStripMenuItem.Text = "Leer Agenda";
            this.leerToolStripMenuItem.Click += new System.EventHandler(this.leerToolStripMenuItem_Click);
            // 
            // leerAgendaPorInicialToolStripMenuItem
            // 
            this.leerAgendaPorInicialToolStripMenuItem.Name = "leerAgendaPorInicialToolStripMenuItem";
            this.leerAgendaPorInicialToolStripMenuItem.Size = new System.Drawing.Size(193, 22);
            this.leerAgendaPorInicialToolStripMenuItem.Text = "Leer agenda por inicial";
            // 
            // eliminarContactoToolStripMenuItem
            // 
            this.eliminarContactoToolStripMenuItem.Name = "eliminarContactoToolStripMenuItem";
            this.eliminarContactoToolStripMenuItem.Size = new System.Drawing.Size(114, 20);
            this.eliminarContactoToolStripMenuItem.Text = "Eliminar Contacto";
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.panel1);
            this.MainMenuStrip = this.menuStrip1;
            this.Name = "Form1";
            this.Text = "Form1";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.panel1.ResumeLayout(false);
            this.panel1.PerformLayout();
            this.menuStrip1.ResumeLayout(false);
            this.menuStrip1.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.performanceCounter1)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Panel panel1;
        private System.Windows.Forms.ContextMenuStrip contextMenuStrip1;
        private System.Windows.Forms.ContextMenuStrip contextMenuStrip2;
        private System.Windows.Forms.MenuStrip menuStrip1;
        private System.Windows.Forms.ToolStripMenuItem altasToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem consultasToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem guardarAgendaToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem guardarAgendaToolStripMenuItem1;
        private System.Windows.Forms.ToolStripMenuItem leerToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem leerAgendaPorInicialToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem eliminarContactoToolStripMenuItem;
    }
}

