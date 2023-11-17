package com.innova.spring.advancedspring.log;


import org.springframework.data.jpa.repository.JpaRepository;

public interface ILogDao extends JpaRepository<LogObject,Long> {
}
