/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package water_quality_monitoring_system;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import jssc.SerialPortException;

/**
 *
 * @author User
 */
public class Water_Quality_Monitoring_System {

    /**
     * @param args the command line arguments
     */
    
     public static interface01 informationFrame=new interface01(); 
     public static String comportinterface ="";
     
    
    
    public static void main(String[] args) {
        
      
        
        
        
       Water_Quality_Monitoring_System water1=new Water_Quality_Monitoring_System();
       water1.slideExecutioner();//calling the executer service
       //informationFrame.setSize(400,100);
       informationFrame.setVisible(true); 
       
       
       //String gettemp= sensorData.getTemparature();
       
       
       }
    
    
    /* public static void closeMethod(int x){
    setDefaultCloseOperation(informationFrame.x);
    
    }*/
    
    
    public void slideExecutioner(){
    
        ScheduledExecutorService executer= Executors.newScheduledThreadPool(2);
        executer.scheduleAtFixedRate(sliderDesplayThread,0, 6, TimeUnit.SECONDS);
    //runing the thread 
    
    }
    
    
    Runnable sliderDesplayThread = new Runnable() {
    public void run() {
        try {
            sliderDisplay();//continues running/ to get data continuesly 
        } catch (InterruptedException ex) {
            Logger.getLogger(Water_Quality_Monitoring_System.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SerialPortException ex) {
            Logger.getLogger(Water_Quality_Monitoring_System.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
};
    
    
    
    public void sliderDisplay() throws InterruptedException, SerialPortException{
        
        int damiData=77;
        
        informationFrame.comboBox();
        
        ArduinoData sensorData=new ArduinoData();// getting data from arduino
        sensorData.arduinoExecuter();// data reading method
        String getvolt= sensorData.getValtage();// converting data
        String gettemp= sensorData.getTemparature();
        float floatvolt=Float.parseFloat(getvolt)*20;
        System.out.println(floatvolt);
        
        
        int intvolt=Math.round(floatvolt);
        
        //intvolt=damiData;
        System.out.println(floatvolt);
     //System.out.println(intvolt);
       
       informationFrame.cunductSlider(intvolt);
       
       if(intvolt<40){// massages according to the ion density
       informationFrame.setInformationLabel("Low Ion Density");
       }else if(intvolt>40&&intvolt<52){
       
       informationFrame.setInformationLabel("Safe to Drink");
       }else{
       informationFrame.setInformationLabel("High Ion Density");
       }
       
       informationFrame.setTemparatue(gettemp);
       
       //informationFrame.setVisible(true); 
       
    }
    
    
    
    
    
    
    
}
