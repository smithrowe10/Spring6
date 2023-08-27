package com.lm.spring6.auto.service;

import com.lm.spring6.auto.dao.UserDao;

/**
 * @author ming
 * @date 2023.06.20
 * @about
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void addUserService() {
        System.out.println("UserService方法执行……");
        userDao.addUserDao();
    }
}
