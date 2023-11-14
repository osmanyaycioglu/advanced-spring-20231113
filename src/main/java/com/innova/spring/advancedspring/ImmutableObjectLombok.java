package com.innova.spring.advancedspring;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ImmutableObjectLombok {
    private final String name;
    private final String surname;

}
