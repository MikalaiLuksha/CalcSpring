package tms;


public class CalcAction {


    private Writen writen;
    private Reader reader;
    private CalcService calcService;

    public CalcAction(Writen writen, Reader reader, CalcService calcService) {
        this.writen = writen;
        this.reader = reader;
        this.calcService = calcService;
    }

    void start(){

        boolean b = true;
        while (b) {
            writen.writen("Выберите операцию sum / minus / div / times");
            String operation = reader.readerOperation();
            writen.writen("Введите первое число");
            double num1 = this.reader.readerDouble();
            writen.writen("Ведите второе число");
            double num2 = reader.readerDouble();
            double res = calcService.calc(operation, num1, num2);
            writen.writen("Ваш результат " + res);
            writen.writen("Выберите: продолжить - 1 / история - 2");
            String choice = reader.readerOperation();
            if (choice.equals("2")){
                writen.writen(calcService.getHistory());
                b = false;
            }
        }
    }
}
