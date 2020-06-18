package tms.service;

import tms.entity.Operation;

import java.util.ArrayList;
import java.util.List;


public class CalcService {

    private List<Operation> operations;

    public CalcService(List<Operation> operations) {
        this.operations = operations;
    }

    public double calc(String operation, double num1, double num2) {
        double res;
        switch (operation) {
            case "1":
                res = num1 + num2;
                break;
            case "2":
                res = num1 - num2;
                break;
            case "3":
                res = num1 / num2;
                break;
            case "4":
                res = num1 * num2;
                break;
            default:
                return -666;
        }
        addHistopy(num1, num2, res, operation);
        return res;
    }

    private void addHistopy(double num1, double num2, double res, String operation) {
        String symbol = symbol(operation);
        Operation operation1 = new Operation(num1, num2, res, symbol);
        operations.add(operation1);
    }

    public List getHistory() {
        return new ArrayList<>(operations);
    }

    public boolean checkOperation(String operation) {
        if (operation.equals("1") || operation.equals("2") || operation.equals("3") || operation.equals("4")) {
            return true;
        } else return false;
    }

    public String symbol(String operation) {

        switch (operation) {
            case ("1"):
                return "+";
            case ("2"):
                return "-";
            case ("3"):
                return "/";
            case ("4"):
                return "*";
            default:
                throw new IllegalStateException("Unexpected value: " + operation);
        }

    }
}
