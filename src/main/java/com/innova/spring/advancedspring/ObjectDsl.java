package com.innova.spring.advancedspring;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


// @Getter // anti pattern
public class ObjectDsl {

    @Getter
    private final String name;
    @Getter
    private final String surname;
    @Builder.Default
    @Getter
    @Setter
    private int    port = 100;

    private String temp;

    @Builder(setterPrefix = "with")
    public ObjectDsl(final String name,
                     final String surname,
                     final int port) {
        this.name    = name;
        this.surname = surname;
        this.port    = port;
    }
}
