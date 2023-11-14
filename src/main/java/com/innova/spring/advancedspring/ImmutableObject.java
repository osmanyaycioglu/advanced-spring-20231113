package com.innova.spring.advancedspring;

public class ImmutableObject {
    private final String name;
    private final String surname;

    public ImmutableObject(final String nameParam,
                           final String surnameParam) {
        name    = nameParam;
        surname = surnameParam;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}
