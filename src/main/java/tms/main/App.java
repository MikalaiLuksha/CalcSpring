package tms.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import tms.action.CalcAction;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main(String[] args) {
        ApplicationContext app = new AnnotationConfigApplicationContext("tms");
        CalcAction calcAction = (CalcAction) app.getBean("calcAction");
        calcAction.start();
    }

}
