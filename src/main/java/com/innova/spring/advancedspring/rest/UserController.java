package com.innova.spring.advancedspring.rest;

import com.innova.spring.advancedspring.user.UserEntity;
import com.innova.spring.advancedspring.user.dao.IUserEntityDao;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/sec/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final IUserEntityDao userEntityDao;

    @PostMapping("/add")
    public UserEntity add(@Valid @RequestBody UserEntity userParam){
        UserEntity saveLoc = userEntityDao.save(userParam);
        return saveLoc;
    }

    @GetMapping("/get/all")
    public List<UserEntity> getAllUSers(){
        return userEntityDao.findAll();
    }

}
