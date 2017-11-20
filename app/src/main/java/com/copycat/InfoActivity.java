package com.copycat;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import autovalue.shaded.com.google$.common.collect.$Iterables;

public class InfoActivity extends AppCompatActivity {

    private TextView mainTitle;
    private TextView aboutTitle;
    private TextView patchTitle;
    private TextView howTitle;;
    private TextView moreTitle;
    private TextView genTitle;
    private TextView transTitle;
    private TextView actTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Typeface font = Typeface.createFromAsset(getAssets(),"fonts/Quantify Bold v2.6.ttf");

        mainTitle = (TextView) findViewById(R.id.infoHeader);
        mainTitle.setTypeface(font);

        aboutTitle = (TextView) findViewById(R.id.textView3);
        aboutTitle.setTypeface(font);

        patchTitle = (TextView) findViewById(R.id.textView6);
        patchTitle.setTypeface(font);

        howTitle = (TextView) findViewById(R.id.textView7);
        howTitle.setTypeface(font);

        moreTitle = (TextView) findViewById(R.id.textView8);
        moreTitle.setTypeface(font);

        genTitle = (TextView) findViewById(R.id.genTitle);
        genTitle.setTypeface(font);

        transTitle = (TextView) findViewById(R.id.transTitle);
        transTitle.setTypeface(font);

        actTitle = (TextView) findViewById(R.id.actTitle);
        actTitle.setTypeface(font);

    }
}
