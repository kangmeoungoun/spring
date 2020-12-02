package me.goldapple;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Created by jojoldu@gmail.com on 2020-12-01
 * Blog : http://jojoldu.tistory.com
 * Github : http://github.com/jojoldu
 */
@Configuration
@ComponentScan
public class WebConfig {
     @Bean
    public ViewResolver viewResolver(){
         InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
         viewResolver.setPrefix("/WEB-INF/");
         viewResolver.setSuffix(".jsp");
         return viewResolver;
     }
}
