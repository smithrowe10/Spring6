package com.lm.dao.daoImpl;

import com.lm.annotation.Bean;
import com.lm.dao.UserDao;

/**
 * @author ming
 * @date 2023.06.21
 * @about
 */
@Bean
public class UserDaoImpl implements UserDao {
    @Override
    public void add() {
        System.out.println("Dao层执行……");
    }
}
