package com.example.vrams.ramdieuconverter.domain.lottery.models;

import java.io.Serializable;
import java.util.List;

/**
 * Created by vrams on 4/27/2017.
 */

/*
* @des: ket qua cac so so
* */
public class LotteryProviderList implements Serializable{
    List<LotteryProvider> lotteryProviders;

    boolean isFromLocal;

    public List<LotteryProvider> getLotteryProviders() {
        return lotteryProviders;
    }

    public void setLotteryProviders(List<LotteryProvider> lotteryProviders) {
        this.lotteryProviders = lotteryProviders;
    }

    public boolean isFromLocal() {
        return isFromLocal;
    }

    public void setFromLocal(boolean fromLocal) {
        isFromLocal = fromLocal;
    }
}
