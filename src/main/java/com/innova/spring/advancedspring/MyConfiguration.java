package com.innova.spring.advancedspring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("profx")
public class MyConfiguration {

    @Bean
    public IGreetings beanOfThird() {
        MyThirdSpringBean myThirdSpringBeanLoc = new MyThirdSpringBean("test",
                                                                       "mest");
        myThirdSpringBeanLoc.hello();
        return myThirdSpringBeanLoc;
    }

}
