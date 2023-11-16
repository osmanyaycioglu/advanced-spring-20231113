package com.innova.spring.advancedspring.user.dao;

import com.innova.spring.advancedspring.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserEntityDao extends JpaRepository<UserEntity, Long> {
}
