package com.innova.spring.advancedspring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
public class MyFirstRun implements ApplicationRunner {

    private static final Logger logger = LoggerFactory.getLogger(MyFirstRun.class);

    @Autowired
    private MyFirstSpringBean myFirstSpringBean1;
    private final MyFirstSpringBean myFirstSpringBean2;
    private MyFirstSpringBean myFirstSpringBean3;

    public MyFirstRun(final MyFirstSpringBean myFirstSpringBean2Param) {
        myFirstSpringBean2 = myFirstSpringBean2Param;
        System.out.println("Init called");
    }

    @Autowired
    public void methodInjection(MyFirstSpringBean myFirstSpringBean3Param) {
        myFirstSpringBean3 = myFirstSpringBean3Param;
    }

    @PostConstruct
    public void init(){
        System.out.println("Init called");
    }


    @Override
    public void run(final ApplicationArguments args) throws Exception {
        logger.debug("Spring running : " + Arrays.toString(args.getSourceArgs()));

        logger.debug("Spring running : {} ",
                     Arrays.toString(args.getSourceArgs()));

        if (logger.isDebugEnabled()) {
            logger.debug("[MyFirstRun][run]-> " + Arrays.toString(args.getSourceArgs()));
        }
        myFirstSpringBean1.hello();
        myFirstSpringBean2.hello();
        myFirstSpringBean3.hello();
        myFirstSpringBean1.hello();
        myFirstSpringBean2.hello();
        myFirstSpringBean3.hello();
    }

}
