package com.copycat;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity {

    private TextView mainTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        mainTitle = (TextView) findViewById(R.id.infoHeader);
        Typeface font = Typeface.createFromAsset(getAssets(),"fonts/Quantify Bold v2.6.ttf");
        mainTitle.setTypeface(font);
    }
}
