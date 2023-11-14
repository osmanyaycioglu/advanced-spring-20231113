package com.innova.spring.advancedspring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyThirdSpringBean implements IGreetings {

    private String prefix;
    private String suffix;
    private int    count = 0;


    public MyThirdSpringBean(@Value("${app.prefix}") final String prefixParam,
                             @Value("${app.suffix}") final String suffixParam) {
        prefix = prefixParam;
        suffix = suffixParam;
    }

    @Override
    public void hello() {
        count++;
        System.out.println(prefix + " world " + count + " " + suffix);
    }
}
