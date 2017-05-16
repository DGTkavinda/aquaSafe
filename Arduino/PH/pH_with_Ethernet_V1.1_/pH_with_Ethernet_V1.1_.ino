#include <LiquidCrystal_I2C.h>
#include <DallasTemperature.h>
#include <Wire.h> 
#include <OneWire.h>

//server connection ubidots
#include <Ethernet.h>
#include <SPI.h>
#include <UbidotsEthernet.h>
#define ID  "590b03337625421b6a02c329"  // Put here your Ubidots variable ID
#define ID2 "590adb457625421b6cfe8a34"
#define ID3 "590b039e7625421b6a02cb91"
#define TOKEN  "bfTW9Nrw0iQzSrUYTIsqG1j8NtX1BI"  // Put here your Ubidots TOKEN


byte mac[] = {0x00, 0xAA, 0xBB, 0xCC, 0xDE, 0x02};
// Set the static IP address to use if the DHCP fails to assign
IPAddress ip(192, 168, 8, 101);

Ubidots client(TOKEN);

//pH probe parts
int phPin = A1;

//buzzer parts
const int buzzer = 9;

//Temp Sensor part
int temp_sensor = 5;

float temperature = 0; //variable to store the temp
int lowerLimit = 15; // lower tempLimit
int higherLimit = 35; // upper TempLimit

OneWire oneWirePin(temp_sensor);
DallasTemperature sensors(&oneWirePin);

//conductivity probe parts
const int switchPin = 6;
int switchState = 0;
int condVal;


//lcd Panel components
LiquidCrystal_I2C lcd(0x27,2,1,0,4,5,6,7,3,POSITIVE);
// the setup function runs once when you press reset or power the board


void setup(void) {
  Serial.begin(9600);
  pinMode(switchPin, INPUT);
  pinMode(buzzer,OUTPUT);
  sensors.begin();
  lcd.begin(16,2);
  lcd.clear();
  lcd.setCursor(4,0);
  lcd.print("aquaSafe");
  delay(2000);
  lcd.clear();

   // start the Ethernet connection:
    if (Ethernet.begin(mac) == 0) {
      Serial.println("Failed to configure Ethernet using DHCP");
      lcd.setCursor(0,0);
      lcd.print("Unable to connect!!!!");
      lcd.setCursor(0,1);
      lcd.print("Unable to connect!!!!");
      delay(2000);
      lcd.clear();
      // try to congifure using IP address instead of DHCP:
      Ethernet.begin(mac, ip);
    }
    // give the Ethernet shield a second to initialize:
    
}
// the loop function runs over and over again forever

void loop() {

//conductivity calculation
  condVal = analogRead(A0);// conductivity reading
  float voltage = condVal*(5.0/1023.0);
  
//temperature calculation
  sensors.requestTemperatures(); 
//  Serial.println("DONE");
  
  temperature = sensors.getTempCByIndex(0);// temp reading
  String Stringtemperature = String(temperature);
  
  
  Serial.println(temperature);

  
//ph calculation
 int measure = analogRead(phPin);// ph analog reading

  double pHvoltage = 5 / 1024.0 * measure; //classic digital to voltage conversion
  Serial.print(pHvoltage);

  // PH_step = (voltage@PH7 - voltage@PH4) / (PH7 - PH4)
  // PH_probe = PH7 - ((voltage@PH7 - voltage@probe) / PH_step)
  
  float phValue = 7 + ((2.5 - pHvoltage) / 0.18);//final ph value
  Serial.print(phValue);
  String StringphValue = String(phValue);
  //lcd.println();
  if(voltage==0||voltage>3.00||temperature>50){
    
    tone(buzzer, 1000);
  
    noTone(buzzer);
  
   }

  float ubTem= temperature;
  float ubCon=voltage;
  float ubphValue=phValue;

  client.add(ID, ubTem);
  client.add(ID2, ubCon);
  client.add(ID3, ubphValue);
  client.sendAll();

  //Serial.print("Codutivity:- ");
  //Serial.println(voltage);

 lcd.setCursor(0,0);
 lcd.print("Temp:");
 lcd.setCursor(7,0);
 lcd.print(Stringtemperature);
 lcd.setCursor(0,1);
 lcd.print("pH value:");
 lcd.setCursor(10,1);
 lcd.print(StringphValue);
 delay(2000);
 lcd.clear();
 lcd.setCursor(0,0);
 lcd.print("Conductivity:");
 lcd.setCursor(12,0);
 delay(2000);
 lcd.clear();
 
 

}
