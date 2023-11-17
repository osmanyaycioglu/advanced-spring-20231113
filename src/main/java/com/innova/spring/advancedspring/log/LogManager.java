package com.innova.spring.advancedspring.log;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LogManager {
    private final ILogDao logDao;

    @Transactional(propagation = Propagation.REQUIRED)
    public void insertLog(String log) {
        logDao.save(new LogObject(log));
    }

}
