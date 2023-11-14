package com.innova.spring.advancedspring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("profy")
public class MyConfigurationOther {

    @Bean
    public IGreetings beanOfThird(@Value("${app.prefix}") String prefix,
                                  @Value("${app.suffix}") String suffix) {
        MyThirdSpringBean myThirdSpringBeanLoc = new MyThirdSpringBean(prefix,
                                                                       suffix);
        myThirdSpringBeanLoc.hello();
        return myThirdSpringBeanLoc;
    }

}
