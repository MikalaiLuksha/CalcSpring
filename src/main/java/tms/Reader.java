package tms;

import org.springframework.stereotype.Component;

import java.util.Scanner;


class Reader {


    double readerDouble(){
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()) {
            return scanner.nextDouble();
        }
        return -100;
    }

    String readerOperation(){
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()) {
            return scanner.next();
        }
        return null;
    }

}
