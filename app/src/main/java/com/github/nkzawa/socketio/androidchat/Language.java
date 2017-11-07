package com.github.nkzawa.socketio.androidchat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;


public class Language extends Activity {
    private ListView listView;
    private ArrayAdapter<CharSequence>adapter;

    //search edittext
    private EditText search;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_languages);

        listView = (ListView)findViewById(R.id.languagelist);
        search = (EditText)findViewById(R.id.searchtxt);

        adapter= ArrayAdapter.createFromResource(this,R.array.languages,android.R.layout.simple_list_item_1);
        listView.setAdapter(adapter);


//Search bar for languages
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
               Language.this.adapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s)
            {

            }
        });



//New Activity moved from languages to Mainfragment
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {


                //new activity after the Language ListView gets clicked
                Intent intent = new Intent(getApplicationContext(),MainFragment.class);
                startActivity(intent);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }



}