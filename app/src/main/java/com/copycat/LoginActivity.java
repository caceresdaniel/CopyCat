package com.copycat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.CheckBox;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;
import org.json.JSONException;
import org.json.JSONObject;
import android.graphics.Typeface;

import com.copycat.R;

import static com.copycat.R.array.languages;
import static com.copycat.R.id.language_spinner;

/**
 * A login screen that offers login via username.
 */
public class LoginActivity extends Activity implements View.OnClickListener{

    private EditText mUsernameView;

    private String mUsername;

    private CheckBox ageRequirement;
    private boolean metAgeReq;
    private TextView mainTitle;
    private NavigationView mNavigationView;

    private String selectedlanguage;
    private TextView languageTextView;
    private Spinner spinner;

    ArrayAdapter<CharSequence> adapter;

    private Socket mSocket;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ChatApplication app = (ChatApplication) getApplication();
        mSocket = app.getSocket();
        //Main Title
        mainTitle = (TextView) findViewById(R.id.mainHeader);
        Typeface font = Typeface.createFromAsset(getAssets(),"fonts/Quantify Bold v2.6.ttf");
        mainTitle.setTypeface(font);

        // Set up the login form.
        mUsernameView = (EditText) findViewById(R.id.username_input);

        //Age Requirement
        ageRequirement = (CheckBox)findViewById(R.id.age_confirmation);

        ageRequirement.setOnClickListener(this);
        mUsernameView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == EditorInfo.IME_NULL) {
                    attemptLogin();
                    return true;
                }
                return false;
            }
        });

        Button signInButton = (Button) findViewById(R.id.sign_in_button);
        signInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });

        //Txt indicating what language was selected
        languageTextView = (TextView)findViewById(R.id.textoflanguage);
        //adapter to langauge list
        spinner = (Spinner) findViewById(language_spinner);
        adapter = ArrayAdapter.createFromResource(this, languages,android.R.layout.simple_spinner_item);
        //specifying layout for dropdown
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
                           @Override
                           public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
                           {
                            //spinner.setOnItemSelectedListener(this);
                            // textview.setText(textview.getText()+ parent.getItemAtPosition(position).toString());
                            selectedlanguage =  spinner.getItemAtPosition(position).toString();
                           }
                           @Override
                           public void onNothingSelected(AdapterView<?> parent) {}
                      }
        );

/*
 <AutoCompleteTextView
            android:id="@+id/searchtxt"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"ste
            android:hint="@string/searchlanguage"
            android:padding="10dp"
            />
             AutoCompleteTextView choose =(AutoCompleteTextView)findViewById(R.id.searchtxt);
        choose.setAdapter(adapter);
 */
        mSocket.on("login", onLogin);
    }



    //Checkbox for age Requirement
    public void onClick(View view){
        CheckBox ageRequirement = (CheckBox)view;
        if(ageRequirement.isChecked()){
            ageRequirement.setError(null);
            metAgeReq = true;
        }else{
            metAgeReq = false;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        mSocket.off("login", onLogin);
    }
    /**
     * Attempts to sign in the account specified by the login form.
     * If there are form errors (invalid username, missing fields, etc.), the
     * errors are presented and no actual login attempt is made.
     */
    private void attemptLogin() {
        // Reset errors.
        mUsernameView.setError(null);
        ageRequirement.setError(null);

        // Store values at the time of the login attempt.
        String username = mUsernameView.getText().toString().trim();

        // Check for a valid username.
        if (TextUtils.isEmpty(username)) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            mUsernameView.setError(getString(R.string.error_field_required));
            mUsernameView.requestFocus();

            return;
        }
        if(!metAgeReq){
            ageRequirement.setError(getString(R.string.error_field_ageRequired));
            ageRequirement.requestFocus();
            return;
        }

        mUsername = username;

        // perform the user login attempt.
        mSocket.emit("add user", username);
    }

    private Emitter.Listener onLogin = new Emitter.Listener() {
        @Override
        public void call(Object... args) {
            JSONObject data = (JSONObject) args[0];

            int numUsers;
            try {
                numUsers = data.getInt("numUsers");
            } catch (JSONException e) {
                return;
            }


            Intent intent = new Intent();
            intent.putExtra("username", mUsername);
            intent.putExtra("numUsers", numUsers);
            intent.putExtra("targetLanguage", selectedlanguage);
            setResult(RESULT_OK, intent);
            finish();
        }
    };
}
