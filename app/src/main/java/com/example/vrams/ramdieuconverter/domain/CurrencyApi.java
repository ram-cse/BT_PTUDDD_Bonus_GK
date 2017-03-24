package com.example.vrams.ramdieuconverter.domain;

import android.os.AsyncTask;
import android.util.Log;

import com.example.vrams.ramdieuconverter.callbacks.Callback;
import com.example.vrams.ramdieuconverter.domain.models.YahooCurrencyListModel;
import com.example.vrams.ramdieuconverter.domain.models.YahooCurrencyModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vrams on 3/24/2017.
 */

public class CurrencyApi {
    public static final String API_KEY = "";
    public static final String BASE_URL = "http://query.yahooapis.com/v1/public/yql?format=json&q=select%20*%20from%20yahoo.finance.xchange%20where%20pair%20in%20(%20%22USDVND%22,%22EURVND%22,%20%22USDEUR%22,%20%22USDJPY%22,%20%22USDBGN%22,%20%22USDCZK%22,%20%22USDDKK%22,%20%22USDGBP%22,%20%22USDHUF%22,%20%22USDLTL%22,%20%22USDLVL%22,%20%22USDPLN%22,%20%22USDRON%22,%20%22USDSEK%22,%20%22USDCHF%22,%20%22USDNOK%22,%20%22USDHRK%22,%20%22USDRUB%22,%20%22USDTRY%22,%20%22USDAUD%22,%20%22USDBRL%22,%20%22USDCAD%22,%20%22USDCNY%22,%20%22USDHKD%22,%20%22USDIDR%22,%20%22USDILS%22,%20%22USDINR%22,%20%22USDKRW%22,%20%22USDMXN%22,%20%22USDMYR%22,%20%22USDNZD%22,%20%22USDPHP%22,%20%22USDSGD%22,%20%22USDTHB%22,%20%22USDZAR%22,%20%22USDISK%22)&env=store://datatables.org/alltableswithkeys";


    private static final Gson GSON = new GsonBuilder()
            .registerTypeAdapterFactory(new MyResultObjectAdapterFactory())
            .create();

    public static void getCurrency(final Callback<YahooCurrencyListModel> callback){
        new AsyncTask<Void, Void, YahooCurrencyListModel>(){

            @Override
            protected YahooCurrencyListModel doInBackground(Void ...params) {
                try {
                    YahooCurrencyListModel weathers = getCurrency();
                    return weathers;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(YahooCurrencyListModel weathers) {
                super.onPostExecute(weathers);
                if(callback != null){
                    callback.callback(weathers);
                }
            }
        }.execute();
    }


    public static YahooCurrencyListModel getCurrency() throws IOException{
        YahooCurrencyListModel result = null;
        String url = BASE_URL;

        try {
            HttpURLConnection conn = connect(url);
            if(conn.getResponseCode() == 200){
                String json = readResponse(conn.getInputStream());
                Log.d("Weather_JSON:", json+"");
                try {
                    result = parseJson(json);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else{
                throw new IOException("Request failed -> response_code=" + conn.getResponseCode());
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new IOException(e);
        }

        return result;
    }

    private static YahooCurrencyListModel parseJson(String json) throws Exception{
        YahooCurrencyListModel currency = new YahooCurrencyListModel();
        List<YahooCurrencyModel> yahooCurrencyModels = new ArrayList<YahooCurrencyModel>();
        JSONObject root = new JSONObject(json);
        JSONArray jsonArray = root.getJSONObject("query").getJSONObject("results").getJSONArray("rate");
        int len = jsonArray.length();
        YahooCurrencyModel model;
        for (int i = 0; i < len; i++){
            try{
                JSONObject object = jsonArray.getJSONObject(i);
                model = new YahooCurrencyModel();
                model.setName(object.getString("Name"));
                model.setId(object.getString("id"));
                model.setAsk((float)object.getDouble("Ask"));
                model.setBid((float)object.getDouble("Bid"));
                model.setRate((float) object.getDouble("Rate"));
                model.setTime(object.getString("Time"));
                model.setDate(object.getString("Date"));
                yahooCurrencyModels.add(model);
            }catch (JSONException e){e.printStackTrace();}
        }
        currency.setCurrency(yahooCurrencyModels);
        return currency;
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
