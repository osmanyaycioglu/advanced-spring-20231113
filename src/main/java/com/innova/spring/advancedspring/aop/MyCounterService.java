package com.innova.spring.advancedspring.aop;

import org.springframework.stereotype.Service;

@Service
public class MyCounterService {
    private long counter = 0;

    @DeltaTime
    public long increase(String str){
        System.out.println("Gelen param : " + str);
        return counter++;
    }

}
