package com.example.vrams.ramdieuconverter.helper;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by vrams on 3/31/2017.
 */

public class Prefs {
    private static SharedPreferences mPrefs;
    private static final Object mObject;
    static{
        mObject = new Object();
    }

    private static final String PREF_NAME = "com.vramsngraicse.converter.prefs";

    private Prefs(){
    }

    public static void init(Context context){
        getPrefs(context);
    }


    private static SharedPreferences getPrefs(Context context) {
        if(mPrefs == null) {
            synchronized (mObject) {
                if(mPrefs == null){
                    mPrefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
                }
            }
        }
        return mPrefs;
    }

    public static void saveCurrencyJsonData(String json){
        mPrefs.edit().putString("saveCurrencyJsonData", json).commit();
    }

    public static String getCurrencyJsonData(){
        return mPrefs.getString("saveCurrencyJsonData", null);
    }

    public static void saveLotteryJsonData(String json){
        mPrefs.edit().putString("saveLotteryJsonData", json).commit();
    }

    public static String getLotteryJsonData(){
        return mPrefs.getString("saveLotteryJsonData", null);
    }

}
