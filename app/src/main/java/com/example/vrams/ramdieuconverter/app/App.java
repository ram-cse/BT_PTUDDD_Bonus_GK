package com.example.vrams.ramdieuconverter.app;

import android.app.Application;

import com.example.vrams.ramdieuconverter.helper.Prefs;

/**
 * Created by vrams on 3/31/2017.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //INIT PREF
        Prefs.init(this);
    }
}
