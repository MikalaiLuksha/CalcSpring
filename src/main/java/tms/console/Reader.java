package tms.console;

import org.springframework.stereotype.Component;

import java.util.Scanner;


public class Reader {


    public String readerDouble(){
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()) {
            return scanner.next();
        }
        return "fail";
    }


    public String readerOperation(){
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()) {
            return scanner.next();
        }
        return null;
    }

    public boolean checkDouble(){
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextDouble()){
            return false;
        }
        return true;
    }

}
