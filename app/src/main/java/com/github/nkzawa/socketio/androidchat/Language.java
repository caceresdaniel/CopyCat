package com.github.nkzawa.socketio.androidchat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class Language extends Activity {
    ListView listView;
    private ArrayAdapter<String> adapter;
    //search edittext
    EditText search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_languages);

        listView = (ListView) findViewById(R.id.languagelist);
        search = (EditText) findViewById(R.id.searchtxt);

       /* toolbar =(Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(getResources().getString(R.string.languages));
        */
        adapter = new ArrayAdapter<String>(Language.this, android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.languages));
        listView.setAdapter(adapter);


//Search bar for languages
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Language.this.adapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


//New Activity moved from languages to Mainfragment
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                //new activity after the Language ListView gets clicked
                Intent intent = new Intent(Language.this, MainActivity.class);
                intent.putExtra("Language",listView.getItemAtPosition(position).toString());
                startActivity(intent);
            }
        });
    }
}