package com.github.nkzawa.socketio.androidchat;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;


public class SplashScreen extends AppCompatActivity
{
    TextView txt;
    Button clk;
    Typeface typeface;
    private static int SPLASH_TIME_OUT= 5000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_TIME_OUT);
        txt= (TextView)findViewById(R.id.textView);

        typeface=Typeface.createFromAsset(getAssets(),"fonts/Quantify Bold v2.6.ttf");
        txt.setTypeface(typeface);

    }
}