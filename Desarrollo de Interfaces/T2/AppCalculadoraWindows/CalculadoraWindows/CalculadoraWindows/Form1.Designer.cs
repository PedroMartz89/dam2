namespace CalculadoraWindows
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
            this.splitContainer1 = new System.Windows.Forms.SplitContainer();
            this.label1 = new System.Windows.Forms.Label();
            this.lbHistorial = new System.Windows.Forms.ListBox();
            this.txtDisplay = new System.Windows.Forms.TextBox();
            this.tlpTeclado = new System.Windows.Forms.TableLayoutPanel();
            this.btn1 = new System.Windows.Forms.Button();
            this.btn2 = new System.Windows.Forms.Button();
            this.btn3 = new System.Windows.Forms.Button();
            this.btnMulti = new System.Windows.Forms.Button();
            this.btn4 = new System.Windows.Forms.Button();
            this.btn5 = new System.Windows.Forms.Button();
            this.btn6 = new System.Windows.Forms.Button();
            this.btnDiv = new System.Windows.Forms.Button();
            this.btn7 = new System.Windows.Forms.Button();
            this.btn8 = new System.Windows.Forms.Button();
            this.btn9 = new System.Windows.Forms.Button();
            this.btnRest = new System.Windows.Forms.Button();
            this.btnMasMenos = new System.Windows.Forms.Button();
            this.btn0 = new System.Windows.Forms.Button();
            this.btnComa = new System.Windows.Forms.Button();
            this.btnSum = new System.Windows.Forms.Button();
            this.btnIgual = new System.Windows.Forms.Button();
            this.btnCE = new System.Windows.Forms.Button();
            ((System.ComponentModel.ISupportInitialize)(this.splitContainer1)).BeginInit();
            this.splitContainer1.Panel1.SuspendLayout();
            this.splitContainer1.Panel2.SuspendLayout();
            this.splitContainer1.SuspendLayout();
            this.tlpTeclado.SuspendLayout();
            this.SuspendLayout();
            // 
            // splitContainer1
            // 
            this.splitContainer1.Dock = System.Windows.Forms.DockStyle.Fill;
            this.splitContainer1.Location = new System.Drawing.Point(0, 0);
            this.splitContainer1.Name = "splitContainer1";
            // 
            // splitContainer1.Panel1
            // 
            this.splitContainer1.Panel1.Controls.Add(this.tlpTeclado);
            this.splitContainer1.Panel1.Controls.Add(this.txtDisplay);
            this.splitContainer1.Panel1.RightToLeft = System.Windows.Forms.RightToLeft.No;
            // 
            // splitContainer1.Panel2
            // 
            this.splitContainer1.Panel2.Controls.Add(this.lbHistorial);
            this.splitContainer1.Panel2.Controls.Add(this.label1);
            this.splitContainer1.Panel2.RightToLeft = System.Windows.Forms.RightToLeft.No;
            this.splitContainer1.Panel2MinSize = 140;
            this.splitContainer1.Size = new System.Drawing.Size(800, 450);
            this.splitContainer1.SplitterDistance = 600;
            this.splitContainer1.TabIndex = 0;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Dock = System.Windows.Forms.DockStyle.Top;
            this.label1.Location = new System.Drawing.Point(0, 0);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(44, 13);
            this.label1.TabIndex = 0;
            this.label1.Text = "Historial";
            // 
            // lbHistorial
            // 
            this.lbHistorial.Dock = System.Windows.Forms.DockStyle.Fill;
            this.lbHistorial.FormattingEnabled = true;
            this.lbHistorial.Location = new System.Drawing.Point(0, 13);
            this.lbHistorial.Name = "lbHistorial";
            this.lbHistorial.Size = new System.Drawing.Size(196, 437);
            this.lbHistorial.TabIndex = 1;
            // 
            // txtDisplay
            // 
            this.txtDisplay.Dock = System.Windows.Forms.DockStyle.Top;
            this.txtDisplay.Font = new System.Drawing.Font("Microsoft Sans Serif", 16F);
            this.txtDisplay.Location = new System.Drawing.Point(0, 0);
            this.txtDisplay.Multiline = true;
            this.txtDisplay.Name = "txtDisplay";
            this.txtDisplay.ReadOnly = true;
            this.txtDisplay.Size = new System.Drawing.Size(600, 36);
            this.txtDisplay.TabIndex = 0;
            this.txtDisplay.Text = "0";
            this.txtDisplay.TextAlign = System.Windows.Forms.HorizontalAlignment.Right;
            // 
            // tlpTeclado
            // 
            this.tlpTeclado.ColumnCount = 5;
            this.tlpTeclado.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 20F));
            this.tlpTeclado.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 20F));
            this.tlpTeclado.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 20F));
            this.tlpTeclado.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 20F));
            this.tlpTeclado.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 20F));
            this.tlpTeclado.Controls.Add(this.btnCE, 4, 0);
            this.tlpTeclado.Controls.Add(this.btnIgual, 4, 2);
            this.tlpTeclado.Controls.Add(this.btnSum, 3, 3);
            this.tlpTeclado.Controls.Add(this.btnComa, 2, 3);
            this.tlpTeclado.Controls.Add(this.btn0, 1, 3);
            this.tlpTeclado.Controls.Add(this.btnMasMenos, 0, 3);
            this.tlpTeclado.Controls.Add(this.btnRest, 3, 2);
            this.tlpTeclado.Controls.Add(this.btn9, 2, 2);
            this.tlpTeclado.Controls.Add(this.btn8, 1, 2);
            this.tlpTeclado.Controls.Add(this.btn7, 0, 2);
            this.tlpTeclado.Controls.Add(this.btnDiv, 3, 1);
            this.tlpTeclado.Controls.Add(this.btn6, 2, 1);
            this.tlpTeclado.Controls.Add(this.btn5, 1, 1);
            this.tlpTeclado.Controls.Add(this.btn4, 0, 1);
            this.tlpTeclado.Controls.Add(this.btnMulti, 3, 0);
            this.tlpTeclado.Controls.Add(this.btn3, 2, 0);
            this.tlpTeclado.Controls.Add(this.btn2, 1, 0);
            this.tlpTeclado.Controls.Add(this.btn1, 0, 0);
            this.tlpTeclado.Dock = System.Windows.Forms.DockStyle.Fill;
            this.tlpTeclado.Location = new System.Drawing.Point(0, 36);
            this.tlpTeclado.Margin = new System.Windows.Forms.Padding(0);
            this.tlpTeclado.Name = "tlpTeclado";
            this.tlpTeclado.Padding = new System.Windows.Forms.Padding(6);
            this.tlpTeclado.RowCount = 4;
            this.tlpTeclado.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Percent, 20F));
            this.tlpTeclado.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Percent, 20F));
            this.tlpTeclado.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Percent, 20F));
            this.tlpTeclado.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Percent, 20F));
            this.tlpTeclado.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Percent, 20F));
            this.tlpTeclado.Size = new System.Drawing.Size(600, 414);
            this.tlpTeclado.TabIndex = 1;
            // 
            // btn1
            // 
            this.btn1.Dock = System.Windows.Forms.DockStyle.Fill;
            this.btn1.Font = new System.Drawing.Font("Microsoft Sans Serif", 16F);
            this.btn1.Location = new System.Drawing.Point(12, 12);
            this.btn1.Margin = new System.Windows.Forms.Padding(6);
            this.btn1.Name = "btn1";
            this.btn1.Size = new System.Drawing.Size(105, 88);
            this.btn1.TabIndex = 0;
            this.btn1.Text = "1";
            this.btn1.UseVisualStyleBackColor = true;
            // 
            // btn2
            // 
            this.btn2.Dock = System.Windows.Forms.DockStyle.Fill;
            this.btn2.Font = new System.Drawing.Font("Microsoft Sans Serif", 16F);
            this.btn2.Location = new System.Drawing.Point(129, 12);
            this.btn2.Margin = new System.Windows.Forms.Padding(6);
            this.btn2.Name = "btn2";
            this.btn2.Size = new System.Drawing.Size(105, 88);
            this.btn2.TabIndex = 1;
            this.btn2.Text = "2";
            this.btn2.UseVisualStyleBackColor = true;
            // 
            // btn3
            // 
            this.btn3.Dock = System.Windows.Forms.DockStyle.Fill;
            this.btn3.Font = new System.Drawing.Font("Microsoft Sans Serif", 16F);
            this.btn3.Location = new System.Drawing.Point(246, 12);
            this.btn3.Margin = new System.Windows.Forms.Padding(6);
            this.btn3.Name = "btn3";
            this.btn3.Size = new System.Drawing.Size(105, 88);
            this.btn3.TabIndex = 2;
            this.btn3.Text = "3";
            this.btn3.UseVisualStyleBackColor = true;
            // 
            // btnMulti
            // 
            this.btnMulti.Dock = System.Windows.Forms.DockStyle.Fill;
            this.btnMulti.Font = new System.Drawing.Font("Microsoft Sans Serif", 16F);
            this.btnMulti.Location = new System.Drawing.Point(363, 12);
            this.btnMulti.Margin = new System.Windows.Forms.Padding(6);
            this.btnMulti.Name = "btnMulti";
            this.btnMulti.Size = new System.Drawing.Size(105, 88);
            this.btnMulti.TabIndex = 3;
            this.btnMulti.Text = "*";
            this.btnMulti.UseVisualStyleBackColor = true;
            // 
            // btn4
            // 
            this.btn4.Dock = System.Windows.Forms.DockStyle.Fill;
            this.btn4.Font = new System.Drawing.Font("Microsoft Sans Serif", 16F);
            this.btn4.Location = new System.Drawing.Point(12, 112);
            this.btn4.Margin = new System.Windows.Forms.Padding(6);
            this.btn4.Name = "btn4";
            this.btn4.Size = new System.Drawing.Size(105, 88);
            this.btn4.TabIndex = 5;
            this.btn4.Text = "4";
            this.btn4.UseVisualStyleBackColor = true;
            // 
            // btn5
            // 
            this.btn5.Dock = System.Windows.Forms.DockStyle.Fill;
            this.btn5.Font = new System.Drawing.Font("Microsoft Sans Serif", 16F);
            this.btn5.Location = new System.Drawing.Point(129, 112);
            this.btn5.Margin = new System.Windows.Forms.Padding(6);
            this.btn5.Name = "btn5";
            this.btn5.Size = new System.Drawing.Size(105, 88);
            this.btn5.TabIndex = 6;
            this.btn5.Text = "5";
            this.btn5.UseVisualStyleBackColor = true;
            // 
            // btn6
            // 
            this.btn6.Dock = System.Windows.Forms.DockStyle.Fill;
            this.btn6.Font = new System.Drawing.Font("Microsoft Sans Serif", 16F);
            this.btn6.Location = new System.Drawing.Point(246, 112);
            this.btn6.Margin = new System.Windows.Forms.Padding(6);
            this.btn6.Name = "btn6";
            this.btn6.Size = new System.Drawing.Size(105, 88);
            this.btn6.TabIndex = 7;
            this.btn6.Text = "6";
            this.btn6.UseVisualStyleBackColor = true;
            // 
            // btnDiv
            // 
            this.btnDiv.Dock = System.Windows.Forms.DockStyle.Fill;
            this.btnDiv.Font = new System.Drawing.Font("Microsoft Sans Serif", 16F);
            this.btnDiv.Location = new System.Drawing.Point(363, 112);
            this.btnDiv.Margin = new System.Windows.Forms.Padding(6);
            this.btnDiv.Name = "btnDiv";
            this.btnDiv.Size = new System.Drawing.Size(105, 88);
            this.btnDiv.TabIndex = 8;
            this.btnDiv.Text = "/";
            this.btnDiv.UseVisualStyleBackColor = true;
            // 
            // btn7
            // 
            this.btn7.Dock = System.Windows.Forms.DockStyle.Fill;
            this.btn7.Font = new System.Drawing.Font("Microsoft Sans Serif", 16F);
            this.btn7.Location = new System.Drawing.Point(12, 212);
            this.btn7.Margin = new System.Windows.Forms.Padding(6);
            this.btn7.Name = "btn7";
            this.btn7.Size = new System.Drawing.Size(105, 88);
            this.btn7.TabIndex = 10;
            this.btn7.Text = "7";
            this.btn7.UseVisualStyleBackColor = true;
            // 
            // btn8
            // 
            this.btn8.Dock = System.Windows.Forms.DockStyle.Fill;
            this.btn8.Font = new System.Drawing.Font("Microsoft Sans Serif", 16F);
            this.btn8.Location = new System.Drawing.Point(129, 212);
            this.btn8.Margin = new System.Windows.Forms.Padding(6);
            this.btn8.Name = "btn8";
            this.btn8.Size = new System.Drawing.Size(105, 88);
            this.btn8.TabIndex = 11;
            this.btn8.Text = "8";
            this.btn8.UseVisualStyleBackColor = true;
            // 
            // btn9
            // 
            this.btn9.Dock = System.Windows.Forms.DockStyle.Fill;
            this.btn9.Font = new System.Drawing.Font("Microsoft Sans Serif", 16F);
            this.btn9.Location = new System.Drawing.Point(246, 212);
            this.btn9.Margin = new System.Windows.Forms.Padding(6);
            this.btn9.Name = "btn9";
            this.btn9.Size = new System.Drawing.Size(105, 88);
            this.btn9.TabIndex = 12;
            this.btn9.Text = "9";
            this.btn9.UseVisualStyleBackColor = true;
            // 
            // btnRest
            // 
            this.btnRest.Dock = System.Windows.Forms.DockStyle.Fill;
            this.btnRest.Font = new System.Drawing.Font("Microsoft Sans Serif", 16F);
            this.btnRest.Location = new System.Drawing.Point(363, 212);
            this.btnRest.Margin = new System.Windows.Forms.Padding(6);
            this.btnRest.Name = "btnRest";
            this.btnRest.Size = new System.Drawing.Size(105, 88);
            this.btnRest.TabIndex = 13;
            this.btnRest.Text = "-";
            this.btnRest.UseVisualStyleBackColor = true;
            // 
            // btnMasMenos
            // 
            this.btnMasMenos.Dock = System.Windows.Forms.DockStyle.Fill;
            this.btnMasMenos.Font = new System.Drawing.Font("Microsoft Sans Serif", 16F);
            this.btnMasMenos.Location = new System.Drawing.Point(12, 312);
            this.btnMasMenos.Margin = new System.Windows.Forms.Padding(6);
            this.btnMasMenos.Name = "btnMasMenos";
            this.btnMasMenos.Size = new System.Drawing.Size(105, 90);
            this.btnMasMenos.TabIndex = 15;
            this.btnMasMenos.Text = "+/-";
            this.btnMasMenos.UseVisualStyleBackColor = true;
            // 
            // btn0
            // 
            this.btn0.Dock = System.Windows.Forms.DockStyle.Fill;
            this.btn0.Font = new System.Drawing.Font("Microsoft Sans Serif", 16F);
            this.btn0.Location = new System.Drawing.Point(129, 312);
            this.btn0.Margin = new System.Windows.Forms.Padding(6);
            this.btn0.Name = "btn0";
            this.btn0.Size = new System.Drawing.Size(105, 90);
            this.btn0.TabIndex = 16;
            this.btn0.Text = "0";
            this.btn0.UseVisualStyleBackColor = true;
            // 
            // btnComa
            // 
            this.btnComa.Dock = System.Windows.Forms.DockStyle.Fill;
            this.btnComa.Font = new System.Drawing.Font("Microsoft Sans Serif", 16F);
            this.btnComa.Location = new System.Drawing.Point(246, 312);
            this.btnComa.Margin = new System.Windows.Forms.Padding(6);
            this.btnComa.Name = "btnComa";
            this.btnComa.Size = new System.Drawing.Size(105, 90);
            this.btnComa.TabIndex = 17;
            this.btnComa.Text = ",";
            this.btnComa.UseVisualStyleBackColor = true;
            // 
            // btnSum
            // 
            this.btnSum.Dock = System.Windows.Forms.DockStyle.Fill;
            this.btnSum.Font = new System.Drawing.Font("Microsoft Sans Serif", 16F);
            this.btnSum.Location = new System.Drawing.Point(363, 312);
            this.btnSum.Margin = new System.Windows.Forms.Padding(6);
            this.btnSum.Name = "btnSum";
            this.btnSum.Size = new System.Drawing.Size(105, 90);
            this.btnSum.TabIndex = 18;
            this.btnSum.Text = "+";
            this.btnSum.UseVisualStyleBackColor = true;
            // 
            // btnIgual
            // 
            this.btnIgual.Dock = System.Windows.Forms.DockStyle.Fill;
            this.btnIgual.Font = new System.Drawing.Font("Microsoft Sans Serif", 16F);
            this.btnIgual.Location = new System.Drawing.Point(480, 212);
            this.btnIgual.Margin = new System.Windows.Forms.Padding(6);
            this.btnIgual.Name = "btnIgual";
            this.tlpTeclado.SetRowSpan(this.btnIgual, 2);
            this.btnIgual.Size = new System.Drawing.Size(108, 190);
            this.btnIgual.TabIndex = 29;
            this.btnIgual.Text = "=";
            this.btnIgual.UseVisualStyleBackColor = true;
            // 
            // btnCE
            // 
            this.btnCE.Dock = System.Windows.Forms.DockStyle.Fill;
            this.btnCE.Font = new System.Drawing.Font("Microsoft Sans Serif", 16F);
            this.btnCE.Location = new System.Drawing.Point(480, 12);
            this.btnCE.Margin = new System.Windows.Forms.Padding(6);
            this.btnCE.Name = "btnCE";
            this.tlpTeclado.SetRowSpan(this.btnCE, 2);
            this.btnCE.Size = new System.Drawing.Size(108, 188);
            this.btnCE.TabIndex = 30;
            this.btnCE.Text = "CE";
            this.btnCE.UseVisualStyleBackColor = true;
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.splitContainer1);
            this.Name = "Form1";
            this.Text = "Calculadora Windows";
            this.splitContainer1.Panel1.ResumeLayout(false);
            this.splitContainer1.Panel1.PerformLayout();
            this.splitContainer1.Panel2.ResumeLayout(false);
            this.splitContainer1.Panel2.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.splitContainer1)).EndInit();
            this.splitContainer1.ResumeLayout(false);
            this.tlpTeclado.ResumeLayout(false);
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.SplitContainer splitContainer1;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.ListBox lbHistorial;
        private System.Windows.Forms.TextBox txtDisplay;
        private System.Windows.Forms.TableLayoutPanel tlpTeclado;
        private System.Windows.Forms.Button btnSum;
        private System.Windows.Forms.Button btnComa;
        private System.Windows.Forms.Button btn0;
        private System.Windows.Forms.Button btnMasMenos;
        private System.Windows.Forms.Button btnRest;
        private System.Windows.Forms.Button btn9;
        private System.Windows.Forms.Button btn8;
        private System.Windows.Forms.Button btn7;
        private System.Windows.Forms.Button btnDiv;
        private System.Windows.Forms.Button btn6;
        private System.Windows.Forms.Button btn5;
        private System.Windows.Forms.Button btn4;
        private System.Windows.Forms.Button btnMulti;
        private System.Windows.Forms.Button btn3;
        private System.Windows.Forms.Button btn2;
        private System.Windows.Forms.Button btn1;
        private System.Windows.Forms.Button btnCE;
        private System.Windows.Forms.Button btnIgual;
    }
}

