package tms.action;


import tms.service.CalcService;
import tms.console.Reader;
import tms.console.Writer;

import java.util.List;


public class CalcAction {


    private Writer writer;
    private Reader reader;
    private CalcService calcService;

    public CalcAction(Writer writer, Reader reader, CalcService calcService) {
        this.writer = writer;
        this.reader = reader;
        this.calcService = calcService;
    }

    public void start(){

        boolean b = true;
        while (b) {
            writer.writer("Выберите операцию: sum - 1 / minus -2 / div - 3 / times -4 ");
            String operation = reader.readerOperation();
            if (calcService.checkOperation(operation)) {
                double num1 = firstNum();
                double num2 = secondNum();
                 double res = calcService.calc(operation, num1, num2);
                writer.writer("Ваш результат " + res);
                writer.writer("Выберите: продолжить - 1 / история - 2");
                String choice = reader.readerOperation();
                if (choice.equals("2")) {
                    b = history();
               }
            }
            else {
                writer.writer("Error. Choose again");
            }
        }
    }

    private double firstNum (){
        boolean b = true;
        while (b) {
            writer.writer("Введите первое число");
            String num = reader.readerDouble();
            try {
                double num1 = Double.parseDouble(num);
                b = false;
                return num1;
        }
            catch (NumberFormatException e){
            writer.writer("Incorrect number");
            }
        }
        return 0;
    }

    private double secondNum (){
        boolean b = true;
        while (b) {
            writer.writer("Введите второе число");
            String num = reader.readerDouble();
            try {
                double num2 = Double.parseDouble(num);
                b = false;
                return num2;
            }
            catch (NumberFormatException e){
                writer.writer("Incorrect number");
            }
        }
        return 0;
    }

    private boolean history(){
        List history = calcService.getHistory();
        for (Object o : history) {
            writer.writer(o);
        }
        return false;
    }
}
