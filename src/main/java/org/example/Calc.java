package org.example;

public class Calc {
    public int sum(int amount, int percent, int year) {
        int tempSum = amount;
        double tempPercent = (double) percent / 100;
        int tempYear = year;
            for (;tempYear > 0; tempYear--){
                tempSum = (int) (tempSum + (tempSum * tempPercent));
            }
            return tempSum;
        }
    }
