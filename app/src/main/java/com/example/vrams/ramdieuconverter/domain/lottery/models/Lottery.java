package com.example.vrams.ramdieuconverter.domain.lottery.models;

import java.io.Serializable;
import java.util.List;

/**
 * Created by vrams on 4/27/2017.
 */

/*
* @des: ket qua so so (1 ngay)
* */
public class Lottery implements Serializable{
    String date;
    Prizes prizes;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Prizes getPrizes() {
        return prizes;
    }

    public void setPrizes(Prizes prizes) {
        this.prizes = prizes;
    }
}
