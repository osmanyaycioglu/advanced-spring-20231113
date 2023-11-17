package com.innova.spring.advancedspring.user.dao;

import com.innova.spring.advancedspring.customer.rest.models.UserDetails;
import com.innova.spring.advancedspring.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Future;
import java.util.stream.Stream;

public interface IUserEntityDao extends JpaRepository<UserEntity, Long> {

    UserEntity findByUsername(String username);

    // NATIVE -> SELECT * FROM USER_ENTITY WHERE username=x AND password=y
    // JPQL ->   select u from UserEntity u where u.username=x and u.password=y
    Optional<UserEntity> findByUsernameAndPasswordOrderByUsername(String x, String y);

    Future<List<UserEntity>> findByUsernameLike(String pattern);

    Stream<UserEntity> findByUsernameIn(List<String> pattern);

    @Query("select u from UserEntity u where u.username=?1")
    List<UserEntity> searchUsername(String username);

    @Query(value = "select * from USER_ENTITY u where u.username=?1",nativeQuery = true)
    List<UserEntity> searchUsernameNative(String username);

    @Query("select u.username,u.userRole from UserEntity u where u.username=?1")
    List<Object[]> searchUsernameGetRole(String username);

//    @Query("select new com.innova.spring.advancedspring.customer.rest.models.UserDetails(u.username,u.userRole) from UserEntity u where u.username=?1")
//    List<UserDetails> searchUsernameGetUserDetails(String username);

    @Modifying
    @Transactional
    @Query("update UserEntity u set u.username=?1")
    List<UserEntity> updateUsername(String username);

}
