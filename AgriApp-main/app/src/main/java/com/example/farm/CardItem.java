package com.example.farm;

import android.content.Intent;

public class CardItem {
    private String text1;
    private int color;
    private double data;

    public void setColor(int color) {
        this.color = color;
    }
    private void setData(float data) {

    }

    CardItem(String text1, int color, double data) {
        this.text1 = text1;
        this.color = color;
        this.data = data;
    }

    double getData() {
        return data;
    }

    public void setData(double data) {
        this.data = data;
    }

    String getText1() {
        return text1;
    }
    public int getColor()
    {
        return color;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }
}
