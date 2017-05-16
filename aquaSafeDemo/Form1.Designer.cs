namespace aquaSafeDemo$safeprojectname$
{
    partial class Form1
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
        System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Form1));
        this.temp = new System.Windows.Forms.Label();
        this.button1 = new System.Windows.Forms.Button();
        this.tbPort = new System.Windows.Forms.TextBox();
        this.tbTemp = new System.Windows.Forms.TextBox();
        this.tbConductivity = new System.Windows.Forms.TextBox();
        this.label1 = new System.Windows.Forms.Label();
        this.label2 = new System.Windows.Forms.Label();
        this.tbDate = new System.Windows.Forms.TextBox();
        this.tbTime = new System.Windows.Forms.TextBox();
        this.label3 = new System.Windows.Forms.Label();
        this.trackBar1 = new System.Windows.Forms.TrackBar();
        this.label4 = new System.Windows.Forms.Label();
        this.label5 = new System.Windows.Forms.Label();
        this.label6 = new System.Windows.Forms.Label();
        this.label7 = new System.Windows.Forms.Label();
        this.label8 = new System.Windows.Forms.Label();
        this.tbStatus = new System.Windows.Forms.TextBox();
        this.pH = new System.Windows.Forms.Label();
        this.tbPH = new System.Windows.Forms.TextBox();
        ((System.ComponentModel.ISupportInitialize)(this.trackBar1)).BeginInit();
        this.SuspendLayout();
        // 
        // temp
        // 
        this.temp.AutoSize = true;
        this.temp.Location = new System.Drawing.Point(9, 22);
        this.temp.Name = "temp";
        this.temp.Size = new System.Drawing.Size(67, 13);
        this.temp.TabIndex = 1;
        this.temp.Text = "Temperature";
        // 
        // button1
        // 
        this.button1.Location = new System.Drawing.Point(429, 12);
        this.button1.Name = "button1";
        this.button1.Size = new System.Drawing.Size(88, 117);
        this.button1.TabIndex = 0;
        this.button1.Text = "Connect";
        this.button1.UseVisualStyleBackColor = true;
        this.button1.Click += new System.EventHandler(this.button1_Click);
        // 
        // tbPort
        // 
        this.tbPort.Location = new System.Drawing.Point(226, 33);
        this.tbPort.Name = "tbPort";
        this.tbPort.Size = new System.Drawing.Size(100, 20);
        this.tbPort.TabIndex = 2;
        // 
        // tbTemp
        // 
        this.tbTemp.Enabled = false;
        this.tbTemp.Location = new System.Drawing.Point(94, 22);
        this.tbTemp.Name = "tbTemp";
        this.tbTemp.Size = new System.Drawing.Size(100, 20);
        this.tbTemp.TabIndex = 3;
        // 
        // tbConductivity
        // 
        this.tbConductivity.Enabled = false;
        this.tbConductivity.Location = new System.Drawing.Point(94, 53);
        this.tbConductivity.Name = "tbConductivity";
        this.tbConductivity.Size = new System.Drawing.Size(100, 20);
        this.tbConductivity.TabIndex = 4;
        // 
        // label1
        // 
        this.label1.AutoSize = true;
        this.label1.Location = new System.Drawing.Point(9, 56);
        this.label1.Name = "label1";
        this.label1.Size = new System.Drawing.Size(65, 13);
        this.label1.TabIndex = 5;
        this.label1.Text = "Conductivity";
        // 
        // label2
        // 
        this.label2.AutoSize = true;
        this.label2.Location = new System.Drawing.Point(17, 139);
        this.label2.Name = "label2";
        this.label2.Size = new System.Drawing.Size(30, 13);
        this.label2.TabIndex = 6;
        this.label2.Text = "Date";
        // 
        // tbDate
        // 
        this.tbDate.Enabled = false;
        this.tbDate.Location = new System.Drawing.Point(53, 136);
        this.tbDate.Name = "tbDate";
        this.tbDate.Size = new System.Drawing.Size(249, 20);
        this.tbDate.TabIndex = 7;
        // 
        // tbTime
        // 
        this.tbTime.Enabled = false;
        this.tbTime.Location = new System.Drawing.Point(348, 136);
        this.tbTime.Name = "tbTime";
        this.tbTime.Size = new System.Drawing.Size(69, 20);
        this.tbTime.TabIndex = 8;
        // 
        // label3
        // 
        this.label3.AutoSize = true;
        this.label3.Location = new System.Drawing.Point(312, 139);
        this.label3.Name = "label3";
        this.label3.Size = new System.Drawing.Size(30, 13);
        this.label3.TabIndex = 9;
        this.label3.Text = "Time";
        // 
        // trackBar1
        // 
        this.trackBar1.AutoSize = false;
        this.trackBar1.Enabled = false;
        this.trackBar1.Location = new System.Drawing.Point(39, 247);
        this.trackBar1.Maximum = 100;
        this.trackBar1.Name = "trackBar1";
        this.trackBar1.Size = new System.Drawing.Size(423, 45);
        this.trackBar1.TabIndex = 10;
        this.trackBar1.Value = 50;
        // 
        // label4
        // 
        this.label4.AutoSize = true;
        this.label4.Location = new System.Drawing.Point(223, 17);
        this.label4.Name = "label4";
        this.label4.Size = new System.Drawing.Size(26, 13);
        this.label4.TabIndex = 5;
        this.label4.Text = "Port";
        // 
        // label5
        // 
        this.label5.AutoSize = true;
        this.label5.Location = new System.Drawing.Point(36, 308);
        this.label5.Name = "label5";
        this.label5.Size = new System.Drawing.Size(86, 13);
        this.label5.TabIndex = 6;
        this.label5.Text = "Low Iron Density";
        // 
        // label6
        // 
        this.label6.AutoSize = true;
        this.label6.Location = new System.Drawing.Point(203, 308);
        this.label6.Name = "label6";
        this.label6.Size = new System.Drawing.Size(99, 13);
        this.label6.TabIndex = 6;
        this.label6.Text = "Normal Iron Density";
        // 
        // label7
        // 
        this.label7.AutoSize = true;
        this.label7.Location = new System.Drawing.Point(374, 306);
        this.label7.Name = "label7";
        this.label7.Size = new System.Drawing.Size(88, 13);
        this.label7.TabIndex = 6;
        this.label7.Text = "High Iron Density";
        // 
        // label8
        // 
        this.label8.AutoSize = true;
        this.label8.Location = new System.Drawing.Point(17, 165);
        this.label8.Name = "label8";
        this.label8.Size = new System.Drawing.Size(46, 13);
        this.label8.TabIndex = 6;
        this.label8.Text = "Status :-";
        // 
        // tbStatus
        // 
        this.tbStatus.Enabled = false;
        this.tbStatus.Location = new System.Drawing.Point(69, 162);
        this.tbStatus.Name = "tbStatus";
        this.tbStatus.Size = new System.Drawing.Size(69, 20);
        this.tbStatus.TabIndex = 11;
        // 
        // pH
        // 
        this.pH.AutoSize = true;
        this.pH.Location = new System.Drawing.Point(12, 87);
        this.pH.Name = "pH";
        this.pH.Size = new System.Drawing.Size(50, 13);
        this.pH.TabIndex = 12;
        this.pH.Text = "pH Level";
        // 
        // tbPH
        // 
        this.tbPH.Enabled = false;
        this.tbPH.Location = new System.Drawing.Point(94, 87);
        this.tbPH.Name = "tbPH";
        this.tbPH.Size = new System.Drawing.Size(100, 20);
        this.tbPH.TabIndex = 4;
        // 
        // Form1
        // 
        this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
        this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
        this.BackColor = System.Drawing.SystemColors.Control;
        this.ClientSize = new System.Drawing.Size(529, 330);
        this.Controls.Add(this.pH);
        this.Controls.Add(this.tbStatus);
        this.Controls.Add(this.trackBar1);
        this.Controls.Add(this.label3);
        this.Controls.Add(this.tbTime);
        this.Controls.Add(this.tbDate);
        this.Controls.Add(this.label7);
        this.Controls.Add(this.label6);
        this.Controls.Add(this.label8);
        this.Controls.Add(this.label5);
        this.Controls.Add(this.label2);
        this.Controls.Add(this.label4);
        this.Controls.Add(this.label1);
        this.Controls.Add(this.tbPH);
        this.Controls.Add(this.tbConductivity);
        this.Controls.Add(this.tbTemp);
        this.Controls.Add(this.tbPort);
        this.Controls.Add(this.temp);
        this.Controls.Add(this.button1);
        this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.Fixed3D;
        this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
        this.Name = "Form1";
        this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
        this.Text = "aquaSafe";
        ((System.ComponentModel.ISupportInitialize)(this.trackBar1)).EndInit();
        this.ResumeLayout(false);
        this.PerformLayout();

    }

    #endregion

    private System.Windows.Forms.Label temp;
    private System.Windows.Forms.Button button1;
    private System.Windows.Forms.TextBox tbPort;
    private System.Windows.Forms.TextBox tbTemp;
    private System.Windows.Forms.TextBox tbConductivity;
    private System.Windows.Forms.Label label1;
    private System.Windows.Forms.Label label2;
    private System.Windows.Forms.TextBox tbDate;
    private System.Windows.Forms.TextBox tbTime;
    private System.Windows.Forms.Label label3;
    private System.Windows.Forms.TrackBar trackBar1;
    private System.Windows.Forms.Label label4;
    private System.Windows.Forms.Label label5;
    private System.Windows.Forms.Label label6;
    private System.Windows.Forms.Label label7;
    private System.Windows.Forms.Label label8;
    private System.Windows.Forms.TextBox tbStatus;
    private System.Windows.Forms.Label pH;
    private System.Windows.Forms.TextBox tbPH;
}
}

