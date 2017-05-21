package com.example.narmal.aquasafe_prototype;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by narmal on 5/19/2017.
 */
public class SignUP extends Activity {

    EditText txtUserName,txtPassword,txtConfirmPassword;
    Button btnCreateAccount;

    DBConnector DBConnector;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        // get Instance  of Database Adapter
        DBConnector =new DBConnector(this);
        DBConnector = DBConnector.open();

        // Get Refferences of Views
        txtUserName=(EditText)findViewById(R.id.editTextUserName);
        txtPassword=(EditText)findViewById(R.id.editTextPassword);
        txtConfirmPassword=(EditText)findViewById(R.id.editTextConfirmPassword);

        btnCreateAccount=(Button)findViewById(R.id.buttonCreateAccount);
        btnCreateAccount.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub

                String userName=txtUserName.getText().toString();
                String password=txtPassword.getText().toString();
                String confirmPassword=txtConfirmPassword.getText().toString();

                // check if any of the fields are vaccant
                if(userName.equals("")||password.equals("")||confirmPassword.equals(""))
                {
                    Toast.makeText(getApplicationContext(), "There is a vacant slot", Toast.LENGTH_LONG).show();
                    return;
                }
                // check if both password matches
                if(!password.equals(confirmPassword))
                {
                    Toast.makeText(getApplicationContext(), "Password does not match", Toast.LENGTH_LONG).show();
                    return;
                }
                else
                {
                    // Save the Data in Database
                    DBConnector.insertValues(userName, password);
                    Toast.makeText(getApplicationContext(), "Account Successfully Created ", Toast.LENGTH_LONG).show();
                    Intent ToTheMain=new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(ToTheMain);
                }
            }
        });
    }
    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();

        DBConnector.close();
    }
}
