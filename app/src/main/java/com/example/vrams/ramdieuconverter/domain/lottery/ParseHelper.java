package com.example.vrams.ramdieuconverter.domain.lottery;

import android.util.Log;

import com.example.vrams.ramdieuconverter.domain.lottery.models.Lottery;
import com.example.vrams.ramdieuconverter.domain.lottery.models.LotteryProvider;
import com.example.vrams.ramdieuconverter.domain.lottery.models.LotteryProviderList;
import com.example.vrams.ramdieuconverter.domain.lottery.models.Prizes;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by vrams on 4/27/2017.
 */

public class ParseHelper {


    public static LotteryProviderList parseJson(String json) throws Exception {
        LotteryProviderList lotteryProviderList = new LotteryProviderList();
        List<LotteryProvider> lotteryProviders = new ArrayList<LotteryProvider>();
        JSONObject root = new JSONObject(json);

        Iterator<String> keys = root.keys();
        LotteryProvider lotteryProvider; // So so cua tinh 1 tinh thanh
        while (keys.hasNext()){ // moi tinh thanh
            String key = keys.next();
            try {
                lotteryProvider = new LotteryProvider();
                lotteryProvider.setProvider(key);
                JSONObject lotteryJson = root.getJSONObject(key);

                List<Lottery> lotteries = parseLotteryJson(lotteryJson);
                lotteryProvider.setLotteries(lotteries);
                lotteryProviders.add(lotteryProvider);
            }catch (Exception e){
                e.printStackTrace();
            }
            Log.d("ParseHelper:parseJson", key+"");
        }
        lotteryProviderList.setLotteryProviders(lotteryProviders);

        return lotteryProviderList;
    }

    private static List<Lottery> parseLotteryJson(JSONObject json) throws JSONException {
        List<Lottery> lotteries = new ArrayList<Lottery>();
        JSONObject jsonObject = json;
        Iterator<String> keys = jsonObject.keys();
        Lottery lottery;
        while (keys.hasNext()){ // for cac ngay phat hanh
            String key = keys.next();
            JSONObject jsonObject1 = jsonObject.getJSONObject(key);// So so theo ngay hay cac giai
            lottery = new Lottery();
            lottery.setDate(key);

            Prizes prizes = new Prizes(); // Cac giai
            try{
                prizes.setFirst(parsePrize(jsonObject1.getJSONArray("1")));
                prizes.setSecond(parsePrize(jsonObject1.getJSONArray("2")));
                prizes.setThird(parsePrize(jsonObject1.getJSONArray("3")));
                prizes.setFourth(parsePrize(jsonObject1.getJSONArray("4")));
                prizes.setFifth(parsePrize(jsonObject1.getJSONArray("5")));
                prizes.setSix(parsePrize(jsonObject1.getJSONArray("6")));
                prizes.setSeven(parsePrize(jsonObject1.getJSONArray("7")));
                prizes.setEight(parsePrize(jsonObject1.getJSONArray("8")));
                prizes.setSpecial(parsePrize(jsonObject1.getJSONArray("DB")));
            }catch (JSONException e){
                e.printStackTrace();
                continue;
            }
            lottery.setPrizes(prizes);
            lotteries.add(lottery);
        }
        return  lotteries;
    }

    //Parse Giai
    private static int[] parsePrize(JSONArray json)throws JSONException{
        JSONArray jsonArray = json;
        if(jsonArray.length() <= 0){
            return null;
        }
        int prizes[] = new int[jsonArray.length()];
        for(int i = 0; i < jsonArray.length(); i++){
            prizes[i] = jsonArray.getInt(i);
        }
        return prizes;
    }
}
