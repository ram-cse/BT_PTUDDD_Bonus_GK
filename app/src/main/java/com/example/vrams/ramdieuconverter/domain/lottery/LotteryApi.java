package com.example.vrams.ramdieuconverter.domain.lottery;

import android.os.AsyncTask;
import android.util.Log;

import com.example.vrams.ramdieuconverter.callbacks.Callback;
import com.example.vrams.ramdieuconverter.domain.lottery.models.LotteryProviderList;
import com.example.vrams.ramdieuconverter.helper.Prefs;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by vrams on 4/27/2017.
 */

public class LotteryApi {
   // public static final String API_KEY = "";
    public static final String BASE_URL = "http://thanhhungqb.tk:8080/kqxsmn";

    public static void getLottery(final Callback<LotteryProviderList> callback) {
        new AsyncTask<Void, Void, LotteryProviderList>() {

            @Override
            protected LotteryProviderList doInBackground(Void... params) {
                LotteryProviderList lots = getLotteryProviderList();
                return lots;
            }

            @Override
            protected void onPostExecute(LotteryProviderList lots) {
                super.onPostExecute(lots);
                if (callback != null) {
                    callback.callback(lots);
                }
            }
        }.execute();
    }


    public static LotteryProviderList getLotteryProviderList() {
        LotteryProviderList result = null;
        String url = BASE_URL;

        try {
            HttpURLConnection conn = connect(url);
            if (conn.getResponseCode() == 200) {
                String json = readResponse(conn.getInputStream());
                try {
                    result = ParseHelper.parseJson(json);
                    result.setFromLocal(false);
                    //STORE JSON
                    Prefs.saveLotteryJsonData(json);
                    Log.d("Lottery_JSON:", json + "");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                throw new IOException("Request failed -> response_code=" + conn.getResponseCode());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*if (result == null || result.getLotteryProviders() == null || result.getLotteryProviders().size() == 0) { // IF NULL THEN GET MODEL FROM LOCAL
            try {
                String json = Prefs.getCurrencyJsonData();
                if (json != null) {
                    result = parseJson(json);
                    result.setOffline(true);
                }else{
                    Log.i("CurrencyApi", "Prefs.getCurrencyJsonData() return null");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }*/
        //TODO IF NETWORK  ERROR ==> THROW...
        return result;
    }


    private static HttpURLConnection connect(String url) throws IOException {
        URL u = new URL(url);
        return (HttpURLConnection) u.openConnection();
    }

    private static String readResponse(InputStream is) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] data = new byte[2048];
        int len = 0;
        while ((len = is.read(data, 0, data.length)) >= 0) {
            bos.write(data, 0, len);
        }
        return new String(bos.toByteArray(), "UTF-8");
    }

}
