package org.example.model;

import lombok.Data;

@Data
public class InfoCalc {

    private int percent;
    private int years;
    private int amount;

    public InfoCalc(int amount, int percent, int years) {
        this.amount = amount;
        this.percent = percent;
        this.years = years;


    }
}
