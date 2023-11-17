package com.innova.spring.advancedspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
@ServletComponentScan
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableScheduling
@EnableAspectJAutoProxy
public class AdvancedSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdvancedSpringApplication.class,
                              args);

        ImmutableObjectLombok il = new ImmutableObjectLombok("osman",
                                                             "yay");

        NormalObject no = new NormalObject();
        no.setName("osman");
        String nameLoc = il.getName();
        no.setName("hatice");

        ObjectDsl buildLoc = ObjectDsl.builder()
                                      .withName("osman")
                                      .withSurname("yaycıoğlu")
                                      .build();

        List<String> stringsLoc = Arrays.asList("osman",
                                                "ali",
                                                "mehmet",
                                                "ayşe");

        List<ObjectDsl> aLoc = stringsLoc.stream()
                                         .filter(s -> s.contains("a"))
                                         .map(s -> ObjectDsl.builder()
                                                            .withName(s)
                                                            .build())
                                         .collect(Collectors.toList());
    }

}
