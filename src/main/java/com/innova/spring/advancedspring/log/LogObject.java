package com.innova.spring.advancedspring.log;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class LogObject {
    @Id
    @GeneratedValue
    private Long logId;
    private String logDesc;

    public LogObject(final String logDescParam) {
        logDesc = logDescParam;
    }
}
