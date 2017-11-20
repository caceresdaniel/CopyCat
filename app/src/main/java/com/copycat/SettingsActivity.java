package com.copycat;

/**
 * Created by steph on 11/19/2017.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.copycat.R;

public class SettingsActivity extends AppCompatActivity {
    ListView listView;
    private ArrayAdapter<String> adapter;
    EditText search;
    String selectedlanguage;
    String targetLanguageCode;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        listView = (ListView) findViewById(R.id.languagelist);
        search = (EditText) findViewById(R.id.searchtxt);
        adapter = new ArrayAdapter<String>(SettingsActivity.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.languages));
        listView.setAdapter(adapter);


//Search bar for languages
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                SettingsActivity.this.adapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //New Activity moved from languages to Mainfragment
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedlanguage = listView.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(), "Language Changed to " + selectedlanguage, Toast.LENGTH_SHORT).show();

                Intent returnIntent = getIntent();
                returnIntent.putExtra("targetLanguage", selectedlanguage);
                setResult(Activity.RESULT_OK, returnIntent);
                finish();
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }

        });
        //if(listView.getOnItemClick(selectedlanguage))
    }


}