/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package water_quality_monitoring_system;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.Timer;
import jssc.SerialPort;
import jssc.SerialPortException;
import jssc.SerialPortList;

/** 
 *
 * @author User
 */



public class ArduinoData {
    
     final static String start_char = "@";//charactors to clear the arduino reading
 final static String end_char = "#";
 final static String sep_char = ":";
 private Timer timer;
 String comPort="";
 public static String portValue="COM3";
 public static SerialPort serialPort;//serial port object
 public static String valtage="0";
 public static String temparature="0";
 
 
 
 
 public void arduinoExecuter() throws InterruptedException, SerialPortException {
 
 String portValue= interface01.setPort();// getting the port from the interface
 
 System.out.println("this is comport"+portValue);
 ArduinoData arduinoObj=new ArduinoData();
 serialPort = new SerialPort(portValue);
 arduinoObj.openPort();
 //arduinoObj.threadExecuter();
 arduinoObj.arduinoReading();
 
 }
 
 /* public static void main(String [] args) throws InterruptedException, SerialPortException {
 ArduinoData arduinoObj=new ArduinoData();
 arduinoObj.openPort();
 // arduinoObj.threadExecuter();
 arduinoObj.arduinoReading();
 
 
 }*/



Runnable arduinoThread = new Runnable() {
    public void run() {
        arduinoReading();//
    }
};


public SerialPort comPortChanger(String portValue){


SerialPort serialPort = new SerialPort(portValue);

return serialPort;

}


public void comPortChanger(){




}


public void openPort() throws SerialPortException{// opening the port
 System.out.println("this is comport port opener"+portValue);
 serialPort.openPort();// 
 serialPort.setParams(9600,8,1,0);
 
 }


public void threadExecuter(){
    
    
ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
executor.scheduleAtFixedRate(arduinoThread, 20, 20, TimeUnit.SECONDS);


}



public void arduinoReading(){

 
System.out.println("this is comport reading"+portValue);
 String[] portList = SerialPortList.getPortNames();
 for(int i = 0; i < portList.length; i++)
 System.out.println(portList[i]);
 
 try {
  
byte[] buffer;
 buffer = serialPort.readBytes(200);
 buffer = serialPort.readBytes(100);
 String dataStream = new String(buffer);
 

 dataStream = dataStream.substring(dataStream.indexOf(start_char)+1);//spliting data
 dataStream = dataStream.substring(0,dataStream.indexOf(end_char)-1);
 
 String[] data = dataStream.split(sep_char);
 
 for(int i = 0; i < data.length; i++){
 System.out.println(data[i]);
 valtage=data[1];//geting valtage and temparature
 temparature=data[0];
 System.out.println("in the loop"+valtage);
 System.out.println("in the loop temparature"+temparature);
 serialPort.closePort();
 }
 
}
 catch (SerialPortException ex) {
 System.out.println(ex);
 
}
}

public String getTemparature(){//sending data
System.out.println("second"+temparature);
    return temparature;
}

public String getValtage(){
System.out.println("lopp"+valtage);
String val=valtage;
 return val;
}
    
    
}
