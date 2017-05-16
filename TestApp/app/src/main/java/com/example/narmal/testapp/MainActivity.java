package com.example.narmal.testapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int fails = 5;
    Button Button1;
    Button Button2;
    EditText TextEdit1;
    EditText TextEdit2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        Button1 = (Button)findViewById(R.id.button);
        TextEdit1 = (EditText)findViewById(R.id.editText);
        TextEdit2 = (EditText)findViewById(R.id.editText2);

        Button2 = (Button)findViewById(R.id.button2);


        Button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextEdit1.getText().toString().equals("Jonathan") &&
                        TextEdit2.getText().toString().equals("fcuk")) {
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
                finish();
            }
        });
    }
}

