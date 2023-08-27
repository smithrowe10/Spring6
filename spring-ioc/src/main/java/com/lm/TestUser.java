package com.lm;

import com.lm.bean.AnnotationApplicationContext;
import com.lm.bean.ApplicationContext;
import com.lm.service.UserService;

/**
 * @author ming
 * @date 2023.06.21
 * @about
 */
public class TestUser {
    public static void main(String[] args) throws NoSuchMethodException {
        ApplicationContext context = new AnnotationApplicationContext("com.lm");
        UserService userService = (UserService) context.getBean(UserService.class);
        System.out.println(userService);
        userService.add();
    }
}
