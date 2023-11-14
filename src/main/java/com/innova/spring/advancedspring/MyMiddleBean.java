package com.innova.spring.advancedspring;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class MyMiddleBean {

    private final MyFirstSpringBean myFirstSpringBean;
    private final MySecondSpringBean mySecondSpringBean;

    // Doğru değil
    @PostConstruct
    public void init(){
        // init code
        System.out.println("init");
    }

}
