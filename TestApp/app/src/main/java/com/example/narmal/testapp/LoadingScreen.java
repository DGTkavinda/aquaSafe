package com.example.narmal.testapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by narmal on 5/10/2017.
 */
public class LoadingScreen extends AppCompatActivity {

    private static final int Pause_Time = 4800;//time to pause the program for the loading screen

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.loading_screen);
        new LoadingScreenBackground().execute();
    }

    private class LoadingScreenBackground extends AsyncTask<Void, Void, Void> {//using of the asyn task

        @Override
        protected void onPreExecute(){
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... arg0) {//the three methods in the asyntask
            try {
                Thread.sleep(Pause_Time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            Intent i = new Intent(LoadingScreen.this, MainActivity.class);
            startActivity(i); finish();
        }

    }
}
