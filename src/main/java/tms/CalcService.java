package tms;

import org.springframework.stereotype.Component;

import java.util.List;


public class CalcService {

    private List <Operation> operations;

    public CalcService(List<Operation> operations) {
        this.operations = operations;
    }

    public double calc(String operation, double num1, double num2) {
        double res;
        switch (operation) {
            case "sum":
                res = num1 + num2;
                break;
            case "minus":
                res = num1 - num2;
                break;
            case "div":
                res = num1 / num2;
                break;
            case "times":
                res = num1 * num2;
                break;
            default:
                return -666;
        }
        addHistopy(num1, num2, res, operation);
        return res;
    }

    private void addHistopy( double num1, double num2, double res, String operation){
        Operation operation1 = new Operation(num1, num2, res, operation);
        operations.add(operation1);
    }

    List getHistory(){
        return operations;
    }

}
