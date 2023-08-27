package com.lm.service.serviceImpl;

import com.lm.annotation.Bean;
import com.lm.annotation.Di;
import com.lm.dao.UserDao;
import com.lm.service.UserService;

/**
 * @author ming
 * @date 2023.06.21
 * @about
 */
@Bean
public class UserServiceImpl implements UserService {
    @Di
    private UserDao userDao;

    public void add(){
        System.out.println("service层……");
        userDao.add();
    }
}
