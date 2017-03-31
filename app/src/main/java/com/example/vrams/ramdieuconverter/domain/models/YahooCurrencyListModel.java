package com.example.vrams.ramdieuconverter.domain.models;

import com.example.vrams.ramdieuconverter.domain.models.YahooCurrencyModel;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by vrams on 3/24/2017.
 */

public class YahooCurrencyListModel {

    private boolean isOffline = false;
    public boolean isOffline() {return isOffline;}
    public void setOffline(boolean offline) {isOffline = offline;}

    @SerializedName("rate")
    private List<YahooCurrencyModel> currency;

    public List<YahooCurrencyModel> getCurrency() {
        return currency;
    }

    public void setCurrency(List<YahooCurrencyModel> currency) {
        this.currency = currency;
    }
}
