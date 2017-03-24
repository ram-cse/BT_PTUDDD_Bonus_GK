package com.example.vrams.ramdieuconverter.domain.models;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by vrams on 3/24/2017.
 */

public class YahooCurrencyModel {
    @SerializedName("id")
    private String id;
    @SerializedName("Name")
    private String name;
    @SerializedName("Rate")
    private float rate;
    @SerializedName("Date")
    private String date;
    @SerializedName("Time")
    private String time;
    @SerializedName("Ask")
    private float ask;
    @SerializedName("Bid")
    private float bid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public float getAsk() {
        return ask;
    }

    public void setAsk(float ask) {
        this.ask = ask;
    }

    public float getBid() {
        return bid;
    }

    public void setBid(float bid) {
        this.bid = bid;
    }
}
