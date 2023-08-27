package com.lm.spring6.auto.controller;

import com.lm.spring6.auto.service.UserService;

/**
 * @author ming
 * @date 2023.06.20
 * @about
 */
public class UserController {
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void addUser(){
        System.out.println("Controller方法执行……");
        userService.addUserService();
    }
}
