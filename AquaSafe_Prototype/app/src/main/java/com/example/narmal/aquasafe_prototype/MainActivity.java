package com.example.narmal.aquasafe_prototype;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int fails = 5;
    Button Button1;
    Button Button2,Button3;
    EditText TextEdit1;
    EditText TextEdit2;

    DBConnector DBConnector;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        DBConnector =new DBConnector(this);
        DBConnector = DBConnector.open();

        Button1 = (Button)findViewById(R.id.button);
        TextEdit1 = (EditText)findViewById(R.id.editText);
        TextEdit2 = (EditText)findViewById(R.id.editText2);

        Button2 = (Button)findViewById(R.id.button2);
        Button3 = (Button)findViewById(R.id.btnDelete);


        Button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userName=TextEdit1.getText().toString();
                String password=TextEdit2.getText().toString();

                String storedPassword= DBConnector.SelectedEntry(userName);


                if(password.equals(storedPassword)) {
                    Toast.makeText(getApplicationContext(),


                            "Welcome to AquaSafe...You can view your results in a moment...",Toast.LENGTH_LONG).show();
                    startActivity(new Intent(getApplicationContext(),WebApp.class));
                }else{
                    Toast.makeText(getApplicationContext(), "Wrong UserName or Password",Toast.LENGTH_LONG).show();


                    fails--;
                    Toast.makeText(getApplicationContext(), "You have "+fails+" attempts Left",Toast.LENGTH_LONG).show();


                    if (fails == 0) {
                        Button1.setEnabled(false);
                    }
                }
            }
        });

        Button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSignUP=new Intent(getApplicationContext(),SignUP.class);
                startActivity(intentSignUP);
            }
        });
        Button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent delete=new Intent(getApplicationContext(),Delete.class);
                startActivity(delete);
            }
        });
    }
}
