using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.IO.Ports;
using System.Data.Sql;
using System.Data.SqlClient;

namespace $safeprojectname$
{
    public partial class Form1 : Form
    {
        private SerialPort myport;
        private String inData,date,time;
        private DateTime dateTime;
        private float conductivity,temperature;
 

        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            myport = new SerialPort();
            myport.BaudRate = 9600;
            myport.PortName = tbPort.Text;
            myport.Parity = Parity.None;
            myport.DataBits = 8;
            myport.StopBits = StopBits.One;
            myport.DataReceived += Myport_DataReceived;
            try {
                myport.Open();
                tbTemp.Text = "";
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message,"Error");
            }

        }

        private void Myport_DataReceived(object sender, SerialDataReceivedEventArgs e)
        {
            inData = myport.ReadLine();
            
            this.Invoke(new EventHandler(displaydata_event));

        }

       

        private void displaydata_event(object sender, EventArgs e)
        {
            dateTime = DateTime.Now;
            date = dateTime.Year + "-" + dateTime.Month + "-" + dateTime.Day;
            time = dateTime.Hour + ":" + dateTime.Minute + ":" + dateTime.Second;
            String[] values = inData.Split('#');
            tbTime.Text = time;
            tbDate.Text = date;
            tbTemp.Text = values[0];
            tbConductivity.Text = values[1];
            tbPH.Text = values[2];
            
            check(values[0], values[1]);
            
        }
        private void check(String temp, String con)
        {
            conductivity = float.Parse(con);
            temperature = float.Parse(temp);

           sql();

            if ((conductivity > 2.5)||conductivity==0)
            {

                tbStatus.Text = "Not Safe to d";
               // MessageBox.Show("Message sent");

            }
            else
            {
                tbStatus.Text = "Safe to drin";
            }
                      
        }

        private void sql() {

            SqlCommand cmd;
            SqlConnection conect;
            SqlDataAdapter da;
            
            conect = new SqlConnection(@"Data Source=aquasafeserver1.database.windows.net;Initial Catalog=aquaSafeDB;Integrated Security=False;User ID=aquaadmin1;Password=aquaSafe1;Connect Timeout=15;Encrypt=True;TrustServerCertificate=False;ApplicationIntent=ReadWrite;MultiSubnetFailover=False");
            conect.Open();
            cmd = new SqlCommand("INSERT INTO Employee (Date,Time,Conductivity,Temperature) VALUES (@Date,@Time,@Conductivity,@Temperature)", conect);
            cmd.Parameters.AddWithValue("@Date", date);
            cmd.Parameters.AddWithValue("@Time", time);
            cmd.Parameters.AddWithValue("@Conductivity", conductivity);
            cmd.Parameters.AddWithValue("@Temperature", temperature);
            try
            {
                cmd.ExecuteNonQuery();
            }
            catch (Exception ex) {
                MessageBox.Show(ex.Message, "Error");
            }
        }
        
    }
}
