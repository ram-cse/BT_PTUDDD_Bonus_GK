package com.example.vrams.ramdieuconverter.domain.lottery.models;

import java.io.Serializable;

/**
 * Created by vrams on 4/27/2017.
 */

public class Prizes implements Serializable{
    int first[];
    int second[];
    int third[];
    int fourth[];
    int fifth[];
    int six[];
    int seven[];
    int eight[];
    int special[];

    public int[] getFirst() {
        return first;
    }

    public void setFirst(int[] first) {
        this.first = first;
    }

    public int[] getSecond() {
        return second;
    }

    public void setSecond(int[] second) {
        this.second = second;
    }

    public int[] getThird() {
        return third;
    }

    public void setThird(int[] third) {
        this.third = third;
    }

    public int[] getFourth() {
        return fourth;
    }

    public void setFourth(int[] fourth) {
        this.fourth = fourth;
    }

    public int[] getFifth() {
        return fifth;
    }

    public void setFifth(int[] fifth) {
        this.fifth = fifth;
    }

    public int[] getSix() {
        return six;
    }

    public void setSix(int[] six) {
        this.six = six;
    }

    public int[] getSeven() {
        return seven;
    }

    public void setSeven(int[] seven) {
        this.seven = seven;
    }

    public int[] getEight() {
        return eight;
    }

    public void setEight(int[] eight) {
        this.eight = eight;
    }

    public int[] getSpecial() {
        return special;
    }

    public void setSpecial(int[] special) {
        this.special = special;
    }




}
