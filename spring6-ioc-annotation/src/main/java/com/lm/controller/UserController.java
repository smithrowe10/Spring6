package com.lm.controller;


import com.lm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author ming
 * @date 2023.06.20
 * @about
 */
@Controller
public class UserController {
    // 方法一：属性注入
    @Autowired
    private UserService userService;

    // 方法2：set方法注入
//    @Autowired
//    public void setUserService(UserService userService) {
//        this.userService = userService;
//    }

    // 方法3：构造方法注入

//    @Autowired
//    public UserController(UserService userService){
//        this.userService = userService;
//    }
//    // 方法4：形参上注入
//    private UserService userService;
//
//    public UserController(@Autowired UserService userService){
//        this.userService = userService;
//    }

    public void addUser(){
        System.out.println("Controller方法执行……");
        userService.addUserService();
    }
}
