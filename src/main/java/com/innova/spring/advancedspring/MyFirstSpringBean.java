package com.innova.spring.advancedspring;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Service
//@Controller
//@Repository
//@Configuration
@Component
//@Scope("prototype")
public class MyFirstSpringBean {

    private int count = 0;

    public void hello(){
        count++;
        System.out.println("Hello world " + count);
    }
}
