package com.lm.dao;

import org.springframework.stereotype.Repository;

/**
 * @author ming
 * @date 2023.06.20
 * @about
 */
@Repository
public class UserDaoImpl implements UserDao{
    @Override
    public void addUserDao() {
        System.out.println("UserDao方法执行……");
    }
}
