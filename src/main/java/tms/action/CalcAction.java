package tms.action;


import tms.service.CalcService;
import tms.console.Reader;
import tms.console.Writen;

import java.util.List;


public class CalcAction {


    private Writen writen;
    private Reader reader;
    private CalcService calcService;

    public CalcAction(Writen writen, Reader reader, CalcService calcService) {
        this.writen = writen;
        this.reader = reader;
        this.calcService = calcService;
    }

    public void start(){

        boolean b = true;
        while (b) {
            writen.writen("Выберите операцию: sum - 1 / minus -2 / div - 3 / times -4 ");
            String operation = reader.readerOperation();
            if (calcService.checkOperation(operation)) {
                double num1 = firstNum();
                double num2 = secondNum();
                 double res = calcService.calc(operation, num1, num2);
                writen.writen("Ваш результат " + res);
                writen.writen("Выберите: продолжить - 1 / история - 2");
                String choice = reader.readerOperation();
                if (choice.equals("2")) {
                    b = history();
               }
            }
            else {
                writen.writen("Error. Choose again");
            }
        }
    }

    private double firstNum (){
        boolean b = true;
        while (b) {
            writen.writen("Введите первое число");
            String num = reader.readerDouble();
            try {
                double num1 = Double.parseDouble(num);
                b = false;
                return num1;
        }
            catch (NumberFormatException e){
            writen.writen("Incorrect number");
            }
        }
        return 0;
    }

    private double secondNum (){
        boolean b = true;
        while (b) {
            writen.writen("Введите второе число");
            String num = reader.readerDouble();
            try {
                double num2 = Double.parseDouble(num);
                b = false;
                return num2;
            }
            catch (NumberFormatException e){
                writen.writen("Incorrect number");
            }
        }
        return 0;
    }

    private boolean history(){
        List history = calcService.getHistory();
        for (Object o : history) {
            writen.writen(o);
        }
        return false;
    }
}
