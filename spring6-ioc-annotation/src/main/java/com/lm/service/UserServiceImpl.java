package com.lm.service;
import com.lm.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ming
 * @date 2023.06.20
 * @about
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public void addUserService() {
        System.out.println("UserService方法执行……");
        userDao.addUserDao();
    }
}
