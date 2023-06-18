package org.example.service;

import lombok.Data;
import org.example.model.InfoCalc;
import org.springframework.stereotype.Component;

@Component
@Data
public class Calc {
    public int sum(InfoCalc infoCalc) {
        int tempSum = infoCalc.getAmount();
        double tempPercent = (double) infoCalc.getPercent() / 100;
        int tempYear = infoCalc.getYears();
            for (;tempYear > 0; tempYear--){
                tempSum = (int) (tempSum + (tempSum * tempPercent));
            }
            return tempSum;
        }
    }
