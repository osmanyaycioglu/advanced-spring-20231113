package com.innova.spring.advancedspring.user;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@Entity
public class UserEntity {
    @Id
    @GeneratedValue
    private Long userId;
    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
    @NotNull
    @Enumerated(EnumType.STRING)
    private EUserRole userRole;
}
