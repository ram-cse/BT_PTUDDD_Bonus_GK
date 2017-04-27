package com.example.vrams.ramdieuconverter.domain.lottery.models;

/**
 * Created by vrams on 4/27/2017.
 */

public enum ELotProvider {
    AG("AG"),
    BG("BD"),
    BL("BL"),
    BP("BP"),
    BTH("BTH"),
    CM("CM"),
    CT("CT"),
    HCM("HCM");


    private String providerName;

    ELotProvider(String providerName){
        this.providerName = providerName;
    }

    public String getProviderName() {
        return providerName;
    }
}
