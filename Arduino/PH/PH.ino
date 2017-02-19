#include <DallasTemperature.h>

#include <OneWire.h>
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

// the setup function runs once when you press reset or power the board
void setup(void) {
  Serial.begin(9600);
  pinMode(switchPin, INPUT);
  pinMode(buzzer,OUTPUT);
  sensors.begin();
}

// the loop function runs over and over again forever

void loop() {

//conductivity calculation
  condVal = analogRead(A0);
  float voltage = condVal*(5.0/1023.0);
  
   //temperature calculation
  //Serial.print("Requesting Temperatures from sensors: ");
  sensors.requestTemperatures(); 
//  Serial.println("DONE");
  
  temperature = sensors.getTempCByIndex(0);

//ph calculation
 int measure = analogRead(phPin);

  double pHvoltage = 5 / 1024.0 * measure; //classic digital to voltage conversion

  // PH_step = (voltage@PH7 - voltage@PH4) / (PH7 - PH4)
  // PH_probe = PH7 - ((voltage@PH7 - voltage@probe) / PH_step)
  float Po = 7 + ((2.5 - pHvoltage) / 0.18);

  if(voltage==0||voltage>3.00||temperature>50){
    
    tone(buzzer, 1000);
    delay(1000);
    noTone(buzzer);
    delay(1000);
    
   }
  
 // Serial.print("Temperature is ");
 String temp = String(temperature);
 String volt = String(voltage);
 Serial.println(temp+"#"+volt+"#"+(Po));
 // Serial.println(temp);
  
  //Serial.print("Codutivity:- ");
  //Serial.println(voltage);
  
  
  delay(100);
 
}
