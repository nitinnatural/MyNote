package com.example.note;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;
import android.util.Log;
import android.widget.Toast;

import com.example.note.data.entity.Note;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;

/**
 * Created by IAMONE on 11/14/2015.
 */
public class App extends Application {

    @Override
    public void onCreate() {
        MultiDex.install(this);
        super.onCreate();

        ParseObject.registerSubclass(Note.class);
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, Config.APP_ID, Config.CLIENT_ID);


        com.example.note.data.entity.Note testNote = new com.example.note.data.entity.Note();
        testNote.title = "Hello Universe";
        testNote.content = "mercury, Venus, earth, mars, jupiter, sturn , uranus, neptune, pluto";
        testNote.color = "#fff";

        testNote.toParse();
        testNote.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if (e == null)
                    Log.d("notestag", "saved successfully");
                else {
                    Log.d("notestag", "" + e.getMessage());
                }
            }
        });


    }


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
