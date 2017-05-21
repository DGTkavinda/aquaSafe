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
public class Delete extends Activity {

    Button buttonDelete,buttonUpdate;
    EditText textDelete ;


    DBConnector DBConnector;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delete);

        // get Instance  of Database Adapter
        DBConnector =new DBConnector(this);
        DBConnector = DBConnector.open();

        // Get Refferences of Views
        textDelete=(EditText)findViewById(R.id.txtDelete);


        buttonDelete=(Button)findViewById(R.id.btnDelete);
        buttonUpdate = (Button)findViewById(R.id.btnUpdate);
        buttonDelete.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {


                String userName=textDelete.getText().toString();


                String storedName= DBConnector.SelectedEntry(userName);


                if(userName.equals(storedName))
                {
                    DBConnector.deleteValues(userName);
                    Toast.makeText(getApplicationContext(), "record deleted", Toast.LENGTH_LONG).show();
                    // return;
                    Intent Main=new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(Main);
                }
                // check if both password matches

                else
                {

                    Toast.makeText(getApplicationContext(), "No such a user name exists ", Toast.LENGTH_LONG).show();
                    Intent Main=new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(Main);





                }
            }
        });
        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent update=new Intent(getApplicationContext(),Update.class);
                startActivity(update);

            }
        });

    }
}
