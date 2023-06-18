package org.example.config;

import org.example.service.Calc;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;



@Configuration
@PropertySource("classpath:application.properties")
public class MyConfig {
    @Bean
    public Calc calc(){
        return new Calc();
    }
}
