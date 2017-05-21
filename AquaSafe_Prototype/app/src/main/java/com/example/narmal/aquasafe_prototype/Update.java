package com.example.narmal.aquasafe_prototype;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by narmal on 5/20/2017.
 */
public class Update extends Activity {

    Button Update,BackToLogin;
    EditText UpdataName,UpdatePassword;


    DBConnector DBConnector;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update);

        // getting the databaseconnector instances
        DBConnector =new DBConnector(this);
        DBConnector = DBConnector.open();

        // refferencing the views
        UpdataName=(EditText)findViewById(R.id.txtUpdateName);
        UpdatePassword=(EditText)findViewById(R.id.txtUpdatePassword);


        Update=(Button)findViewById(R.id.btnUpdate);
        BackToLogin = (Button)findViewById(R.id.btnToLogin);
        //setting command to the update button
        Update.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {


                //

                String userName=UpdataName.getText().toString();
                String password = UpdatePassword.getText().toString();


                String NameInTheDatabase= DBConnector.SelectedEntry(userName);


                if(userName.equals(NameInTheDatabase))
                {
                    DBConnector.updateEntry(userName,password);
                    Toast.makeText(getApplicationContext(), "The record has been Updated", Toast.LENGTH_LONG).show();
                    // return;
                    Intent ToTheMain=new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(ToTheMain);
                }


                else
                {

                    Toast.makeText(getApplicationContext(), "No such a user name exists ", Toast.LENGTH_LONG).show();
                    Intent ToTheMain=new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(ToTheMain);





                }
            }
        });
        BackToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ToTheMain=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(ToTheMain);

            }
        });

    }


}
