package com.github.nkzawa.socketio.androidchat;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class SelectLanguage extends Fragment {
    ListView listView;
    private ArrayAdapter<String> adapter;
    //search edittext
    EditText search;

    public SelectLanguage() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_languages, container, false);

        ListView listView = (ListView) view.findViewById(R.id.languagelist);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getActivity(), android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.languages)
        );

        listView.setAdapter(adapter);

        return view;
    }

//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_languages);
//
//        listView = (ListView) findViewById(R.id.languagelist);
//        search = (EditText) findViewById(R.id.searchtxt);
//
//        adapter = new ArrayAdapter<String>(SelectLanguage.this, android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.languages));
//        listView.setAdapter(adapter);
//
//        //Search bar for languages
//        search.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                SelectLanguage.this.adapter.getFilter().filter(s);
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//
//            }
//        });
//
////New Activity moved from languages to Mainfragment
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                //new activity after the SelectLanguage ListView gets clicked
//                Intent intent = new Intent(SelectLanguage.this, MainActivity.class);
//                intent.putExtra("SelectLanguage",listView.getItemAtPosition(position).toString());
//                startActivity(intent);
//            }
//        });
//    }
}
