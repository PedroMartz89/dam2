namespace ejercicio1Clases
{
    partial class Form2
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
            this.listView1 = new System.Windows.Forms.ListView();
            this.lblListadoTodos = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // listView1
            // 
            this.listView1.HideSelection = false;
            this.listView1.Location = new System.Drawing.Point(133, 122);
            this.listView1.Name = "listView1";
            this.listView1.Size = new System.Drawing.Size(522, 231);
            this.listView1.TabIndex = 0;
            this.listView1.UseCompatibleStateImageBehavior = false;
            this.listView1.View = System.Windows.Forms.View.List;
            // 
            // lblListadoTodos
            // 
            this.lblListadoTodos.AutoSize = true;
            this.lblListadoTodos.Font = new System.Drawing.Font("Microsoft Sans Serif", 25F);
            this.lblListadoTodos.Location = new System.Drawing.Point(225, 45);
            this.lblListadoTodos.Name = "lblListadoTodos";
            this.lblListadoTodos.Size = new System.Drawing.Size(310, 39);
            this.lblListadoTodos.TabIndex = 1;
            this.lblListadoTodos.Text = "Listado de artículos";
            this.lblListadoTodos.Click += new System.EventHandler(this.lblListadoTodos_Click);
            // 
            // Form2
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.lblListadoTodos);
            this.Controls.Add(this.listView1);
            this.Name = "Form2";
            this.Text = "Form2";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.ListView listView1;
        private System.Windows.Forms.Label lblListadoTodos;
    }
}