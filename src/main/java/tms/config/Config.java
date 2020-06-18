package tms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tms.entity.Operation;
import tms.action.CalcAction;
import tms.service.CalcService;
import tms.console.Reader;
import tms.console.Writen;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class Config {

    @Bean
     List <Operation> operations (){
        return new ArrayList<>();
    };

    @Bean
    CalcAction calcAction (Writen writen, Reader reader, CalcService calcService){
        return new CalcAction(writen, reader, calcService);
    }

    @Bean
    Reader reader (){
        return new Reader();
    }

    @Bean
    Writen writen (){
        return new Writen();
    }

    @Bean
    CalcService calcService (List<Operation> operations){
        return new CalcService(operations);
    }


}
