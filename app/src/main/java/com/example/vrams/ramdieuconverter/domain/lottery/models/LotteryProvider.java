package com.example.vrams.ramdieuconverter.domain.lottery.models;

import java.io.Serializable;
import java.util.List;

/**
 * Created by vrams on 4/27/2017.
 */


/*
@des: So so cua tinh 1 tinh thanh (ten tinh & cac xo so co theo ngay co san)
* */
public class LotteryProvider implements Serializable{

    String provider; // Tinh Thanh
    List<Lottery> lotteries;


    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public List<Lottery> getLotteries() {
        return lotteries;
    }

    public void setLotteries(List<Lottery> lotteries) {
        this.lotteries = lotteries;
    }
}
