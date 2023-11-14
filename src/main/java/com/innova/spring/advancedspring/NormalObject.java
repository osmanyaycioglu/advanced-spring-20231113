package com.innova.spring.advancedspring;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // anti pattern kullanma
@AllArgsConstructor
@NoArgsConstructor
public class NormalObject {
    private  String name;
    private  String surname;

}
