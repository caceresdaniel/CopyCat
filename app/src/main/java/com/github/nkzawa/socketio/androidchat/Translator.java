package com.github.nkzawa.socketio.androidchat;

import android.os.AsyncTask;

import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;

import org.codehaus.jackson.annotate.JsonTypeInfo;

import java.util.Arrays;

/**
 * Created by marco on 10/30/2017.
 */

public class Translator extends AsyncTask<String, Void, String> {

    public static final String API_KEY = "AIzaSyCsMGmWKoCkOsDeL-gvZW5cPsGIeIfVNmI";
    public AsyncTranslatorResponse delegate = null;

    public Translator(){ }

    public Translator(AsyncTranslatorResponse delegate){
        this.delegate = delegate;
    }

    @Override
    protected String doInBackground(String... messageToBeTranslatedParams) {
        String translatedMsg = null;
        // Do some background work
        try {
            // See comments on
            //   https://developers.google.com/resources/api-libraries/documentation/translate/v2/java/latest/
            // on options to set
            TranslateOptions options = TranslateOptions.newBuilder()
                    .setApiKey(API_KEY)
                    .build();

            com.google.cloud.translate.Translate t = options.getService();

            //request google to translate
            //parse language String to languageCode
            Translation translation =  t.translate(messageToBeTranslatedParams[0],
                    com.google.cloud.translate.Translate.TranslateOption.targetLanguage(
                            LanguageCodeParser.getLanguageCode(messageToBeTranslatedParams[1])));

            translatedMsg = translation.getTranslatedText();

            //workaround on google translate html entity bug
            if(translatedMsg.contains("&#39;"))
                translatedMsg = translatedMsg.replaceAll("&#39;","");



        } catch (Exception e) {
            e.printStackTrace();
        }
        return translatedMsg;
    }

    @Override
    protected void onPostExecute(String result) {
        delegate.onTranslationFinish(result);
    }

}