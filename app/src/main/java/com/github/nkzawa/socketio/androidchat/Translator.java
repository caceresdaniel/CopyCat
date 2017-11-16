package com.github.nkzawa.socketio.androidchat;

        import android.os.AsyncTask;
        import android.widget.Spinner;

        import com.google.cloud.translate.Translate;
        import com.google.cloud.translate.TranslateOptions;
        import com.google.cloud.translate.Translation;
        import java.util.Arrays;
import com.github.nkzawa.socketio.androidchat.LoginActivity;


/**
 * Created by marco on 10/30/2017.
 * edited by stephanie
 */

public class Translator extends AsyncTask<String, Void, String> {

    public static final String API_KEY = "AIzaSyCsMGmWKoCkOsDeL-gvZW5cPsGIeIfVNmI";
    String selectedlanguage;
    Spinner spinner;

    @Override
    protected String doInBackground(String... messageToBeTranslated) {
        String translatedMsg = null;
        // Do some background work


        try {
            // See comments on
            //   https://developers.google.com/resources/api-libraries/documentation/translate/v2/java/latest/
            // on options to set
            TranslateOptions options = TranslateOptions.newBuilder()
                    .setApiKey("AIzaSyBeoTtgL8y4qWing3w6_Zccj2HGl8nQHhc")
                    .build();

            com.google.cloud.translate.Translate t = options.getService();


            Translation translation = t.translate(messageToBeTranslated[0],
                    com.google.cloud.translate.Translate.TranslateOption.targetLanguage("it"));


            //TODO: add targetLanguage code to param array

            translatedMsg = translation.getTranslatedText();


        } catch (Exception e) {
            e.printStackTrace();
        }
        return translatedMsg;
    }


}