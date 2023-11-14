package com.innova.spring.advancedspring;

import org.springframework.stereotype.Component;

@Component
public class MySecondSpringBean {

    private int count = 0;

    public void hello(){
        count++;
        System.out.println("Hello world Second " + count);
    }
}
