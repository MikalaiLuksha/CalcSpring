package tms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tms.service.CalcService;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Operation {

    private double num1;
    private  double num2;
    private  double res;
    private String operationCalc;

    @Override
    public String toString() {

        return num1 + " " + operationCalc + " " + num2 + " = " + res;

    }
}
