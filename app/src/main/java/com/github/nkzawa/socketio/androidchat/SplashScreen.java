package com.github.nkzawa.socketio.androidchat;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity
{
    TextView txt;
    Typeface typeface;
    ImageView copycat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

//SplashScreen animation rotation and Intent to next (MainActivity)
        copycat= (ImageView)findViewById(R.id.imageView);
        final Animation animation= AnimationUtils.loadAnimation(getBaseContext(),R.anim.rotate_image);
        copycat.startAnimation(animation);
        animation.setAnimationListener(new Animation.AnimationListener()
           {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        //Splashscreen Font COPYCAT
        txt= (TextView)findViewById(R.id.textView);
        typeface=Typeface.createFromAsset(getAssets(),"fonts/Quantify Bold v2.6.ttf");
        txt.setTypeface(typeface);
    }

}